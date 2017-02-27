package com.xt.controller.pc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("weather")
public class TxWeatherController {

	// 基础路径
	final String BASEPATH = "weather/";

	@RequestMapping("area-weather")
	public ModelAndView areaWeather() {
		ModelAndView modelAndView = new ModelAndView(BASEPATH + "area-weather");
		return modelAndView;
	}

	@RequestMapping("early-warning")
	public ModelAndView earlyWarning() {
		ModelAndView modelAndView = new ModelAndView(BASEPATH + "early-warning");
		return modelAndView;
	}

	@RequestMapping("system-set")
	public ModelAndView systemSet() {
		ModelAndView modelAndView = new ModelAndView(BASEPATH + "system-set");
		return modelAndView;
	}

}