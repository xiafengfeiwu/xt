package com.xt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.dao.generation.DeviceVenderMapper;
import com.xt.entity.generation.DeviceVender;
import com.xt.entity.generation.DeviceVenderExample;
import com.xt.service.DeviceVenderService;

@Service
public class DeviceVenderServiceImpl implements DeviceVenderService {

	@Autowired
	DeviceVenderMapper deviceVenderMapper;

	@Override
	public List<DeviceVender> findAll() {
		DeviceVenderExample example = new DeviceVenderExample();
		example.setOrderByClause("vender_name asc");
		return deviceVenderMapper.selectByExample(example);
	}

	@Override
	public void create(DeviceVender deviceVender) {
		deviceVenderMapper.insert(deviceVender);
	}

	@Override
	public void update(DeviceVender deviceVender) {
		deviceVenderMapper.updateByPrimaryKey(deviceVender);
	}

	@Override
	public void delete(String venderId) {
		deviceVenderMapper.deleteByPrimaryKey(venderId);
	}

	@Override
	public DeviceVender findById(String venderId) {
		return deviceVenderMapper.selectByPrimaryKey(venderId);
	}

}
