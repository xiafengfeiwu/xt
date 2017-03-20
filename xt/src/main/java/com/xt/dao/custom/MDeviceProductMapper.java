package com.xt.dao.custom;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xt.entity.custom.MDeviceProduct;

public interface MDeviceProductMapper {
	List<MDeviceProduct> selectAll(@Param("orderByClause") String orderByClause);
}