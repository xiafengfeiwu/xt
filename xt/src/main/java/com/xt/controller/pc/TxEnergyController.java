package com.xt.controller.pc;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiresAuthentication
@RequestMapping("energy")
public class TxEnergyController {

	// 基础路径
	final String BASEPATH = "energy/";

	@RequiresAuthentication
	@RequestMapping("consumption")
	public ModelAndView consumption() {
		ModelAndView modelAndView = new ModelAndView(BASEPATH + "consumption");
		return modelAndView;
	}

	@RequiresAuthentication
	@RequestMapping("conservation")
	public ModelAndView conservation() {
		ModelAndView modelAndView = new ModelAndView(BASEPATH + "conservation");
		return modelAndView;
	}
}
