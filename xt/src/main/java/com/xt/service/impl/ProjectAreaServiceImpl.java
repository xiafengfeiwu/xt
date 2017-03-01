package com.xt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.dao.generation.AreaMapper;
import com.xt.dao.generation.ProjectAreaMapper;
import com.xt.entity.generation.Area;
import com.xt.entity.generation.AreaExample;
import com.xt.entity.generation.ProjectArea;
import com.xt.entity.generation.ProjectAreaExample;
import com.xt.service.ProjectAreaService;

@Service
public class ProjectAreaServiceImpl implements ProjectAreaService {

	@Autowired
	ProjectAreaMapper projectAreaMapper;
	@Autowired
	AreaMapper areaMapper;

	@Override
	public List<ProjectArea> getProjectAreaData() {
		ProjectAreaExample example = new ProjectAreaExample();
		example.setOrderByClause("area_code asc");
		return projectAreaMapper.selectByExample(example);
	}

	@Override
	public ProjectArea getByAreaId(Long projectAreaId){
		return projectAreaMapper.selectByPrimaryKey(projectAreaId);
	}
	
	@Override
	public ProjectArea getByAreaCode(String areaCode) {
		ProjectAreaExample example = new ProjectAreaExample();
		example.createCriteria().andAreaCodeEqualTo(areaCode);
		List<ProjectArea> areas = projectAreaMapper.selectByExample(example);
		if (areas != null && areas.size() > 0) {
			return areas.get(0);
		}
		return null;
	}

	@Override
	public List<ProjectArea> getByParentAreaCode(String parentAreaCode) {
		ProjectAreaExample example = new ProjectAreaExample();
		example.createCriteria().andParentAreaCodeEqualTo(parentAreaCode);
		return projectAreaMapper.selectByExample(example);
	}

	@Override
	public List<Area> getChildArea(String parentCode) {
		AreaExample example = new AreaExample();
		example.createCriteria().andAreaParentCodeEqualTo(parentCode);
		return areaMapper.selectByExample(example);
	}

	@Override
	public void create(ProjectArea projectArea) {
		projectAreaMapper.insert(projectArea);
	}

	@Override
	public void update(ProjectArea projectArea) {
		projectAreaMapper.updateByPrimaryKey(projectArea);
	}

	@Override
	public void delete(Long projectAreaId) {
		// ProjectArea projectArea =
		// projectAreaMapper.selectByPrimaryKey(projectAreaId);
		// if (projectArea != null) {
		// ProjectAreaExample example = new ProjectAreaExample();
		// example.createCriteria().andParentAreaCodeEqualTo(projectArea.getAreaCode());
		// List<ProjectArea> childs =
		// projectAreaMapper.selectByExample(example);
		// if (childs != null && !childs.isEmpty()) {
		// return;
		// }
		// }
		projectAreaMapper.deleteByPrimaryKey(projectAreaId);
	}

}
