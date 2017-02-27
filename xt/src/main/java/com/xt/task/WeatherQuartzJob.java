package com.xt.task;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

import net.sf.json.JSONObject;

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
			WeatherData wd = cityWeatherService.findTodayCityWeatherByCode(code);
			if (wd != null && wd.getLastUpdateTime().getTime() - new Date().getTime() < 30 * 60 * 1000) {
				logger.info(code + " : 无更新天气");
				continue;
			}
			// 通过城市编码获取天气详情
			String w_url = WeatherURL.replaceAll("#CITYCODE#", code).replaceAll("#KEY#", key0);
			try {
				String result = HttpUtil.getRequest(w_url);
				// 解析result
				WeatherData weatherData = analysisWeatherDataJson(result);
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
				WeatherAlarm weatherAlarm = analysisAlarmDataJson(result);
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

	private WeatherData analysisWeatherDataJson(String json) {
		try {
			JSONObject object = JSONObject.fromObject(json);
			JSONObject root = object.getJSONArray("HeWeather5").getJSONObject(0);
			String status = root.getString("status");
			if (!"ok".equals(status)) {
				logger.error("解析天气数据失败：" + json);
				return null;
			}
			JSONObject basic = root.getJSONObject("basic");
			WeatherData data = new WeatherData();
			data.setWeatherCityCode(basic.getString("id"));
			JSONObject update = basic.getJSONObject("update");
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			data.setCollectDate(df.parse(update.getString("loc")));
			JSONObject now = root.getJSONObject("now");
			JSONObject cond = now.getJSONObject("cond");
			data.setCondCode(cond.getString("code"));
			data.setCondCodeUrl(cityWeatherService.findWeatherIconByCode(data.getCondCode()).getIcon());
			data.setCondTxt(cond.getString("txt"));
			data.setFl(now.getString("fl"));
			data.setHum(now.getString("hum"));
			data.setPcpn(now.getString("pcpn"));
			data.setPres(now.getString("pres"));
			data.setTmp(now.getString("tmp"));
			data.setVis(now.getString("vis"));
			JSONObject wind = now.getJSONObject("wind");
			data.setWindDeg(wind.getString("deg"));
			data.setWindDir(wind.getString("dir"));
			data.setWindSc(wind.getString("sc"));
			data.setWindSpd(wind.getString("spd"));
			data.setLastUpdateTime(new Date());
			return data;
		} catch (Exception e) {
			return null;
		}
	}

	private WeatherAlarm analysisAlarmDataJson(String json) {
		try {
			JSONObject object = JSONObject.fromObject(json);
			JSONObject root = object.getJSONArray("HeWeather5").getJSONObject(0);
			String status = root.getString("status");
			if (!"ok".equals(status)) {
				logger.error("解析天气预警数据失败：" + json);
				return null;
			}
			JSONObject basic = root.getJSONObject("basic");
			WeatherAlarm data = new WeatherAlarm();
			data.setWeatherCityCode(basic.getString("id"));
			Object alarms = root.get("alarms");
			if (alarms == null) {
				return data;
			}
			JSONObject alarm = root.getJSONArray("alarms").getJSONObject(0);
			data.setEarlyWarnLevel(alarm.getString("level"));
			data.setEarlyWarnStat(alarm.getString("stat"));
			data.setEarlyWarnTitle(alarm.getString("title"));
			data.setEarlyWarnTxt(alarm.getString("txt"));
			data.setEarlyWarnType(alarm.getString("type"));
			data.setEarlyWarnTime(new Date());
			return data;
		} catch (Exception e) {
			return null;
		}
	}
}
