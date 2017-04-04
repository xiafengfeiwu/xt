package com.xt.service;

import java.util.Date;
import java.util.List;

import com.xt.entity.custom.MPumpEleStatistics;
import com.xt.entity.generation.PacketQuery;
import com.xt.entity.generation.PumpConstantlyData;
import com.xt.entity.generation.PumpEle;
import com.xt.entity.generation.PumpEleConstantly;
import com.xt.entity.generation.PumpEleStatistics;
import com.xt.entity.generation.PumpHistoryData;

public interface PumpCollectService {

	// 保存实时用电量
	void savePumpEle(PumpEle pumpEle);

	// 保存热泵历史数据表
	void savePumpHistory(PumpHistoryData historyData);

	// 保存热泵告警信息
	void savePumpWarn(String pumpId, String code);

	// 保存分时用电量
	void savePumpEleStatistics(PumpEleStatistics pumpEleStatistics);

	// 获取热泵用电实时数据
	PumpEleConstantly getPumpEleConstantlyData(String pumpId);

	// 批量获取热泵用电实时数据
	List<PumpEleConstantly> getPumpsEleConstantlyData(List<String> pumpIds);

	// 获取热泵用电分时最新数据
	PumpEleStatistics getPumpEleStatisticsLastData(String pumpId);

	// 获取日用电详情
	List<MPumpEleStatistics> getPumpEleData(List<String> pumpIds, Short year, Short month, Short day);

	// 获取热泵实时数据
	PumpConstantlyData getPumpConstantlyData(String pumpId);

	// 获取日数据采集详情
	List<PumpHistoryData> getPumpDayCollectData(String pumpId, Date date);

	// 获取最先插入的前100个报文数据（有效的）
	List<PacketQuery> getPacketQuery100();

	// 删除报文数据
	void deletePacket(Long packetId);

	// 更新报文数据
	void updatePacket(PacketQuery packetQuery);
}
