package com.xt.dao.generation;

import com.xt.entity.generation.WeatherCity;
import com.xt.entity.generation.WeatherCityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WeatherCityMapper {
    long countByExample(WeatherCityExample example);

    int deleteByExample(WeatherCityExample example);

    int deleteByPrimaryKey(String code);

    int insert(WeatherCity record);

    int insertSelective(WeatherCity record);

    List<WeatherCity> selectByExample(WeatherCityExample example);

    WeatherCity selectByPrimaryKey(String code);

    int updateByExampleSelective(@Param("record") WeatherCity record, @Param("example") WeatherCityExample example);

    int updateByExample(@Param("record") WeatherCity record, @Param("example") WeatherCityExample example);

    int updateByPrimaryKeySelective(WeatherCity record);

    int updateByPrimaryKey(WeatherCity record);
}