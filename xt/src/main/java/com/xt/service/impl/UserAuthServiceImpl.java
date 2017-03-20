package com.xt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.dao.generation.UserAuthMapper;
import com.xt.entity.generation.UserAuth;
import com.xt.entity.generation.UserAuthExample;
import com.xt.service.UserAuthService;
import com.xt.util.PublicUtil;

@Service
public class UserAuthServiceImpl implements UserAuthService {

	@Autowired
	UserAuthMapper userAuthMapper;

	@Override
	public boolean authUser(UserAuth userAuth) {
		List<UserAuth> userAuths = findUserAll(userAuth.getUserId());
		if (userAuths != null && !userAuths.isEmpty()) {
			for (UserAuth ua : userAuths) {
				if (userAuth.getAuthCode().startsWith(PublicUtil.delZero(ua.getAuthCode()))) {
					return false;
				}
				if (ua.getAuthCode().startsWith(PublicUtil.delZero(userAuth.getAuthCode()))) {
					unAuthUser(ua.getRootId());
				}
			}
		}
		userAuthMapper.insert(userAuth);
		return true;
	}

	@Override
	public UserAuth findByUserIdWithNodeId(Long userId, Long nodeId) {
		UserAuthExample example = new UserAuthExample();
		example.createCriteria().andUserIdEqualTo(userId).andProjectAreaIdEqualTo(nodeId);
		List<UserAuth> uas = userAuthMapper.selectByExample(example);
		if (uas != null && uas.size() == 1) {
			return uas.get(0);
		}
		example = new UserAuthExample();
		example.createCriteria().andUserIdEqualTo(userId).andPumpIdEqualTo(nodeId);
		uas = userAuthMapper.selectByExample(example);
		if (uas != null && uas.size() == 1) {
			return uas.get(0);
		}
		return null;
	}

	@Override
	public void unAuthUser(Long rootId) {
		userAuthMapper.deleteByPrimaryKey(rootId);
	}

	@Override
	public List<UserAuth> findUserAll(Long userId) {
		UserAuthExample example = new UserAuthExample();
		example.createCriteria().andUserIdEqualTo(userId);
		example.setOrderByClause("auth_code asc");
		return userAuthMapper.selectByExample(example);
	}

}
