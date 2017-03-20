package com.xt.service;

import java.util.List;

import com.xt.entity.custom.MPumpWarnGroup;
import com.xt.entity.generation.WarnGroup;
import com.xt.entity.generation.WarnGroupItem;

public interface WarnGroupService {

	// 新增告警组
	void create(WarnGroup warnGroup);

	// 修改告警组
	void update(WarnGroup warnGroup);

	// 删除告警组
	void delete(Long warnGroupId);

	// 通过ID获取告警组
	WarnGroup getById(Long warnGroupId);

	// 获取系统所有的告警组
	List<WarnGroup> getAll();

	// 获取用户所有的告警组以及系统告警组
	List<WarnGroup> getOwnerAll(Long ownerId);

	// 获取用户所有的告警组以及系统告警组
	List<MPumpWarnGroup> getPumpNoSelects(Long ownerId, Long pumpId);

	// 新增告警项
	void addItem(WarnGroupItem item);

	// 修改告警项
	void updateItem(WarnGroupItem item);

	// 删除告警项
	void deleteItem(Long itemId);

	// 通过ID获取告警组项
	WarnGroupItem getItemById(Long warnGroupItemId);

	// 获取告警组的所有告警项
	List<WarnGroupItem> getWarnGroupItems(Long warnGroupId);

	WarnGroupItem getWarnGroupItemByCode(String warnCode);
}
