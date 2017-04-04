package com.xt.task;

import java.math.BigDecimal;
import java.util.List;

import org.apache.log4j.Logger;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import com.xt.entity.generation.Pump;
import com.xt.entity.generation.PumpEleConstantly;
import com.xt.entity.generation.PumpEleStatistics;
import com.xt.service.PumpCollectService;
import com.xt.service.PumpService;
import com.xt.util.PublicUtil;

@DisallowConcurrentExecution
public class PumpEleStatisticsQuartzJob implements Job {
	Logger logger = Logger.getLogger(PumpEleStatisticsQuartzJob.class);

	@Autowired
	PumpService pumpService;
	@Autowired
	PumpCollectService pumpCollectService;

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		logger.info("PumpEleStatisticsQuartzJob");
		// 定时执行
		// 每小时执行
		// 统计用电量

		// 获取所有热泵
		List<Pump> pumps = pumpService.getAll();
		if (pumps == null || pumps.isEmpty()) {
			return;
		}
		String pumpId = null;
		PumpEleConstantly pumpEleConstantly = null;
		PumpEleStatistics pumpEleStatistics = null;
		PumpEleStatistics sPumpEleStatistics = null;
		// 遍历
		for (Pump pump : pumps) {
			pumpId = pump.getPumpId();

			// 获取热泵最新用电情况
			pumpEleConstantly = pumpCollectService.getPumpEleConstantlyData(pumpId);

			sPumpEleStatistics = new PumpEleStatistics();
			sPumpEleStatistics.setDataId(PublicUtil.initId());
			sPumpEleStatistics.setPumpId(pumpId);
			sPumpEleStatistics.setIntervalYear(new Short(PublicUtil.getCurrentYear()));
			sPumpEleStatistics.setIntervalMonth(new Short(PublicUtil.getCurrentMonth()));
			sPumpEleStatistics.setIntervalDay(new Short(PublicUtil.getCurrentDay()));
			sPumpEleStatistics.setIntervalHour(new Short(PublicUtil.getCurrentHour()));

			if (pumpEleConstantly == null) {
				pumpEleConstantly = new PumpEleConstantly();
				pumpEleConstantly.setElectricity(new BigDecimal("0.00"));
			}
			sPumpEleStatistics.setEleTotal(pumpEleConstantly.getElectricity());
			// 获取热泵最新的分时用电情况
			pumpEleStatistics = pumpCollectService.getPumpEleStatisticsLastData(pumpId);
			if (pumpEleStatistics == null) {
				sPumpEleStatistics.setEleInterval(new BigDecimal("0.00"));
			} else {
				sPumpEleStatistics.setEleInterval(pumpEleConstantly.getElectricity().subtract(pumpEleStatistics.getEleTotal()));
			}
			pumpCollectService.savePumpEleStatistics(sPumpEleStatistics);

		}

	}

}
