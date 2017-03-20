package com.xt.task;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import com.xt.entity.generation.WeatherAlarm;
import com.xt.entity.generation.WeatherCity;
import com.xt.entity.generation.WeatherData;
import com.xt.entity.generation.WeatherKey;
import com.xt.service.CityWeatherService;
import com.xt.util.HttpUtil;
import com.xt.util.PublicUtil;

// 0 0 0,6,13,17 * * ?
@DisallowConcurrentExecution
public class WeatherQuartzJob implements Job {

	private final static String WeatherURL = "https://free-api.heweather.com/v5/now?city=#CITYCODE#&key=#KEY#";
	private final static String AlarmURL = "https://free-api.heweather.com/v5/alarm?city=#CITYCODE#&key=#KEY#";

	Logger logger = Logger.getLogger(WeatherQuartzJob.class);

	@Autowired
	CityWeatherService cityWeatherService;

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		logger.info(context.getFireTime().getTime());

		List<WeatherCity> wcs = cityWeatherService.findAllCity();
		// 获取要进行更新的天气的城市编码 LIST
		Set<String> cityCodes = new HashSet<>();
		for (WeatherCity wc : wcs) {
			cityCodes.add(wc.getCode());
		}
		List<WeatherKey> weatherKeys = cityWeatherService.findWeatherKeys();
		if (weatherKeys == null || weatherKeys.isEmpty() || weatherKeys.size() < 2) {
			logger.error("未配置第三方天气接口KEY值");
			return;
		}
		String key0 = weatherKeys.get(0).getWeatherKey();
		String key1 = weatherKeys.get(1).getWeatherKey();
		// 遍历城市编码
		for (String code : cityCodes) {
			WeatherData wd = cityWeatherService.findCityWeatherByCode(code);
			if (wd != null && new Date().getTime() - wd.getLastUpdateTime().getTime() < 30 * 60 * 1000) {
				logger.info(code + " : 无更新天气");
				continue;
			}
			// 通过城市编码获取天气详情
			String w_url = WeatherURL.replaceAll("#CITYCODE#", code).replaceAll("#KEY#", key0);
			try {
				String result = HttpUtil.getRequest(w_url);
				// 解析result
				WeatherData weatherData = PublicUtil.analysisWeatherDataJson(result, cityWeatherService);
				// 插入更新天气信息
				if (weatherData != null) {
					cityWeatherService.upInsertWeatherData(weatherData);
				}
			} catch (Exception e) {
				logger.error("Weather E " + e.getMessage());
			}
			// 通过城市编码获取预警信息
			String a_url = AlarmURL.replaceAll("#CITYCODE#", code).replaceAll("#KEY#", key1);
			try {
				String result = HttpUtil.getRequest(a_url);
				// 解析result
				WeatherAlarm weatherAlarm = PublicUtil.analysisAlarmDataJson(result);
				logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>" + weatherAlarm);
				// 插入更新预警信息
				if (weatherAlarm != null) {
					if (weatherAlarm.getEarlyWarnTime() == null) {
						if (cityWeatherService.findWeatherAlarmByCode(weatherAlarm.getWeatherCityCode()) != null) {
							cityWeatherService.clearWeaterAlarm(weatherAlarm.getWeatherCityCode());
						}
					} else {
						logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>" + result);
						cityWeatherService.upInsertWeaterAlarm(weatherAlarm);
					}
				}
			} catch (Exception e) {
				logger.error("Alarm E " + e.getMessage());
			}
		}
	}

}
