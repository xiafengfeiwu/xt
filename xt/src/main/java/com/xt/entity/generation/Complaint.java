package com.xt.entity.generation;

import java.util.Date;

public class Complaint {
    private String complaintId;

    private String complaintTypeId;

    private String complaintContent;

    private String userId;

    private String contactWay;

    private Date createTime;

    public String getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(String complaintId) {
        this.complaintId = complaintId;
    }

    public String getComplaintTypeId() {
        return complaintTypeId;
    }

    public void setComplaintTypeId(String complaintTypeId) {
        this.complaintTypeId = complaintTypeId;
    }

    public String getComplaintContent() {
        return complaintContent;
    }

    public void setComplaintContent(String complaintContent) {
        this.complaintContent = complaintContent;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContactWay() {
        return contactWay;
    }

    public void setContactWay(String contactWay) {
        this.contactWay = contactWay;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}