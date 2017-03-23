<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="modal" tabindex="-1" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-ng-click="$hide()">&times;</button>
        <h4 class="modal-title">{{ pumpd.base.pumpName }} - 图片资源</h4>
      </div>
      <div class="modal-body" style="height: 320px;overflow: auto;">
      	<div class="btn" data-ngf-select="uploadPumpImg($file, pumpGroupId)" data-ngf-accept="'image/gif,image/jpeg,image/jpg,image/png'"><img alt="新增图片" src="assets/img/add-picture.png"> 上传</div>
  		<div data-ng-if="progressPercentage>0 && progressPercentage<100" class="progress progress-striped active" style="margin-top: 25px;">
          <div class="progress-bar progress-bar-success" style="width: {{progressPercentage}}%;"></div>
        </div>
  		<div class="row" style="margin-top: 32px;">
  			<div class="col-sm-4 col-xs-6" style="margin-bottom: 30px" data-ng-repeat="(key, picture) in pictures">
  				<img data-ng-src="uploads{{picture.resPath}}" alt="{{picture.resName}}" class="img-thumbnail">
  			</div>
		</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-ng-click="$hide()">关闭</button>
      </div>
    </div>
  </div>
</div>
