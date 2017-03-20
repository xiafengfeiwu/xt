package com.xt.entity.custom;

public class MUserAuth {
	private String userId;
	private String nodeId;
	private boolean areaNode;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public boolean isAreaNode() {
		return areaNode;
	}

	public void setAreaNode(boolean areaNode) {
		this.areaNode = areaNode;
	}

}
