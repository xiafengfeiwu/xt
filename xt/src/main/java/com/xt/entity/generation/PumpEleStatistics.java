package com.xt.entity.generation;

import java.math.BigDecimal;
import java.util.Date;

public class PumpEleStatistics {
    private String dataId;

    private String pumpId;

    private Date intervalDate;

    private Short intervalHour;

    private BigDecimal eleInterval;

    private BigDecimal eleTotal;

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getPumpId() {
        return pumpId;
    }

    public void setPumpId(String pumpId) {
        this.pumpId = pumpId;
    }

    public Date getIntervalDate() {
        return intervalDate;
    }

    public void setIntervalDate(Date intervalDate) {
        this.intervalDate = intervalDate;
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