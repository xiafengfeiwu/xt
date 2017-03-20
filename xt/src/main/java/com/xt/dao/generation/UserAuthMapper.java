package com.xt.dao.generation;

import com.xt.entity.generation.UserAuth;
import com.xt.entity.generation.UserAuthExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserAuthMapper {
    long countByExample(UserAuthExample example);

    int deleteByExample(UserAuthExample example);

    int deleteByPrimaryKey(Long rootId);

    int insert(UserAuth record);

    int insertSelective(UserAuth record);

    List<UserAuth> selectByExample(UserAuthExample example);

    UserAuth selectByPrimaryKey(Long rootId);

    int updateByExampleSelective(@Param("record") UserAuth record, @Param("example") UserAuthExample example);

    int updateByExample(@Param("record") UserAuth record, @Param("example") UserAuthExample example);

    int updateByPrimaryKeySelective(UserAuth record);

    int updateByPrimaryKey(UserAuth record);
}