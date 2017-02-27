package com.xt.controller.pc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("tpl")
public class TplController {

	// 基础路径
	final String BASEPATH = "tpl/";

	@RequestMapping("dashboard")
	public ModelAndView dashboard() {
		ModelAndView modelAndView = new ModelAndView(BASEPATH + "dashboard");
		return modelAndView;
	}

	@RequestMapping("sidebar")
	public ModelAndView sidebar() {
		ModelAndView modelAndView = new ModelAndView(BASEPATH + "sidebar");
		return modelAndView;
	}

	@RequestMapping("topnav")
	public ModelAndView topnav() {
		ModelAndView modelAndView = new ModelAndView(BASEPATH + "topnav");
		return modelAndView;
	}

	@RequestMapping("theme-picker")
	public ModelAndView themePicker() {
		ModelAndView modelAndView = new ModelAndView(BASEPATH + "theme-picker");
		return modelAndView;
	}

	@RequestMapping("dropdown-navbar")
	public ModelAndView dropdownNavbar() {
		ModelAndView modelAndView = new ModelAndView(BASEPATH + "dropdown-navbar");
		return modelAndView;
	}

	@RequestMapping("data-table-pager")
	public ModelAndView dataTablePager() {
		ModelAndView modelAndView = new ModelAndView(BASEPATH + "data-table-pager");
		return modelAndView;
	}

	@RequestMapping("dropdown-list-example")
	public ModelAndView dropdownListExample() {
		ModelAndView modelAndView = new ModelAndView(BASEPATH + "dropdown-list-example");
		return modelAndView;
	}

	@RequestMapping("menu-link")
	public ModelAndView menuLink() {
		ModelAndView modelAndView = new ModelAndView(BASEPATH + "menu-link");
		return modelAndView;
	}

	@RequestMapping("menu-toggle")
	public ModelAndView menuToggle() {
		ModelAndView modelAndView = new ModelAndView(BASEPATH + "menu-toggle");
		return modelAndView;
	}

	@RequestMapping("navbar-search")
	public ModelAndView navbarSearch() {
		ModelAndView modelAndView = new ModelAndView(BASEPATH + "navbar-search");
		return modelAndView;
	}

	@RequestMapping("use-chrome")
	public ModelAndView useChrome() {
		ModelAndView modelAndView = new ModelAndView(BASEPATH + "use-chrome");
		return modelAndView;
	}

	/////// *** 表单模板 ***//////

	@RequestMapping("form-base")
	public ModelAndView formBase() {
		ModelAndView modelAndView = new ModelAndView(BASEPATH + "form-base");
		return modelAndView;
	}

	@RequestMapping("form-user-create")
	public ModelAndView formUserCreate() {
		ModelAndView modelAndView = new ModelAndView(BASEPATH + "form-user-create");
		return modelAndView;
	}

	@RequestMapping("form-user-update")
	public ModelAndView formUserUpdate() {
		ModelAndView modelAndView = new ModelAndView(BASEPATH + "form-user-update");
		return modelAndView;
	}

	@RequestMapping("form-user-detail")
	public ModelAndView formUserDetail() {
		ModelAndView modelAndView = new ModelAndView(BASEPATH + "form-user-detail");
		return modelAndView;
	}

	@RequestMapping("form-role-auth")
	public ModelAndView formRoleAuth() {
		ModelAndView modelAndView = new ModelAndView(BASEPATH + "form-role-auth");
		return modelAndView;
	}

}