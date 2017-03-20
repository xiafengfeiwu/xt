package com.xt.entity.generation;

import java.util.Date;

public class ManagerArea {
    private String userId;

    private String manageAreaCode;

    private Date createTime;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getManageAreaCode() {
        return manageAreaCode;
    }

    public void setManageAreaCode(String manageAreaCode) {
        this.manageAreaCode = manageAreaCode;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}