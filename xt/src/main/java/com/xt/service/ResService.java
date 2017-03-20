package com.xt.service;

import java.util.List;

import com.xt.entity.generation.Res;

public interface ResService {

	// 新增资源
	void insert(Res res);

	// 新增图片
	void update(Res res);

	// 删除资源
	void delete(String resId);

	// 通过GroupId获取所有资源
	List<Res> findResByGroupId(String groupId);

	// 通过GroupId获取默认路径
	Res findDefaultByGroup(String groupId);

}
