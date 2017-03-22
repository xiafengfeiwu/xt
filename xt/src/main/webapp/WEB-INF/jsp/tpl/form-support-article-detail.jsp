<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="modal" tabindex="-1" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-ng-click="$hide()">&times;</button>
        <h4 class="modal-title">{{article.knowledgeTitle}}</h4>
      </div>
      <div class="modal-body" style="height: 320px;overflow: auto;">
      	<p data-ng-bind-html="article.knowledgeContent"></p>
      </div>
    </div>
  </div>
</div>