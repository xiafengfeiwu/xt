<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<section class="tables-data">
  <div class="page-header">
    <h1>角色授权</h1>
    <p class="lead">
     	 此处展示的是系统的角色数据，系统管理员在此处可以查看并重新授权角色权限，其他角色人员不可以查看角色信息。
    </p>
  </div>
</section>
<div ng-controller="RoleController">
	<div class="table-responsive well no-padding white no-margin">
		<div class="row">
	      <div class="col-sm-8">
	        <h3 class="table-title">共有 <span ng-bind="data.length || 0"></span> 条记录</h3>
	      </div>
	      <div class="col-sm-4">
	      	<form class="form-floating">
          		<fieldset>
			      	<div class="form-group has-success">
		              <label class="control-label" for="inputSuccess">通过角色名称检索</label>
		              <input type="text" class="form-control" ng-model="keyword">
		            </div>
	            </fieldset>
	        </form>
	      </div>
	    </div>
		<table class="table table-hover table-full m-b-60" id="table-role-2172158" >
			<thead>
				<tr fsm-sticky-header scroll-body="'#table-role-2172158'" scroll-stop="64">
					<th width="50px"></th>
					<th>角色名称</th>
					<th width="140px" class="text-center">操作</th>
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="(key, role) in data" ng-dblclick="auth(role)" ng-if="keyword=='' || (role.roleName.indexOf(keyword)>=0)">
					<td class="f20 ng-binding"><i class="md md-account-child indigo lighten-2 icon-color"></i></td>
					<td>{{ role.roleName }}</td>
					<td class="text-center" ng-click="$event.stopPropagation()">
						<button type="button" class="btn btn-link btn-round" data-title="授权" ng-click="auth(role)" data-placement="bottom" bs-tooltip>
							<i class="md md-verified-user"></i>
						</button>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>