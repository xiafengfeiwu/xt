package com.xt.dao.generation;

import com.xt.entity.generation.VenderProduct;
import com.xt.entity.generation.VenderProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VenderProductMapper {
    long countByExample(VenderProductExample example);

    int deleteByExample(VenderProductExample example);

    int deleteByPrimaryKey(Long productId);

    int insert(VenderProduct record);

    int insertSelective(VenderProduct record);

    List<VenderProduct> selectByExampleWithBLOBs(VenderProductExample example);

    List<VenderProduct> selectByExample(VenderProductExample example);

    VenderProduct selectByPrimaryKey(Long productId);

    int updateByExampleSelective(@Param("record") VenderProduct record, @Param("example") VenderProductExample example);

    int updateByExampleWithBLOBs(@Param("record") VenderProduct record, @Param("example") VenderProductExample example);

    int updateByExample(@Param("record") VenderProduct record, @Param("example") VenderProductExample example);

    int updateByPrimaryKeySelective(VenderProduct record);

    int updateByPrimaryKeyWithBLOBs(VenderProduct record);

    int updateByPrimaryKey(VenderProduct record);
}