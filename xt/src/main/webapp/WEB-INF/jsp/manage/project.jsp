<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<section class="forms-basic" ng-controller="ProjectController">
	<div class="page-header">
		<div class="actions">
			<a menu-link class="btn black-text" href="#/manage/project-area"
				name="项目区域" data-title="点击管理项目区域" data-placement="left" bs-tooltip>
				<i class="md md-view-list f12" style="color: #33cc99">项目区域</i>
			</a>
		</div>
		<h1>
			项目管理
		</h1>
		<p class="lead">
			此处展示的是平台项目管理列表，只有管理员和区域负责人可以查看和管理该项目内容，区域负责人只能查看自己负责区域内的项目。</p>
	</div>
	<div class="row m-b-40">
		<div class="col-sm-3">
			<div class="card bordered small">
				<div class="card-header">
					<div class="card-title">
						<i class="md md-location-on"></i> 区域范围检索
					</div>
				</div>
				<div class="card-content">
					<div treecontrol class="tree-boot" tree-model="projectAreas"
						options="treeOptions" selected-node="currentNode">{{node.areaName}}</div>
				</div>
			</div>
		</div>
		<div class="col-sm-9">
			<div class="table-responsive well no-padding white no-margin">

				<div class="pull-right" ng-if="currentNode">
					<a type="button" class="btn black-text f12"
						style="margin: 18px 24px 0 0;" ng-click="create(currentNode)">
						<i class="md md-add" style="color: #33cc99">在 <span
							style="color: red"><i>{{currentNode.areaName}}</i></span> 新增项目
					</i>
					</a>
				</div>

				<div class="row">
					<div class="col-sm-6">
						<form class="form-floating">
							<fieldset>
								<div class="form-group has-success">
									<label class="control-label" for="inputSuccess"> &nbsp;
										通过项目名称、编码、业主信息等检索项目</label> <input type="text" class="form-control"
										ng-model="keyword">
								</div>
							</fieldset>
						</form>
					</div>
				</div>

				<table class="table table-hover table-full m-b-60"
					id="table-project-2172158">
					<thead>
						<tr fsm-sticky-header scroll-body="'#table-project-2172158'"
							scroll-stop="64">
							<th></th>
							<th>项目名称</th>
							<th>项目编码</th>
							<th>业主名称</th>
							<th>联系方式</th>
							<th class="text-center">操作</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="(key, project) in data"
							ng-if="(currentNode && project.projectAreaId==currentNode.projectAreaId) || !currentNode"
							ng-hide="keyword!='' && (project.projectName.indexOf(keyword)<0 && project.projectCode.indexOf(keyword)<0 && project.ownerName.indexOf(keyword)<0 && project.ownerPhoneNo.indexOf(keyword)<0)">
							<td class="f20 ng-binding"><i
								class="md md-local-play light-green lighten-1 icon-color"></i></td>
							<td>{{ project.projectName }}</td>
							<td>{{ project.projectCode }}</td>
							<td>{{ project.ownerName }}</td>
							<td>{{ project.ownerPhoneNo }}</td>
							<td class="text-center" ng-click="$event.stopPropagation()">
								<button type="button" class="btn btn-link btn-round"
									data-title="编辑" ng-click="edit(project)"
									data-placement="bottom" bs-tooltip>
									<i class="md md-edit"></i>
								</button>
								<button type="button" class="btn btn-link btn-round"
									data-title="管理" ng-click="manage(project)"
									data-placement="bottom" bs-tooltip>
									<i class="md md-devices"></i>
								</button>
								<button type="button" class="btn btn-link btn-round"
									data-title="删除" ng-click="remove(project)"
									data-placement="bottom" bs-tooltip>
									<i class="md md-delete"></i>
								</button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div class="footer-buttons">
		<div class="btn btn-primary btn-round " ng-click="create(currentNode)"
			ng-if="currentNode" data-title="在  {{currentNode.areaName}} 下新增项目"
			bs-tooltip>
			<i class="md md-add"></i>
		</div>
		<div class="btn btn-default btn-round m-r-10 btn-footer"
			scroll-to="top" ng-hide="scroll<100" data-title="返回顶部" bs-tooltip>
			<i class="md md-arrow-drop-up"></i>
		</div>
	</div>
</section>