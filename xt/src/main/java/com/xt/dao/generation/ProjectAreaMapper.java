package com.xt.dao.generation;

import com.xt.entity.generation.ProjectArea;
import com.xt.entity.generation.ProjectAreaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectAreaMapper {
    long countByExample(ProjectAreaExample example);

    int deleteByExample(ProjectAreaExample example);

    int deleteByPrimaryKey(String projectAreaId);

    int insert(ProjectArea record);

    int insertSelective(ProjectArea record);

    List<ProjectArea> selectByExample(ProjectAreaExample example);

    ProjectArea selectByPrimaryKey(String projectAreaId);

    int updateByExampleSelective(@Param("record") ProjectArea record, @Param("example") ProjectAreaExample example);

    int updateByExample(@Param("record") ProjectArea record, @Param("example") ProjectAreaExample example);

    int updateByPrimaryKeySelective(ProjectArea record);

    int updateByPrimaryKey(ProjectArea record);
}