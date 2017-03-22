<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="modal" tabindex="-1" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-ng-click="$hide()">&times;</button>
        <h4 class="modal-title">修改文章</h4>
      </div>
      <div class="modal-body">
		<form class="form-floating" novalidate="novalidate">
          <div class="form-group filled">
            <label class="control-label">标题</label>
            <input type="text" data-ng-model="article.knowledgeTitle" class="form-control"/>
          </div>
          <div class="form-group filled">
            <label>内容</label>
            <textarea style="width:100%" id="articleContent">{{article.knowledgeContent}}</textarea>
          </div>
	    </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-ng-click="updateKnowledge()">提交</button>
        <button type="button" class="btn btn-default" data-ng-click="$hide()">关闭</button>
      </div>
    </div>
  </div>
</div>