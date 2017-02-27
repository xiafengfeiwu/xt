package com.xt.entity.generation;

import java.util.Date;

public class Complaint {
    private Long complaintId;

    private Long complaintTypeId;

    private String complaintContent;

    private Long userId;

    private String contactWay;

    private Date createTime;

    public Long getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(Long complaintId) {
        this.complaintId = complaintId;
    }

    public Long getComplaintTypeId() {
        return complaintTypeId;
    }

    public void setComplaintTypeId(Long complaintTypeId) {
        this.complaintTypeId = complaintTypeId;
    }

    public String getComplaintContent() {
        return complaintContent;
    }

    public void setComplaintContent(String complaintContent) {
        this.complaintContent = complaintContent;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
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