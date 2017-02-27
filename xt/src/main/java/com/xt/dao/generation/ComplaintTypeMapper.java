package com.xt.dao.generation;

import com.xt.entity.generation.ComplaintType;
import com.xt.entity.generation.ComplaintTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ComplaintTypeMapper {
    long countByExample(ComplaintTypeExample example);

    int deleteByExample(ComplaintTypeExample example);

    int deleteByPrimaryKey(Long complaintTypeId);

    int insert(ComplaintType record);

    int insertSelective(ComplaintType record);

    List<ComplaintType> selectByExample(ComplaintTypeExample example);

    ComplaintType selectByPrimaryKey(Long complaintTypeId);

    int updateByExampleSelective(@Param("record") ComplaintType record, @Param("example") ComplaintTypeExample example);

    int updateByExample(@Param("record") ComplaintType record, @Param("example") ComplaintTypeExample example);

    int updateByPrimaryKeySelective(ComplaintType record);

    int updateByPrimaryKey(ComplaintType record);
}