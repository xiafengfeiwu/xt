package com.xt.entity.generation;

import java.util.Date;

public class DeviceVender {
    private String venderId;

    private String venderName;

    private String venderContacts;

    private String venderContactsTel;

    private String venderAddress;

    private String venderRemark;

    private Date createTime;

    private Date modifyTime;

    public String getVenderId() {
        return venderId;
    }

    public void setVenderId(String venderId) {
        this.venderId = venderId;
    }

    public String getVenderName() {
        return venderName;
    }

    public void setVenderName(String venderName) {
        this.venderName = venderName;
    }

    public String getVenderContacts() {
        return venderContacts;
    }

    public void setVenderContacts(String venderContacts) {
        this.venderContacts = venderContacts;
    }

    public String getVenderContactsTel() {
        return venderContactsTel;
    }

    public void setVenderContactsTel(String venderContactsTel) {
        this.venderContactsTel = venderContactsTel;
    }

    public String getVenderAddress() {
        return venderAddress;
    }

    public void setVenderAddress(String venderAddress) {
        this.venderAddress = venderAddress;
    }

    public String getVenderRemark() {
        return venderRemark;
    }

    public void setVenderRemark(String venderRemark) {
        this.venderRemark = venderRemark;
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