package com.xt.service;

import java.util.List;

import com.xt.entity.generation.Res;

public interface ResService {

	// 新增资源
	void insert(Res res);

	// 删除资源
	void delete(String resId);

	// 通过ID获取资源
	Res getById(String resId);

	// 通过GroupId获取所有资源
	List<Res> findResByGroupId(String groupId);

}
