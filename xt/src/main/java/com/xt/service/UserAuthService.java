package com.xt.service;

import java.util.List;

import com.xt.entity.generation.UserAuth;

public interface UserAuthService {

	boolean authUser(UserAuth userAuth);

	UserAuth findByUserIdWithNodeId(Long userId, Long nodeId);

	void unAuthUser(Long rootId);

	List<UserAuth> findUserAll(Long userId);

}
