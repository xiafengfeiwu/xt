package com.xt.dao.generation;

import com.xt.entity.generation.PacketQuery;
import com.xt.entity.generation.PacketQueryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PacketQueryMapper {
    long countByExample(PacketQueryExample example);

    int deleteByExample(PacketQueryExample example);

    int deleteByPrimaryKey(Long packetId);

    int insert(PacketQuery record);

    int insertSelective(PacketQuery record);

    List<PacketQuery> selectByExample(PacketQueryExample example);

    PacketQuery selectByPrimaryKey(Long packetId);

    int updateByExampleSelective(@Param("record") PacketQuery record, @Param("example") PacketQueryExample example);

    int updateByExample(@Param("record") PacketQuery record, @Param("example") PacketQueryExample example);

    int updateByPrimaryKeySelective(PacketQuery record);

    int updateByPrimaryKey(PacketQuery record);
}