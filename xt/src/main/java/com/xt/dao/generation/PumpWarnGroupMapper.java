package com.xt.dao.generation;

import com.xt.entity.generation.PumpWarnGroup;
import com.xt.entity.generation.PumpWarnGroupExample;
import com.xt.entity.generation.PumpWarnGroupKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PumpWarnGroupMapper {
    long countByExample(PumpWarnGroupExample example);

    int deleteByExample(PumpWarnGroupExample example);

    int deleteByPrimaryKey(PumpWarnGroupKey key);

    int insert(PumpWarnGroup record);

    int insertSelective(PumpWarnGroup record);

    List<PumpWarnGroup> selectByExample(PumpWarnGroupExample example);

    PumpWarnGroup selectByPrimaryKey(PumpWarnGroupKey key);

    int updateByExampleSelective(@Param("record") PumpWarnGroup record, @Param("example") PumpWarnGroupExample example);

    int updateByExample(@Param("record") PumpWarnGroup record, @Param("example") PumpWarnGroupExample example);

    int updateByPrimaryKeySelective(PumpWarnGroup record);

    int updateByPrimaryKey(PumpWarnGroup record);
}