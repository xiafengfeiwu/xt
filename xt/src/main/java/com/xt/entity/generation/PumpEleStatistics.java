package com.xt.entity.generation;

import java.math.BigDecimal;

public class PumpEleStatistics {
    private String dataId;

    private String pumpId;

    private Short intervalYear;

    private Short intervalMonth;

    private Short intervalDay;

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

    public Short getIntervalYear() {
        return intervalYear;
    }

    public void setIntervalYear(Short intervalYear) {
        this.intervalYear = intervalYear;
    }

    public Short getIntervalMonth() {
        return intervalMonth;
    }

    public void setIntervalMonth(Short intervalMonth) {
        this.intervalMonth = intervalMonth;
    }

    public Short getIntervalDay() {
        return intervalDay;
    }

    public void setIntervalDay(Short intervalDay) {
        this.intervalDay = intervalDay;
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