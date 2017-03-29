package com.xt.entity.generation;

import java.util.Date;

public class Stoppage {
    private String stoppageId;

    private String operatorId;

    private String stoppageNo;

    private String pumpId;

    private String pumpWarnId;

    private String descript;

    private String attachId;

    private String originatorId;

    private String occurTime;

    private Date createTime;

    private String handleStatus;

    private Date handleModifyTime;

    public String getStoppageId() {
        return stoppageId;
    }

    public void setStoppageId(String stoppageId) {
        this.stoppageId = stoppageId;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getStoppageNo() {
        return stoppageNo;
    }

    public void setStoppageNo(String stoppageNo) {
        this.stoppageNo = stoppageNo;
    }

    public String getPumpId() {
        return pumpId;
    }

    public void setPumpId(String pumpId) {
        this.pumpId = pumpId;
    }

    public String getPumpWarnId() {
        return pumpWarnId;
    }

    public void setPumpWarnId(String pumpWarnId) {
        this.pumpWarnId = pumpWarnId;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public String getAttachId() {
        return attachId;
    }

    public void setAttachId(String attachId) {
        this.attachId = attachId;
    }

    public String getOriginatorId() {
        return originatorId;
    }

    public void setOriginatorId(String originatorId) {
        this.originatorId = originatorId;
    }

    public String getOccurTime() {
        return occurTime;
    }

    public void setOccurTime(String occurTime) {
        this.occurTime = occurTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getHandleStatus() {
        return handleStatus;
    }

    public void setHandleStatus(String handleStatus) {
        this.handleStatus = handleStatus;
    }

    public Date getHandleModifyTime() {
        return handleModifyTime;
    }

    public void setHandleModifyTime(Date handleModifyTime) {
        this.handleModifyTime = handleModifyTime;
    }
}