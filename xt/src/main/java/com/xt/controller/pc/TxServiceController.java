package com.xt.controller.pc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("service")
public class TxServiceController {

	// 基础路径
	final String BASEPATH = "service/";

	@RequestMapping("support")
	public ModelAndView support() {
		ModelAndView modelAndView = new ModelAndView(BASEPATH + "support");
		return modelAndView;
	}

	@RequestMapping("repair")
	public ModelAndView repair() {
		ModelAndView modelAndView = new ModelAndView(BASEPATH + "repair");
		return modelAndView;
	}

	@RequestMapping("handling")
	public ModelAndView handling() {
		ModelAndView modelAndView = new ModelAndView(BASEPATH + "handling");
		return modelAndView;
	}

}