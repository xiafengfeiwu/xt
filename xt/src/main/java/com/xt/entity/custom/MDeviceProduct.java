package com.xt.entity.custom;

import java.util.Date;

public class MDeviceProduct {
	private String productId;

	private String productName;

	private String productType;

	private String productVenderId;

	private String productVenderName;

	private String productSpec;

	private String productPi;

	private String productPowerSpec;

	private Date createTime;

	private Date modifyTime;

	private String productDescript;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
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

	public String getProductVenderId() {
		return productVenderId;
	}

	public void setProductVenderId(String productVenderId) {
		this.productVenderId = productVenderId;
	}

	public String getProductVenderName() {
		return productVenderName;
	}

	public void setProductVenderName(String productVenderName) {
		this.productVenderName = productVenderName;
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