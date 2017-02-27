package com.xt.service;

import java.util.List;

import com.xt.entity.generation.WeatherAlarm;
import com.xt.entity.generation.WeatherCity;
import com.xt.entity.generation.WeatherData;
import com.xt.entity.generation.WeatherIcon;
import com.xt.entity.generation.WeatherKey;

public interface CityWeatherService {
	
	// 通过城市编码获取城市天气详情
	WeatherData findTodayCityWeatherByCode(String cityCode);

	// 通过天气编码获取城市天气图标
	WeatherIcon findWeatherIconByCode(String weatherCode);

	// 获取第三方天气KEY值
	List<WeatherKey> findWeatherKeys();

	// 获取所有的城市列表
	List<WeatherCity> findAllCity();

	// 通过城市编码获取预警信息
	WeatherAlarm findWeatherAlarmByCode(String cityCode);

	// 更新第三方天气KEY值
	void updateWeatherKey(WeatherKey weatherKey);

	// 更新插入天气数据
	void upInsertWeatherData(WeatherData weatherData);

	// 更新插入天气预警数据
	void upInsertWeaterAlarm(WeatherAlarm weatherAlarm);

	// 清除天气预警数据
	void clearWeaterAlarm(String cityCode);
}
