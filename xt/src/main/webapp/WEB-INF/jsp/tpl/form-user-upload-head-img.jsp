<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="modal" tabindex="-1" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" ng-click="$hide()">&times;</button>
        <h4 class="modal-title">修改用户头像</h4>
      </div>
      <div class="modal-body" style="text-align: center;">
      	<div style="margin: auto;" class="btn" data-ngf-select="updateHeadImg($file, currentUser)" data-ngf-accept="'image/gif,image/jpeg,image/jpg,image/png'">选择头像文件</div>
      
      	<div data-ng-if="progressPercentage>0" class="progress progress-striped active" style="margin-top: 25px;">
          <div class="progress-bar progress-bar-success" style="width: {{progressPercentage}}%;"></div>
        </div>
      
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-ng-click="$hide()">关闭</button>
      </div>
    </div>
  </div>
</div>