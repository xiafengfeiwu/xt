package com.xt.controller.pc;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xt.dao.custom.MProjectArea;
import com.xt.entity.generation.Project;
import com.xt.entity.generation.ProjectArea;
import com.xt.service.ProjectAreaService;
import com.xt.service.ProjectService;
import com.xt.util.PublicUtil;

@Controller
@RequestMapping("manage")
public class TxManageController {
	// 基础路径
	final String BASEPATH = "manage/";

	@Autowired
	ProjectService projectService;
	@Autowired
	ProjectAreaService projectAreaService;

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
		if (project.getProjectAreaId() == null) {
			data.put("message", "无效的区域信息");
			return data;
		}
		if (PublicUtil.isEmpty(project.getProjectName())) {
			data.put("message", "请输入项目名称");
			return data;
		}
		if (PublicUtil.isEmpty(project.getOwnerId())) {
			data.put("message", "请选择业主信息");
			return data;
		}
		if (PublicUtil.isEmpty(project.getOwnerPhoneNo())) {
			data.put("message", "请输入业主联系方式");
			return data;
		}
		if (PublicUtil.isEmpty(project.getOwnerType())) {
			data.put("message", "请选择业主类别");
			return data;
		}

		ProjectArea projectArea = projectAreaService.getByAreaId(project.getProjectAreaId());
		if (projectArea == null) {
			data.put("message", "无效的区域信息");
			return data;
		}

		project.setProjectId(PublicUtil.initId());
		// ToDo : 项目编码生产规则设计
		project.setProjectCode("P" + PublicUtil.initId());
		project.setCreateTime(new Date());
		project.setModifyTime(new Date());

		projectService.create(project);

