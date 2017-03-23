package com.xt.controller.pc;

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
import org.springframework.web.servlet.ModelAndView;

import com.xt.entity.custom.MAreaPump;
import com.xt.entity.custom.MUserAuth;
import com.xt.entity.generation.ProjectArea;
import com.xt.entity.generation.Pump;
import com.xt.entity.generation.Role;
import com.xt.entity.generation.User;
import com.xt.entity.generation.UserAuth;
import com.xt.service.ProjectAreaService;
import com.xt.service.ProjectService;
import com.xt.service.PumpService;
import com.xt.service.RoleService;
import com.xt.service.UserAuthService;
import com.xt.service.UserService;
import com.xt.util.PublicUtil;

@Controller
@RequestMapping("auth")
public class TxAuthController {

	@Autowired
	UserService userService;
	@Autowired
	UserAuthService userAuthService;
	@Autowired
	RoleService roleService;
	@Autowired
	ProjectAreaService projectAreaService;
	@Autowired
	ProjectService projectService;
	@Autowired
	PumpService pumpService;

	// 基础路径
	final String BASEPATH = "auth/";

	@RequiresAuthentication
	@RequestMapping("users")
	public ModelAndView users() {
		ModelAndView modelAndView = new ModelAndView(BASEPATH + "users");
		return modelAndView;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("user-data")
	public Map<String, Object> userData() {
		Map<String, Object> data = new HashMap<>();
		List<User> users = userService.getUserData();
		data.put("data", users);
		return data;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("add-user")
	public Map<String, Object> addUser(@RequestBody(required = true) User user) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		if (user == null) {
			data.put("message", "无效的数据");
			return data;
		}
		if (!PublicUtil.isLoginName(user.getUserLoginName())) {
			data.put("message", "无效的登录名称");
			return data;
		}
		if (PublicUtil.isEmpty(user.getUserName()) || user.getUserName().length() < 2
				|| user.getUserName().length() > 20) {
			data.put("message", "无效的用户名称");
			return data;
		}
		if (!PublicUtil.isPhoneNo(user.getUserPhone())) {
			data.put("message", "无效的用户手机号码");
			return data;
		}
		if (null != userService.findByLoginName(user.getUserLoginName())) {
			data.put("message", "用户登录名称已存在");
			return data;
		}
		if (null != userService.findByPhoneNo(user.getUserPhone())) {
			data.put("message", "用户手机号码已存在");
			return data;
		}
		user.setUserId(PublicUtil.initId());
		user.setUserDisableStatus(false);
		user.setUserNamePy(PublicUtil.getStringPy(user.getUserName()));
		user.setUserPassword(PublicUtil.sha1("123456"));
		user.setUserPortraitPath("assets/img/default_head_124x124.png");
		user.setUserWxOpenId(null);
		user.setUserRegistTime(new Date());
		user.setUserModifyTime(new Date());
		try {
			userService.regist(user);
		} catch (Exception e) {
			data.put("message", "操作失败，请稍后重试");
			return data;
		}
		data.put("success", true);
		data.put("user", user);
		return data;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("change-user")
	public Map<String, Object> changeUser(@RequestBody(required = true) User user) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		if (user == null) {
			data.put("message", "无效的数据");
			return data;
		}
		if (!PublicUtil.isLoginName(user.getUserLoginName())) {
			data.put("message", "无效的登录名称");
			return data;
		}
		if (PublicUtil.isEmpty(user.getUserName()) || user.getUserName().length() < 2
				|| user.getUserName().length() > 20) {
			data.put("message", "无效的用户名称");
			return data;
		}
		if (!PublicUtil.isPhoneNo(user.getUserPhone())) {
			data.put("message", "无效的用户手机号码");
			return data;
		}
		User _user = null;
		_user = userService.findByLoginName(user.getUserLoginName());
		if (null != _user && !user.getUserId().equals(_user.getUserId())) {
			data.put("message", "用户登录名称已存在");
			return data;
		}
		_user = userService.findByPhoneNo(user.getUserPhone());
		if (null != _user && !user.getUserId().equals(_user.getUserId())) {
			data.put("message", "用户手机号码已存在");
			return data;
		}
		_user = userService.findById(user.getUserId());
		if (_user == null) {
			data.put("message", "无效的用户参数");
			return data;
		}
		_user.setUserName(user.getUserName());
		_user.setUserNamePy(PublicUtil.getStringPy(user.getUserName()));
		_user.setUserLoginName(user.getUserLoginName());
		_user.setUserPhone(user.getUserPhone());
		_user.setRoleId(user.getRoleId());
		_user.setUserModifyTime(new Date());
		try {
			userService.update(_user);
		} catch (Exception e) {
			data.put("message", "修改失败，请稍后重试");
			return data;
		}
		data.put("success", true);
		data.put("user", _user);
		return data;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("toggle-user-status")
	public Map<String, Object> toggleUserStatus(@RequestBody(required = true) User user) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		if (user == null) {
			data.put("message", "无效的数据");
			return data;
		}
		User _user = userService.findById(user.getUserId());
		if (_user == null) {
			data.put("message", "无效的用户参数");
			return data;
		}
		if (_user.getUserDisableStatus().equals(user.getUserDisableStatus())) {
			_user.setUserDisableStatus(!_user.getUserDisableStatus());
			_user.setUserModifyTime(new Date());
			try {
				userService.update(_user);
			} catch (Exception e) {
				data.put("message", "修改失败，请稍后重试");
				return data;
			}
		}
		data.put("success", true);
		return data;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("reset-pwd")
	public Map<String, Object> resetPwd(@RequestBody(required = true) User user) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		if (user == null || user.getUserId() == null) {
			data.put("message", "请传入用户ID");
			return data;
		}
		User u = userService.findById(user.getUserId());
		if (u == null) {
			data.put("message", "无效的用户ID");
			return data;
		}
		u.setUserPassword(PublicUtil.sha1("123456"));
		u.setUserModifyTime(new Date());
		try {
			userService.update(u);
		} catch (Exception e) {
			data.put("message", "修改失败，请稍后重试");
			return data;
		}
		data.put("success", true);
		return data;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("delete-user")
	public Map<String, Object> deleteUser(@RequestBody(required = true) User user) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		if (user == null || user.getUserId() == null) {
			data.put("message", "无效的数据");
			return data;
		}
		try {
			userService.delete(user.getUserId());
			data.put("success", true);
		} catch (Exception e) {
			data.put("message", "删除失败，数据可能存在关联，不允许删除，您可以尝试禁用该用户。");
		}
		return data;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("user-auth-data")
	public Map<String, Object> userAuthData(String userId) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		User u = userService.findById(userId);
		if (PublicUtil.ROLE_SYSTEM_MANAGE_ID.equals(u.getRoleId())) {
			return data;
		}
		List<MAreaPump> mAps = new ArrayList<>();
		List<UserAuth> userAuths = userAuthService.findUserAll(userId);
		if (userAuths != null && !userAuths.isEmpty()) {
			List<String> pumpIds = new ArrayList<>();
			List<String> projectAreaIds = new ArrayList<>();
			for (UserAuth ua : userAuths) {
				if (ua.getPumpId() != null) {
					pumpIds.add(ua.getPumpId());
				} else if (ua.getProjectAreaId() != null) {
					projectAreaIds.add(ua.getProjectAreaId());
				}
			}
			if (!pumpIds.isEmpty()) {
				mAps.addAll(pumpService.selectPumpsByIds(pumpIds));
			}
			if (!projectAreaIds.isEmpty()) {
				mAps.addAll(projectService.selectProjectPumpsByIds(projectAreaIds));
			}
		}
		data.put("success", true);
		data.put("data", mAps);
		return data;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("auth-user-visit")
	public Map<String, Object> authUserVisit(@RequestBody(required = true) MUserAuth mUserAuth) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		if (mUserAuth == null) {
			data.put("message", "无效的数据");
			return data;
		}
		if (mUserAuth.getUserId() == null) {
			data.put("message", "请传入用户ID");
			return data;
		}
		if (mUserAuth.getNodeId() == null) {
			data.put("message", "请传入节点ID");
			return data;
		}
		UserAuth userAuth = new UserAuth();
		if (mUserAuth.isAreaNode()) {
			ProjectArea projectArea = projectAreaService.getByAreaId(mUserAuth.getNodeId());
			if (projectArea == null) {
				data.put("message", "无效的区域节点ID");
				return data;
			}
			userAuth.setAuthCode(projectArea.getAreaCode());
			userAuth.setProjectAreaId(mUserAuth.getNodeId());
		} else {
			Pump pump = pumpService.getById(mUserAuth.getNodeId());
			if (pump == null) {
				data.put("message", "无效的热泵节点ID");
				return data;
			}
			userAuth.setAuthCode(pump.getPumpCode());
			userAuth.setPumpId(mUserAuth.getNodeId());
		}
		userAuth.setRootId(PublicUtil.initId());
		userAuth.setUserId(mUserAuth.getUserId());
		try {
			if (!userAuthService.authUser(userAuth)) {
				data.put("message", "当前节点已在访问范围内，无需再授权");
				return data;
			}
		} catch (Exception e) {
			data.put("message", "操作失败，请稍候重试");
			return data;
		}
		data.put("success", true);
		return data;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("un-auth-user-visit")
	public Map<String, Object> unAuthUserVisit(@RequestBody(required = true) MUserAuth mUserAuth) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		if (mUserAuth == null) {
			data.put("message", "无效的数据");
			return data;
		}
		if (mUserAuth.getUserId() == null) {
			data.put("message", "请传入用户ID");
			return data;
		}
		if (mUserAuth.getNodeId() == null) {
			data.put("message", "请传入节点ID");
			return data;
		}
		UserAuth ua = userAuthService.findByUserIdWithNodeId(mUserAuth.getUserId(), mUserAuth.getNodeId());
		if (ua == null) {
			data.put("message", "无效的数据组合");
			return data;
		}
		try {
			userAuthService.unAuthUser(ua.getRootId());
		} catch (Exception e) {
			data.put("message", "操作失败，请稍候重试");
			return data;
		}
		data.put("success", true);
		return data;
	}

	// @ResponseBody
	// @RequestMapping("delete-users")
	// public Map<String, Object> deleteUsers(@RequestBody(required = true)
	// String[] userIds) {
	// Map<String, Object> data = new HashMap<>();
	// data.put("success", false);
	// if (userIds == null || userIds.length < 1) {
	// data.put("message", "无效的数据");
	// return data;
	// }
	// int successCount = 0;
	// int failCount = 0;
	// for (String userId : userIds) {
	// try {
	// userService.delete(userId);
	// successCount++;
	// } catch (Exception e) {
	// failCount++;
	// }
	// }
	// data.put("success", true);
	// data.put("successCount", successCount);
	// data.put("failCount", failCount);
	// if (failCount > 0)
	// data.put("failMessage", "数据可能存在关联，不允许删除");
	// else
	// data.put("failMessage", "");
	// return data;
	// }

	@RequiresAuthentication
	@RequestMapping("roles")
	public ModelAndView roles() {
		ModelAndView modelAndView = new ModelAndView(BASEPATH + "roles");
		return modelAndView;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("role-data")
	public Map<String, Object> roleData() {
		Map<String, Object> data = new HashMap<>();
		List<Role> roles = roleService.findAll();
		data.put("data", roles);
		return data;
	}

	@RequiresAuthentication
	@RequestMapping("user-info")
	public ModelAndView userinfo() {
		ModelAndView modelAndView = new ModelAndView(BASEPATH + "userinfo");
		return modelAndView;
	}

}