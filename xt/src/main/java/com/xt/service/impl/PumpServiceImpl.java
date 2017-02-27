package com.xt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.dao.generation.PumpMapper;
import com.xt.entity.generation.Pump;
import com.xt.entity.generation.PumpExample;
import com.xt.service.PumpService;
import com.xt.util.PublicUtil;

@Service
public class PumpServiceImpl implements PumpService {

	@Autowired
	PumpMapper pumpMapper;

	@Override
	public Pump getById(Long pumpId) {
		return pumpMapper.selectByPrimaryKey(pumpId);
	}

	@Override
	public void create(Pump pump) {
		pumpMapper.insert(pump);
	}

	@Override
	public void update(Pump pump) {
		pumpMapper.updateByPrimaryKey(pump);
	}

	@Override
	public void delete(Long pumpId) {
		pumpMapper.deleteByPrimaryKey(pumpId);
	}

	@Override
	public long getCountByPage(String searchWord) {
		PumpExample example = new PumpExample();
		if (PublicUtil.isNotEmpty(searchWord)) {
			searchWord = "%" + searchWord + "%";
		}
		return pumpMapper.countByExample(example);
	}

	@Override
	public List<Pump> getListByPage(String searchWord, String field, String order) {
		PumpExample example = new PumpExample();
		if (PublicUtil.isNotEmpty(searchWord)) {
			searchWord = "%" + searchWord + "%";
		}
		return pumpMapper.selectByExample(example);
	}

	@Override
	public List<Pump> getOwnerAllPumps(Long ownerId) {
		PumpExample example = new PumpExample();
		return pumpMapper.selectByExample(example);
	}

}
