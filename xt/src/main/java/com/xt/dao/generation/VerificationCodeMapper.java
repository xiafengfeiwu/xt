package com.xt.dao.generation;

import com.xt.entity.generation.VerificationCode;
import com.xt.entity.generation.VerificationCodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VerificationCodeMapper {
    long countByExample(VerificationCodeExample example);

    int deleteByExample(VerificationCodeExample example);

    int deleteByPrimaryKey(Long smsId);

    int insert(VerificationCode record);

    int insertSelective(VerificationCode record);

    List<VerificationCode> selectByExample(VerificationCodeExample example);

    VerificationCode selectByPrimaryKey(Long smsId);

    int updateByExampleSelective(@Param("record") VerificationCode record, @Param("example") VerificationCodeExample example);

    int updateByExample(@Param("record") VerificationCode record, @Param("example") VerificationCodeExample example);

    int updateByPrimaryKeySelective(VerificationCode record);

    int updateByPrimaryKey(VerificationCode record);
}