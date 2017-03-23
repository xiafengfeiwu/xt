package com.xt.controller.pc;

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
import org.springframework.web.servlet.ModelAndView;

import com.xt.entity.custom.MPumpWarnGroup;
import com.xt.entity.custom.MPumpWarnGroupParam;
import com.xt.entity.generation.DeviceProduct;
import com.xt.entity.generation.DeviceVender;
import com.xt.entity.generation.Project;
import com.xt.entity.generation.ProjectArea;
import com.xt.entity.generation.Pump;
import com.xt.entity.generation.PumpWarnGroup;
import com.xt.entity.generation.PumpWarnGroupKey;
import com.xt.entity.generation.Res;
import com.xt.entity.generation.Role;
import com.xt.entity.generation.WarnGroup;
import com.xt.entity.generation.WarnGroupItem;
import com.xt.entity.generation.WeatherAlarm;
import com.xt.entity.generation.WeatherData;
import com.xt.service.CityWeatherService;
import com.xt.service.DeviceProductService;
import com.xt.service.DeviceVenderService;
import com.xt.service.ProjectAreaService;
import com.xt.service.ProjectService;
import com.xt.service.PumpService;
import com.xt.service.ResService;
import com.xt.service.WarnGroupService;
import com.xt.util.PublicUtil;

@Controller
@RequiresAuthentication
@RequestMapping("monitor")
public class TxMonitorController {

	// 基础路径
	final String BASEPATH = "monitor/";

	@Autowired
	PumpService pumpService;
	@Autowired
	ProjectService projectService;
	@Autowired
	ProjectAreaService projectAreaService;
	@Autowired
	CityWeatherService cityWeatherService;
	@Autowired
	WarnGroupService warnGroupService;
	@Autowired
	DeviceProductService deviceProductService;
	@Autowired
	DeviceVenderService deviceVenderService;
	@Autowired
	ResService resService;

	@RequiresAuthentication
	@RequestMapping("pump")
	public ModelAndView pump() {
		ModelAndView modelAndView = new ModelAndView(BASEPATH + "pump");
		return modelAndView;
	}

	@RequiresAuthentication
	@RequestMapping("report")
	public ModelAndView report() {
		ModelAndView modelAndView = new ModelAndView(BASEPATH + "report");
		return modelAndView;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("pump-info")
	public Map<String, Object> pumpInfo(String pumpId) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		if (PublicUtil.isEmpty(pumpId)) {
			data.put("message", "请传入热泵ID");
			return data;
		}
		Pump pump = pumpService.getById(pumpId);
		if (pump == null) {
			data.put("message", "无效的热泵ID");
			return data;
		}

		Project project = projectService.getProjectById(pump.getProjectId());
		if (project == null) {
			data.put("message", "无效的项目ID");
			return data;
		}

		ProjectArea projectArea = projectAreaService.getByAreaId(project.getProjectAreaId());
		if (projectArea == null) {
			data.put("message", "无效的项目区域ID");
			return data;
		}

		DeviceProduct deviceProduct = deviceProductService.findById(pump.getProductId());
		if (deviceProduct == null) {
			data.put("message", "无效的产品信息");
			return data;
		}

		DeviceVender deviceVender = deviceVenderService.findById(deviceProduct.getProductVenderId());
		if (deviceVender == null) {
			data.put("message", "无效的供应商信息");
			return data;
		}

		List<MPumpWarnGroup> warnGroups = pumpService.selectPumpWarnGroups(pumpId);
		WeatherData weather = cityWeatherService.findCityWeatherByCode(projectArea.getWeatherCode());
		WeatherAlarm weatherAlarm = cityWeatherService.findWeatherAlarmByCode(projectArea.getWeatherCode());

		data.put("success", true);
		data.put("pump", pump);
		data.put("project", project);
		data.put("projectArea", projectArea);
		data.put("warnGroups", warnGroups);
		data.put("deviceProduct", deviceProduct);
		data.put("deviceVender", deviceVender);
		data.put("weather", weather);
		data.put("weatherAlarm", weatherAlarm);
		return data;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("pump-pictures")
	public Map<String, Object> pumpPictures(String pumpId) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		if (PublicUtil.isEmpty(pumpId)) {
			data.put("message", "请传入热泵ID");
			return data;
		}
		Pump pump = pumpService.getById(pumpId);
		if (pump == null) {
			data.put("message", "无效的热泵ID");
			return data;
		}
		List<Res> res = resService.findResByGroupId(pump.getGroupId());
		data.put("success", true);
		data.put("data", res);
		data.put("groupId", pump.getGroupId());
		return data;
	}

