package com.xt.service;

import java.util.List;
import java.util.Set;

import com.xt.entity.generation.Role;
import com.xt.entity.generation.RoleJurisdictionKey;

public interface RoleService {

	// 通过ID获取角色
	Role getById(String roleId);

	// 创建角色
	void create(Role role);

	// 更新角色
	void update(Role role);

	// 删除角色
	void delete(String roleId);

	// 获取所有角色
	List<Role> findAll();

	// 获取角色所有权限字
	Set<String> findRoleJurisdictions(String roleId);

	// 检查角色权限字是否存在
	boolean checkRoleJurisdiction(String roleId, String jurisdictionCode);

	// 增加角色权限字关联
	void addRoleJurisdiction(RoleJurisdictionKey jurisdictionKey);

	// 移除角色权限字关联
	void removeRoleJurisdiction(RoleJurisdictionKey jurisdictionKey);
}
