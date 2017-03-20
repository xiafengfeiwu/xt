package com.xt.service;

import java.util.List;

import com.xt.entity.generation.Knowledge;
import com.xt.entity.generation.KnowledgeType;

public interface KnowledgeServer {

	void addType(KnowledgeType knowledgeType);

	void delType(String knowledgeTypeId);

	KnowledgeType getTypeById(String knowledgeTypeId);

	void updateType(KnowledgeType knowledgeType);

	List<KnowledgeType> getAllTypes();

	List<Knowledge> getListByTypeId(String typeId, int page);

	void create(Knowledge knowledge);

	void update(Knowledge knowledge);

	void delete(String knowledgeId);

	Knowledge getById(String knowledgeId);
}
