package com.xt.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.dao.custom.MPumpMapper;
import com.xt.dao.generation.PumpMapper;
import com.xt.dao.generation.PumpWarnGroupMapper;
import com.xt.entity.custom.MAreaPump;
import com.xt.entity.custom.MLastCode;
import com.xt.entity.custom.MPumpMonitor;
import com.xt.entity.custom.MPumpWarnGroup;
import com.xt.entity.generation.Pump;
import com.xt.entity.generation.PumpExample;
import com.xt.entity.generation.PumpWarnGroup;
import com.xt.entity.generation.PumpWarnGroupKey;
import com.xt.entity.generation.UserAuth;
import com.xt.service.PumpService;
import com.xt.service.UserAuthService;
import com.xt.util.PublicUtil;

@Service
public class PumpServiceImpl implements PumpService {

	@Autowired
	PumpMapper pumpMapper;
	@Autowired
	MPumpMapper mAreaPumpMapper;
	@Autowired
	UserAuthService userAuthService;
	@Autowired
	PumpWarnGroupMapper pumpWarnGroupMapper;

	@Override
	public Pump getById(String pumpId) {
		return pumpMapper.selectByPrimaryKey(pumpId);
	}

	@Override
	public Pump getBySn(String pumpSn) {
		PumpExample example = new PumpExample();
		example.createCriteria().andPumpSnEqualTo(pumpSn);
		List<Pump> pumps = pumpMapper.selectByExample(example);
		if (pumps != null && pumps.size() > 0) {
			return pumps.get(0);
		}
		return null;
	}

	@Override
	public String getLastPumpCode(String preCode) {
		MLastCode mLastCode = mAreaPumpMapper.selectLastPumpcode(preCode);
		if (mLastCode == null) {
			return preCode + "0001";
		}
		return PublicUtil.getNextPumpCode(mLastCode.getCode());
	}

	@Override
	public void create(Pump pump) {
		pumpMapper.insert(pump);

		UserAuth userAuth = new UserAuth();
		userAuth.setRootId(PublicUtil.initId());
		userAuth.setUserId(pump.getOwnerId());
		userAuth.setPumpId(pump.getPumpId());
		userAuth.setAuthCode(pump.getPumpCode());
		userAuthService.authUser(userAuth);

	}

	@Override
	public void update(Pump pump) {
		pumpMapper.updateByPrimaryKey(pump);
	}

	@Override
	public void delete(String pumpId) {
		pumpMapper.deleteByPrimaryKey(pumpId);
	}

	@Override
	public List<Pump> getAll() {
		PumpExample example = new PumpExample();
		example.setOrderByClause("project_id asc, create_time asc");
		return pumpMapper.selectByExample(example);
	}

	@Override
	public List<Pump> getOwnerAll(String ownerId) {
		PumpExample example = new PumpExample();
		example.createCriteria().andOwnerIdEqualTo(ownerId);
		example.setOrderByClause("project_id asc, create_time asc");
		return pumpMapper.selectByExample(example);
	}

	@Override
	public List<Pump> getProjectAll(String projectId) {
		PumpExample example = new PumpExample();
		example.createCriteria().andProjectIdEqualTo(projectId);
		example.setOrderByClause("project_id asc, create_time asc");
		return pumpMapper.selectByExample(example);
	}

	@Override
	public List<MAreaPump> getProjectAreaAll(String projectAreaId) {
		return mAreaPumpMapper.selectAreaPumps(projectAreaId);
	}

	@Override
	public List<MAreaPump> selectUserAuthPump(String userId) {
		return mAreaPumpMapper.selectUserAuthPump(userId);
	}

	@Override
	public List<MAreaPump> selectPumpsByIds(List<String> pumpIds) {
		return mAreaPumpMapper.selectPumpsByIds(pumpIds);
	}

	@Override
	public List<MAreaPump> selectPumpsByCodes(List<String> pumpCodes) {
		List<String> iPumpCodes = new ArrayList<>();
		if (pumpCodes != null && !pumpCodes.isEmpty()) {
			for (String code : pumpCodes) {
				iPumpCodes.add(PublicUtil.delZero(code));
			}
		}
		return mAreaPumpMapper.selectPumpsByCodes(iPumpCodes);
	}

	@Override
	public List<MPumpMonitor> selectAllPumpMonitors() {
		return mAreaPumpMapper.selectAllPumpMonitors();
	}

	@Override
	public List<MPumpWarnGroup> selectPumpWarnGroups(String pumpId) {
		return mAreaPumpMapper.selectPumpWarnGroups(pumpId);
	}

	@Override
	public void addPumpWarnGroup(PumpWarnGroup warnGroup) {
		pumpWarnGroupMapper.insert(warnGroup);
	}

	@Override
	public void removePumpWarnGroup(PumpWarnGroupKey key) {
		pumpWarnGroupMapper.deleteByPrimaryKey(key);
	}
}
