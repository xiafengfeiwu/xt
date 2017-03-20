package com.xt.service;

import java.util.List;

import com.xt.entity.custom.MDeviceProduct;
import com.xt.entity.generation.DeviceProduct;

public interface DeviceProductService {

	List<MDeviceProduct> findAll();

	void create(DeviceProduct deviceProduct);

	void update(DeviceProduct deviceProduct);

	void delete(String productId);

	DeviceProduct findById(String productId);

}