		data.put("success", true);
		data.put("message", "创建成功");
		data.put("project", project);
		return data;
	}

	@ResponseBody
	@RequestMapping("change-project")
	public Map<String, Object> changeProject(@RequestBody(required = true) Project project) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		if (project == null) {
			data.put("message", "无效的数据");
			return data;
		}
		if (project.getProjectId() == null) {
			data.put("message", "无效的项目信息");
			return data;
		}
		if (PublicUtil.isEmpty(project.getProjectName())) {
			data.put("message", "请输入项目名称");
			return data;
		}
		if (PublicUtil.isEmpty(project.getOwnerName())) {
			data.put("message", "请输入业主名称");
			return data;
		}
		if (PublicUtil.isEmpty(project.getOwnerPhoneNo())) {
			data.put("message", "请输入业主联系方式");
			return data;
		}
		if (PublicUtil.isEmpty(project.getOwnerType())) {
			data.put("message", "请选择业主类别");
			return data;
		}

		Project _project = projectService.getProjectById(project.getProjectId());
		if (_project == null) {
			data.put("message", "无效的区域信息");
			return data;
		}

		_project.setProjectName(project.getProjectName());
		_project.setOwnerName(project.getOwnerName());
		_project.setOwnerPhoneNo(project.getOwnerPhoneNo());
		_project.setOwnerType(project.getOwnerType());
		_project.setModifyTime(new Date());

		projectService.update(_project);

		data.put("success", true);
		data.put("message", "修改成功");
		data.put("project", _project);
		return data;
	}

	@ResponseBody
	@RequestMapping("delete-project")
	public Map<String, Object> deleteProject(Long projectId) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		if (projectId == null) {
			data.put("message", "无效的数据");
			return data;
		}

		// 检查项目下热泵信息
		projectService.delete(projectId);

		data.put("success", true);
		data.put("message", "删除成功");
		return data;
	}

	@RequestMapping("project-area")
	public ModelAndView projectArea() {
		ModelAndView modelAndView = new ModelAndView(BASEPATH + "project-area");
		return modelAndView;
	}

	@ResponseBody
	@RequestMapping("project-area-data")
	public Map<String, Object> projectAreaData() {
		Map<String, Object> data = new HashMap<>();
		List<ProjectArea> projectAreas = projectAreaService.getProjectAreaData();
		List<MProjectArea> mProjectAreas = new ArrayList<>();
		if (projectAreas != null && !projectAreas.isEmpty()) {
			for (ProjectArea projectArea : projectAreas) {
				MProjectArea mProjectArea = new MProjectArea();
				BeanUtils.copyProperties(projectArea, mProjectArea);
				mProjectArea.setChildren(new ArrayList<MProjectArea>());
				mProjectAreas.add(mProjectArea);
			}
		}
		data.put("data", buildListToTree(mProjectAreas));
		return data;
	}

	@ResponseBody
	@RequestMapping("child-area-data")
	public Map<String, Object> childAreaData(String parentCode) {
		Map<String, Object> data = new HashMap<>();
		data.put("data", projectAreaService.getChildArea(parentCode));
		return data;
	}

	@ResponseBody
	@RequestMapping("add-child-area")
	public Map<String, Object> addChildArea(@RequestBody(required = true) ProjectArea area) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		if (area == null) {
			data.put("message", "无效的数据");
			return data;
		}
		if (PublicUtil.isEmpty(area.getAreaCode())) {
			data.put("message", "无效的区域编码");
			return data;
		}
		if (PublicUtil.isEmpty(area.getParentAreaCode())) {
			data.put("message", "无效的父级区域编码");
			return data;
		}
		if (PublicUtil.isEmpty(area.getWeatherCode())) {
			data.put("message", "无效的区域天气编码");
			return data;
		}
		ProjectArea projectArea = projectAreaService.getByAreaCode(area.getAreaCode());
		if (projectArea != null) {
			data.put("message", "当前区域已被创建");
			return data;
		}

		area.setProjectAreaId(PublicUtil.initId());
		area.setCreateTime(new Date());
		area.setModifyTime(new Date());

		projectAreaService.create(area);

		MProjectArea mProjectArea = new MProjectArea();
		BeanUtils.copyProperties(area, mProjectArea);
		mProjectArea.setChildren(new ArrayList<>());
		data.put("area", mProjectArea);
		data.put("success", true);

		return data;
	}

	@ResponseBody
	@RequestMapping("delete-area")
	public Map<String, Object> deleteArea(String areaCode) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		if (PublicUtil.isEmpty(areaCode)) {
			data.put("message", "请传入区域编码");
			return data;
		}
		if ("110000".equals(areaCode)) {
			data.put("message", "不可删除顶级节点");
			return data;
		}
		ProjectArea projectArea = projectAreaService.getByAreaCode(areaCode);
		if (projectArea == null) {
			data.put("message", "无效的区域编码");
			return data;
		}
		List<ProjectArea> childs = projectAreaService.getByParentAreaCode(areaCode);
		if (childs != null && !childs.isEmpty()) {
			data.put("message", "存在子级区域，不可删除");
			return data;
		}
		List<Project> project = projectService.getProjectByAreaCode(projectArea.getProjectAreaId());
		if (project != null && !project.isEmpty()) {
			data.put("message", "存在关联项目，不可删除");
			return data;
		}
		projectAreaService.delete(projectArea.getProjectAreaId());
		data.put("success", true);
		data.put("message", "删除成功");
		return data;
	}

	private List<MProjectArea> buildListToTree(List<MProjectArea> mProjectAreas) {
		if (mProjectAreas == null || mProjectAreas.isEmpty()) {
			return mProjectAreas;
		}
		List<MProjectArea> roots = findListRoots(mProjectAreas);
		List<MProjectArea> childs = (List<MProjectArea>) CollectionUtils.subtract(mProjectAreas, roots);
		for (MProjectArea root : roots) {
			root.setChildren(findChildren(root, childs));
		}
		return roots;
	}

	private List<MProjectArea> findListRoots(List<MProjectArea> mProjectAreas) {
		List<MProjectArea> roots = new ArrayList<MProjectArea>();
		for (MProjectArea mProjectArea : mProjectAreas) {
			if (PublicUtil.isEmpty(mProjectArea.getParentAreaCode())) {
				roots.add(mProjectArea);
			}
		}
		return roots;
	}

	private List<MProjectArea> findChildren(MProjectArea root, List<MProjectArea> allNodes) {
		List<MProjectArea> children = new ArrayList<MProjectArea>();
		for (MProjectArea comparedOne : allNodes) {
			if (comparedOne.getParentAreaCode().equals(root.getAreaCode())) {
				children.add(comparedOne);
			}
		}
		if (children.size() > 0) {
			List<MProjectArea> notChildren = (List<MProjectArea>) CollectionUtils.subtract(allNodes, children);
			for (MProjectArea child : children) {
				child.setChildren(findChildren(child, notChildren));
			}
		}
		return children;
	}

	@RequestMapping("device")
	public ModelAndView device() {
		ModelAndView modelAndView = new ModelAndView(BASEPATH + "device");
		return modelAndView;
	}

}
