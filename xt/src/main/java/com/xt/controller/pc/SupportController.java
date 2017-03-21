package com.xt.controller.pc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xt.entity.generation.KnowledgeType;
import com.xt.service.KnowledgeServer;
import com.xt.util.PublicUtil;

@Controller
@RequestMapping("support")
public class SupportController {

	@Autowired
	KnowledgeServer knowledgeServer;

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("type-data")
	public Map<String, Object> typeData() {
		Map<String, Object> data = new HashMap<>();
		List<KnowledgeType> types = knowledgeServer.getAllTypes();
		data.put("data", types);
		return data;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("add-type")
	public Map<String, Object> addType(@RequestBody(required = false) KnowledgeType knowledgeType) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		if (knowledgeType == null) {
			data.put("message", "无效的数据");
			return data;
		}
		if (PublicUtil.isEmpty(knowledgeType.getKnowledgeTypeName())) {
			data.put("message", "请输入类别名称");
			return data;
		}
		knowledgeType.setKnowledgeTypeId(PublicUtil.initId());
		knowledgeType.setSystemItem(Boolean.FALSE);
		try {
			knowledgeServer.addType(knowledgeType);
		} catch (Exception e) {
			data.put("message", "操作失败，可能存在相同类别的名称，请核对后重试");
			return data;
		}
		data.put("success", true);
		data.put("knowledgeType", knowledgeType);
		data.put("message", "操作成功");
		return data;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("update-type")
	public Map<String, Object> updateType(@RequestBody(required = false) KnowledgeType knowledgeType) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		if (knowledgeType == null) {
			data.put("message", "无效的数据");
			return data;
		}
		if (PublicUtil.isEmpty(knowledgeType.getKnowledgeTypeName())) {
			data.put("message", "请输入类别名称");
			return data;
		}
		KnowledgeType upKnowledgeType = knowledgeServer.getTypeById(knowledgeType.getKnowledgeTypeId());
		if (upKnowledgeType == null) {
			data.put("message", "无效的数据");
			return data;
		}
		if (knowledgeType.getSystemItem()) {
			data.put("message", "系统默认项不可修改");
			return data;
		}
		upKnowledgeType.setKnowledgeTypeName(knowledgeType.getKnowledgeTypeName());
		try {
			knowledgeServer.updateType(upKnowledgeType);
		} catch (Exception e) {
			data.put("message", "操作失败，可能存在相同类别的名称，请核对后重试");
			return data;
		}
		data.put("success", true);
		data.put("knowledgeType", upKnowledgeType);
		data.put("message", "操作成功");
		return data;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("del-type")
	public Map<String, Object> delType(String knowledgeTypeId) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		if (knowledgeTypeId == null) {
			data.put("message", "请传入类型ID");
			return data;
		}

		KnowledgeType knowledgeType = knowledgeServer.getTypeById(knowledgeTypeId);
		if (knowledgeType == null) {
			data.put("message", "无效的数据");
			return data;
		}

		if (knowledgeType.getSystemItem()) {
			data.put("message", "系统默认项不可删除");
			return data;
		}

		try {
			knowledgeServer.delType(knowledgeTypeId);
		} catch (Exception e) {
			data.put("message", "操作失败，可能存在关联数据");
			return data;
		}
		data.put("success", true);
		data.put("knowledgeType", knowledgeType);
		data.put("message", "操作成功");
		return data;
	}
}