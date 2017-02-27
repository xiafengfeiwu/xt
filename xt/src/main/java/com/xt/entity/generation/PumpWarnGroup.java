package com.xt.entity.generation;

import java.util.Date;

public class PumpWarnGroup extends PumpWarnGroupKey {
    private Long creatorId;

    private Date createTime;

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