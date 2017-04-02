package com.xt.service;

import java.util.List;

import com.xt.entity.generation.PumpWarn;

public interface PumpWarnService {

	void create(PumpWarn pumpWarn);

	void delete(String pumpWarnId);

	PumpWarn getById(String pumpWarnId);

	List<PumpWarn> getByPumpId(String pumpId);

	// 获取最新的告警信息
	PumpWarn getLastOneByPumpId(String pumpId);
}
