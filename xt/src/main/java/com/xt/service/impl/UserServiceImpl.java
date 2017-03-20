package com.xt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.dao.generation.UserMapper;
import com.xt.entity.generation.User;
import com.xt.entity.generation.UserAuth;
import com.xt.entity.generation.UserExample;
import com.xt.service.UserAuthService;
import com.xt.service.UserService;
import com.xt.util.PublicUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;
	@Autowired
	UserAuthService userAuthService;

	@Override
	public User findByLoginName(String loginName) {
		UserExample example = new UserExample();
		example.createCriteria().andUserLoginNameEqualTo(loginName);
		List<User> users = userMapper.selectByExample(example);
		if (users == null || users.isEmpty()) {
			return null;
		}
		return users.get(0);
	}

	@Override
	public User findByPhoneNo(String phoneNo) {
		UserExample example = new UserExample();
		example.createCriteria().andUserPhoneEqualTo(phoneNo);
		List<User> users = userMapper.selectByExample(example);
		if (users == null || users.isEmpty()) {
			return null;
		}
		return users.get(0);
	}

	@Override
	public User findById(String userId) {
		return userMapper.selectByPrimaryKey(userId);
	}

	@Override
	public User findUserByWxOpenId(String openId) {
		UserExample example = new UserExample();
		example.createCriteria().andUserWxOpenIdEqualTo(openId);
		List<User> users = userMapper.selectByExample(example);
		if (users == null || users.isEmpty()) {
			return null;
		}
		return users.get(0);
	}

	@Override
	public List<User> getTop5BySearchWord(String searchWord) {
		UserExample example = new UserExample();
		if (PublicUtil.isNotEmpty(searchWord)) {
			searchWord = "%" + searchWord + "%";
			example.or().andUserNameLike(searchWord);
			example.or().andUserLoginNameLike(searchWord);
			example.or().andUserNamePyLike(searchWord);
			example.or().andUserPhoneLike(searchWord);
		}
		example.setOrderByClause("user_name asc");
		return userMapper.selectByExample(example);
	}

	@Override
	public List<User> getUserData() {
		UserExample example = new UserExample();
		example.setOrderByClause("user_regist_time asc");
		return userMapper.selectByExample(example);
	}

	@Override
	public void regist(User user) {
		userMapper.insert(user);
	}

	@Override
	public void update(User user) {
		userMapper.updateByPrimaryKey(user);
		if (PublicUtil.ROLE_SYSTEM_MANAGE_ID.equals(user.getRoleId())) {
			// 是管理员，删除分配的区域和热泵关联
			List<UserAuth> auths = userAuthService.findUserAll(user.getUserId());
			if (auths != null && !auths.isEmpty()) {
				for (UserAuth ua : auths) {
					userAuthService.unAuthUser(ua.getRootId());
				}
			}
		}
	}

	@Override
	public void delete(String userId) {
		userMapper.deleteByPrimaryKey(userId);
	}

}
