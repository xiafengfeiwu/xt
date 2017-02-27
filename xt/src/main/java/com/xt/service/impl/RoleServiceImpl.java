package com.xt.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.dao.generation.JurisdictionMapper;
import com.xt.dao.generation.RoleJurisdictionMapper;
import com.xt.dao.generation.RoleMapper;
import com.xt.entity.generation.Jurisdiction;
import com.xt.entity.generation.JurisdictionExample;
import com.xt.entity.generation.Role;
import com.xt.entity.generation.RoleExample;
import com.xt.entity.generation.RoleJurisdictionExample;
import com.xt.entity.generation.RoleJurisdictionKey;
import com.xt.service.RoleService;
import com.xt.util.PublicUtil;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleMapper roleMapper;
	@Autowired
	RoleJurisdictionMapper roleJurisdictionMapper;
	@Autowired
	JurisdictionMapper jurisdictionMapper;

	@Override
	public Role getById(Long roleId) {
		return roleMapper.selectByPrimaryKey(roleId);
	}

	@Override
	public void create(Role role) {
		roleMapper.insert(role);
	}

	@Override
	public void update(Role role) {
		roleMapper.updateByPrimaryKey(role);
	}

	@Override
	public void delete(Long roleId) {
		roleMapper.deleteByPrimaryKey(roleId);
	}

	@Override
	public List<Role> findAll() {
		RoleExample example = new RoleExample();
		return roleMapper.selectByExample(example);
	}

	@Override
	public List<Jurisdiction> findRoleJurisdictions(Long roleId) {
		RoleJurisdictionExample example = new RoleJurisdictionExample();
		example.createCriteria().andRoleIdEqualTo(roleId);
		List<RoleJurisdictionKey> jurisdictions = roleJurisdictionMapper.selectByExample(example);
		if (PublicUtil.isEmpty(jurisdictions)) {
			return null;
		}
		List<Long> juids = new LinkedList<>();
		for (RoleJurisdictionKey key : jurisdictions) {
			juids.add(key.getJurisdictionId());
		}
		JurisdictionExample example2 = new JurisdictionExample();
		example2.createCriteria().andJurisdictionIdIn(juids);
		List<Jurisdiction> list = jurisdictionMapper.selectByExample(example2);
		return list;
	}

	@Override
	public boolean checkRoleJurisdiction(Long roleId, Long jurisdictionId) {
		RoleJurisdictionExample example = new RoleJurisdictionExample();
		example.createCriteria().andJurisdictionIdEqualTo(jurisdictionId).andRoleIdEqualTo(roleId);
		List<RoleJurisdictionKey> roleJurisdictions = roleJurisdictionMapper.selectByExample(example);
		return PublicUtil.isNotEmpty(roleJurisdictions);
	}


	@Override
	public void addRoleJurisdiction(RoleJurisdictionKey jurisdictionKey) {
		roleJurisdictionMapper.insert(jurisdictionKey);
	}

	@Override
	public void removeRoleJurisdiction(RoleJurisdictionKey jurisdictionKey) {
		roleJurisdictionMapper.deleteByPrimaryKey(jurisdictionKey);
	}

}
