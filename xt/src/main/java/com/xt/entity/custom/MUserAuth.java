package com.xt.entity.custom;

public class MUserAuth {
	private Long userId;
	private Long nodeId;
	private boolean areaNode;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getNodeId() {
		return nodeId;
	}

	public void setNodeId(Long nodeId) {
		this.nodeId = nodeId;
	}

	public boolean isAreaNode() {
		return areaNode;
	}

	public void setAreaNode(boolean areaNode) {
		this.areaNode = areaNode;
	}

}
