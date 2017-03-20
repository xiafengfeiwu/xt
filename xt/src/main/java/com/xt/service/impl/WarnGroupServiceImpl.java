package com.xt.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.dao.custom.MPumpMapper;
import com.xt.dao.generation.WarnGroupItemMapper;
import com.xt.dao.generation.WarnGroupMapper;
import com.xt.entity.custom.MPumpWarnGroup;
import com.xt.entity.generation.WarnGroup;
import com.xt.entity.generation.WarnGroupExample;
import com.xt.entity.generation.WarnGroupItem;
import com.xt.entity.generation.WarnGroupItemExample;
import com.xt.service.WarnGroupService;

@Service
public class WarnGroupServiceImpl implements WarnGroupService {

	@Autowired
	WarnGroupMapper warnGroupMapper;
	@Autowired
	WarnGroupItemMapper warnGroupItemMapper;
	@Autowired
	MPumpMapper mPumpMapper;

	@Override
	public void create(WarnGroup warnGroup) {
		warnGroupMapper.insert(warnGroup);
	}

	@Override
	public void update(WarnGroup warnGroup) {
		warnGroupMapper.updateByPrimaryKey(warnGroup);
	}

	@Override
	public void delete(Long warnGroupId) {
		warnGroupMapper.deleteByPrimaryKey(warnGroupId);
	}

	@Override
	public WarnGroup getById(Long warnGroupId) {
		return warnGroupMapper.selectByPrimaryKey(warnGroupId);
	}

	@Override
	public List<WarnGroup> getAll() {
		WarnGroupExample example = new WarnGroupExample();
		example.setOrderByClause("system_group desc, create_time asc");
		return warnGroupMapper.selectByExample(example);
	}

	private List<WarnGroup> getSystemAll() {
		WarnGroupExample example = new WarnGroupExample();
		example.createCriteria().andSystemGroupEqualTo(Boolean.TRUE);
		example.setOrderByClause("create_time asc");
		return warnGroupMapper.selectByExample(example);
	}

	@Override
	public List<WarnGroup> getOwnerAll(Long ownerId) {
		List<WarnGroup> warnGroups = new ArrayList<>();
		warnGroups.addAll(getSystemAll());
		WarnGroupExample example = new WarnGroupExample();
		example.createCriteria().andOwnerIdEqualTo(ownerId);
		example.setOrderByClause("create_time asc");
		warnGroups.addAll(warnGroupMapper.selectByExample(example));
		return warnGroups;
	}

	@Override
	public List<MPumpWarnGroup> getPumpNoSelects(Long ownerId, Long pumpId) {
		return mPumpMapper.selectPumpNoUseWarnGroups(ownerId, pumpId);
	}

	@Override
	public void addItem(WarnGroupItem item) {
		warnGroupItemMapper.insert(item);
	}

	@Override
	public void updateItem(WarnGroupItem item) {
		warnGroupItemMapper.updateByPrimaryKey(item);
	}

	@Override
	public void deleteItem(Long itemId) {
		warnGroupItemMapper.deleteByPrimaryKey(itemId);
	}

	// 通过ID获取告警组项
	@Override
	public WarnGroupItem getItemById(Long warnGroupItemId) {
		return warnGroupItemMapper.selectByPrimaryKey(warnGroupItemId);
	}

	@Override
	public List<WarnGroupItem> getWarnGroupItems(Long warnGroupId) {
		WarnGroupItemExample example = new WarnGroupItemExample();
		example.createCriteria().andWarnGroupIdEqualTo(warnGroupId);
		example.setOrderByClause("create_time asc");
		return warnGroupItemMapper.selectByExample(example);
	}

	@Override
	public WarnGroupItem getWarnGroupItemByCode(String warnCode) {
		WarnGroupItemExample example = new WarnGroupItemExample();
		example.createCriteria().andWarnCodeEqualTo(warnCode);
		List<WarnGroupItem> groupItems = warnGroupItemMapper.selectByExample(example);
		if (groupItems != null && !groupItems.isEmpty()) {
			return groupItems.get(0);
		}
		return null;
	}
}
