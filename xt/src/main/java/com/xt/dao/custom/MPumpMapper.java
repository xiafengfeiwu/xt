package com.xt.dao.custom;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xt.entity.custom.MAreaPump;
import com.xt.entity.custom.MLastCode;
import com.xt.entity.custom.MPumpMonitor;
import com.xt.entity.custom.MPumpStoppage;
import com.xt.entity.custom.MPumpWarnGroup;

public interface MPumpMapper {
	// 获取项目下的直接热泵信息
	List<MAreaPump> selectAreaPumps(@Param("projectAreaId") String projectAreaId);

	// 获取项目下的所有热泵信息
	List<MAreaPump> selectAreaDepthPumps(@Param("projectAreaId") String projectAreaId);

	// 通过热泵ID列表批量获取热泵信息
	List<MAreaPump> selectPumpsByIds(@Param("pumpIds") List<String> pumpIds);

	// 获取热泵最新编码
	MLastCode selectLastPumpcode(@Param("preCode") String preCode);

	// 获取用户已授权的热泵根节点
	List<MAreaPump> selectUserAuthPump(@Param("userId") String userId);

	// 通过热泵Code列表批量获取热泵信息
	List<MAreaPump> selectPumpsByCodes(@Param("pumpCodes") List<String> pumpCodes);

	// 获取所有热泵监测数据
	List<MPumpMonitor> selectAllPumpMonitors();

	// 获取热泵的告警组信息
	List<MPumpWarnGroup> selectPumpWarnGroups(@Param("pumpId") String pumpId);

	// 获取热泵非使用的告警组
	List<MPumpWarnGroup> selectPumpNoUseWarnGroups(@Param("ownerId") String ownerId, @Param("pumpId") String pumpId);

	List<MPumpStoppage> selectStoppagesByPumpIds(@Param("pumpIds") List<String> pumpIds);

	List<MPumpStoppage> selectAllStoppages();
}