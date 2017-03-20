package com.xt.dao.generation;

import com.xt.entity.generation.DeviceVender;
import com.xt.entity.generation.DeviceVenderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeviceVenderMapper {
    long countByExample(DeviceVenderExample example);

    int deleteByExample(DeviceVenderExample example);

    int deleteByPrimaryKey(String venderId);

    int insert(DeviceVender record);

    int insertSelective(DeviceVender record);

    List<DeviceVender> selectByExample(DeviceVenderExample example);

    DeviceVender selectByPrimaryKey(String venderId);

    int updateByExampleSelective(@Param("record") DeviceVender record, @Param("example") DeviceVenderExample example);

    int updateByExample(@Param("record") DeviceVender record, @Param("example") DeviceVenderExample example);

    int updateByPrimaryKeySelective(DeviceVender record);

    int updateByPrimaryKey(DeviceVender record);
}