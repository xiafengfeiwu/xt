package com.xt.service;

import java.util.List;

import com.xt.entity.generation.UserAuth;

public interface UserAuthService {

	boolean authUser(UserAuth userAuth);

	UserAuth findByUserIdWithNodeId(String userId, String nodeId);

	void unAuthUser(String rootId);

	List<UserAuth> findUserAll(String userId);

}
