package com.xt.entity.generation;

import java.util.Date;

public class StoppageHandle {
    private String stoppageHandleId;

    private String stoppageId;

    private String handleUserId;

    private Date handleTime;

    private String handleDuration;

    private String handleStatus;

    private String handleDescript;

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

    public String getHandleDuration() {
        return handleDuration;
    }

    public void setHandleDuration(String handleDuration) {
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
}