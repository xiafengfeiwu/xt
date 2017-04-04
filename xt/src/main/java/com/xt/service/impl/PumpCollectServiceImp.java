package com.xt.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.dao.custom.MPumpMapper;
import com.xt.dao.generation.PacketQueryMapper;
import com.xt.dao.generation.PumpConstantlyDataMapper;
import com.xt.dao.generation.PumpEleConstantlyMapper;
import com.xt.dao.generation.PumpEleMapper;
import com.xt.dao.generation.PumpEleStatisticsMapper;
import com.xt.dao.generation.PumpHistoryDataMapper;
import com.xt.entity.custom.MPumpEleStatistics;
import com.xt.entity.generation.PacketQuery;
import com.xt.entity.generation.PacketQueryExample;
import com.xt.entity.generation.PumpConstantlyData;
import com.xt.entity.generation.PumpEle;
import com.xt.entity.generation.PumpEleConstantly;
import com.xt.entity.generation.PumpEleConstantlyExample;
import com.xt.entity.generation.PumpEleStatistics;
import com.xt.entity.generation.PumpEleStatisticsExample;
import com.xt.entity.generation.PumpHistoryData;
import com.xt.entity.generation.PumpHistoryDataExample;
import com.xt.entity.generation.PumpWarn;
import com.xt.entity.generation.WarnGroupItem;
import com.xt.service.PumpCollectService;
import com.xt.service.PumpWarnService;
import com.xt.service.WarnGroupService;
import com.xt.util.PublicUtil;

@Service
public class PumpCollectServiceImp implements PumpCollectService {

	@Autowired
	PumpEleMapper pumpEleMapper;
	@Autowired
	PumpEleConstantlyMapper pumpEleConstantlyMapper;
	@Autowired
	PumpEleStatisticsMapper pumpEleStatisticsMapper;
	@Autowired
	PumpConstantlyDataMapper pumpConstantlyDataMapper;
	@Autowired
	PumpHistoryDataMapper pumpHistoryDataMapper;
	@Autowired
	PumpWarnService pumpWarnService;
	@Autowired
	WarnGroupService warnGroupService;
	@Autowired
	PacketQueryMapper packetQueryMapper;
	@Autowired
	MPumpMapper mPumpMapper;

	@Override
	public void savePumpEle(PumpEle pumpEle) {
		pumpEleMapper.insert(pumpEle);
		PumpEleConstantly constantlyData = new PumpEleConstantly();
		BeanUtils.copyProperties(pumpEle, constantlyData);
		savePumpEleConstantly(constantlyData);
	}

	private void savePumpEleConstantly(PumpEleConstantly constantlyData) {
		if (constantlyData != null) {
			PumpEleConstantly elec = getPumpEleConstantlyData(constantlyData.getPumpId());
			if (elec != null) {
				updatePumpEleConstantly(constantlyData);
			} else {
				pumpEleConstantlyMapper.insert(constantlyData);
			}
		}
	}

	private void updatePumpEleConstantly(PumpEleConstantly constantlyData) {
		pumpEleConstantlyMapper.updateByPrimaryKey(constantlyData);
	}

	@Override
	public PumpEleConstantly getPumpEleConstantlyData(String pumpId) {
		return pumpEleConstantlyMapper.selectByPrimaryKey(pumpId);
	}

	@Override
	public List<PumpEleConstantly> getPumpsEleConstantlyData(List<String> pumpIds) {
		PumpEleConstantlyExample example = new PumpEleConstantlyExample();
		example.createCriteria().andPumpIdIn(pumpIds);
		return pumpEleConstantlyMapper.selectByExample(example);
	}

	@Override
	public PumpEleStatistics getPumpEleStatisticsLastData(String pumpId) {
		PumpEleStatisticsExample example = new PumpEleStatisticsExample();
		example.createCriteria().andPumpIdEqualTo(pumpId);
		example.setOrderByClause(
				"interval_year desc, interval_month desc, interval_day desc, interval_hour desc limit 0,1");
		List<PumpEleStatistics> eles = pumpEleStatisticsMapper.selectByExample(example);
		if (eles != null && !eles.isEmpty()) {
			return eles.get(0);
		}
		return null;
	}

