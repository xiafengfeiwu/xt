package com.xt.dao.generation;

import com.xt.entity.generation.WeatherKey;
import com.xt.entity.generation.WeatherKeyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WeatherKeyMapper {
    long countByExample(WeatherKeyExample example);

    int deleteByExample(WeatherKeyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WeatherKey record);

    int insertSelective(WeatherKey record);

    List<WeatherKey> selectByExample(WeatherKeyExample example);

    WeatherKey selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WeatherKey record, @Param("example") WeatherKeyExample example);

    int updateByExample(@Param("record") WeatherKey record, @Param("example") WeatherKeyExample example);

    int updateByPrimaryKeySelective(WeatherKey record);

    int updateByPrimaryKey(WeatherKey record);
}