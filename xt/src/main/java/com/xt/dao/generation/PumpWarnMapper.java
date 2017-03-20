package com.xt.dao.generation;

import com.xt.entity.generation.PumpWarn;
import com.xt.entity.generation.PumpWarnExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PumpWarnMapper {
    long countByExample(PumpWarnExample example);

    int deleteByExample(PumpWarnExample example);

    int deleteByPrimaryKey(String warnId);

    int insert(PumpWarn record);

    int insertSelective(PumpWarn record);

    List<PumpWarn> selectByExample(PumpWarnExample example);

    PumpWarn selectByPrimaryKey(String warnId);

    int updateByExampleSelective(@Param("record") PumpWarn record, @Param("example") PumpWarnExample example);

    int updateByExample(@Param("record") PumpWarn record, @Param("example") PumpWarnExample example);

    int updateByPrimaryKeySelective(PumpWarn record);

    int updateByPrimaryKey(PumpWarn record);
}