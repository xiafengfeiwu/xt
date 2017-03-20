package com.xt.dao.generation;

import com.xt.entity.generation.PumpHistoryData;
import com.xt.entity.generation.PumpHistoryDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PumpHistoryDataMapper {
    long countByExample(PumpHistoryDataExample example);

    int deleteByExample(PumpHistoryDataExample example);

    int deleteByPrimaryKey(String dataId);

    int insert(PumpHistoryData record);

    int insertSelective(PumpHistoryData record);

    List<PumpHistoryData> selectByExample(PumpHistoryDataExample example);

    PumpHistoryData selectByPrimaryKey(String dataId);

    int updateByExampleSelective(@Param("record") PumpHistoryData record, @Param("example") PumpHistoryDataExample example);

    int updateByExample(@Param("record") PumpHistoryData record, @Param("example") PumpHistoryDataExample example);

    int updateByPrimaryKeySelective(PumpHistoryData record);

    int updateByPrimaryKey(PumpHistoryData record);
}