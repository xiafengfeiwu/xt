<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="modal" tabindex="-1" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" ng-click="$hide()">&times;</button>
        <h4 class="modal-title">{{ pumpd.base.pumpName }}</h4>
      </div>
      <div class="modal-body">
      	<form class="form-floating" novalidate="novalidate">
	      	<div class="form-group filled" data-ng-if="pumpNoUseWarnGroups.length>0">
	           <label class="control-label">告警组</label>
	           <ui-select ng-model="pumpNoUseWarnGroups.selected" class="f13" theme="select2" search-enabled="false" required>
	             <ui-select-match placeholder="选择一个告警组"><span ng-bind="$select.selected.groupName"></span></ui-select-match>
	             <ui-select-choices repeat="warnGroup in pumpNoUseWarnGroups | filter: $select.search">
	               <div ng-bind-html="warnGroup.groupName | highlight: $select.search"></div>
	             </ui-select-choices>
	           </ui-select>
	      	</div>
	      	<div data-ng-if="pumpNoUseWarnGroups.length==0" style="color:red;text-align: center;">
	      		无可用告警组。
	      	</div>
      	</form>
      </div>
      <div class="modal-footer">
        <button type="button" data-ng-click="addPumpWarnGroup()" class="btn btn-primary" data-ng-if="pumpNoUseWarnGroups.length>0">添加</button>
        <button type="button" class="btn btn-default" ng-click="$hide()">关闭</button>
      </div>
    </div>
  </div>
</div>
