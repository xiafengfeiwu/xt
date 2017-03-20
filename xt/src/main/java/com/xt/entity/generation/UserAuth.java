package com.xt.entity.generation;

public class UserAuth {
    private Long rootId;

    private Long userId;

    private String authCode;

    private Long projectAreaId;

    private Long pumpId;

    public Long getRootId() {
        return rootId;
    }

    public void setRootId(Long rootId) {
        this.rootId = rootId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public Long getProjectAreaId() {
        return projectAreaId;
    }

    public void setProjectAreaId(Long projectAreaId) {
        this.projectAreaId = projectAreaId;
    }

    public Long getPumpId() {
        return pumpId;
    }

    public void setPumpId(Long pumpId) {
        this.pumpId = pumpId;
    }
}