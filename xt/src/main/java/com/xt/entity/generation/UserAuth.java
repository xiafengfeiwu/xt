package com.xt.entity.generation;

public class UserAuth {
    private String rootId;

    private String userId;

    private String authCode;

    private String projectAreaId;

    private String pumpId;

    public String getRootId() {
        return rootId;
    }

    public void setRootId(String rootId) {
        this.rootId = rootId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getProjectAreaId() {
        return projectAreaId;
    }

    public void setProjectAreaId(String projectAreaId) {
        this.projectAreaId = projectAreaId;
    }

    public String getPumpId() {
        return pumpId;
    }

    public void setPumpId(String pumpId) {
        this.pumpId = pumpId;
    }
}