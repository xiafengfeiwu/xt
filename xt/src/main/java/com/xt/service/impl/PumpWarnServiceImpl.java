package com.xt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.dao.generation.PumpWarnMapper;
import com.xt.entity.generation.PumpWarn;
import com.xt.entity.generation.PumpWarnExample;
import com.xt.service.PumpWarnService;

@Service
public class PumpWarnServiceImpl implements PumpWarnService {

	@Autowired
	PumpWarnMapper pumpWarnMapper;

	@Override
	public void create(PumpWarn pumpWarn) {
		pumpWarnMapper.insert(pumpWarn);
	}

	@Override
	public void delete(String pumpWarnId) {
		pumpWarnMapper.deleteByPrimaryKey(pumpWarnId);
	}

	@Override
	public PumpWarn getById(String pumpWarnId) {
		return pumpWarnMapper.selectByPrimaryKey(pumpWarnId);
	}

	@Override
	public List<PumpWarn> getByPumpId(String pumpId) {
		PumpWarnExample example = new PumpWarnExample();
		example.createCriteria().andPumpIdEqualTo(pumpId);
		example.setOrderByClause("warn_happen_time desc");
		return pumpWarnMapper.selectByExample(example);
	}

}