	@RequiresAuthentication
	@RequestMapping("warn-group")
	public ModelAndView warnGroup() {
		ModelAndView modelAndView = new ModelAndView(BASEPATH + "warn-group");
		return modelAndView;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("warn-group-data")
	public Map<String, Object> warnGroupData() {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		Role role = PublicUtil.sessionUserRole();
		if (role == null) {
			data.put("message", "无效的角色");
			return data;
		}
		List<WarnGroup> warnGroups = null;
		if (PublicUtil.ROLE_SYSTEM_MANAGE_ID.equals(role.getRoleId())) {
			// 是系统管理员
			warnGroups = warnGroupService.getAll();
		} else {
			warnGroups = warnGroupService.getOwnerAll(PublicUtil.sessionUid());
		}
		data.put("success", true);
		data.put("data", warnGroups);
		return data;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("pump-warn-group-data")
	public Map<String, Object> pumpWarnGroupData(String pumpId) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		if (pumpId == null) {
			data.put("message", "请传入热泵ID");
			return data;
		}
		Pump pump = pumpService.getById(pumpId);
		if (pump == null) {
			data.put("message", "无效的热泵ID");
			return data;
		}
		data.put("success", true);
		data.put("data", warnGroupService.getPumpNoSelects(pump.getOwnerId(), pumpId));
		return data;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("add-pump-warn-group")
	public Map<String, Object> addPumpWarnGroup(@RequestBody(required = true) MPumpWarnGroupParam groupParam) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		if (groupParam == null) {
			data.put("message", "请传入参数");
			return data;
		}
		if (groupParam.getPumpId() == null) {
			data.put("message", "请传入热泵ID");
			return data;
		}
		if (groupParam.getGroupId() == null) {
			data.put("message", "请传入告警组ID");
			return data;
		}

		WarnGroup wg = warnGroupService.getById(groupParam.getGroupId());
		if (wg == null) {
			data.put("message", "无效的告警组ID");
			return data;
		}
		PumpWarnGroup warnGroup = new PumpWarnGroup();
		warnGroup.setPumpId(groupParam.getPumpId());
		warnGroup.setWarnGroupId(groupParam.getGroupId());
		warnGroup.setCreateTime(new Date());
		try {
			pumpService.addPumpWarnGroup(warnGroup);
		} catch (Exception e) {
			data.put("message", "操作失败，请稍后重试");
			return data;
		}

		MPumpWarnGroup mPumpWarnGroup = new MPumpWarnGroup();
		mPumpWarnGroup.setGroupId(wg.getGroupId());
		mPumpWarnGroup.setGroupName(wg.getGroupName());
		mPumpWarnGroup.setGroupDescript(wg.getGroupDescript());

		data.put("success", true);
		data.put("warnGroup", mPumpWarnGroup);
		data.put("message", "操作成功");
		return data;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("remove-pump-warn-group")
	public Map<String, Object> removePumpWarnGroup(@RequestBody(required = true) MPumpWarnGroupParam groupParam) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		if (groupParam == null) {
			data.put("message", "请传入参数");
			return data;
		}
		if (groupParam.getPumpId() == null) {
			data.put("message", "请传入热泵ID");
			return data;
		}
		if (groupParam.getGroupId() == null) {
			data.put("message", "请传入告警组ID");
			return data;
		}
		WarnGroup wg = warnGroupService.getById(groupParam.getGroupId());
		if (wg == null) {
			data.put("message", "无效的告警组ID");
			return data;
		}
		PumpWarnGroupKey groupKey = new PumpWarnGroupKey();
		groupKey.setPumpId(groupParam.getPumpId());
		groupKey.setWarnGroupId(groupParam.getGroupId());
		try {
			pumpService.removePumpWarnGroup(groupKey);
		} catch (Exception e) {
			data.put("message", "操作失败，可能存在关联数据");
			return data;
		}
		MPumpWarnGroup mPumpWarnGroup = new MPumpWarnGroup();
		mPumpWarnGroup.setGroupId(wg.getGroupId());
		mPumpWarnGroup.setGroupName(wg.getGroupName());
		mPumpWarnGroup.setGroupDescript(wg.getGroupDescript());

		data.put("success", true);
		data.put("warnGroup", mPumpWarnGroup);
		data.put("message", "操作成功");
		return data;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("save-warn-group")
	public Map<String, Object> saveWarnGroup(@RequestBody(required = true) WarnGroup warnGroup) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		if (warnGroup == null) {
			data.put("message", "无效的数据");
			return data;
		}
		if (PublicUtil.isEmpty(warnGroup.getGroupName())) {
			data.put("message", "请输入告警组名称");
			return data;
		}
		if (PublicUtil.isEmpty(warnGroup.getGroupDescript())) {
			data.put("message", "请输入告警组描述");
			return data;
		}
		Role role = PublicUtil.sessionUserRole();
		if (role == null) {
			data.put("message", "无效的角色");
			return data;
		}
		if (PublicUtil.ROLE_SYSTEM_MANAGE_ID.equals(role.getRoleId())) {
			warnGroup.setSystemGroup(Boolean.TRUE);
			warnGroup.setOwnerId(null);
		} else {
			warnGroup.setSystemGroup(Boolean.FALSE);
			warnGroup.setOwnerId(PublicUtil.sessionUid());
		}
		warnGroup.setGroupId(PublicUtil.initId());
		warnGroup.setCreateTime(new Date());
		try {
			warnGroupService.create(warnGroup);
		} catch (Exception e) {
			data.put("message", "操作失败，请稍候重试");
			return data;
		}
		data.put("success", true);
		data.put("message", "操作成功");
		data.put("warnGroup", warnGroup);
		return data;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("update-warn-group")
	public Map<String, Object> updateWarnGroup(@RequestBody(required = true) WarnGroup warnGroup) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		if (warnGroup == null) {
			data.put("message", "无效的数据");
			return data;
		}
		if (PublicUtil.isEmpty(warnGroup.getGroupName())) {
			data.put("message", "请输入告警组名称");
			return data;
		}
		if (PublicUtil.isEmpty(warnGroup.getGroupDescript())) {
			data.put("message", "请输入告警组描述");
			return data;
		}
		WarnGroup uWarnGroup = warnGroupService.getById(warnGroup.getGroupId());
		if (uWarnGroup == null) {
			data.put("message", "无效的告警组ID");
			return data;
		}
		uWarnGroup.setGroupName(warnGroup.getGroupName());
		uWarnGroup.setGroupDescript(warnGroup.getGroupDescript());
		try {
			warnGroupService.update(uWarnGroup);
		} catch (Exception e) {
			data.put("message", "操作失败，请稍候重试");
			return data;
		}
		data.put("success", true);
		data.put("message", "操作成功");
		data.put("warnGroup", uWarnGroup);
		return data;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("delete-warn-group")
	public Map<String, Object> deleteWarnGroup(String warnGroupId) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		if (warnGroupId == null) {
			data.put("message", "请传入告警组ID");
			return data;
		}
		WarnGroup dWarnGroup = warnGroupService.getById(warnGroupId);
		if (dWarnGroup == null) {
			data.put("message", "无效的告警组ID");
			return data;
		}
		try {
			warnGroupService.delete(warnGroupId);
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
	@RequestMapping("warn-group-items")
	public Map<String, Object> warnGroupItems(String warnGroupId) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		if (warnGroupId == null) {
			data.put("message", "请传入告警组ID");
			return data;
		}
		WarnGroup warnGroup = warnGroupService.getById(warnGroupId);
		if (warnGroup == null) {
			data.put("message", "无效的告警组ID");
			return data;
		}
		data.put("success", true);
		data.put("data", warnGroupService.getWarnGroupItems(warnGroupId));
		return data;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("save-warn-group-item")
	public Map<String, Object> saveWarnGroupItem(@RequestBody(required = true) WarnGroupItem warnGroupItem) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		if (warnGroupItem == null) {
			data.put("message", "无效的数据");
			return data;
		}
		if (warnGroupItem.getWarnGroupId() == null) {
			data.put("message", "无效的告警组ID");
			return data;
		}
		if (PublicUtil.isEmpty(warnGroupItem.getItemName())) {
			data.put("message", "请选择告警项");
			return data;
		}
		if (PublicUtil.isEmpty(warnGroupItem.getItemCode())) {
			data.put("message", "请选择告警项");
			return data;
		}
		if (PublicUtil.isEmpty(warnGroupItem.getItemOperators())) {
			data.put("message", "请选择一个操作符");
			return data;
		}
		if (!PublicUtil.isNumber(warnGroupItem.getItemThreshold())) {
			data.put("message", "无效的阈值");
			return data;
		}
		if (PublicUtil.isEmpty(warnGroupItem.getWarnCode())) {
			data.put("message", "请输入告警编码");
			return data;
		}
		if (PublicUtil.isEmpty(warnGroupItem.getWarnLevel())) {
			data.put("message", "请输入告警级别");
			return data;
		}
		if (PublicUtil.isEmpty(warnGroupItem.getWarnDescript())) {
			data.put("message", "请输入告警描述");
			return data;
		}
		if (PublicUtil.isEmpty(warnGroupItem.getWarnScheme())) {
			data.put("message", "请输入处理建议");
			return data;
		}

		WarnGroupItem item = warnGroupService.getWarnGroupItemByCode(warnGroupItem.getWarnCode());
		if (item != null) {
			data.put("message", "告警编码已存在");
			return data;
		}

		warnGroupItem.setItemId(PublicUtil.initId());
		warnGroupItem.setCreateTime(new Date());
		try {
			warnGroupService.addItem(warnGroupItem);
		} catch (Exception e) {
			data.put("message", "操作失败，请稍候重试");
			return data;
		}
		data.put("success", true);
		data.put("message", "操作成功");
		data.put("warnGroupItem", warnGroupItem);
		return data;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("delete-warn-group-item")
	public Map<String, Object> deleteWarnGroupItem(String warnGroupItemId) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		if (warnGroupItemId == null) {
			data.put("message", "请传入告警项ID");
			return data;
		}
		WarnGroupItem dWarnGroupItem = warnGroupService.getItemById(warnGroupItemId);
		if (dWarnGroupItem == null) {
			data.put("message", "无效的告警项ID");
			return data;
		}
		try {
			warnGroupService.deleteItem(warnGroupItemId);
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
	@RequestMapping("update-warn-group-item")
	public Map<String, Object> updateWarnGroupItem(@RequestBody(required = true) WarnGroupItem warnGroupItem) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		if (warnGroupItem == null) {
			data.put("message", "无效的数据");
			return data;
		}
		if (warnGroupItem.getItemId() == null) {
			data.put("message", "无效的告警项ID");
			return data;
		}
		if (PublicUtil.isEmpty(warnGroupItem.getItemName())) {
			data.put("message", "请选择告警项");
			return data;
		}
		if (PublicUtil.isEmpty(warnGroupItem.getItemCode())) {
			data.put("message", "请选择告警项");
			return data;
		}
		if (PublicUtil.isEmpty(warnGroupItem.getItemOperators())) {
			data.put("message", "请选择一个操作符");
			return data;
		}
		if (!PublicUtil.isNumber(warnGroupItem.getItemThreshold())) {
			data.put("message", "无效的阈值");
			return data;
		}
		if (PublicUtil.isEmpty(warnGroupItem.getWarnCode())) {
			data.put("message", "请输入告警编码");
			return data;
		}
		if (PublicUtil.isEmpty(warnGroupItem.getWarnLevel())) {
			data.put("message", "请输入告警级别");
			return data;
		}
		if (PublicUtil.isEmpty(warnGroupItem.getWarnDescript())) {
			data.put("message", "请输入告警描述");
			return data;
		}
		if (PublicUtil.isEmpty(warnGroupItem.getWarnScheme())) {
			data.put("message", "请输入处理建议");
			return data;
		}

		WarnGroupItem item = warnGroupService.getWarnGroupItemByCode(warnGroupItem.getWarnCode());
		if (item != null && !item.getItemId().equals(warnGroupItem.getItemId())) {
			data.put("message", "告警编码已存在");
			return data;
		}
		if (item == null) {
			item = warnGroupService.getItemById(warnGroupItem.getItemId());
		}
		item.setItemCode(warnGroupItem.getItemCode());
		item.setItemName(warnGroupItem.getItemName());
		item.setItemThreshold(warnGroupItem.getItemThreshold());
		item.setItemOperators(warnGroupItem.getItemOperators());
		item.setWarnCode(warnGroupItem.getWarnCode());
		item.setWarnLevel(warnGroupItem.getWarnLevel());
		item.setWarnDescript(warnGroupItem.getWarnDescript());
		item.setWarnScheme(warnGroupItem.getWarnScheme());
		try {
			warnGroupService.updateItem(item);
		} catch (Exception e) {
			data.put("message", "操作失败，请稍候重试");
			return data;
		}
		data.put("success", true);
		data.put("message", "操作成功");
		data.put("warnGroupItem", item);
		return data;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("pump-warn-group-detail")
	public Map<String, Object> pumpWarnGroupDetail(String warnGroupId) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		if (warnGroupId == null) {
			data.put("message", "无效的告警组ID");
			return data;
		}
		data.put("success", true);
		data.put("warnGroupItems", warnGroupService.getWarnGroupItems(warnGroupId));
		return data;
	}

}
