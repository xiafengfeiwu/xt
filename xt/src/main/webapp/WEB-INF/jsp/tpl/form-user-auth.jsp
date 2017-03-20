<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="aside bs-docs-aside" tabindex="-1" role="dialog">
  <div class="close">
    <div class="btn btn-round btn-info" ng-click="$hide()"><i class="md md-close"></i></div>
  </div>
  <div class="aside-dialog">
    <div class="aside-body bs-sidebar">
    	<h5>用户 <u>{{user.userName}}</u> 授权访问</h6>
    	<div class="row" ng-show="success">
    		<div class="col-sm-6 well">
    			<h6>已授权列表</h6>
    			<div ng-repeat="(key, userAuth) in userAuths">
    				<span class="label label-success" style="cursor: pointer;" ng-click="unauth(user.userId, userAuth.id, userAuth.name)">{{userAuth.name}} &times;</span>
    			</div>
    		</div>
    		<div class="col-sm-6">
    			<ul id="pumpTree" class="ztree"></ul>
    		</div>
    	</div>
    	<div class="row" ng-show="!success">
    		<div class="col-sm-12">
    			角色为系统管理员的用户无需分配访问权限，默认可访问全部数据。
    		</div>
    	</div>
    </div>
  </div>
</div>