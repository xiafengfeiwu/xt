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
	public Device findById(Long deviceId) {
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
	public Long getDeviceCount(String searchWord) {
		DeviceExample example = new DeviceExample();
		if (PublicUtil.isNotEmpty(searchWord)) {
			searchWord = "%" + searchWord + "%";
			example.or().andDeviceSnLike(searchWord);
			example.or().andDeviceNameLike(searchWord);
		}
		return deviceMapper.countByExample(example);
	}

	@Override
	public List<Device> getDeviceData(String searchWord, String field, String order, int page, int length) {
		DeviceExample example = new DeviceExample();
		if (PublicUtil.isNotEmpty(searchWord)) {
			searchWord = "%" + searchWord + "%";
			example.or().andDeviceSnLike(searchWord);
			example.or().andDeviceNameLike(searchWord);
		}
		if (PublicUtil.isNotEmpty(field) && PublicUtil.isNotEmpty(order)) {
			example.setOrderByClause(field + " " + order);
		}
		// example.setPage(new Page(page, length));
		return deviceMapper.selectByExample(example);
	}

	@Override
	public List<Device> getTop5BySearchWord(String searchWord) {
		DeviceExample example = new DeviceExample();
		if (PublicUtil.isNotEmpty(searchWord)) {
			searchWord = "%" + searchWord + "%";
			example.or().andDeviceSnLike(searchWord);
			example.or().andDeviceNameLike(searchWord);
		}
		example.setOrderByClause("device_sn asc");
		// example.setPage(new Page(1, 5));
		return deviceMapper.selectByExample(example);
	}

	@Override
	public void delete(Long deviceId) {
		deviceMapper.deleteByPrimaryKey(deviceId);
	}

	@Override
	public void createVender(DeviceVender vender) {
		deviceVenderMapper.insert(vender);
	}

	@Override
	public DeviceVender findVenderById(Long venderId) {
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
	public void deleteVender(Long venderId) {
		deviceVenderMapper.deleteByPrimaryKey(venderId);
	}

	@Override
	public void updateVender(DeviceVender vender) {
		deviceVenderMapper.updateByPrimaryKey(vender);
	}

}
