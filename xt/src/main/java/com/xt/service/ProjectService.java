package com.xt.service;

import java.util.List;

import com.xt.entity.generation.Project;

public interface ProjectService {

	// 获取项目数据
	List<Project> getProjectData();

	// 新增项目
	void create(Project project);

	// 更新项目
	void update(Project project);

	// 删除项目
	void delete(Long projectId);
}
