package com.xt.dao.generation;

import com.xt.entity.generation.PumpConstantlyData;
import com.xt.entity.generation.PumpConstantlyDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PumpConstantlyDataMapper {
    long countByExample(PumpConstantlyDataExample example);

    int deleteByExample(PumpConstantlyDataExample example);

    int deleteByPrimaryKey(String pumpId);

    int insert(PumpConstantlyData record);

    int insertSelective(PumpConstantlyData record);

    List<PumpConstantlyData> selectByExample(PumpConstantlyDataExample example);

    PumpConstantlyData selectByPrimaryKey(String pumpId);

    int updateByExampleSelective(@Param("record") PumpConstantlyData record, @Param("example") PumpConstantlyDataExample example);

    int updateByExample(@Param("record") PumpConstantlyData record, @Param("example") PumpConstantlyDataExample example);

    int updateByPrimaryKeySelective(PumpConstantlyData record);

    int updateByPrimaryKey(PumpConstantlyData record);
}