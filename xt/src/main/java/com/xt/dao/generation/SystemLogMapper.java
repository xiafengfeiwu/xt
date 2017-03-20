package com.xt.dao.generation;

import com.xt.entity.generation.SystemLog;
import com.xt.entity.generation.SystemLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SystemLogMapper {
    long countByExample(SystemLogExample example);

    int deleteByExample(SystemLogExample example);

    int deleteByPrimaryKey(String logId);

    int insert(SystemLog record);

    int insertSelective(SystemLog record);

    List<SystemLog> selectByExample(SystemLogExample example);

    SystemLog selectByPrimaryKey(String logId);

    int updateByExampleSelective(@Param("record") SystemLog record, @Param("example") SystemLogExample example);

    int updateByExample(@Param("record") SystemLog record, @Param("example") SystemLogExample example);

    int updateByPrimaryKeySelective(SystemLog record);

    int updateByPrimaryKey(SystemLog record);
}