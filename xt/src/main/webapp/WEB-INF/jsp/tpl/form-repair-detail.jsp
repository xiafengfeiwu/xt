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
			<form>
				<fieldset>
					<legend>故障详情 </legend>
					
		          	<div class="form-group filled">
		            	<label class="control-label">故障编号：{{stoppaged.stoppage.stoppageNo}}</label>
		          	</div>
		          	<div class="form-group filled">
		            	<label class="control-label">热泵名称：{{stoppaged.pump.pumpName}}</label>
		          	</div>
		          	<div class="form-group filled" data-ng-if="stoppaged.pumpWarn">
		            	<label class="control-label">告警编码：{{stoppaged.pumpWarn.warnCode}}</label>
		          	</div>
		          	<div class="form-group filled" data-ng-if="stoppaged.pumpWarn">
		            	<label class="control-label">告警级别：{{stoppaged.pumpWarn.warnLevel}}</label>
		          	</div>
		          	<div class="form-group filled">
		            	<label class="control-label">发生时间：{{stoppaged.stoppage.occurTime}}</label>
		          	</div>
		          	<div class="form-group filled">
		            	<label class="control-label">创建时间：{{stoppaged.stoppage.createTime | date:'yyyy-MM-dd HH:mm:ss'}}</label>
		          	</div>
		          	<div class="form-group filled">
		            	<label class="control-label">当前状态：<span data-ng-bind-html="formatStatus(stoppaged.stoppage.handleStatus)"></span></label>
		          	</div>
		          	<div class="form-group filled" data-ng-if="stoppaged.stoppage.handleModifyTime">
		            	<label class="control-label">最后处理时间：{{stoppaged.stoppage.handleModifyTime | date:'yyyy-MM-dd HH:mm:ss'}}</label>
		          	</div>
		          	<div class="form-group filled">
		            	<label class="control-label">故障描述：{{stoppaged.stoppage.descript}}</label>
		          	</div>
		          	<div class="form-group filled" data-ng-if="stoppaged.reses.length">
		            	<label class="control-label">附件列表：</label>
		            	<div class="card">
					        <div class="list-group" data-ng-repeat="(key, file) in stoppaged.reses">
					          <a href="{{ file.resPath }}" target="_new" data-download='{{ file.resName }}' class="list-group-item">
					          	<h4 class="list-group-item-heading">{{ file.resName }} ({{formatNum(file.resSize)}})</h4>
					          </a>
					        </div>
						</div>
		          	</div>
		          	<div class="form-group filled" data-ng-if="stoppaged.handles.length">
		            	<label class="control-label">处理列表：</label>
		            	<div class="card">
					        <div class="list-group" data-ng-repeat="(key, handle) in stoppaged.handles">
					          <a href="javascript:;" class="list-group-item">
					          	<h4 class="list-group-item-heading">{{ handle.handleTime | date:"yyyy-MM-dd HH:mm" }} - {{ handle.handleStatus }} 
					          		<span class="pull-right" bs-tooltip data-placement="top" data-html="true" data-title="<p style='text-align:left'><br/>级别：{{handle.evaluateLevel}}<br/>评价：{{handle.evaluateDescript}}</p>" data-ng-if="formatLevel(handle.evaluateLevel)" data-ng-bind-html="formatLevel(handle.evaluateLevel)"></span>
					          		<button class="btn btn-sm btn-link pull-right" style="font-size: 12px;line-height:16px;" data-ng-if="!formatLevel(handle.evaluateLevel)" data-ng-click="toEvaluate(handle)">点击评价</button>
					          	</h4>
					            <p class="list-group-item-text">{{ handle.handleDescript }}</p>
					          </a>
					        </div>
						</div>
		          	</div>
		          	
					<button type="button" class="btn" data-ng-click="remove(stoppaged.stoppage.stoppageId)">
						<i class="md md-delete"></i> 删除故障信息
					</button>
		        </fieldset>
		    </form>
		</div>
	</div>
</div>
