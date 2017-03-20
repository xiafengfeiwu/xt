package com.xt.entity.custom;

import java.util.Date;
import java.util.List;

public class MProjectArea {

	private String projectAreaId;

	private String areaName;

	private String areaCode;

	private String parentAreaCode;

	private String weatherCode;

	private Date createTime;

	private Date modifyTime;

	private List<MProjectArea> children;

	public String getProjectAreaId() {
		return projectAreaId;
	}

	public void setProjectAreaId(String projectAreaId) {
		this.projectAreaId = projectAreaId;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getParentAreaCode() {
		return parentAreaCode;
	}

	public void setParentAreaCode(String parentAreaCode) {
		this.parentAreaCode = parentAreaCode;
	}

	public String getWeatherCode() {
		return weatherCode;
	}

	public void setWeatherCode(String weatherCode) {
		this.weatherCode = weatherCode;
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

	public List<MProjectArea> getChildren() {
		return children;
	}

	public void setChildren(List<MProjectArea> children) {
		this.children = children;
	}

}
