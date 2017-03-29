package com.xt.controller.pc;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xt.entity.custom.MAreaPump;
import com.xt.entity.custom.MPumpStoppage;
import com.xt.entity.custom.MStoppage;
import com.xt.entity.generation.Pump;
import com.xt.entity.generation.Res;
import com.xt.entity.generation.Role;
import com.xt.entity.generation.Stoppage;
import com.xt.entity.generation.StoppageHandle;
import com.xt.entity.generation.UserAuth;
import com.xt.service.PumpService;
import com.xt.service.PumpWarnService;
import com.xt.service.ResService;
import com.xt.service.StoppageService;
import com.xt.service.UserAuthService;
import com.xt.util.PublicUtil;

@Controller
@RequiresAuthentication
@RequestMapping("stoppage")
public class TxStoppageController {

	@Autowired
	UserAuthService userAuthService;
	@Autowired
	PumpService pumpService;
	@Autowired
	StoppageService stoppageService;
	@Autowired
	ResService resService;
	@Autowired
	PumpWarnService pumpWarnService;

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("my-data")
	public Map<String, Object> myData() {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		Role role = PublicUtil.sessionUserRole();
		if (role == null) {
			data.put("success", "无效的用户信息");
			return data;
		}
		List<MPumpStoppage> datas = null;
		if (PublicUtil.ROLE_SYSTEM_MANAGE_ID.equals(role.getRoleId())) {
			datas = stoppageService.getAll();
		} else {
			List<UserAuth> uas = userAuthService.findUserAll(PublicUtil.sessionUid());
			List<String> pumpIds = null;
			if (!PublicUtil.isEmpty(uas)) {
				List<String> pumpCodes = new ArrayList<>();
				for (UserAuth ua : uas) {
					pumpCodes.add(ua.getAuthCode());
				}
				List<MAreaPump> aps = pumpService.selectPumpsByCodes(pumpCodes);
				if (aps != null && !aps.isEmpty()) {
					if (pumpIds == null) {
						pumpIds = new ArrayList<>();
					}
					for (MAreaPump mAreaPump : aps) {
						pumpIds.add(mAreaPump.getId());
					}
				}
			}
			if (pumpIds != null) {
				datas = stoppageService.getByPumpIds(pumpIds);
			}
		}
		data.put("success", true);
		data.put("data", datas);
		return data;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("save")
	public Map<String, Object> save(@RequestBody(required = true) MStoppage mStoppage) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		if (mStoppage == null) {
			data.put("message", "无效的数据");
			return data;
		}
		if (PublicUtil.isEmpty(mStoppage.getAttachId())) {
			data.put("message", "无效的表单数据");
			return data;
		}
		if (PublicUtil.isEmpty(mStoppage.getPumpId())) {
			data.put("message", "请选择一个热泵");
			return data;
		}
		if (mStoppage.getOccurDate() == null) {
			data.put("message", "请选择故障发生日期");
			return data;
		}
		if (mStoppage.getOccurTime() == null) {
			data.put("message", "请选择故障发生时间");
			return data;
		}
		if (PublicUtil.isEmpty(mStoppage.getDescript())) {
			data.put("message", "请输入故障描述");
			return data;
		}

		Pump pump = pumpService.getById(mStoppage.getPumpId());
		if (pump == null) {
			data.put("message", "无效的电站ID");
			return data;
		}

		Stoppage stoppage = new Stoppage();
		stoppage.setStoppageId(PublicUtil.initId());
		stoppage.setOperatorId(null);
		stoppage.setPumpId(mStoppage.getPumpId());
		stoppage.setStoppageNo("W" + PublicUtil.initId());
		stoppage.setOriginatorId(PublicUtil.sessionUid());
		stoppage.setCreateTime(new Date());
		stoppage.setAttachId(mStoppage.getAttachId());
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dt = dateFormat.format(mStoppage.getOccurDate());
		DateFormat timeFormat = new SimpleDateFormat("HH:mm");
		String tm = timeFormat.format(mStoppage.getOccurTime());
		stoppage.setOccurTime(dt + " " + tm);
		stoppage.setHandleStatus("N");
		stoppage.setDescript(mStoppage.getDescript());

		try {
			stoppageService.create(stoppage);
		} catch (Exception e) {
			data.put("message", "操作失败，请稍后重试");
			return data;
		}
		data.put("success", true);
		MPumpStoppage mPumpStoppage = new MPumpStoppage();
		mPumpStoppage.setStoppageId(stoppage.getStoppageId());
		mPumpStoppage.setStoppageNo(stoppage.getStoppageNo());
		mPumpStoppage.setOccurTime(stoppage.getOccurTime());
		mPumpStoppage.setPumpId(stoppage.getPumpId());
		mPumpStoppage.setPumpName(pump.getPumpName());
		mPumpStoppage.setDescript(stoppage.getDescript());
		mPumpStoppage.setCreateTime(stoppage.getCreateTime());
		mPumpStoppage.setHandleStatus("N");
		mPumpStoppage.setHandleModifyTime(null);
		data.put("stoppage", mPumpStoppage);
		List<Res> reses = resService.findResByGroupId(mStoppage.getAttachId());
		if (reses == null || reses.isEmpty()) {
			data.put("message", "操作成功，未上传附件");
			return data;
		}
		data.put("message", "操作成功");
		return data;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("detail")
	public Map<String, Object> detail(String stoppageId) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		if (PublicUtil.isEmpty(stoppageId)) {
			data.put("message", "请传入故障ID");
			return data;
		}
		Stoppage stoppage = stoppageService.getById(stoppageId);
		if (stoppage == null) {
			data.put("message", "无效的故障ID");
			return data;
		}
		data.put("stoppage", stoppage);
		data.put("pump", pumpService.getById(stoppage.getPumpId()));
		data.put("reses", resService.findResByGroupId(stoppage.getAttachId()));
		data.put("handles", stoppageService.getHandleByStoppageId(stoppageId));
		if (!PublicUtil.isEmpty(stoppage.getPumpWarnId())) {
			data.put("pumpWarn", pumpWarnService.getById(stoppage.getPumpWarnId()));
		}
		return data;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("delete")
	public Map<String, Object> delete(String stoppageId) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		if (PublicUtil.isEmpty(stoppageId)) {
			data.put("message", "请传入故障ID");
			return data;
		}
		Stoppage stoppage = stoppageService.getById(stoppageId);
		if (stoppage == null) {
			data.put("message", "无效的故障ID");
			return data;
		}
		try {
			stoppageService.delete(stoppageId);
		} catch (Exception e) {
			data.put("message", "操作失败，可能存在关联数据");
			return data;
		}
		data.put("success", true);
		data.put("message", "操作成功");
		return data;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("save-evaluate")
	public Map<String, Object> saveEvaluate(@RequestBody(required = true) StoppageHandle stoppageHandle) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		if (stoppageHandle == null) {
			data.put("message", "无效的数据");
			return data;
		}
		if (PublicUtil.isEmpty(stoppageHandle.getStoppageHandleId())) {
			data.put("message", "无效的表单数据");
			return data;
		}
		if (PublicUtil.isEmpty(stoppageHandle.getEvaluateLevel())) {
			data.put("message", "请选择一个评价等级");
			return data;
		}
		if (PublicUtil.isEmpty(stoppageHandle.getEvaluateDescript())) {
			data.put("message", "请输入评价描述");
			return data;
		}

		StoppageHandle handle = stoppageService.getHandleById(stoppageHandle.getStoppageHandleId());
		handle.setEvaluateTime(new Date());
		handle.setEvaluateLevel(stoppageHandle.getEvaluateLevel());
		handle.setEvaluateDescript(stoppageHandle.getEvaluateDescript());
		try {
			stoppageService.handleEvaluate(handle);
		} catch (Exception e) {
			data.put("message", "操作失败，请稍后重试");
			return data;
		}
		data.put("success", true);
		data.put("message", "操作成功");
		data.put("handle", handle);
		return data;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("no-allot-stoppage")
	public Map<String, Object> getByNoAllotStoppage(String stoppageNo, Integer page) {
		Map<String, Object> data = new HashMap<>();
		if (page == null) {
			page = Integer.valueOf(1);
		}
		// 自己授权的热泵
		data.put("data", stoppageService.getByNoAllot(stoppageNo, page));
		return data;
	}
}