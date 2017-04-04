package com.xt.controller.pc;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.xt.entity.custom.MAreaPump;
import com.xt.entity.custom.MIdParam;
import com.xt.entity.custom.MPumpMonitor;
import com.xt.entity.generation.ProjectArea;
import com.xt.entity.generation.Role;
import com.xt.entity.generation.User;
import com.xt.entity.generation.UserAuth;
import com.xt.service.ProjectAreaService;
import com.xt.service.ProjectService;
import com.xt.service.PumpService;
import com.xt.service.UserAuthService;
import com.xt.service.UserService;
import com.xt.service.VerificationCodeService;
import com.xt.util.PublicUtil;

@Controller
public class MainController {

	@Autowired
	PumpService pumpService;
	@Autowired
	ProjectService projectService;
	@Autowired
	ProjectAreaService projectAreaService;
	@Autowired
	UserAuthService userAuthService;
	@Autowired
	UserService userService;
	@Autowired
	VerificationCodeService verificationCodeService;

	@RequiresAuthentication
	@RequestMapping("index")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("index");
		return modelAndView;
	}

	@RequestMapping("login")
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}

	@RequestMapping("forgetpwd")
	public ModelAndView forgetpwd() {
		ModelAndView modelAndView = new ModelAndView("forgetpwd");
		return modelAndView;
	}

	@ResponseBody
	@RequestMapping("send-vcode")
	public Map<String, Object> sendVcode(String phoneNo) {
		Map<String, Object> map = new HashMap<>();
		map.put("success", false);
		if (PublicUtil.isEmpty(phoneNo)) {
			map.put("message", "请传入手机号");
			return map;
		}
		User user = userService.findByPhoneNo(phoneNo);
		if (user == null) {
			map.put("message", "无效的手机号");
			return map;
		}
		if (!verificationCodeService.sendVerificationCode(phoneNo)) {
			map.put("message", "发送失败，请稍候重试或联系管理员");
			return map;
		}
		map.put("success", true);
		return map;
	}

	@RequestMapping("logout")
	public ModelAndView logout() {
		ModelAndView modelAndView = new ModelAndView("logout-action");
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return modelAndView;
	}

	@RequestMapping("login-invalid")
	public ModelAndView loginInvalid() {
		ModelAndView modelAndView = new ModelAndView("redirect:/logout.jspx");
		return modelAndView;
	}

	@RequestMapping("unauthorized")
	public ModelAndView unauthorized() {
		ModelAndView modelAndView = new ModelAndView("redirect:/logout.jspx");
		return modelAndView;
	}

	@RequestMapping("login-action")
	public ModelAndView loginAction(String username, String password, RedirectAttributes attributes) {
		ModelAndView modelAndView = new ModelAndView("redirect:/login.jspx");
		if (PublicUtil.isEmpty(username)) {
			attributes.addFlashAttribute("message", "请输入登录名");
			return modelAndView;
		}
		if (PublicUtil.isEmpty(password)) {
			attributes.addFlashAttribute("message", "请输入密码");
			return modelAndView;
		}

		UsernamePasswordToken token = new UsernamePasswordToken(username, PublicUtil.sha1(password));
		token.setRememberMe(false);
		Subject subject = SecurityUtils.getSubject();
		String message = null;
		try {
			// 登陆
			subject.login(token);
		} catch (UnknownAccountException uae) {
			message = "输入的账户不存在";
		} catch (IncorrectCredentialsException ice) {
			message = "密码和账户不匹配";
		} catch (ExpiredCredentialsException ece) {
			message = "当前账户已被管理员删除";
		} catch (DisabledAccountException dae) {
			message = "当前账户已被管理员禁用";
		}
		// 错误信息
		if (message != null) {
			attributes.addFlashAttribute("message", message);
			return modelAndView;
		}
		modelAndView.setViewName("login-action");
		return modelAndView;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("my-pump-data")
	public List<Map<String, Object>> myPumpData(@RequestBody(required = false) MIdParam param) {
		List<Map<String, Object>> data = new ArrayList<>();
		// 获取根节点
		if (param == null || param.getId() == null) {
			Role role = PublicUtil.sessionUserRole();
			if (role == null) {
				return data;
			}
			if (PublicUtil.ROLE_SYSTEM_MANAGE_ID.equals(role.getRoleId())) {
				// 是系统管理员
				List<ProjectArea> projectAreas = projectAreaService.getParentProjectArea();
				PublicUtil.transforAreaObj(data, projectAreas);
			} else {
				// 非管理员
				String userId = PublicUtil.sessionUid();
				List<MAreaPump> mAreas = projectService.selectUserAuthProjectArea(userId);
				PublicUtil.transforPumpObj(data, mAreas, true);
				List<MAreaPump> mPumps = pumpService.selectUserAuthPump(userId);
				PublicUtil.transforPumpObj(data, mPumps, false);
			}

		} else {
			List<ProjectArea> projectAreas = projectAreaService.getByParentAreaId(param.getId());
			PublicUtil.transforAreaObj(data, projectAreas);
			List<MAreaPump> mAreaPumps = pumpService.getProjectAreaAll(param.getId());
			PublicUtil.transforPumpObj(data, mAreaPumps, false);
		}

		return data;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("all-pumps")
	public List<Map<String, Object>> allPumps() {
		List<Map<String, Object>> data = new ArrayList<>();
		List<MPumpMonitor> pms = pumpService.selectAllPumpMonitors();
		if (PublicUtil.isEmpty(pms)) {
			return data;
		}
		Role role = PublicUtil.sessionUserRole();
		if (role == null) {
			return data;
		}
		String roleId = role.getRoleId();

		List<MAreaPump> aps = null;
		List<UserAuth> uas = userAuthService.findUserAll(PublicUtil.sessionUid());
		if (!PublicUtil.isEmpty(uas)) {
			List<String> pumpCodes = new ArrayList<>();
			for (UserAuth ua : uas) {
				pumpCodes.add(ua.getAuthCode());
			}
			aps = pumpService.selectPumpsByCodes(pumpCodes);
		}
		boolean in;
		for (MPumpMonitor pm : pms) {
			if (PublicUtil.ROLE_SYSTEM_MANAGE_ID.equals(roleId)) {
				data.add(transformAll(pm));
				continue;
			}
			if (PublicUtil.isEmpty(aps)) {
				data.add(transformBase(pm));
				continue;
			}
			in = false;
			for (MAreaPump ap : aps) {
				if (ap.getId().equals(pm.getPumpId())) {
					in = true;
					break;
				}
			}
			if (in) {
				data.add(transformAll(pm));
			} else {
				data.add(transformBase(pm));
			}
		}
		return data;
	}

	private Map<String, Object> transformBase(MPumpMonitor pm) {
		Map<String, Object> map = new HashMap<>();
		map.put("pumpName", pm.getPumpName());
		map.put("backAirTemp", pm.getBackAirTemp());
		map.put("backWaterTemp", pm.getBackWaterTemp());
		map.put("collectTime", pm.getCollectTime());
		map.put("compressorCurrent", pm.getCompressorCurrent());
		map.put("environmentTemp", pm.getEnvironmentTemp());
		map.put("indoorTemp", pm.getIndoorTemp());
		map.put("outAirTemp", pm.getOutAirTemp());
		map.put("outWaterTemp", pm.getOutWaterTemp());
		map.put("setUpTemp", pm.getSetUpTemp());
		map.put("warnCode", pm.getWarnCode());
		map.put("waterTankTemp", pm.getWaterTankTemp());
		map.put("workMode", pm.getWorkMode());
		map.put("status", "无监控权限");
		Object[] values = { pm.getAreaLongitude(), pm.getAreaLatitude(), "#616161" };
		map.put("value", values);
		return map;
	}

	private Map<String, Object> transformAll(MPumpMonitor pm) {
		Map<String, Object> map = transformBase(pm);
		map.put("pumpId", pm.getPumpId());
		String color;
		if (pm.getCollectTime() == null) {
			color = "#FF9800";
			map.put("status", "离线");
		} else if (new Date().getTime() - pm.getCollectTime().getTime() < 30 * 60 * 1000) {
			color = "#8BC34A";
			map.put("status", "正常");
		} else {
			color = "#FF9800";
			map.put("status", "离线");
		}
		if (!PublicUtil.isEmpty(pm.getWarnCode()) && !"0".equals(pm.getWarnCode())) {
			color = "#E91E63";
			map.put("status", "故障");
		}
		((Object[]) map.get("value"))[2] = color;
		return map;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("get-group-id")
	public Map<String, Object> getGroupId() {
		Map<String, Object> data = new HashMap<>();
		data.put("groupId", PublicUtil.initId());
		return data;
	}
}