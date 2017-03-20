package com.xt.service;

import java.util.List;

import com.xt.entity.generation.DeviceVender;

public interface DeviceVenderService {

	List<DeviceVender> findAll();

	void create(DeviceVender deviceVender);

	void update(DeviceVender deviceVender);

	void delete(String venderId);

	DeviceVender findById(String venderId);

}
