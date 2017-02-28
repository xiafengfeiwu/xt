package com.xt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.dao.generation.ProjectMapper;
import com.xt.entity.generation.Project;
import com.xt.entity.generation.ProjectExample;
import com.xt.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	ProjectMapper projectMapper;

	@Override
	public List<Project> getProjectData() {
		ProjectExample example = new ProjectExample();
		example.setOrderByClause("owner_id asc, create_time asc");
		return projectMapper.selectByExample(example);
	}

	@Override
	public void create(Project project) {
		projectMapper.insert(project);
	}

	@Override
	public void update(Project project) {
		projectMapper.updateByPrimaryKey(project);
	}

	@Override
	public void delete(Long projectId) {
		projectMapper.deleteByPrimaryKey(projectId);
	}

}
