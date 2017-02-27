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
	public WeatherData findTodayCityWeatherByCode(String cityCode) {
		WeatherDataKey key = new WeatherDataKey();
		key.setWeatherCityCode(cityCode);
		key.setCollectDate(new Date());
		return weatherDataMapper.selectByPrimaryKey(key);
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
		return weatherAlarmMapper.selectByPrimaryKey(cityCode);
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
