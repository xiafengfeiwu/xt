package com.xt.service;

import java.util.List;

import com.xt.entity.custom.MAreaPump;
import com.xt.entity.generation.Project;

public interface ProjectService {
	// 获取项目数据
	List<Project> getProjectData();

	// 通过ID获取项目
	Project getProjectById(Long projectId);

	// 通过区域获取项目数据
	List<Project> getProjectByAreaCode(Long areaId);

	// 通过项目编号前缀获取项目最后编号
	String getLastProjectCode(String preCode);

	// 新增项目
	void create(Project project);

	// 更新项目
	void update(Project project);

	// 删除项目
	void delete(Long projectId);

	List<MAreaPump> selectUserAuthProjectArea(Long userId);

	List<MAreaPump> selectProjectPumpsByIds(List<Long> projectAreaIds);
}
