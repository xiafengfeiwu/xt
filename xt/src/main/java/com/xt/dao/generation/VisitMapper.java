package com.xt.dao.generation;

import com.xt.entity.generation.Visit;
import com.xt.entity.generation.VisitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VisitMapper {
    long countByExample(VisitExample example);

    int deleteByExample(VisitExample example);

    int deleteByPrimaryKey(String visitId);

    int insert(Visit record);

    int insertSelective(Visit record);

    List<Visit> selectByExample(VisitExample example);

    Visit selectByPrimaryKey(String visitId);

    int updateByExampleSelective(@Param("record") Visit record, @Param("example") VisitExample example);

    int updateByExample(@Param("record") Visit record, @Param("example") VisitExample example);

    int updateByPrimaryKeySelective(Visit record);

    int updateByPrimaryKey(Visit record);
}