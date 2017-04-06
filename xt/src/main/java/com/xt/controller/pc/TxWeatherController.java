package com.xt.controller.pc;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xt.entity.custom.MWeatherSystemSetParam;
import com.xt.entity.generation.WeatherAlarm;
import com.xt.entity.generation.WeatherCity;
import com.xt.entity.generation.WeatherData;
import com.xt.entity.generation.WeatherKey;
import com.xt.service.CityWeatherService;
import com.xt.util.HttpUtil;
import com.xt.util.PublicUtil;

@Controller
@RequiresAuthentication
@RequestMapping("weather")
public class TxWeatherController {
	final String WeatherURL = "https://free-api.heweather.com/v5/now?city=#CITYCODE#&key=#KEY#";
	final String AlarmURL = "https://free-api.heweather.com/v5/alarm?city=#CITYCODE#&key=#KEY#";

	// 基础路径
	final String BASEPATH = "weather/";

	@Autowired
	CityWeatherService cityWeatherService;

	@RequiresAuthentication
	@RequestMapping("area-weather")
	public ModelAndView areaWeather() {
		ModelAndView modelAndView = new ModelAndView(BASEPATH + "area-weather");
		return modelAndView;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("area-weather-data")
	public Map<String, Object> weatherData(String cityCode) {
		Map<String, Object> data = new HashMap<>();
		data.put("weather", cityWeatherService.findCityWeatherByCode(cityCode));
		WeatherAlarm alarm = cityWeatherService.findWeatherAlarmByCode(cityCode);
		data.put("alarm", alarm);
		return data;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("refresh-weather-data")
	public Map<String, Object> refreshWeatherData() {
		Map<String, Object> data = new HashMap<>();
		List<WeatherCity> wcs = cityWeatherService.findAllCity();
		// 获取要进行更新的天气的城市编码 LIST
		Set<String> cityCodes = new HashSet<>();
		for (WeatherCity wc : wcs) {
			cityCodes.add(wc.getCode());
		}
		List<WeatherKey> weatherKeys = cityWeatherService.findWeatherKeys();
		if (weatherKeys == null || weatherKeys.isEmpty() || weatherKeys.size() < 2) {
			data.put("message", "未配置第三方天气接口KEY值");
			return data;
		}
		String key0 = weatherKeys.get(0).getWeatherKey();
		String key1 = weatherKeys.get(1).getWeatherKey();
		for (String code : cityCodes) {
			WeatherData wd = cityWeatherService.findCityWeatherByCode(code);
			if (wd != null && new Date().getTime() - wd.getLastUpdateTime().getTime() < 30 * 60 * 1000) {
				continue;
			}
			String w_url = WeatherURL.replaceAll("#CITYCODE#", code).replaceAll("#KEY#", key0);
			try {
				String result = HttpUtil.getRequest(w_url);
				WeatherData weatherData = PublicUtil.analysisWeatherDataJson(result, cityWeatherService);
				if (weatherData != null) {
					cityWeatherService.upInsertWeatherData(weatherData);
				}
			} catch (Exception e) {
				data.put("message", e.getMessage());
				return data;
			}
			String a_url = AlarmURL.replaceAll("#CITYCODE#", code).replaceAll("#KEY#", key1);
			try {
				String result = HttpUtil.getRequest(a_url);
				WeatherAlarm weatherAlarm = PublicUtil.analysisAlarmDataJson(result);
				if (weatherAlarm != null) {
					if (weatherAlarm.getEarlyWarnTime() == null) {
						if (cityWeatherService.findWeatherAlarmByCode(weatherAlarm.getWeatherCityCode()) != null) {
							cityWeatherService.clearWeaterAlarm(weatherAlarm.getWeatherCityCode());
						}
					} else {
						cityWeatherService.upInsertWeaterAlarm(weatherAlarm);
					}
				}
			} catch (Exception e) {
				data.put("message", e.getMessage());
				return data;
			}
		}
		data.put("message", "刷新成功");
		return data;
	}

	@RequiresAuthentication
	@RequestMapping("early-warning")
	public ModelAndView earlyWarning() {
		ModelAndView modelAndView = new ModelAndView(BASEPATH + "early-warning");
		return modelAndView;
	}

	@RequiresAuthentication
	@RequestMapping("system-set")
	public ModelAndView systemSet() {
		ModelAndView modelAndView = new ModelAndView(BASEPATH + "system-set");
		return modelAndView;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("system-set-data")
	public Map<String, Object> systemSetData() {
		Map<String, Object> data = new HashMap<>();
		List<WeatherKey> keys = cityWeatherService.findWeatherKeys();
		if (keys != null && keys.size() == 2) {
			WeatherKey key = keys.get(0);
			data.put("key1", key.getWeatherKey());
			WeatherKey key2 = keys.get(1);
			data.put("key2", key2.getWeatherKey());
		} else {
			data.put("success", false);
			data.put("message", "无效的Key设置，请联系管理员！");
			return data;
		}
		data.put("success", true);
		return data;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("update-system-set-data")
	public Map<String, Object> updateSystemSetData(@RequestBody(required = true) MWeatherSystemSetParam param) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		if (param == null) {
			data.put("message", "无效的参数");
			return data;
		}
		if (PublicUtil.isEmpty(param.getKey1())) {
			data.put("message", "请输入Key1值");
			return data;
		}
		if (PublicUtil.isEmpty(param.getKey2())) {
			data.put("message", "请输入Key2值");
			return data;
		}
		List<WeatherKey> keys = cityWeatherService.findWeatherKeys();
		if (keys != null && keys.size() == 2) {
			WeatherKey key = keys.get(0);
			key.setWeatherKey(param.getKey1());
			WeatherKey key2 = keys.get(1);
			key2.setWeatherKey(param.getKey2());
			try {
				cityWeatherService.updateWeatherKey(key);
				cityWeatherService.updateWeatherKey(key2);
			} catch (Exception e) {
				data.put("message", "操作失败，请稍候重试");
				return data;
			}
		} else {
			data.put("message", "无效的Key设置，请联系管理员");
			return data;
		}
		data.put("success", true);
		data.put("message", "操作成功");
		return data;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("add-weather-early-warning-data")
	public Map<String, Object> addWeatherEarlyWarningData(@RequestBody(required = true) WeatherAlarm alarm) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		if (alarm == null) {
			data.put("message", "无效的数据");
			return data;
		}
		if (PublicUtil.isEmpty(alarm.getWeatherCityCode())) {
			data.put("message", "请选择一个城市");
			return data;
		}
		if (PublicUtil.isEmpty(alarm.getEarlyWarnType())) {
			data.put("message", "请选择一个告警类别");
			return data;
		}
		if (PublicUtil.isEmpty(alarm.getEarlyWarnLevel())) {
			data.put("message", "请选择一个告警级别");
			return data;
		}
		if (PublicUtil.isEmpty(alarm.getEarlyWarnTitle())) {
			data.put("message", "请输入告警标题");
			return data;
		}
		if (PublicUtil.isEmpty(alarm.getEarlyWarnTxt())) {
			data.put("message", "请输入告警描述");
			return data;
		}
		alarm.setEarlyWarnStat("预警中");
		alarm.setEarlyWarnTime(new Date());
		String[] codes = { "CN101010100", "CN101010200", "CN101010300", "CN101010400", "CN101010500", "CN101010600",
				"CN101010700", "CN101010800", "CN101010900", "CN101011000", "CN101011100", "CN101011200", "CN101011300",
				"CN101011400", "CN101011500" };
		try {
			if ("CN101010100".equals(alarm.getWeatherCityCode())) {
				for (String c : codes) {
					alarm.setWeatherCityCode(c);
					cityWeatherService.upInsertWeaterAlarm(alarm);
				}
			} else {
				cityWeatherService.upInsertWeaterAlarm(alarm);
			}

		} catch (Exception e) {
			data.put("message", "操作失败，请稍后重试");
			return data;
		}
		data.put("success", true);
		data.put("message", "添加成功");
		return data;
	}
}