<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="aside bs-docs-aside" tabindex="-1" role="dialog">
	<div class="close">
		<div class="btn btn-round btn-info" data-ng-click="$hide()">
			<i class="md md-close"></i>
		</div>
	</div>
	<div class="aside-dialog">
		<div class="aside-body bs-sidebar">
			<form name="form" class="form-floating" novalidate="novalidate" data-ng-submit="save()">
				<fieldset>
					<legend>新增故障申请 </legend>
					
					<button type="button" class="btn btn-sm" data-ng-click="selectRepairPump()">选择一个热泵</button>
					<input data-ng-show="currentPumpId" type="text" style="font-size: 12px;line-height: 29px;text-align: center;color: red" value="{{currentPumpText}}" disabled="disabled"/>
					
		          	<div class="form-group filled">
		            	<label class="control-label">发生日期</label>
		            	<input type="text" class="form-control ng-valid" data-ng-model="stoppage.occurTime1" data-date-format="yyyy-MM-dd" data-max-date="today" data-autoclose="false" data-bs-datepicker required>
		          	</div>
		          	
		          	<div class="form-group filled">
		            	<label class="control-label">大致时间</label>
		            	<input type="text" class="form-control ng-valid" data-ng-model="stoppage.occurTime2" data-date-format="HH:mm" data-autoclose="false" data-bs-timepicker required>
		          	</div>
		          	

					<div class="form-group filled">
						<label class="control-label">故障描述</label>
						<textarea data-ng-model="stoppage.descript" class="form-control" required></textarea>
					</div>
		
					<div class="form-group filled">
						<div data-ng-hide="progressPercentage==100" style="margin: auto;" class="btn" data-ngf-select="uploadFile($file, currentGroupId)">选择附件</div> (最多上传5个附件)
				      	<div data-ng-if="progressPercentage>0 && progressPercentage<100" class="progress progress-striped active" style="margin-top: 25px;">
				          <div class="progress-bar progress-bar-success" style="width: {{progressPercentage}}%;"></div>
				        </div>
				        <div data-ng-if="progressPercentage==100" style="margin-top: 25px;text-align: center;">{{cMessage}}</div>
					</div>
					
					<div class="form-group">
						<div class="card">
					        <div class="list-group" data-ng-repeat="(key, file) in files">
					          <a href="javascript:;" class="list-group-item">
					          	<h4 class="list-group-item-heading">{{ file.resName }} ({{formatNum(file.resSize)}})
					          		<span data-ng-click="removeFile(file)" class="pull-right" data-bs-tooltip data-title="删除">&times;</span>
					          	</h4>
					          </a>
					        </div>
						</div>
					</div>
					
					<div class="form-group">
						<button type="submit" class="btn btn-primary">提交</button>
					</div>
				</fieldset>
			</form>

		</div>
	</div>
</div>