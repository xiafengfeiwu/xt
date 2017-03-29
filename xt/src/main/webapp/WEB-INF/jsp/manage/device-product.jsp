<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<section class="forms-basic" ng-controller="DeviceProductController">
	<div class="page-header">
		<div class="actions">
			<a menu-link class="btn black-text" href="#/manage/device-vender"
				name="设备厂家" data-title="设备厂家" data-placement="left" bs-tooltip>
				<i class="md md-view-list f12" style="color: #33cc99">设备厂家</i>
			</a>
		</div>
		<h1>产品管理</h1>
		<p class="lead">此处展示的是厂家产品信息。产品类型分为热泵产品和其他类型产品，其他类型产品主要是采集器。</p>
	</div>
	
	<div class="row todo-app">
		<div class="col-md-12 filters">
			<div class="btn-group" role="group">
				<button class="btn btn-link filter ng-binding ng-scope" ng-click="changeTab('R')" ng-class="{true: 'active', false: ''}[tabFlag=='R']">
					热泵 <div class="ripple-wrapper"></div>
				</button>
				<button class="btn btn-link filter ng-binding ng-scope" ng-click="changeTab('C')" ng-class="{true: 'active', false: ''}[tabFlag=='C']">
					采集器 <div class="ripple-wrapper"></div>
				</button>
			</div> 
		</div>
	</div>
	<div class="row m-b-40">
		<div class="col-sm-12">
			<div class="table-responsive well no-padding white" style="margin-top:10px;" ng-show="tabFlag=='R'">
				<table class="table table-hover table-full m-b-60" id="table-device-product-2172158">
					<thead>
						<tr fsm-sticky-header scroll-body="'#table-device-product-2172158'" scroll-stop="64">
							<th width="45"></th>
							<th width="120">名称</th>
							<th class="text-center">型号</th>
							<th class="text-center">匹数</th>
							<th class="text-center">电源规格</th>
							<th>厂家</th>
							<th class="text-center">创建时间</th>
							<th width="78" class="text-center">操作</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="(key, product) in RsData" ng-dblclick="detail(product)">
							<td class="f20 ng-binding"><i class="md md-stars light-green lighten-1 icon-color"></i></td>
							<td>{{ product.productName }}</td>
							<td class="text-center">{{ product.productSpec }}</td>
							<td class="text-center">{{ product.productPi }}</td>
							<td class="text-center">{{ product.productPowerSpec }}</td>
							<td>{{ product.productVenderName }}</td>
							<td class="text-center">{{ product.createTime | date: 'yyyy-MM-dd HH:mm:ss' }}</td>
							<td ng-click="$event.stopPropagation()">
								<button type="button" class="btn btn-link btn-round" data-title="编辑" ng-click="edit(product)" data-placement="bottom" bs-tooltip>
									<i class="md md-edit"></i>
								</button>
								<button type="button" class="btn btn-link btn-round" data-title="详情" ng-click="detail(product)" data-placement="bottom" bs-tooltip>
									<i class="md md-receipt"></i>
								</button>
								<button type="button" class="btn btn-link btn-round" data-title="删除" ng-click="remove(product)" data-placement="bottom" bs-tooltip>
									<i class="md md-delete"></i>
								</button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			
			<div class="table-responsive well no-padding white" style="margin-top:10px;" ng-show="tabFlag=='C'">
				<table class="table table-hover table-full m-b-60" id="table-device-product-2172158">
					<thead>
						<tr fsm-sticky-header scroll-body="'#table-device-product-2172158'" scroll-stop="64">
							<th width="45"></th>
							<th width="120">名称</th>
							<th class="text-center">型号</th>
							<th>厂家</th>
							<th class="text-center">创建时间</th>
							<th width="78" class="text-center">操作</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="(key, product) in CsData" ng-dblclick="detail(product)">
							<td class="f20 ng-binding"><i class="md md-settings-applications light-green lighten-1 icon-color"></i></td>
							<td>{{ product.productName }}</td>
							<td class="text-center">{{ product.productSpec }}</td>
							<td>{{ product.productVenderName }}</td>
							<td class="text-center">{{ product.createTime | date: 'yyyy-MM-dd HH:mm:ss' }}</td>
							<td ng-click="$event.stopPropagation()">
								<button type="button" class="btn btn-link btn-round" data-title="编辑" ng-click="edit(product)" data-placement="bottom" bs-tooltip>
									<i class="md md-edit"></i>
								</button>
								<button type="button" class="btn btn-link btn-round" data-title="详情" ng-click="detail(product)" data-placement="bottom" bs-tooltip>
									<i class="md md-receipt"></i>
								</button>
								<button type="button" class="btn btn-link btn-round" data-title="删除" ng-click="remove(product)" data-placement="bottom" bs-tooltip>
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