package com.xt.dao.generation;

import com.xt.entity.generation.WarnDictionary;
import com.xt.entity.generation.WarnDictionaryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WarnDictionaryMapper {
    long countByExample(WarnDictionaryExample example);

    int deleteByExample(WarnDictionaryExample example);

    int deleteByPrimaryKey(String warnCode);

    int insert(WarnDictionary record);

    int insertSelective(WarnDictionary record);

    List<WarnDictionary> selectByExample(WarnDictionaryExample example);

    WarnDictionary selectByPrimaryKey(String warnCode);

    int updateByExampleSelective(@Param("record") WarnDictionary record, @Param("example") WarnDictionaryExample example);

    int updateByExample(@Param("record") WarnDictionary record, @Param("example") WarnDictionaryExample example);

    int updateByPrimaryKeySelective(WarnDictionary record);

    int updateByPrimaryKey(WarnDictionary record);
}