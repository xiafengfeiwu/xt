<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<section class="forms-basic" ng-controller="DeviceController">
	<div class="page-header">
		<div class="actions">
			<a menu-link class="btn black-text" href=""
				name="厂家管理" data-title="厂家管理" data-placement="left" bs-tooltip>
				<i class="md md-view-list f12" style="color: #33cc99">厂家管理</i>
			</a>
		</div>
		<h1>
			设备管理
		</h1>
		<p class="lead">
			此处展示的是设备、厂家和厂家产品信息。</p>
	</div>
	<div class="row m-b-40">
		<div class="col-sm-12">
			<div class="table-responsive well no-padding white no-margin">

				<table class="table table-hover table-full m-b-60" id="table-device-2172158">
					<thead>
						<tr fsm-sticky-header scroll-body="'#table-device-2172158'" scroll-stop="64">
							<th></th>
							<th>设备名称</th>
							<th>所属热泵</th>
							<th class="text-center">序列号</th>
							<th class="text-center">创建时间</th>
							<th class="text-center">操作</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="f20 ng-binding"><i
								class="md md-memory light-green lighten-1 icon-color"></i></td>
							<td>采集器1</td>
							<td>热泵1</td>
							<td class="text-center">D653809886393</td>
							<td class="text-center">2016-03-01 12:56:12</td>
							<td class="text-center" ng-click="$event.stopPropagation()">
								<button type="button" class="btn btn-link btn-round"
									data-title="详情" ng-click=""
									data-placement="bottom" bs-tooltip>
									<i class="md md-description"></i>
								</button>
							</td>
						</tr>
						<tr>
							<td class="f20 ng-binding"><i
								class="md md-memory light-green lighten-1 icon-color"></i></td>
							<td>采集器2</td>
							<td>热泵2</td>
							<td class="text-center">D653809886394</td>
							<td class="text-center">2016-03-03 12:56:12</td>
							<td class="text-center" ng-click="$event.stopPropagation()">
								<button type="button" class="btn btn-link btn-round"
									data-title="详情" ng-click=""
									data-placement="bottom" bs-tooltip>
									<i class="md md-description"></i>
								</button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div class="footer-buttons">
		<div class="btn btn-default btn-round m-r-10 btn-footer"
			scroll-to="top" ng-hide="scroll<100" data-title="返回顶部" bs-tooltip>
			<i class="md md-arrow-drop-up"></i>
		</div>
	</div>
</section>