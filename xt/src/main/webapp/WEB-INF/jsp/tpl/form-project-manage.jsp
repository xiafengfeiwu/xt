<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="projectManageBox" class="aside" tabindex="-1" role="dialog">
	<div class="table-responsive well no-padding white no-margin">
		<div class="btn btn-round btn-info pull-right"
			style="margin: 7px 7px 0 0;" ng-click="hideCreatPumpForm();$hide()">
			<i class="md md-close"></i>
		</div>
		<h3 class="table-title" ng-bind="project.projectName"></h3>
	</div>
	<div class="aside-dialog">
		<div class="aside-body bs-sidebar" style="background-color: #fcfcfc;">
			<div class="row">
				<div class="col-lg-4 col-sm-6">
					<div class="form-group filled">
						<label class="control-label">项目名称：</label> {{project.projectName}}
					</div>
				</div>
				<div class="col-lg-4  col-sm-6">
					<div class="form-group filled">
						<label class="control-label">项目编码：</label> {{project.projectCode}}
					</div>
				</div>
				<div class="col-lg-4  col-sm-6">
					<div class="form-group filled">
						<label class="control-label" bs-tooltip data-placement="bottom" title="区域编码：{{projectArea.areaCode}}|天气编码：{{projectArea.weatherCode}}">所在区域：</label> {{projectArea.areaName}}
					</div>
				</div>
				<div class="col-lg-4  col-sm-6">
					<div class="form-group filled">
						<label class="control-label">项目业主：</label> {{project.ownerName}}
					</div>
				</div>
				<div class="col-lg-4  col-sm-6">
					<div class="form-group filled">
						<label class="control-label">业主类型：</label> {{project.ownerType}}
					</div>
				</div>
				<div class="col-lg-4  col-sm-6">
					<div class="form-group filled">
						<label class="control-label">联系方式：</label> {{project.ownerPhoneNo}}
					</div>
				</div>
				<div class="col-lg-4  col-sm-6">
					<div class="form-group filled">
						<label class="control-label">创建时间：</label> {{project.createTime  | date: 'yyyy-MM-dd HH:mm:ss' }}
					</div>
				</div>
				<div class="col-lg-4  col-sm-6">
					<div class="form-group filled">
						<label class="control-label">最后修改：</label> {{project.modifyTime  | date: 'yyyy-MM-dd HH:mm:ss' }}
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
					<div class="table-responsive well no-padding white no-margin">
						<table class="table table-hover table-full m-b-60">
							<thead>
								<tr>
									<th></th>
									<th>热泵名称</th>
									<th>序列号</th>
									<th class="text-center">供暖面积</th>
									<th class="text-center">供暖温度</th>
									<th class="text-center">安装时间</th>
									<th class="text-center">操作</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td class="f20 ng-binding"><i class="md md-memory darken-1 icon-color"></i></td>
									<td>测试热泵</td>
									<td>SNJSK011J7</td>
									<td class="text-center">100 m<sup>2</sup></td>
									<td class="text-center">25 ℃</td>
									<td class="text-center">2017-03-01</td>
									<td class="text-center" ng-click="$event.stopPropagation()">
										<button type="button" class="btn btn-link btn-round"
											data-title="编辑" ng-click=""
											data-placement="bottom" bs-tooltip>
											<i class="md md-edit"></i>
										</button>
										<button type="button" class="btn btn-link btn-round"
											data-title="删除" ng-click=""
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
		</div>
	</div>
	<div class="footer-buttons">
		<div class="btn btn-primary btn-round " ng-click="createPump(project)" data-title="新增热泵" data-placement="left" bs-tooltip>
			<i class="md md-add"></i>
		</div>
	</div>
</div>