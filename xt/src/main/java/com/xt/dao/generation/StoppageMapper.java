package com.xt.dao.generation;

import com.xt.entity.generation.Stoppage;
import com.xt.entity.generation.StoppageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StoppageMapper {
    long countByExample(StoppageExample example);

    int deleteByExample(StoppageExample example);

    int deleteByPrimaryKey(Long stoppageId);

    int insert(Stoppage record);

    int insertSelective(Stoppage record);

    List<Stoppage> selectByExample(StoppageExample example);

    Stoppage selectByPrimaryKey(Long stoppageId);

    int updateByExampleSelective(@Param("record") Stoppage record, @Param("example") StoppageExample example);

    int updateByExample(@Param("record") Stoppage record, @Param("example") StoppageExample example);

    int updateByPrimaryKeySelective(Stoppage record);

    int updateByPrimaryKey(Stoppage record);
}