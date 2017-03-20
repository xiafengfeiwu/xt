package com.xt.controller.pc;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("tpl")
public class TplController {

	// 基础路径
	final String BASEPATH = "tpl/";

	@RequiresAuthentication
	@RequestMapping("/{path}")
	public ModelAndView dashboard(@PathVariable("path") String path) {
		ModelAndView modelAndView = new ModelAndView(BASEPATH + path);
		return modelAndView;
	}

}