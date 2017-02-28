package com.xt.controller.pc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xt.entity.generation.Project;
import com.xt.service.ProjectService;

@Controller
@RequestMapping("manage")
public class TxManageController {
	// 基础路径
	final String BASEPATH = "manage/";

	@Autowired
	ProjectService projectService;

	@RequestMapping("project")
	public ModelAndView project() {
		ModelAndView modelAndView = new ModelAndView(BASEPATH + "project");
		return modelAndView;
	}

	@ResponseBody
	@RequestMapping("project-data")
	public Map<String, Object> projectData() {
		Map<String, Object> data = new HashMap<>();
		List<Project> projects = projectService.getProjectData();
		data.put("data", projects);
		return data;
	}

	@ResponseBody
	@RequestMapping("add-project")
	public Map<String, Object> addProject(@RequestBody(required = true) Project project) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		if (project == null) {
			data.put("message", "无效的数据");
			return data;
		}
		data.put("success", true);
		data.put("project", project);
		return data;
	}

	@RequestMapping("project-area")
	public ModelAndView projectArea() {
		ModelAndView modelAndView = new ModelAndView(BASEPATH + "project-area");
		return modelAndView;
	}

	@RequestMapping("device")
	public ModelAndView device() {
		ModelAndView modelAndView = new ModelAndView(BASEPATH + "device");
		return modelAndView;
	}

}
