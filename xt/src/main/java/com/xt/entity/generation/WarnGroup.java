package com.xt.entity.generation;

import java.util.Date;

public class WarnGroup {
    private Long groupId;

    private String groupName;

    private Boolean systemGroup;

    private String groupDescript;

    private Long creatorId;

    private Date createTime;

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
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

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}