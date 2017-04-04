package com.xt.entity.custom;

import java.math.BigDecimal;

public class MPumpEleStatistics {
	private Short intervalTime;
	private BigDecimal eleInterval;

	public Short getIntervalTime() {
		return intervalTime;
	}

	public void setIntervalTime(Short intervalTime) {
		this.intervalTime = intervalTime;
	}

	public BigDecimal getEleInterval() {
		return eleInterval;
	}

	public void setEleInterval(BigDecimal eleInterval) {
		this.eleInterval = eleInterval;
	}
}
