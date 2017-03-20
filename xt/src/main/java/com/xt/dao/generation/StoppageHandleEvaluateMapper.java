package com.xt.dao.generation;

import com.xt.entity.generation.StoppageHandleEvaluate;
import com.xt.entity.generation.StoppageHandleEvaluateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StoppageHandleEvaluateMapper {
    long countByExample(StoppageHandleEvaluateExample example);

    int deleteByExample(StoppageHandleEvaluateExample example);

    int deleteByPrimaryKey(String evaluateId);

    int insert(StoppageHandleEvaluate record);

    int insertSelective(StoppageHandleEvaluate record);

    List<StoppageHandleEvaluate> selectByExample(StoppageHandleEvaluateExample example);

    StoppageHandleEvaluate selectByPrimaryKey(String evaluateId);

    int updateByExampleSelective(@Param("record") StoppageHandleEvaluate record, @Param("example") StoppageHandleEvaluateExample example);

    int updateByExample(@Param("record") StoppageHandleEvaluate record, @Param("example") StoppageHandleEvaluateExample example);

    int updateByPrimaryKeySelective(StoppageHandleEvaluate record);

    int updateByPrimaryKey(StoppageHandleEvaluate record);
}