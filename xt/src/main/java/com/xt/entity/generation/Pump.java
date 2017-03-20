package com.xt.entity.generation;

import java.util.Date;

public class Pump {
    private Long pumpId;

    private Long projectId;

    private Long ownerId;

    private String pumpName;

    private String pumpCode;

    private Long productId;

    private String pumpSn;

    private Date installDate;

    private String areaLongitude;

    private String areaLatitude;

    private Date createTime;

    private Date modifyTime;

    public Long getPumpId() {
        return pumpId;
    }

    public void setPumpId(Long pumpId) {
        this.pumpId = pumpId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
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

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
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