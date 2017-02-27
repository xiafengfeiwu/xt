package com.xt.entity.generation;

import java.util.Date;

public class VenderProduct {
    private Long productId;

    private String productName;

    private Long deviceVenderId;

    private String deviceSpec;

    private Date createTime;

    private Date modifyTime;

    private String productDescript;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getDeviceVenderId() {
        return deviceVenderId;
    }

    public void setDeviceVenderId(Long deviceVenderId) {
        this.deviceVenderId = deviceVenderId;
    }

    public String getDeviceSpec() {
        return deviceSpec;
    }

    public void setDeviceSpec(String deviceSpec) {
        this.deviceSpec = deviceSpec;
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

    public String getProductDescript() {
        return productDescript;
    }

    public void setProductDescript(String productDescript) {
        this.productDescript = productDescript;
    }
}