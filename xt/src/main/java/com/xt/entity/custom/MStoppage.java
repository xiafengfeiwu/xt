package com.xt.entity.custom;

import java.util.Date;

public class MStoppage {
	private String pumpId;
	private Date occurDate;
	private Date occurTime;
	private String descript;
	private String attachId;

	public String getPumpId() {
		return pumpId;
	}

	public void setPumpId(String pumpId) {
		this.pumpId = pumpId;
	}

	public Date getOccurDate() {
		return occurDate;
	}

	public void setOccurDate(Date occurDate) {
		this.occurDate = occurDate;
	}

	public Date getOccurTime() {
		return occurTime;
	}

	public void setOccurTime(Date occurTime) {
		this.occurTime = occurTime;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	public String getAttachId() {
		return attachId;
	}

	public void setAttachId(String attachId) {
		this.attachId = attachId;
	}

}
