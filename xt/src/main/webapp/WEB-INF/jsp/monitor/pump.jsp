<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<section class="forms-basic" ng-controller="PumpController">
	<div class="page-header">
		<h1>
			热泵管理
		</h1>
		<p class="lead">此处展示的是热泵的相关信息。</p>
	</div>
	<div class="row m-b-40">

		<div class="col-sm-12" style="margin-top: -58px">
			<form class="form-floating pull-right" style="width: 260px">
				<fieldset>
					<div class="form-group has-success">
						<label class="control-label" for="inputSuccess">通过热泵名称或区域检索</label>
						<input type="text" class="form-control" ng-model="keyword">
					</div>
				</fieldset>
			</form>
		</div>

		<div class="col-sm-12">

			<div class="table-responsive well no-padding white no-margin">

				<table class="table table-hover table-full m-b-60"
					id="table-pump-2172158">
					<thead>
						<tr fsm-sticky-header scroll-body="'#table-pump-2172158'"
							scroll-stop="64">
							<th width="50px"></th>
							<th>名称</th>
							<th class="text-center">当前状态</th>
							<th class="text-center">安装时间</th>
							<th class="text-center">供暖温度</th>
							<th>地址/区域</th>
							<th class="text-center">操作</th>
						</tr>
					</thead>

					<tbody>
						<tr ng-repeat="(key, pump) in data" ng-dblclick="pumpMonitor(pump.id)" ng-if="keyword=='' || (pump.name.indexOf(keyword)>=0 || pump.area.indexOf(keyword)>=0)">
							<td class="f20 ng-binding"><i class="md md-memory {{ pump.color }} darken-1 icon-color"></i></td>
							<td>{{ pump.name }}</td>
							<td class="text-center"><i class="md md-beenhere f12" style="color:{{ pump.color }}">{{pump.statusText}}</i></td>
							<td class="text-center">{{ pump.installDate | date: "yyyy-MM-dd" }}</td>
							<td class="text-center">{{ pump.heatingTemp}} ℃</td>
							<td>{{ pump.area }}</td>
							<td class="text-center" ng-click="$event.stopPropagation()">
								<button type="button" class="btn btn-link btn-round" ng-click="pumpMonitor(pump.id)" data-title="监控" data-placement="left" bs-tooltip>
									<i class="md md-desktop-windows" style="color:green"></i>
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