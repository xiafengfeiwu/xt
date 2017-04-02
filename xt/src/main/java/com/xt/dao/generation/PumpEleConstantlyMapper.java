package com.xt.dao.generation;

import com.xt.entity.generation.PumpEleConstantly;
import com.xt.entity.generation.PumpEleConstantlyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PumpEleConstantlyMapper {
    long countByExample(PumpEleConstantlyExample example);

    int deleteByExample(PumpEleConstantlyExample example);

    int deleteByPrimaryKey(String pumpId);

    int insert(PumpEleConstantly record);

    int insertSelective(PumpEleConstantly record);

    List<PumpEleConstantly> selectByExample(PumpEleConstantlyExample example);

    PumpEleConstantly selectByPrimaryKey(String pumpId);

    int updateByExampleSelective(@Param("record") PumpEleConstantly record, @Param("example") PumpEleConstantlyExample example);

    int updateByExample(@Param("record") PumpEleConstantly record, @Param("example") PumpEleConstantlyExample example);

    int updateByPrimaryKeySelective(PumpEleConstantly record);

    int updateByPrimaryKey(PumpEleConstantly record);
}