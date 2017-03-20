package com.xt.dao.custom;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xt.entity.custom.MAreaPump;
import com.xt.entity.custom.MLastCode;

public interface MProjectMapper {

	// 获取项目的最新编码
	MLastCode selectLastProjectcode(@Param("preCode") String preCode);

	// 获取用户授权的区域根节点
	List<MAreaPump> selectUserAuthProjectArea(@Param("userId") String userId);

	// 通过项目区域ID列表批量获取项目区域信息
	List<MAreaPump> selectProjectPumpsByIds(@Param("projectAreaIds") List<String> projectAreaIds);
}
