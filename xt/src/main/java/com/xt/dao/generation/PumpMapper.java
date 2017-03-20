package com.xt.dao.generation;

import com.xt.entity.generation.Pump;
import com.xt.entity.generation.PumpExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PumpMapper {
    long countByExample(PumpExample example);

    int deleteByExample(PumpExample example);

    int deleteByPrimaryKey(String pumpId);

    int insert(Pump record);

    int insertSelective(Pump record);

    List<Pump> selectByExample(PumpExample example);

    Pump selectByPrimaryKey(String pumpId);

    int updateByExampleSelective(@Param("record") Pump record, @Param("example") PumpExample example);

    int updateByExample(@Param("record") Pump record, @Param("example") PumpExample example);

    int updateByPrimaryKeySelective(Pump record);

    int updateByPrimaryKey(Pump record);
}