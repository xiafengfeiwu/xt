package com.xt.task;

import java.util.List;

import org.apache.log4j.Logger;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import com.xt.entity.generation.PacketQuery;
import com.xt.entity.generation.PumpWarn;
import com.xt.service.PumpCollectService;
import com.xt.service.PumpService;
import com.xt.service.PumpWarnService;

@DisallowConcurrentExecution
public class PumpCollectQuartzJob implements Job {
	Logger logger = Logger.getLogger(PumpCollectQuartzJob.class);

	@Autowired
	PumpService pumpService;
	@Autowired
	PumpCollectService pumpCollectService;
	@Autowired
	PumpWarnService pumpWarnService;

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		logger.info("PumpCollectQuartzJob");
		List<PacketQuery> querys = pumpCollectService.getPacketQuery100();
		if (querys != null && !querys.isEmpty()) {
			for (PacketQuery packet : querys) {
				// String data = packet.getPacketData();
				
				logger.info("analysis with save");

				String pumpId = "";

				// 保存用电量信息
				// pumpCollectService.savePumpEle(pumpEle);
				
				// 保存采集实时数据
				// pumpCollectService.savePumpHistory(historyData);

				// 获取热泵告警组
				List<PumpWarn> warns = pumpWarnService.getByPumpId(pumpId);
				if (warns != null && !warns.isEmpty()) {
					for(PumpWarn warn : warns) {
						// 获取项
						// 和packet数值比对
						// 产生告警
						// warn.getWarnCode();
						// 保存自定义告警
					}
				}

				// 保存采集热泵告警信息
				// pumpCollectService.savePumpWarn(pumpId, code);
				
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
				}
			}
		}

	}

}
