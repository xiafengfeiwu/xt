package com.xt.task;

import org.apache.log4j.Logger;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

@DisallowConcurrentExecution
public class AnalysisQuartzJob implements Job {
	Logger logger = Logger.getLogger(AnalysisQuartzJob.class);

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		logger.info(context.getFireTime().getTime());
	}

}
