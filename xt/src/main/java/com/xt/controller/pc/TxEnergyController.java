package com.xt.controller.pc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("energy")
public class TxEnergyController {

	// 基础路径
	final String BASEPATH = "energy/";

	@RequestMapping("consumption")
	public ModelAndView consumption() {
		ModelAndView modelAndView = new ModelAndView(BASEPATH + "consumption");
		return modelAndView;
	}

	@RequestMapping("conservation")
	public ModelAndView conservation() {
		ModelAndView modelAndView = new ModelAndView(BASEPATH + "conservation");
		return modelAndView;
	}
}
