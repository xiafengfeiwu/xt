package com.xt.service;

import java.util.List;

import com.xt.entity.generation.Device;
import com.xt.entity.generation.DeviceVender;

public interface DeviceService {

	// 通过ID获取设备信息
	Device findById(String deviceId);

	// 通过SN获取设备信息
	Device findBySn(String sn);

	// 保存设备
	void save(Device device);

	// 更新设备
	void update(Device device);

	// 获取热泵采集设备数据
	List<Device> getDevicesByPumpId(String pumpId);

	// 删除设备
	void delete(String deviceId);

	// 通过供应商ID获取供应商
	DeviceVender findVenderById(String venderId);

	// 通过供应商CODE获取供应商
	DeviceVender findVenderByCode(String venderCode);

	// 创建设备供应商
	void createVender(DeviceVender vender);

	// 获取所有的设备供应商
	List<DeviceVender> findAllVenders();

	// 删除设备供应商
	void deleteVender(String venderId);

	// 更新设备供应商
	void updateVender(DeviceVender vender);

}
