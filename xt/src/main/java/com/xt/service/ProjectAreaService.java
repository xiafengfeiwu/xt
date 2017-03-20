package com.xt.service;

import java.util.List;

import com.xt.entity.generation.Area;
import com.xt.entity.generation.ProjectArea;

public interface ProjectAreaService {

	// 获取项目区域数据
	List<ProjectArea> getProjectAreaData();

	// 获取跟节点
	List<ProjectArea> getParentProjectArea();

	// 通过区域ID获取区域信息
	ProjectArea getByAreaId(Long projectAreaId);

	// 通过区域编码获取区域信息
	ProjectArea getByAreaCode(String areaCode);

	// 通过父级区域编码获取区域信息
	List<ProjectArea> getByParentAreaCode(String parentAreaCode);

	// 通过父级区域ID获取区域信息
	List<ProjectArea> getByParentAreaId(Long parentAreaId);

	// 通过父级编码获取子级
	List<Area> getChildArea(String parentCode);

	// 新增项目区域
	void create(ProjectArea projectArea);

	// 更新项目区域
	void update(ProjectArea projectArea);

	// 删除项目区域
	void delete(Long projectAreaId);
}
