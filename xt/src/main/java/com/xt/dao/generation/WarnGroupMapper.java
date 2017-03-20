package com.xt.dao.generation;

import com.xt.entity.generation.WarnGroup;
import com.xt.entity.generation.WarnGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WarnGroupMapper {
    long countByExample(WarnGroupExample example);

    int deleteByExample(WarnGroupExample example);

    int deleteByPrimaryKey(String groupId);

    int insert(WarnGroup record);

    int insertSelective(WarnGroup record);

    List<WarnGroup> selectByExample(WarnGroupExample example);

    WarnGroup selectByPrimaryKey(String groupId);

    int updateByExampleSelective(@Param("record") WarnGroup record, @Param("example") WarnGroupExample example);

    int updateByExample(@Param("record") WarnGroup record, @Param("example") WarnGroupExample example);

    int updateByPrimaryKeySelective(WarnGroup record);

    int updateByPrimaryKey(WarnGroup record);
}