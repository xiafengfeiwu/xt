package com.xt.dao.generation;

import com.xt.entity.generation.PumpEleStatistics;
import com.xt.entity.generation.PumpEleStatisticsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PumpEleStatisticsMapper {
    long countByExample(PumpEleStatisticsExample example);

    int deleteByExample(PumpEleStatisticsExample example);

    int deleteByPrimaryKey(String dataId);

    int insert(PumpEleStatistics record);

    int insertSelective(PumpEleStatistics record);

    List<PumpEleStatistics> selectByExample(PumpEleStatisticsExample example);

    PumpEleStatistics selectByPrimaryKey(String dataId);

    int updateByExampleSelective(@Param("record") PumpEleStatistics record, @Param("example") PumpEleStatisticsExample example);

    int updateByExample(@Param("record") PumpEleStatistics record, @Param("example") PumpEleStatisticsExample example);

    int updateByPrimaryKeySelective(PumpEleStatistics record);

    int updateByPrimaryKey(PumpEleStatistics record);
}