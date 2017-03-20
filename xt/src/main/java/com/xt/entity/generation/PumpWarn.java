package com.xt.entity.generation;

import java.util.Date;

public class PumpWarn {
    private String warnId;

    private String warnNo;

    private String pumpId;

    private String warnCode;

    private String warnLevel;

    private String warnDescript;

    private Date warnHappenTime;

    public String getWarnId() {
        return warnId;
    }

    public void setWarnId(String warnId) {
        this.warnId = warnId;
    }

    public String getWarnNo() {
        return warnNo;
    }

    public void setWarnNo(String warnNo) {
        this.warnNo = warnNo;
    }

    public String getPumpId() {
        return pumpId;
    }

    public void setPumpId(String pumpId) {
        this.pumpId = pumpId;
    }

    public String getWarnCode() {
        return warnCode;
    }

    public void setWarnCode(String warnCode) {
        this.warnCode = warnCode;
    }

    public String getWarnLevel() {
        return warnLevel;
    }

    public void setWarnLevel(String warnLevel) {
        this.warnLevel = warnLevel;
    }

    public String getWarnDescript() {
        return warnDescript;
    }

    public void setWarnDescript(String warnDescript) {
        this.warnDescript = warnDescript;
    }

    public Date getWarnHappenTime() {
        return warnHappenTime;
    }

    public void setWarnHappenTime(Date warnHappenTime) {
        this.warnHappenTime = warnHappenTime;
    }
}