package com.xt.service;

import java.util.List;

import com.xt.entity.generation.Pump;

public interface PumpService {

	// 通过ID获取热泵信息
	Pump getById(Long pumpId);

	// 新增热泵
	void create(Pump pump);

	// 新增热泵
	void update(Pump pump);

	// 删除热泵
	void delete(Long pumpId);

	// 获取热泵记录条数
	long getCountByPage(String searchWord);

	// 分页获取热泵信息
	List<Pump> getListByPage(String searchWord, String field, String order);

	// 获取农户(所有人)所有热泵信息
	List<Pump> getOwnerAllPumps(Long ownerId);
}