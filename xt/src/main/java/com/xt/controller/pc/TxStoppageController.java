package com.xt.controller.pc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xt.entity.custom.MAreaPump;
import com.xt.entity.custom.MPumpStoppage;
import com.xt.entity.generation.Role;
import com.xt.entity.generation.UserAuth;
import com.xt.service.PumpService;
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

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("data")
	public Map<String, Object> data() {
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

}