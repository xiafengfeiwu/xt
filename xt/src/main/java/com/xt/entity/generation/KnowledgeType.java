package com.xt.entity.generation;

public class KnowledgeType {
    private Long knowledgeTypeId;

    private String knowledgeTypeName;

    private Integer sortNo;

    public Long getKnowledgeTypeId() {
        return knowledgeTypeId;
    }

    public void setKnowledgeTypeId(Long knowledgeTypeId) {
        this.knowledgeTypeId = knowledgeTypeId;
    }

    public String getKnowledgeTypeName() {
        return knowledgeTypeName;
    }

    public void setKnowledgeTypeName(String knowledgeTypeName) {
        this.knowledgeTypeName = knowledgeTypeName;
    }

    public Integer getSortNo() {
        return sortNo;
    }

    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }
}