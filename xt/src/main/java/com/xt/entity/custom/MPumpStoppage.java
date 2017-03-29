package com.xt.entity.custom;

import java.util.Date;

public class MPumpStoppage {
	private String stoppageId;
	private String stoppageNo;
	private String pumpId;
	private String pumpName;
	private String pumpWarnId;
	private String descript;
	private String occurTime;
	private String handleStatus;
	private Date createTime;
	private Date handleModifyTime;

	public String getStoppageId() {
		return stoppageId;
	}

	public void setStoppageId(String stoppageId) {
		this.stoppageId = stoppageId;
	}

	public String getStoppageNo() {
		return stoppageNo;
	}

	public void setStoppageNo(String stoppageNo) {
		this.stoppageNo = stoppageNo;
	}

	public String getPumpId() {
		return pumpId;
	}

	public void setPumpId(String pumpId) {
		this.pumpId = pumpId;
	}

	public String getPumpName() {
		return pumpName;
	}

	public void setPumpName(String pumpName) {
		this.pumpName = pumpName;
	}

	public String getPumpWarnId() {
		return pumpWarnId;
	}

	public void setPumpWarnId(String pumpWarnId) {
		this.pumpWarnId = pumpWarnId;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	public String getOccurTime() {
		return occurTime;
	}

	public void setOccurTime(String occurTime) {
		this.occurTime = occurTime;
	}

	public String getHandleStatus() {
		return handleStatus;
	}

	public void setHandleStatus(String handleStatus) {
		this.handleStatus = handleStatus;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getHandleModifyTime() {
		return handleModifyTime;
	}

	public void setHandleModifyTime(Date handleModifyTime) {
		this.handleModifyTime = handleModifyTime;
	}

}
