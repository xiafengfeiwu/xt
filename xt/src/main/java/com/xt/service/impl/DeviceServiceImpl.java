package com.xt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.dao.generation.DeviceMapper;
import com.xt.dao.generation.DeviceVenderMapper;
import com.xt.entity.generation.Device;
import com.xt.entity.generation.DeviceExample;
import com.xt.entity.generation.DeviceVender;
import com.xt.entity.generation.DeviceVenderExample;
import com.xt.service.DeviceService;
import com.xt.util.PublicUtil;

@Service
public class DeviceServiceImpl implements DeviceService {

	@Autowired
	DeviceMapper deviceMapper;
	@Autowired
	DeviceVenderMapper deviceVenderMapper;

	@Override
	public Device findById(String deviceId) {
		return deviceMapper.selectByPrimaryKey(deviceId);
	}

	@Override
	public Device findBySn(String sn) {
		DeviceExample example = new DeviceExample();
		example.createCriteria().andDeviceSnEqualTo(sn);
		List<Device> devices = deviceMapper.selectByExample(example);
		if (PublicUtil.isEmpty(devices)) {
			return null;
		}
		return devices.get(0);
	}

	@Override
	public void save(Device device) {
		deviceMapper.insert(device);
	}

	@Override
	public void update(Device device) {
		deviceMapper.updateByPrimaryKey(device);
	}

	@Override
	public List<Device> getDevicesByPumpId(String pumpId) {
		DeviceExample example = new DeviceExample();
		example.createCriteria().andPumpIdEqualTo(pumpId);
		example.setOrderByClause("device_sn asc");
		return deviceMapper.selectByExample(example);
	}

	@Override
	public void delete(String deviceId) {
		deviceMapper.deleteByPrimaryKey(deviceId);
	}

	@Override
	public void createVender(DeviceVender vender) {
		deviceVenderMapper.insert(vender);
	}

	@Override
	public DeviceVender findVenderById(String venderId) {
		return deviceVenderMapper.selectByPrimaryKey(venderId);
	}

	@Override
	public DeviceVender findVenderByCode(String venderCode) {
		DeviceVenderExample example = new DeviceVenderExample();
		List<DeviceVender> venders = deviceVenderMapper.selectByExample(example);
		if (PublicUtil.isEmpty(venders)) {
			return null;
		}
		return venders.get(0);
	}

	@Override
	public List<DeviceVender> findAllVenders() {
		DeviceVenderExample example = new DeviceVenderExample();
		example.setOrderByClause("vender_name asc");
		return deviceVenderMapper.selectByExample(example);
	}

	@Override
	public void deleteVender(String venderId) {
		deviceVenderMapper.deleteByPrimaryKey(venderId);
	}

	@Override
	public void updateVender(DeviceVender vender) {
		deviceVenderMapper.updateByPrimaryKey(vender);
	}

}
