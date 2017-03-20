package com.xt.entity.generation;

public class KnowledgeType {
    private String knowledgeTypeId;

    private String knowledgeTypeName;

    private Boolean systemItem;

    public String getKnowledgeTypeId() {
        return knowledgeTypeId;
    }

    public void setKnowledgeTypeId(String knowledgeTypeId) {
        this.knowledgeTypeId = knowledgeTypeId;
    }

    public String getKnowledgeTypeName() {
        return knowledgeTypeName;
    }

    public void setKnowledgeTypeName(String knowledgeTypeName) {
        this.knowledgeTypeName = knowledgeTypeName;
    }

    public Boolean getSystemItem() {
        return systemItem;
    }

    public void setSystemItem(Boolean systemItem) {
        this.systemItem = systemItem;
    }
}