<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<section class="tables-data">
  <div class="page-header">
  	<div class="actions">
  		<a menu-link class="btn black-text" href="#/manage/project-area" name="项目区域" data-title="点击管理项目区域" data-placement="left" bs-tooltip>
  			<i class="md md-view-list f12" style="color:#33cc99">项目区域</i>
  		</a>
    </div>
    <h1>项目管理</h1>
    <p class="lead">
     	 此处展示的是平台项目管理列表，只有管理员和区域负责人可以查看和管理该项目内容，区域负责人只能查看自己负责区域内的项目。
    </p>
  </div>
</section>
<div ng-controller="ProjectController">
	<div class="table-responsive well no-padding white no-margin">
		<div class="row">
	      <div class="col-sm-8">
	        <h3 class="table-title">共有 <span ng-bind="data.length || 0"></span> 条记录</h3>
	      </div>
	      <div class="col-sm-4">
	      	<form class="form-floating">
          		<fieldset>
			      	<div class="form-group has-success">
		              <label class="control-label" for="inputSuccess">通过项目名称、编码、业主信息等检索项目</label>
		              <input type="text" class="form-control" ng-model="keyword">
		            </div>
	            </fieldset>
	        </form>
	      </div>
	    </div>
		<table class="table table-hover table-full m-b-60" id="table-user-2172158" >
			<thead>
				<tr fsm-sticky-header scroll-body="'#table-user-2172158'" scroll-stop="64">
					<th width="30px"><input type="checkbox" class="relative" ng-model="selectAll" ng-click="checkAll()" /></th>
					<th width="50px"></th>
					<th>项目名称</th>
					<th>项目编码</th>
					<th>业主名称</th>
					<th>业主类型</th>
					<th>联系方式</th>
					<th>创建时间</th>
					<th class="text-center">操作</th>
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="(key, project) in data" ng-dblclick="detail(project)" ng-if="keyword=='' || (project.projectName.indexOf(keyword)>=0 || project.projectCode.indexOf(keyword)>=0 || project.ownerName.indexOf(keyword)>=0 || project.ownerPhoneNo.indexOf(keyword)>=0)">
					<td><input type="checkbox" class="relative" ng-model="user.selected" ng-click="$event.stopPropagation()" /></td>
					<td class="f20 ng-binding"><i class="md md-memory light-green darken-1 icon-color"></i></td>
					<td>{{ project.projectName }}</td>
					<td>{{ project.projectCode }}</td>
					<td>{{ project.ownerName }}</td>
					<td>{{ project.ownerType }}</td>
					<td>{{ project.ownerPhoneNo }}</td>
					<td>{{ project.CreateTime | date: "yyyy-MM-dd" }}</td>
					<td class="text-center" ng-click="$event.stopPropagation()">
						<button type="button" class="btn btn-link btn-round" data-title="编辑" ng-click="edit(project)" data-placement="bottom" bs-tooltip>
							<i class="md md-edit"></i>
						</button>
						<button type="button" class="btn btn-link btn-round" data-title="详情" ng-click="detail(project)" data-placement="bottom" bs-tooltip>
							<i class="md md-person"></i>
						</button>
						<button type="button" class="btn btn-link btn-round" data-title="删除" ng-click="remove(project)" data-placement="bottom" bs-tooltip>
							<i class="md md-delete"></i>
						</button>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="footer-buttons">
		<div class="btn btn-primary btn-round m-r-10 btn-footer" ng-show="(data|filter:{selected: true}).length>0" ng-click="removeMore()" data-title="删除 {{(data|filter:{selected: true}).length}} 条记录" bs-tooltip>
			<i class="md md-delete"></i>
		</div>
		<div class="btn btn-primary btn-round " ng-click="create()" data-title="新增" bs-tooltip>
			<i class="md md-add"></i>
		</div>
		<div class="btn btn-default btn-round m-r-10 btn-footer" scroll-to="top" ng-hide="scroll<100" data-title="返回顶部" bs-tooltip>
			<i class="md md-arrow-drop-up"></i>
		</div>
	</div>
</div>