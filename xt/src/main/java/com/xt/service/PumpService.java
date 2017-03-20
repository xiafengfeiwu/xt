package com.xt.service;

import java.util.List;

import com.xt.entity.custom.MAreaPump;
import com.xt.entity.custom.MPumpMonitor;
import com.xt.entity.custom.MPumpWarnGroup;
import com.xt.entity.generation.Pump;
import com.xt.entity.generation.PumpWarnGroup;
import com.xt.entity.generation.PumpWarnGroupKey;

public interface PumpService {

	// 通过ID获取热泵信息
	Pump getById(String pumpId);

	// 通过Sn获取热泵信息
	Pump getBySn(String pumpSn);

	String getLastPumpCode(String preCode);

	// 新增热泵
	void create(Pump pump);

	// 新增热泵
	void update(Pump pump);

	// 删除热泵
	void delete(String pumpId);

	// 获取所有热泵信息
	List<Pump> getAll();

	// 获取农户(所有人)所有热泵信息
	List<Pump> getOwnerAll(String ownerId);

	// 获取项目下所有热泵信息
	List<Pump> getProjectAll(String projectId);

	// 获取项目区域下所有热泵信息
	List<MAreaPump> getProjectAreaAll(String projectAreaId);

	List<MAreaPump> selectUserAuthPump(String userId);

	List<MAreaPump> selectPumpsByIds(List<String> pumpIds);

	List<MAreaPump> selectPumpsByCodes(List<String> pumpCodes);

	List<MPumpMonitor> selectAllPumpMonitors();

	List<MPumpWarnGroup> selectPumpWarnGroups(String pumpId);

	void addPumpWarnGroup(PumpWarnGroup warnGroup);

	void removePumpWarnGroup(PumpWarnGroupKey key);
}