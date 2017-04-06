package com.xt.task;

import org.apache.log4j.Logger;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import com.xt.entity.generation.WeatherAlarm;
import com.xt.service.CityWeatherService;
import com.xt.util.WeatherHttpUtil;

@DisallowConcurrentExecution
public class WeatherAlarmQuartzJob implements Job {

	Logger logger = Logger.getLogger(WeatherAlarmQuartzJob.class);

	@Autowired
	CityWeatherService cityWeatherService;

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		logger.info("WeatherAlarmQuartzJob...");
		String[] codes = { "CN101010100", "CN101010200", "CN101010300", "CN101010400", "CN101010500", "CN101010600",
				"CN101010700", "CN101010800", "CN101010900", "CN101011000", "CN101011100", "CN101011200", "CN101011300",
				"CN101011400", "CN101011500" };
		WeatherAlarm alarm = WeatherHttpUtil.getWeatherAlarm();
		if (alarm != null) {
			for (String c : codes) {
				alarm.setWeatherCityCode(c);
				cityWeatherService.upInsertWeaterAlarm(alarm);
			}
		}
	}

}
