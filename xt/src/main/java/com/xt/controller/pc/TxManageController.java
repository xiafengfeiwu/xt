package com.xt.controller.pc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("manage")
public class TxManageController {
	// 基础路径
	final String BASEPATH = "manage/";

	@RequestMapping("project")
	public ModelAndView project() {
		ModelAndView modelAndView = new ModelAndView(BASEPATH + "project");
		return modelAndView;
	}

	@RequestMapping("device")
	public ModelAndView device() {
		ModelAndView modelAndView = new ModelAndView(BASEPATH + "device");
		return modelAndView;
	}

}
