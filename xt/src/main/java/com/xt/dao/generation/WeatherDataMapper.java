package com.xt.dao.generation;

import com.xt.entity.generation.WeatherData;
import com.xt.entity.generation.WeatherDataExample;
import com.xt.entity.generation.WeatherDataKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WeatherDataMapper {
    long countByExample(WeatherDataExample example);

    int deleteByExample(WeatherDataExample example);

    int deleteByPrimaryKey(WeatherDataKey key);

    int insert(WeatherData record);

    int insertSelective(WeatherData record);

    List<WeatherData> selectByExample(WeatherDataExample example);

    WeatherData selectByPrimaryKey(WeatherDataKey key);

    int updateByExampleSelective(@Param("record") WeatherData record, @Param("example") WeatherDataExample example);

    int updateByExample(@Param("record") WeatherData record, @Param("example") WeatherDataExample example);

    int updateByPrimaryKeySelective(WeatherData record);

    int updateByPrimaryKey(WeatherData record);
}