package com.xt.service;

import java.util.List;

import com.xt.entity.custom.MPumpStoppage;
import com.xt.entity.generation.Stoppage;
import com.xt.entity.generation.StoppageHandle;

public interface StoppageService {

	void create(Stoppage stoppage);

	void update(Stoppage stoppage);

	Stoppage getById(String stoppageId);

	void delete(String stoppageId);

	List<Stoppage> getByPumpId(String pumpId);

	List<MPumpStoppage> getAll();

	List<MPumpStoppage> getByPumpIds(List<String> pumpIds);

	List<StoppageHandle> getHandleByStoppageId(String stoppageId);

	StoppageHandle getHandleById(String handleId);

	void createHandle(StoppageHandle handle);

	void handleEvaluate(StoppageHandle handle);

	List<Stoppage> getByNoAllot(String no, int page);
}
