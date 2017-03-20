package com.xt.task;

import java.net.Socket;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.xt.util.CollectDataUtil;

@DisallowConcurrentExecution
public class AnalysisQuartzJob implements Job {
	Logger logger = Logger.getLogger(AnalysisQuartzJob.class);

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {

		Map<String, Socket> sockets = CollectDataUtil.getPool();
		Map<String, Socket> socketAs = CollectDataUtil.getPoolA();

		logger.info("socket size:" + sockets.size());
		logger.info("socketA size:" + socketAs.size());

		for (Entry<String, Socket> dat : sockets.entrySet()) {
			String key = dat.getKey();
			Socket socket = dat.getValue();
			logger.info(key + " ：" + socket.getInetAddress().getHostAddress() + ":" + socket.getPort());
		}
		logger.info("——————————————————————————————————————");
		for (Entry<String, Socket> dat : socketAs.entrySet()) {
			String key = dat.getKey();
			logger.info(key);
		}

	}

}
