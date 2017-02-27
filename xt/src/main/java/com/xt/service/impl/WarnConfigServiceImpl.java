package com.xt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.dao.generation.WarnGroupItemMapper;
import com.xt.dao.generation.WarnGroupMapper;
import com.xt.dao.generation.WarnMonitorItemMapper;
import com.xt.entity.generation.WarnGroup;
import com.xt.entity.generation.WarnGroupExample;
import com.xt.entity.generation.WarnGroupItem;
import com.xt.entity.generation.WarnGroupItemExample;
import com.xt.entity.generation.WarnMonitorItem;
import com.xt.entity.generation.WarnMonitorItemExample;
import com.xt.service.WarnConfigService;
import com.xt.util.PublicUtil;

@Service
public class WarnConfigServiceImpl implements WarnConfigService {

	@Autowired
	WarnGroupMapper warnGroupMapper;
	@Autowired
	WarnGroupItemMapper warnGroupItemMapper;
	@Autowired
	WarnMonitorItemMapper warnMonitorItemMapper;

	@Override
	public WarnGroup findWarnGroupById(Long warnGroupId) {
		return warnGroupMapper.selectByPrimaryKey(warnGroupId);
	}

	@Override
	public WarnGroupItem findWarnItemById(Long warnItemId) {
		return warnGroupItemMapper.selectByPrimaryKey(warnItemId);
	}

	@Override
	public List<WarnGroup> findAllWarnGroup() {
		WarnGroupExample example = new WarnGroupExample();
		example.setOrderByClause("create_time asc");
		return warnGroupMapper.selectByExample(example);
	}

	@Override
	public List<WarnGroupItem> findAllWarnItem(Long warnGroupId) {
		WarnGroupItemExample example = new WarnGroupItemExample();
		example.createCriteria().andWarnGroupIdEqualTo(warnGroupId);
		example.setOrderByClause("create_time asc");
		return warnGroupItemMapper.selectByExample(example);
	}

	@Override
	public List<WarnMonitorItem> findAllWarnMonitorItem() {
		WarnMonitorItemExample example = new WarnMonitorItemExample();
		example.setOrderByClause("item_name asc");
		return warnMonitorItemMapper.selectByExample(example);
	}

	@Override
	public WarnGroupItem findWarnItemByCode(String warnCode) {
		WarnGroupItemExample example = new WarnGroupItemExample();
		example.createCriteria().andWarnCodeEqualTo(warnCode);
		List<WarnGroupItem> wis = warnGroupItemMapper.selectByExample(example);
		if (PublicUtil.isEmpty(wis)) {
			return null;
		} else {
			return wis.get(0);
		}
	}

	@Override
	public void createWarnGroup(WarnGroup warnGroup) {
		warnGroupMapper.insert(warnGroup);
	}

	@Override
	public void createWarnItem(WarnGroupItem warnGroupItem) {
		warnGroupItemMapper.insert(warnGroupItem);
	}

	@Override
	public void updateWarnGroup(WarnGroup warnGroup) {
		warnGroupMapper.updateByPrimaryKey(warnGroup);
	}

	@Override
	public void updateWarnItem(WarnGroupItem warnGroupItem) {
		warnGroupItemMapper.updateByPrimaryKey(warnGroupItem);
	}

	@Override
	public void deleteWarnGroup(Long warnGroupId) {
		warnGroupMapper.deleteByPrimaryKey(warnGroupId);
	}

	@Override
	public void deleteWarnItem(Long warnItemId) {
		warnGroupItemMapper.deleteByPrimaryKey(warnItemId);
	}

}
