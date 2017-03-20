<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="modal" tabindex="-1" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" ng-click="$hide()">&times;</button>
        <h4 class="modal-title">新增告警项</h4>
      </div>
      <div class="modal-body" style="height: 428px;overflow: auto;">
		<form class="form-floating" novalidate="novalidate"">
	          <div class="row">
	          	<div class="col-xs-6">
		          <div class="form-group filled">
		            <label class="control-label">监测项名称</label>
		            <ui-select ng-model="warnMonitorItems.selected" class="f13" theme="select2" search-enabled="false">
			           <ui-select-match placeholder="请选择一个监测项 ">{{$select.selected.name}}</ui-select-match>
			           <ui-select-choices repeat="item in warnMonitorItems | filter: $select.search">
			             <div ng-bind-html="item.name | highlight: $select.search"></div>
			           </ui-select-choices>
			        </ui-select>
		          </div>
	          	</div>
	          	<div class="col-xs-6">
		          <div class="form-group filled">
		            <label class="control-label">监测项编码</label>
		            <input type="text" ng-model="warnMonitorItems.selected.code" class="form-control" disabled required/>
		          </div>
	          	</div>
	          	<div class="col-xs-6">
		          <div class="form-group filled">
		            <label class="control-label">操作符</label>
		            <ui-select ng-model="warnOperatorItems.selected" class="f13" theme="select2" search-enabled="false">
			           <ui-select-match placeholder="请选择一个操作符 ">{{$select.selected.name}}</ui-select-match>
			           <ui-select-choices repeat="item in warnOperatorItems | filter: $select.search">
			             <div ng-bind-html="item.name | highlight: $select.search"></div>
			           </ui-select-choices>
			        </ui-select>
		          </div>
	          	</div>
	          	<div class="col-xs-6">
		          <div class="form-group filled">
		            <label class="control-label">阈值</label>
		            <input type="text" ng-model="warnGroupItem.itemThreshold" class="form-control" required/>
		          </div>
	          	</div>
	          	<div class="col-xs-6">
		          <div class="form-group filled">
		            <label class="control-label">告警编码</label>
		            <input type="text" ng-model="warnGroupItem.warnCode" class="form-control" required/>
		          </div>
	          	</div>
	          	<div class="col-xs-6">
		          <div class="form-group filled">
		            <label class="control-label">告警级别</label>
		            <ui-select ng-model="warnLevelItems.selected" class="f13" theme="select2" search-enabled="false">
			           <ui-select-match placeholder="请选择一个告警级别 ">{{$select.selected}}</ui-select-match>
			           <ui-select-choices repeat="item in warnLevelItems | filter: $select.search">
			             <div ng-bind-html="item | highlight: $select.search"></div>
			           </ui-select-choices>
			        </ui-select>
		          </div>
	          	</div>
	          </div>
	          <div class="form-group filled">
	            <label class="control-label">告警描述</label>
	            <textarea data-ng-model="warnGroupItem.warnDescript" class="form-control" required></textarea>
	          </div>
	          <div class="form-group filled">
	            <label class="control-label">处理建议</label>
	            <textarea data-ng-model="warnGroupItem.warnScheme" class="form-control" required></textarea>
	          </div>
	      </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-ng-click="saveItem()">提交</button>
        <button type="button" class="btn btn-default" data-ng-click="$hide()">关闭</button>
      </div>
    </div>
  </div>
</div>