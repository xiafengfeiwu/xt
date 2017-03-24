package com.xt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.dao.generation.ResMapper;
import com.xt.entity.generation.Res;
import com.xt.entity.generation.ResExample;
import com.xt.service.ResService;

@Service("resService")
public class ResServiceImpl implements ResService {

	@Autowired
	ResMapper resMapper;

	@Override
	public void insert(Res res) {
		resMapper.insert(res);
	}

	@Override
	public void delete(String resId) {
		resMapper.deleteByPrimaryKey(resId);
	}

	@Override
	public Res getById(String resId) {
		return resMapper.selectByPrimaryKey(resId);
	}

	@Override
	public List<Res> findResByGroupId(String groupId) {
		ResExample example = new ResExample();
		example.createCriteria().andGroupIdEqualTo(groupId);
		example.setOrderByClause("res_create_time desc");
		return resMapper.selectByExample(example);
	}

}
