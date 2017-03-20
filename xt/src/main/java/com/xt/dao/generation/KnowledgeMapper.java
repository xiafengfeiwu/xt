package com.xt.dao.generation;

import com.xt.entity.generation.Knowledge;
import com.xt.entity.generation.KnowledgeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface KnowledgeMapper {
    long countByExample(KnowledgeExample example);

    int deleteByExample(KnowledgeExample example);

    int deleteByPrimaryKey(Long knowledgeId);

    int insert(Knowledge record);

    int insertSelective(Knowledge record);

    List<Knowledge> selectByExampleWithBLOBs(KnowledgeExample example);

    List<Knowledge> selectByExample(KnowledgeExample example);

    Knowledge selectByPrimaryKey(Long knowledgeId);

    int updateByExampleSelective(@Param("record") Knowledge record, @Param("example") KnowledgeExample example);

    int updateByExampleWithBLOBs(@Param("record") Knowledge record, @Param("example") KnowledgeExample example);

    int updateByExample(@Param("record") Knowledge record, @Param("example") KnowledgeExample example);

    int updateByPrimaryKeySelective(Knowledge record);

    int updateByPrimaryKeyWithBLOBs(Knowledge record);

    int updateByPrimaryKey(Knowledge record);
}