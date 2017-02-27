package com.xt.controller.pc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("monitor")
public class TxMonitorController {

	// 基础路径
	final String BASEPATH = "monitor/";

	@RequestMapping("pump")
	public ModelAndView pump() {
		ModelAndView modelAndView = new ModelAndView(BASEPATH + "pump");
		return modelAndView;
	}

	@RequestMapping("warn")
	public ModelAndView warn() {
		ModelAndView modelAndView = new ModelAndView(BASEPATH + "warn");
		return modelAndView;
	}

	@RequestMapping("report")
	public ModelAndView report() {
		ModelAndView modelAndView = new ModelAndView(BASEPATH + "report");
		return modelAndView;
	}

	@RequestMapping("console")
	public ModelAndView console() {
		ModelAndView modelAndView = new ModelAndView(BASEPATH + "console");
		return modelAndView;
	}

}
