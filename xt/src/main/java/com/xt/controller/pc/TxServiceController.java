package com.xt.controller.pc;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiresAuthentication
@RequestMapping("service")
public class TxServiceController {

	// 基础路径
	final String BASEPATH = "service/";

	@RequiresAuthentication
	@RequestMapping("support")
	public ModelAndView support() {
		ModelAndView modelAndView = new ModelAndView(BASEPATH + "support");
		return modelAndView;
	}

	@RequiresAuthentication
	@RequestMapping("repair")
	public ModelAndView repair() {
		ModelAndView modelAndView = new ModelAndView(BASEPATH + "repair");
		return modelAndView;
	}

	@RequiresAuthentication
	@RequestMapping("handling")
	public ModelAndView handling() {
		ModelAndView modelAndView = new ModelAndView(BASEPATH + "handling");
		return modelAndView;
	}

}