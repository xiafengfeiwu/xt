<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="aside bs-docs-aside" tabindex="-1" role="dialog">
	<div class="close">
		<div class="btn btn-round btn-info" ng-click="$hide()">
			<i class="md md-close"></i>
		</div>
	</div>
	<div class="aside-dialog">
		<div class="aside-body bs-sidebar">
			<form class="form-floating" novalidate="novalidate"
				ng-submit="changeAuth()">
				<fieldset>
					<legend class="f14" ng-bind="role.roleName+' 授权'"></legend>
					<div class="row">
						<div class="col-sm-12">综合管理</div>
					</div>
					<div class="row">
						<div class="col-sm-4">
							<div class="form-group">
								<div class="checkbox">
									<label> <input type="checkbox"
										ng-model="jurisdiction.pumbManage"> 热泵管理菜单
									</label>
								</div>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<div class="checkbox">
									<label> <input type="checkbox"
										ng-model="jurisdiction.pumbCreate"> 新增热泵
									</label>
								</div>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<div class="checkbox">
									<label> <input type="checkbox"
										ng-model="jurisdiction.pumbUpdate"> 修改热泵
									</label>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-4">
							<div class="form-group">
								<div class="checkbox">
									<label> <input type="checkbox"
										ng-model="jurisdiction.pumbDelete"> 删除热泵
									</label>
								</div>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<div class="checkbox">
									<label> <input type="checkbox"
										ng-model="jurisdiction.deviceManage"> 设备管理
									</label>
								</div>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<div class="checkbox">
									<label> <input type="checkbox"
										ng-model="jurisdiction.deviceCreate"> 新增设备
									</label>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-4">
							<div class="form-group">
								<div class="checkbox">
									<label> <input type="checkbox"
										ng-model="jurisdiction.deviceUpdate"> 修改设备
									</label>
								</div>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<div class="checkbox">
									<label> <input type="checkbox"
										ng-model="jurisdiction.deviceDelete"> 删除设备
									</label>
								</div>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<div class="checkbox">
									<label> <input type="checkbox"
										ng-model="jurisdiction.deviceReplace"> 更换设备
									</label>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-4">
							<div class="form-group">
								<div class="checkbox">
									<label> <input type="checkbox"
										ng-model="jurisdiction.deviceRemoteControl"> 远程调控
									</label>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-12">运维管理</div>
					</div>
					<div class="row">
						<div class="col-sm-4">
							<div class="form-group">
								<div class="checkbox">
									<label> <input type="checkbox"
										ng-model="jurisdiction.troubleManage"> 故障告警
									</label>
								</div>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<div class="checkbox">
									<label> <input type="checkbox"
										ng-model="jurisdiction.troubleCreate"> 新增故障
									</label>
								</div>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<div class="checkbox">
									<label> <input type="checkbox"
										ng-model="jurisdiction.troubleCreate"> 新增故障
									</label>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-4">
							<div class="form-group">
								<div class="checkbox">
									<label> <input type="checkbox"
										ng-model="jurisdiction.troubleDealWith"> 处理故障
									</label>
								</div>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<div class="checkbox">
									<label> <input type="checkbox"
										ng-model="jurisdiction.troubleUpdate"> 更改故障
									</label>
								</div>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<div class="checkbox">
									<label> <input type="checkbox"
										ng-model="jurisdiction.troubleDelete"> 删除故障
									</label>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-4">
							<div class="form-group">
								<div class="checkbox">
									<label> <input type="checkbox"
										ng-model="jurisdiction.warnDealWith"> 处理告警
									</label>
								</div>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<div class="checkbox">
									<label> <input type="checkbox"
										ng-model="jurisdiction.warnDelete"> 删除告警
									</label>
								</div>
							</div>
						</div>
					</div>

					<div class="form-group">
						<button type="submit" class="btn btn-primary">更改授权</button>
					</div>
				</fieldset>
			</form>
		</div>
	</div>
</div>