	@Override
	public void savePumpEleStatistics(PumpEleStatistics pumpEleStatistics) {
		pumpEleStatisticsMapper.insert(pumpEleStatistics);
	}

	@Override
	public List<MPumpEleStatistics> getPumpEleData(List<String> pumpIds, Short year, Short month, Short day) {
		if (day != null) {
			return mPumpMapper.selelctPumpEleDayStatistics(pumpIds, year, month, day);
		}
		if (month != null) {
			return mPumpMapper.selelctPumpEleMonthStatistics(pumpIds, year, month);
		}
		if (year != null) {
			return mPumpMapper.selelctPumpEleYearStatistics(pumpIds, year);
		}

		return mPumpMapper.selelctPumpEleAllStatistics(pumpIds);
	}

	private void savePumpConstantlyData(PumpConstantlyData constantlyData) {
		if (constantlyData != null) {
			PumpConstantlyData pd = getPumpConstantlyData(constantlyData.getPumpId());
			if (pd != null) {
				updatePumpConstantlyData(constantlyData);
			} else {
				pumpConstantlyDataMapper.insert(constantlyData);
			}
		}
	}

	private void updatePumpConstantlyData(PumpConstantlyData constantlyData) {
		pumpConstantlyDataMapper.updateByPrimaryKey(constantlyData);
	}

	@Override
	public PumpConstantlyData getPumpConstantlyData(String pumpId) {
		return pumpConstantlyDataMapper.selectByPrimaryKey(pumpId);
	}

	@Override
	public void savePumpHistory(PumpHistoryData historyData) {
		PumpConstantlyData constantlyData = new PumpConstantlyData();
		BeanUtils.copyProperties(historyData, constantlyData);
		pumpHistoryDataMapper.insert(historyData);
		savePumpConstantlyData(constantlyData);
	}

	@Override
	public List<PumpHistoryData> getPumpDayCollectData(String pumpId, Date date) {
		PumpHistoryDataExample example = new PumpHistoryDataExample();
		example.createCriteria().andPumpIdEqualTo(pumpId).andCollectTimeBetween(PublicUtil.getTodayMinTime(date),
				PublicUtil.getTodayMaxTime(date));
		example.setOrderByClause("collect_time asc");
		return pumpHistoryDataMapper.selectByExample(example);
	}

	@Override
	public void savePumpWarn(String pumpId, String code) {
		if ("0".equals(code) || "00".equals(code) || "0000".equals(code)) {
			return;
		}
		PumpWarn pumpWarn = pumpWarnService.getLastOneByPumpId(pumpId);
		if (pumpWarn != null && pumpWarn.getWarnCode().equals(code)) {
			if (new Date().getTime() - pumpWarn.getWarnHappenTime().getTime() < 30 * 60 * 1000) {
				return;
			}
		}
		pumpWarn = new PumpWarn();
		pumpWarn.setWarnId(PublicUtil.initId());
		pumpWarn.setPumpId(pumpId);
		pumpWarn.setWarnCode(code);
		pumpWarn.setWarnHappenTime(new Date());
		WarnGroupItem warnItem = warnGroupService.getWarnGroupItemByCode(code);
		if (warnItem != null) {
			pumpWarn.setWarnDescript(warnItem.getWarnDescript());
			pumpWarn.setWarnLevel(warnItem.getWarnLevel());
		} else {
			pumpWarn.setWarnDescript("未知告警，请检查供应商设备告警代码，请配置相关参数。");
			pumpWarn.setWarnLevel("信息");
		}
		pumpWarn.setWarnNo("W" + PublicUtil.initId());
		pumpWarnService.create(pumpWarn);
	}

	// 获取最先插入的前100个报文数据（有效的）
	@Override
	public List<PacketQuery> getPacketQuery100() {
		PacketQueryExample example = new PacketQueryExample();
		example.createCriteria().andPacketStatusEqualTo("A");
		example.setOrderByClause("collect_time asc limit 0, 100");
		return packetQueryMapper.selectByExample(example);
	}

	// 删除报文数据
	@Override
	public void deletePacket(Long packetId) {
		packetQueryMapper.deleteByPrimaryKey(packetId);
	}

	// 更新报文数据
	@Override
	public void updatePacket(PacketQuery packetQuery) {
		packetQueryMapper.updateByPrimaryKey(packetQuery);
	}

}
