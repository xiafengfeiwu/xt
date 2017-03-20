<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<section class="forms-basic" ng-controller="WarnGroupController">
	<div class="page-header">
		<h1>告警组</h1>
		<p class="lead">此处展示的是系统和自定义的告警组信息，用户可以自定义告警阈值。</p>
	</div>
	<div class="row m-b-40">
		<div class="col-sm-12">
			<div class="table-responsive well no-padding white no-margin">
				<table class="table table-hover table-full m-b-60"
					id="table-warn-group-2172158">
					<thead>
						<tr fsm-sticky-header scroll-body="'#table-warn-group-2172158'" scroll-stop="64">
							<th width="45"></th>
							<th width="160">组名称</th>
							<th width="80" class="text-center">系统组</th>
							<th>描述</th>
							<th width="140" class="text-center">创建时间</th>
							<th width="148"></th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="(key, warnGroup) in data" ng-dblclick="warnItems(warnGroup)">
							<td class="f20 ng-binding"><i class="md md-error light-green lighten-1 icon-color"></i></td>
							<td>{{ warnGroup.groupName }}</td>
							<td class="text-center"><i class="md md-done f14" style="color:green" ng-if="warnGroup.systemGroup"></i><i class="md md-clear f14" style="color:gray" ng-if="!warnGroup.systemGroup"></i></td>
							<td>{{ warnGroup.groupDescript }}</td>
							<td class="text-center">{{ warnGroup.createTime | date: "yyyy-MM-dd HH:mm:ss" }}</td>
							<td class="text-center" ng-click="$event.stopPropagation()">
								<button type="button" class="btn btn-link btn-round" data-title="编辑" ng-click="edit(warnGroup)" data-placement="bottom" bs-tooltip>
									<i class="md md-edit"></i>
								</button>
								<button type="button" class="btn btn-link btn-round" data-title="告警项" ng-click="warnItems(warnGroup)" data-placement="bottom" bs-tooltip>
									<i class="md md-format-list-bulleted"></i>
								</button>
								<button type="button" class="btn btn-link btn-round" data-title="删除" ng-click="remove(warnGroup)" data-placement="bottom" bs-tooltip>
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
		<div class="btn btn-primary btn-round " ng-click="create()" data-title="新增" bs-tooltip>
			<i class="md md-add"></i>
		</div>
		<div class="btn btn-default btn-round m-r-10 btn-footer"
			scroll-to="top" ng-hide="scroll<100" data-title="返回顶部" bs-tooltip>
			<i class="md md-arrow-drop-up"></i>
		</div>
	</div>
</section>