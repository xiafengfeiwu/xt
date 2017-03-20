package com.xt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.dao.custom.MDeviceProductMapper;
import com.xt.dao.generation.DeviceProductMapper;
import com.xt.entity.custom.MDeviceProduct;
import com.xt.entity.generation.DeviceProduct;
import com.xt.service.DeviceProductService;

@Service
public class DeviceProductServiceImpl implements DeviceProductService {

	@Autowired
	DeviceProductMapper deviceProductMapper;
	@Autowired
	MDeviceProductMapper mDeviceProductMapper;

	@Override
	public List<MDeviceProduct> findAll() {
		return mDeviceProductMapper.selectAll("p.product_name asc");
	}

	@Override
	public void create(DeviceProduct deviceProduct) {
		deviceProductMapper.insert(deviceProduct);
	}

	@Override
	public void update(DeviceProduct deviceProduct) {
		deviceProductMapper.updateByPrimaryKeyWithBLOBs(deviceProduct);
	}

	@Override
	public void delete(String productId) {
		deviceProductMapper.deleteByPrimaryKey(productId);
	}

	@Override
	public DeviceProduct findById(String productId) {
		return deviceProductMapper.selectByPrimaryKey(productId);
	}

}
