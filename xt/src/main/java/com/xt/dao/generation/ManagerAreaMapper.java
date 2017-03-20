package com.xt.dao.generation;

import com.xt.entity.generation.ManagerArea;
import com.xt.entity.generation.ManagerAreaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ManagerAreaMapper {
    long countByExample(ManagerAreaExample example);

    int deleteByExample(ManagerAreaExample example);

    int deleteByPrimaryKey(String userId);

    int insert(ManagerArea record);

    int insertSelective(ManagerArea record);

    List<ManagerArea> selectByExample(ManagerAreaExample example);

    ManagerArea selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") ManagerArea record, @Param("example") ManagerAreaExample example);

    int updateByExample(@Param("record") ManagerArea record, @Param("example") ManagerAreaExample example);

    int updateByPrimaryKeySelective(ManagerArea record);

    int updateByPrimaryKey(ManagerArea record);
}