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
	void delete(String warnGroupId);

	// 通过ID获取告警组
	WarnGroup getById(String warnGroupId);

	// 获取系统所有的告警组
	List<WarnGroup> getAll();

	// 获取用户所有的告警组以及系统告警组
	List<WarnGroup> getOwnerAll(String ownerId);

	// 获取用户所有的告警组以及系统告警组
	List<MPumpWarnGroup> getPumpNoSelects(String ownerId, String pumpId);

	// 新增告警项
	void addItem(WarnGroupItem item);

	// 修改告警项
	void updateItem(WarnGroupItem item);

	// 删除告警项
	void deleteItem(String itemId);

	// 通过ID获取告警组项
	WarnGroupItem getItemById(String warnGroupItemId);

	// 获取告警组的所有告警项
	List<WarnGroupItem> getWarnGroupItems(String warnGroupId);

	WarnGroupItem getWarnGroupItemByCode(String warnCode);
}
