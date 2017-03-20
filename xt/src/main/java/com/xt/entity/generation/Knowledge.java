package com.xt.entity.generation;

import java.util.Date;

public class Knowledge {
    private Long knowledgeId;

    private Long knowledgeTypeId;

    private String knowledgeTitle;

    private Integer usefulCount;

    private Integer uselessCount;

    private Long creatorId;

    private Date createTime;

    private Date modifyTime;

    private String knowledgeContent;

    public Long getKnowledgeId() {
        return knowledgeId;
    }

    public void setKnowledgeId(Long knowledgeId) {
        this.knowledgeId = knowledgeId;
    }

    public Long getKnowledgeTypeId() {
        return knowledgeTypeId;
    }

    public void setKnowledgeTypeId(Long knowledgeTypeId) {
        this.knowledgeTypeId = knowledgeTypeId;
    }

    public String getKnowledgeTitle() {
        return knowledgeTitle;
    }

    public void setKnowledgeTitle(String knowledgeTitle) {
        this.knowledgeTitle = knowledgeTitle;
    }

    public Integer getUsefulCount() {
        return usefulCount;
    }

    public void setUsefulCount(Integer usefulCount) {
        this.usefulCount = usefulCount;
    }

    public Integer getUselessCount() {
        return uselessCount;
    }

    public void setUselessCount(Integer uselessCount) {
        this.uselessCount = uselessCount;
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

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getKnowledgeContent() {
        return knowledgeContent;
    }

    public void setKnowledgeContent(String knowledgeContent) {
        this.knowledgeContent = knowledgeContent;
    }
}