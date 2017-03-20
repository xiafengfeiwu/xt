package com.xt.entity.generation;

import java.util.Date;

public class WarnGroup {
    private String groupId;

    private String groupName;

    private String ownerId;

    private Boolean systemGroup;

    private String groupDescript;

    private Date createTime;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public Boolean getSystemGroup() {
        return systemGroup;
    }

    public void setSystemGroup(Boolean systemGroup) {
        this.systemGroup = systemGroup;
    }

    public String getGroupDescript() {
        return groupDescript;
    }

    public void setGroupDescript(String groupDescript) {
        this.groupDescript = groupDescript;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}