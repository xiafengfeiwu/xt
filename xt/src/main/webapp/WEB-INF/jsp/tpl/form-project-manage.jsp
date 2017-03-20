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
		<div class="aside-body bs-sidebar" style="background-color: #fcfcfc;padding:10px 30px !important">
			<div class="row">
				<div class="col-xs-4 well m-b-40">
					<div class="form-group filled">
						<label class="control-label">项目名称：</label> {{project.projectName}}
					</div>
					<div class="form-group filled">
						<label class="control-label">项目编码：</label> {{project.projectCode}}
					</div>
					<div class="form-group filled">
						<label class="control-label">所在区域：</label> 
						<span bs-tooltip data-placement="bottom" data-html="true" data-title="<p style='text-align:left'><br/>区域编码：{{projectArea.areaCode}}<br/>天气编码：{{projectArea.weatherCode}}</p>">{{projectArea.areaName}}</span>
					</div>
					<div class="form-group filled">
						<label class="control-label">项目业主：</label> {{project.ownerName}}
					</div>
					<div class="form-group filled">
						<label class="control-label">业主类型：</label> {{project.ownerType}}
					</div>
					<div class="form-group filled">
						<label class="control-label">联系方式：</label> {{project.ownerPhoneNo}}
					</div>
					<div class="form-group filled">
						<label class="control-label">供暖面积：</label> {{project.heatingArea}} ㎡
					</div>
					<div class="form-group filled">
						<label class="control-label">供暖温度：</label> {{project.heatingTemp}} ℃
					</div>
					<div class="form-group filled">
						<label class="control-label">项目地址：</label> {{project.projectAddress}}
					</div>
					<div class="form-group filled">
						<label class="control-label">创建时间：</label> {{project.createTime  | date: 'yyyy-MM-dd HH:mm:ss' }}
					</div>
					<div class="form-group filled">
						<label class="control-label">最后修改：</label> {{project.modifyTime  | date: 'yyyy-MM-dd HH:mm:ss' }}
					</div>
				</div>
				<div class="col-xs-8">
					<div class="btn btn-text " data-ng-click="createPump(project)">
						<i class="md md-add"></i> 新增热泵
					</div>
					<div class="table-responsive well no-padding white no-margin">
						<table class="table table-hover table-full m-b-60">
							<thead>
								<tr>
									<th width="180">热泵名称</th>
									<th width="160">热泵编码</th>
									<th width="120">序列号</th>
									<th width="120" class="text-center">安装时间</th>
									<th width="48" class="text-center">操作</th>
								</tr>
							</thead>
							<tbody>
								<tr ng-repeat="(key, pump) in pumps">
									<td>{{ pump.pumpName }}</td>
									<td>{{ pump.pumpCode }}</td>
									<td>{{ pump.pumpSn }}</td>
									<td class="text-center">{{ pump.installDate | date:'yyyy-MM-dd' }}</td>
									<td class="text-center" ng-click="$event.stopPropagation()">
										<button type="button" class="btn btn-link btn-round"
											data-title="编辑" ng-click="editPump(pump)"
											data-placement="bottom" bs-tooltip>
											<i class="md md-edit"></i>
										</button>
										<button type="button" class="btn btn-link btn-round"
											data-title="删除" ng-click="removePump(pump)"
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
</div>