package com.xt.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.dao.generation.WeatherAlarmMapper;
import com.xt.dao.generation.WeatherCityMapper;
import com.xt.dao.generation.WeatherDataMapper;
import com.xt.dao.generation.WeatherIconMapper;
import com.xt.dao.generation.WeatherKeyMapper;
import com.xt.entity.generation.WeatherAlarm;
import com.xt.entity.generation.WeatherCity;
import com.xt.entity.generation.WeatherCityExample;
import com.xt.entity.generation.WeatherData;
import com.xt.entity.generation.WeatherDataExample;
import com.xt.entity.generation.WeatherDataKey;
import com.xt.entity.generation.WeatherIcon;
import com.xt.entity.generation.WeatherKey;
import com.xt.entity.generation.WeatherKeyExample;
import com.xt.service.CityWeatherService;

@Service
public class CityWeatherServiceImpl implements CityWeatherService {

	@Autowired
	WeatherDataMapper weatherDataMapper;
	@Autowired
	WeatherIconMapper weatherIconMapper;
	@Autowired
	WeatherKeyMapper weatherKeyMapper;
	@Autowired
	WeatherAlarmMapper weatherAlarmMapper;
	@Autowired
	WeatherCityMapper weatherCityMapper;

	@Override
	public WeatherData findCityWeatherByCode(String cityCode) {
		WeatherDataExample example = new WeatherDataExample();
		example.createCriteria().andWeatherCityCodeEqualTo(cityCode);
		example.setOrderByClause("collect_date desc limit 0,1");
		List<WeatherData> datas = weatherDataMapper.selectByExample(example);
		if (datas.size() > 0) {
			return datas.get(0);
		}
		return null;
	}

	@Override
	public WeatherIcon findWeatherIconByCode(String weatherCode) {
		return weatherIconMapper.selectByPrimaryKey(weatherCode);
	}

	@Override
	public List<WeatherKey> findWeatherKeys() {
		WeatherKeyExample example = new WeatherKeyExample();
		example.setOrderByClause("id asc");
		return weatherKeyMapper.selectByExample(example);
	}

	@Override
	public List<WeatherCity> findAllCity() {
		WeatherCityExample example = new WeatherCityExample();
		example.setOrderByClause("code asc");
		return weatherCityMapper.selectByExample(example);
	}

	@Override
	public WeatherAlarm findWeatherAlarmByCode(String cityCode) {
		WeatherAlarm alarm = weatherAlarmMapper.selectByPrimaryKey(cityCode);
		if (alarm != null) {
			long timeInterval = new Date().getTime() - alarm.getEarlyWarnTime().getTime();
			int hour = 60 * 60 * 1000;
			if (timeInterval > 4 * 24 * hour) {
				if (timeInterval > 8 * 48 * hour) {
					clearWeaterAlarm(cityCode);
					alarm = null;
				} else {
					alarm.setEarlyWarnStat("已过期");
					upInsertWeaterAlarm(alarm);
				}
			}
		}
		return alarm;
	}

	@Override
	public void updateWeatherKey(WeatherKey weatherKey) {
		weatherKeyMapper.updateByPrimaryKey(weatherKey);
	}

	@Override
	public void upInsertWeatherData(WeatherData weatherData) {
		WeatherDataKey key = new WeatherDataKey();
		key.setCollectDate(weatherData.getCollectDate());
		key.setWeatherCityCode(weatherData.getWeatherCityCode());
		WeatherData data = weatherDataMapper.selectByPrimaryKey(key);
		if (data == null) {
			weatherDataMapper.insert(weatherData);
		} else {
			weatherDataMapper.updateByPrimaryKey(weatherData);
		}
	}

	@Override
	public void upInsertWeaterAlarm(WeatherAlarm weatherAlarm) {
		WeatherAlarm data = findWeatherAlarmByCode(weatherAlarm.getWeatherCityCode());
		if (data == null) {
			weatherAlarmMapper.insert(weatherAlarm);
		} else {
			weatherAlarmMapper.updateByPrimaryKey(weatherAlarm);
		}
	}

	@Override
	public void clearWeaterAlarm(String cityCode) {
		weatherAlarmMapper.deleteByPrimaryKey(cityCode);
	}

}
