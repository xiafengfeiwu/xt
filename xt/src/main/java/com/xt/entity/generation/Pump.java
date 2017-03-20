package com.xt.entity.generation;

import java.util.Date;

public class Pump {
    private String pumpId;

    private String projectId;

    private String ownerId;

    private String pumpName;

    private String pumpCode;

    private String productId;

    private String pumpSn;

    private Date installDate;

    private String areaLongitude;

    private String areaLatitude;

    private Date createTime;

    private Date modifyTime;

    public String getPumpId() {
        return pumpId;
    }

    public void setPumpId(String pumpId) {
        this.pumpId = pumpId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getPumpName() {
        return pumpName;
    }

    public void setPumpName(String pumpName) {
        this.pumpName = pumpName;
    }

    public String getPumpCode() {
        return pumpCode;
    }

    public void setPumpCode(String pumpCode) {
        this.pumpCode = pumpCode;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getPumpSn() {
        return pumpSn;
    }

    public void setPumpSn(String pumpSn) {
        this.pumpSn = pumpSn;
    }

    public Date getInstallDate() {
        return installDate;
    }

    public void setInstallDate(Date installDate) {
        this.installDate = installDate;
    }

    public String getAreaLongitude() {
        return areaLongitude;
    }

    public void setAreaLongitude(String areaLongitude) {
        this.areaLongitude = areaLongitude;
    }

    public String getAreaLatitude() {
        return areaLatitude;
    }

    public void setAreaLatitude(String areaLatitude) {
        this.areaLatitude = areaLatitude;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}