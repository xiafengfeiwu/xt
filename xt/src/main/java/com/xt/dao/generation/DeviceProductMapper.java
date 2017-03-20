package com.xt.dao.generation;

import com.xt.entity.generation.DeviceProduct;
import com.xt.entity.generation.DeviceProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeviceProductMapper {
    long countByExample(DeviceProductExample example);

    int deleteByExample(DeviceProductExample example);

    int deleteByPrimaryKey(String productId);

    int insert(DeviceProduct record);

    int insertSelective(DeviceProduct record);

    List<DeviceProduct> selectByExampleWithBLOBs(DeviceProductExample example);

    List<DeviceProduct> selectByExample(DeviceProductExample example);

    DeviceProduct selectByPrimaryKey(String productId);

    int updateByExampleSelective(@Param("record") DeviceProduct record, @Param("example") DeviceProductExample example);

    int updateByExampleWithBLOBs(@Param("record") DeviceProduct record, @Param("example") DeviceProductExample example);

    int updateByExample(@Param("record") DeviceProduct record, @Param("example") DeviceProductExample example);

    int updateByPrimaryKeySelective(DeviceProduct record);

    int updateByPrimaryKeyWithBLOBs(DeviceProduct record);

    int updateByPrimaryKey(DeviceProduct record);
}