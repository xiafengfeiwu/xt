package com.xt.entity.generation;

import java.math.BigDecimal;

public class PumpEleStatistics {
    private Long dataId;

    private Long pumpId;

    private Short intervalHour;

    private BigDecimal eleInterval;

    private BigDecimal eleTotal;

    public Long getDataId() {
        return dataId;
    }

    public void setDataId(Long dataId) {
        this.dataId = dataId;
    }

    public Long getPumpId() {
        return pumpId;
    }

    public void setPumpId(Long pumpId) {
        this.pumpId = pumpId;
    }

    public Short getIntervalHour() {
        return intervalHour;
    }

    public void setIntervalHour(Short intervalHour) {
        this.intervalHour = intervalHour;
    }

    public BigDecimal getEleInterval() {
        return eleInterval;
    }

    public void setEleInterval(BigDecimal eleInterval) {
        this.eleInterval = eleInterval;
    }

    public BigDecimal getEleTotal() {
        return eleTotal;
    }

    public void setEleTotal(BigDecimal eleTotal) {
        this.eleTotal = eleTotal;
    }
}