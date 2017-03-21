<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="modal" tabindex="-1" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-ng-click="$hide()">&times;</button>
        <h4 class="modal-title">修改分类</h4>
      </div>
      <div class="modal-body">
		<form class="form-floating" novalidate="novalidate">
          <div class="form-group filled">
            <label class="control-label">类别名称</label>
            <input type="text" data-ng-model="knowledgeType.knowledgeTypeName" class="form-control"/>
          </div>
	    </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-ng-click="delKnowledgeType(knowledgeType)">删除</button>
        <button type="button" class="btn btn-success" data-ng-click="updateKnowledgeType()">更新</button>
        <button type="button" class="btn btn-default" data-ng-click="$hide()">关闭</button>
      </div>
    </div>
  </div>
</div>