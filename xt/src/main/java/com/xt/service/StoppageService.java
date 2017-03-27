package com.xt.service;

import java.util.List;

import com.xt.entity.custom.MPumpStoppage;
import com.xt.entity.generation.Stoppage;
import com.xt.entity.generation.StoppageHandle;
import com.xt.entity.generation.StoppageHandleEvaluate;

public interface StoppageService {

	void create(Stoppage stoppage);

	void update(Stoppage stoppage);

	Stoppage getById(String stoppageId);

	void delete(String stoppageId);

	List<Stoppage> getByPumpId(String pumpId);

	List<MPumpStoppage> getAll();

	List<MPumpStoppage> getByPumpIds(List<String> pumpIds);

	List<Stoppage> getByOriginatorId(String userId);

	List<StoppageHandle> getByStoppageId(String stoppageId);

	void createHandle(StoppageHandle handle);

	void deleteHandle(String handleId);

	StoppageHandleEvaluate getByHeadleId(String handlerId);

	void createHandleEvaluate(StoppageHandleEvaluate evaluate);
}
