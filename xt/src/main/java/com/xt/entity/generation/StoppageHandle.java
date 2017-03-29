package com.xt.entity.generation;

import java.util.Date;

public class StoppageHandle {
    private String stoppageHandleId;

    private String stoppageId;

    private String handleUserId;

    private Date handleTime;

    private Long handleDuration;

    private String handleStatus;

    private String handleDescript;

    private Date evaluateTime;

    private String evaluateLevel;

    private String evaluateDescript;

    public String getStoppageHandleId() {
        return stoppageHandleId;
    }

    public void setStoppageHandleId(String stoppageHandleId) {
        this.stoppageHandleId = stoppageHandleId;
    }

    public String getStoppageId() {
        return stoppageId;
    }

    public void setStoppageId(String stoppageId) {
        this.stoppageId = stoppageId;
    }

    public String getHandleUserId() {
        return handleUserId;
    }

    public void setHandleUserId(String handleUserId) {
        this.handleUserId = handleUserId;
    }

    public Date getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(Date handleTime) {
        this.handleTime = handleTime;
    }

    public Long getHandleDuration() {
        return handleDuration;
    }

    public void setHandleDuration(Long handleDuration) {
        this.handleDuration = handleDuration;
    }

    public String getHandleStatus() {
        return handleStatus;
    }

    public void setHandleStatus(String handleStatus) {
        this.handleStatus = handleStatus;
    }

    public String getHandleDescript() {
        return handleDescript;
    }

    public void setHandleDescript(String handleDescript) {
        this.handleDescript = handleDescript;
    }

    public Date getEvaluateTime() {
        return evaluateTime;
    }

    public void setEvaluateTime(Date evaluateTime) {
        this.evaluateTime = evaluateTime;
    }

    public String getEvaluateLevel() {
        return evaluateLevel;
    }

    public void setEvaluateLevel(String evaluateLevel) {
        this.evaluateLevel = evaluateLevel;
    }

    public String getEvaluateDescript() {
        return evaluateDescript;
    }

    public void setEvaluateDescript(String evaluateDescript) {
        this.evaluateDescript = evaluateDescript;
    }
}