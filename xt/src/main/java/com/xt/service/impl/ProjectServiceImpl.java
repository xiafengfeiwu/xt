package com.xt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.dao.custom.MProjectMapper;
import com.xt.dao.generation.ProjectMapper;
import com.xt.entity.custom.MAreaPump;
import com.xt.entity.custom.MLastCode;
import com.xt.entity.generation.Project;
import com.xt.entity.generation.ProjectExample;
import com.xt.service.ProjectService;
import com.xt.util.PublicUtil;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	ProjectMapper projectMapper;
	@Autowired
	MProjectMapper mProjectMapper;

	@Override
	public List<Project> getProjectData() {
		ProjectExample example = new ProjectExample();
		example.setOrderByClause("owner_id asc, create_time asc");
		return projectMapper.selectByExample(example);
	}

	@Override
	public Project getProjectById(String projectId) {
		return projectMapper.selectByPrimaryKey(projectId);
	}

	@Override
	public List<Project> getProjectByAreaCode(String areaId) {
		ProjectExample example = new ProjectExample();
		example.createCriteria().andProjectAreaIdEqualTo(areaId);
		example.setOrderByClause("owner_id asc, create_time asc");
		return projectMapper.selectByExample(example);
	}

	@Override
	public String getLastProjectCode(String preCode) {
		MLastCode pc = mProjectMapper.selectLastProjectcode(preCode);
		if (pc == null) {
			return preCode + "0001";
		}
		return PublicUtil.getNextCode(pc.getCode());
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
	public void delete(String projectId) {
		projectMapper.deleteByPrimaryKey(projectId);
	}

	@Override
	public List<MAreaPump> selectUserAuthProjectArea(String userId) {
		return mProjectMapper.selectUserAuthProjectArea(userId);
	}

	@Override
	public List<MAreaPump> selectProjectPumpsByIds(List<String> projectAreaIds) {
		return mProjectMapper.selectProjectPumpsByIds(projectAreaIds);
	}
}
