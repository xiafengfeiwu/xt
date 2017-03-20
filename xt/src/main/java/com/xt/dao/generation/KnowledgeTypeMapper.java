package com.xt.dao.generation;

import com.xt.entity.generation.KnowledgeType;
import com.xt.entity.generation.KnowledgeTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface KnowledgeTypeMapper {
    long countByExample(KnowledgeTypeExample example);

    int deleteByExample(KnowledgeTypeExample example);

    int deleteByPrimaryKey(String knowledgeTypeId);

    int insert(KnowledgeType record);

    int insertSelective(KnowledgeType record);

    List<KnowledgeType> selectByExample(KnowledgeTypeExample example);

    KnowledgeType selectByPrimaryKey(String knowledgeTypeId);

    int updateByExampleSelective(@Param("record") KnowledgeType record, @Param("example") KnowledgeTypeExample example);

    int updateByExample(@Param("record") KnowledgeType record, @Param("example") KnowledgeTypeExample example);

    int updateByPrimaryKeySelective(KnowledgeType record);

    int updateByPrimaryKey(KnowledgeType record);
}