package com.xt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.dao.custom.MPumpMapper;
import com.xt.dao.generation.StoppageHandleEvaluateMapper;
import com.xt.dao.generation.StoppageHandleMapper;
import com.xt.dao.generation.StoppageMapper;
import com.xt.entity.custom.MPumpStoppage;
import com.xt.entity.generation.Stoppage;
import com.xt.entity.generation.StoppageExample;
import com.xt.entity.generation.StoppageHandle;
import com.xt.entity.generation.StoppageHandleEvaluate;
import com.xt.entity.generation.StoppageHandleEvaluateExample;
import com.xt.entity.generation.StoppageHandleExample;
import com.xt.service.StoppageService;

@Service
public class StoppageServiceImpl implements StoppageService {

	@Autowired
	StoppageMapper stoppageMapper;
	@Autowired
	StoppageHandleMapper handleMapper;
	@Autowired
	StoppageHandleEvaluateMapper evaluateMapper;
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
	public List<Stoppage> getByOriginatorId(String userId) {
		StoppageExample example = new StoppageExample();
		example.createCriteria().andOriginatorIdEqualTo(userId);
		example.setOrderByClause("occur_time desc");
		return stoppageMapper.selectByExample(example);
	}

	@Override
	public List<StoppageHandle> getByStoppageId(String stoppageId) {
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
	public void deleteHandle(String handleId) {
		handleMapper.deleteByPrimaryKey(handleId);
	}

	@Override
	public StoppageHandleEvaluate getByHeadleId(String handlerId) {
		StoppageHandleEvaluateExample example = new StoppageHandleEvaluateExample();
		example.createCriteria().andStoppageHandleIdEqualTo(handlerId);
		example.setOrderByClause("evaluate_time desc limit 0, 1");
		List<StoppageHandleEvaluate> evaluates = evaluateMapper.selectByExample(example);
		if (evaluates == null || evaluates.isEmpty()) {
			return null;
		}
		return evaluates.get(0);
	}

	@Override
	public void createHandleEvaluate(StoppageHandleEvaluate evaluate) {
		evaluateMapper.insert(evaluate);
	}

}
