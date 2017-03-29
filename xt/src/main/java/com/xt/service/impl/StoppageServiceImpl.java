package com.xt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.dao.custom.MPumpMapper;
import com.xt.dao.generation.StoppageHandleMapper;
import com.xt.dao.generation.StoppageMapper;
import com.xt.entity.custom.MPumpStoppage;
import com.xt.entity.generation.Stoppage;
import com.xt.entity.generation.StoppageExample;
import com.xt.entity.generation.StoppageHandle;
import com.xt.entity.generation.StoppageHandleExample;
import com.xt.service.StoppageService;
import com.xt.util.PublicUtil;

@Service
public class StoppageServiceImpl implements StoppageService {

	@Autowired
	StoppageMapper stoppageMapper;
	@Autowired
	StoppageHandleMapper handleMapper;
	@Autowired
	MPumpMapper mPumpMapper;

	@Override
	public void create(Stoppage stoppage) {
		stoppageMapper.insert(stoppage);
	}

	@Override
	public void update(Stoppage stoppage) {
		stoppageMapper.updateByPrimaryKey(stoppage);
	}

	@Override
	public Stoppage getById(String stoppageId) {
		return stoppageMapper.selectByPrimaryKey(stoppageId);
	}

	@Override
	public void delete(String stoppageId) {
		stoppageMapper.deleteByPrimaryKey(stoppageId);
	}

	@Override
	public List<Stoppage> getByPumpId(String pumpId) {
		StoppageExample example = new StoppageExample();
		example.createCriteria().andPumpIdEqualTo(pumpId);
		example.setOrderByClause("occur_time desc");
		return stoppageMapper.selectByExample(example);
	}

	@Override
	public List<MPumpStoppage> getAll() {
		return mPumpMapper.selectAllStoppages();
	}

	@Override
	public List<MPumpStoppage> getByPumpIds(List<String> pumpIds) {
		return mPumpMapper.selectStoppagesByPumpIds(pumpIds);
	}

	@Override
	public List<StoppageHandle> getHandleByStoppageId(String stoppageId) {
		StoppageHandleExample example = new StoppageHandleExample();
		example.createCriteria().andStoppageIdEqualTo(stoppageId);
		example.setOrderByClause("handle_time desc");
		return handleMapper.selectByExample(example);
	}

	@Override
	public void createHandle(StoppageHandle handle) {
		handleMapper.insert(handle);
	}

	@Override
	public StoppageHandle getHandleById(String handleId) {
		return handleMapper.selectByPrimaryKey(handleId);
	}

	@Override
	public void handleEvaluate(StoppageHandle evaluate) {
		handleMapper.updateByPrimaryKey(evaluate);
	}

	@Override
	public List<Stoppage> getByNoAllot(String no, int page) {
		StoppageExample example = new StoppageExample();
		if (PublicUtil.isNotEmpty(no)) {
			example.createCriteria().andOperatorIdIsNull().andStoppageNoLike("%" + no + "%");
		}
		example.setOrderByClause("create_time asc limit " + (page - 1) * 20 + ", 20");
		return stoppageMapper.selectByExample(example);
	}
}
