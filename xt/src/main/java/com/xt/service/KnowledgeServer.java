package com.xt.service;

import java.util.List;

import com.xt.entity.generation.KnowledgeType;

public interface KnowledgeServer {
	
	void addType(KnowledgeType knowledgeType);
	
	void delType(Long knowledgeTypeId);
	
	void updateType(KnowledgeType knowledgeType);

	List<KnowledgeType> getAllTypes();
	
	
}
