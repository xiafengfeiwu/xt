package com.xt.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.dao.generation.JurisdictionMapper;
import com.xt.dao.generation.RoleJurisdictionMapper;
import com.xt.dao.generation.RoleMapper;
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
	public Role getById(String roleId) {
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
	public void delete(String roleId) {
		roleMapper.deleteByPrimaryKey(roleId);
	}

	@Override
	public List<Role> findAll() {
		RoleExample example = new RoleExample();
		return roleMapper.selectByExample(example);
	}

	@Override
	public Set<String> findRoleJurisdictions(String roleId) {
		RoleJurisdictionExample example = new RoleJurisdictionExample();
		example.createCriteria().andRoleIdEqualTo(roleId);
		List<RoleJurisdictionKey> jurisdictions = roleJurisdictionMapper.selectByExample(example);
		if (PublicUtil.isEmpty(jurisdictions)) {
			return null;
		}
		Set<String> juids = new HashSet<>();
		for (RoleJurisdictionKey key : jurisdictions) {
			juids.add(key.getJurisdictionCode());
		}
		return juids;
	}

	@Override
	public boolean checkRoleJurisdiction(String roleId, String jurisdictionCode) {
		RoleJurisdictionExample example = new RoleJurisdictionExample();
		example.createCriteria().andJurisdictionCodeEqualTo(jurisdictionCode).andRoleIdEqualTo(roleId);
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
