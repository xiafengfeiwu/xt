package com.xt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.dao.generation.KnowledgeMapper;
import com.xt.dao.generation.KnowledgeTypeMapper;
import com.xt.entity.generation.Knowledge;
import com.xt.entity.generation.KnowledgeExample;
import com.xt.entity.generation.KnowledgeType;
import com.xt.entity.generation.KnowledgeTypeExample;
import com.xt.service.KnowledgeServer;

@Service
public class KnowledgeServerImpl implements KnowledgeServer {

	@Autowired
	KnowledgeMapper knowledgeMapper;
	@Autowired
	KnowledgeTypeMapper knowledgeTypeMapper;

	@Override
	public void addType(KnowledgeType knowledgeType) {
		knowledgeTypeMapper.insert(knowledgeType);
	}

	@Override
	public void delType(String knowledgeTypeId) {
		knowledgeTypeMapper.deleteByPrimaryKey(knowledgeTypeId);
	}

	@Override
	public KnowledgeType getTypeById(String knowledgeTypeId) {
		return knowledgeTypeMapper.selectByPrimaryKey(knowledgeTypeId);
	}

	@Override
	public void updateType(KnowledgeType knowledgeType) {
		knowledgeTypeMapper.updateByPrimaryKey(knowledgeType);
	}

	@Override
	public List<KnowledgeType> getAllTypes() {
		KnowledgeTypeExample example = new KnowledgeTypeExample();
		example.setOrderByClause("system_item desc, knowledge_type_id asc");
		return knowledgeTypeMapper.selectByExample(example);
	}

	@Override
	public List<Knowledge> getListByTypeId(String typeId, int page) {
		KnowledgeExample example = new KnowledgeExample();
		example.createCriteria().andKnowledgeTypeIdEqualTo(typeId);
		example.setOrderByClause("knowledge_id desc"); //  limit " + (page - 1) * 10 + ", 10
		return knowledgeMapper.selectByExample(example);
	}

	@Override
	public void create(Knowledge knowledge) {
		knowledgeMapper.insert(knowledge);
	}

	@Override
	public void update(Knowledge knowledge) {
		knowledgeMapper.updateByPrimaryKeyWithBLOBs(knowledge);
	}

	@Override
	public void delete(String knowledgeId) {
		knowledgeMapper.deleteByPrimaryKey(knowledgeId);
	}

	@Override
	public Knowledge getById(String knowledgeId) {
		return knowledgeMapper.selectByPrimaryKey(knowledgeId);
	}

}
