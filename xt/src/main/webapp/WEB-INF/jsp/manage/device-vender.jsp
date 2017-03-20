<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<section class="forms-basic" ng-controller="DeviceVenderController">
	<div class="page-header">
		<div class="actions">
			<a menu-link class="btn black-text" href="#/manage/device-product" name="产品管理" data-title="产品管理" data-placement="left" bs-tooltip>
				<i class="md md-view-list f12" style="color: #33cc99">产品管理</i>
			</a>
		</div>
		<h1>厂家信息</h1>
		<p class="lead">此处展示的是设备厂家信息。</p>
	</div>
	<div class="row m-b-40">
		<div class="col-sm-12">
			<div class="table-responsive well no-padding white no-margin">

				<table class="table table-hover table-full m-b-60" id="table-device-vender-2172158">
					<thead>
						<tr fsm-sticky-header scroll-body="'#table-device-vender-2172158'" scroll-stop="64">
							<th width="45"></th>
							<th width="80">名称</th>
							<th class="text-center" width="80">联系人</th>
							<th class="text-center" width="80">联系方式</th>
							<th>地址</th>
							<th>备注</th>
							<th class="text-center" width="78">操作</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="(key, vender) in data" ng-dblclick="detail(vender)">
							<td class="f20 ng-binding"><i class="md md-quick-contacts-dialer light-green lighten-1 icon-color"></i></td>
							<td>{{ vender.venderName }}</td>
							<td class="text-center">{{ vender.venderContacts }}</td>
							<td class="text-center">{{ vender.venderContactsTel }}</td>
							<td>{{ vender.venderAddress }}</td>
							<td>{{ vender.venderRemark }}</td>
							<td ng-click="$event.stopPropagation()">
								<button type="button" class="btn btn-link btn-round" data-title="编辑" ng-click="edit(vender)" data-placement="bottom" bs-tooltip>
									<i class="md md-edit"></i>
								</button>
								<button type="button" class="btn btn-link btn-round" data-title="详情" ng-click="detail(vender)" data-placement="bottom" bs-tooltip>
									<i class="md md-account-box"></i>
								</button>
								<button type="button" class="btn btn-link btn-round" data-title="删除" ng-click="remove(vender)" data-placement="bottom" bs-tooltip>
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