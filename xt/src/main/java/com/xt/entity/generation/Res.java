package com.xt.entity.generation;

import java.util.Date;

public class Res {
    private Long resId;

    private Long groupId;

    private String resName;

    private String resType;

    private String resPath;

    private Long resSize;

    private Date resCreateTime;

    public Long getResId() {
        return resId;
    }

    public void setResId(Long resId) {
        this.resId = resId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public String getResType() {
        return resType;
    }

    public void setResType(String resType) {
        this.resType = resType;
    }

    public String getResPath() {
        return resPath;
    }

    public void setResPath(String resPath) {
        this.resPath = resPath;
    }

    public Long getResSize() {
        return resSize;
    }

    public void setResSize(Long resSize) {
        this.resSize = resSize;
    }

    public Date getResCreateTime() {
        return resCreateTime;
    }

    public void setResCreateTime(Date resCreateTime) {
        this.resCreateTime = resCreateTime;
    }
}