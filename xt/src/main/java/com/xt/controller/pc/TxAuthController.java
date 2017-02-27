package com.xt.controller.pc;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xt.entity.generation.Role;
import com.xt.entity.generation.User;
import com.xt.service.RoleService;
import com.xt.service.UserService;
import com.xt.util.PublicUtil;

@Controller
@RequestMapping("auth")
public class TxAuthController {

	@Autowired
	UserService userService;
	@Autowired
	RoleService roleService;
	// 基础路径
	final String BASEPATH = "auth/";

	@RequestMapping("users")
	public ModelAndView users() {
		ModelAndView modelAndView = new ModelAndView(BASEPATH + "users");
		return modelAndView;
	}

	@ResponseBody
	@RequestMapping("user-data")
	public Map<String, Object> userData() {
		Map<String, Object> data = new HashMap<>();
		List<User> users = userService.getUserData();
		data.put("data", users);
		return data;
	}

	@ResponseBody
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
		userService.regist(user);
		data.put("success", true);
		data.put("user", user);
		return data;
	}

	@ResponseBody
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
		userService.update(_user);
		data.put("success", true);
		data.put("user", _user);
		return data;
	}

	@ResponseBody
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
			userService.update(_user);
		}
		data.put("success", true);
		return data;
	}

	@ResponseBody
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
			data.put("message", "删除失败，数据可能存在关联，不允许删除");
		}
		return data;
	}

	@ResponseBody
	@RequestMapping("delete-users")
	public Map<String, Object> deleteUsers(@RequestBody(required = true) Long[] userIds) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		if (userIds == null || userIds.length < 1) {
			data.put("message", "无效的数据");
			return data;
		}
		int successCount = 0;
		int failCount = 0;
		for (Long userId : userIds) {
			try {
				userService.delete(userId);
				successCount++;
			} catch (Exception e) {
				failCount++;
			}
		}
		data.put("success", true);
		data.put("successCount", successCount);
		data.put("failCount", failCount);
		if (failCount > 0)
			data.put("failMessage", "数据可能存在关联，不允许删除");
		else
			data.put("failMessage", "");
		return data;
	}

	@RequestMapping("roles")
	public ModelAndView roles() {
		ModelAndView modelAndView = new ModelAndView(BASEPATH + "roles");
		return modelAndView;
	}

	@ResponseBody
	@RequestMapping("role-data")
	public Map<String, Object> roleData() {
		Map<String, Object> data = new HashMap<>();
		List<Role> roles = roleService.findAll();
		data.put("data", roles);
		return data;
	}

	@RequestMapping("user-info")
	public ModelAndView userinfo() {
		ModelAndView modelAndView = new ModelAndView(BASEPATH + "userinfo");
		return modelAndView;
	}

}