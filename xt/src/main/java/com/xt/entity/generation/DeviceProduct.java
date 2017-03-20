package com.xt.entity.generation;

import java.util.Date;

public class DeviceProduct {
    private Long productId;

    private String productName;

    private String productType;

    private Long productVenderId;

    private String productSpec;

    private String productPi;

    private String productPowerSpec;

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

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Long getProductVenderId() {
        return productVenderId;
    }

    public void setProductVenderId(Long productVenderId) {
        this.productVenderId = productVenderId;
    }

    public String getProductSpec() {
        return productSpec;
    }

    public void setProductSpec(String productSpec) {
        this.productSpec = productSpec;
    }

    public String getProductPi() {
        return productPi;
    }

    public void setProductPi(String productPi) {
        this.productPi = productPi;
    }

    public String getProductPowerSpec() {
        return productPowerSpec;
    }

    public void setProductPowerSpec(String productPowerSpec) {
        this.productPowerSpec = productPowerSpec;
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