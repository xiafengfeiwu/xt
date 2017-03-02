<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<section class="forms-basic" ng-controller="WarnController">
	<div class="page-header">
		<h1>
			<i class="md md-warn"></i> 故障告警
		</h1>
		<p class="lead">
			此处展示的是热泵故障和告警信息列表。用户可以新增设备的故障信息并能够查看故障的处理情况；运维人员可以通过设备的告警和用户提交的故障信息，及时处理设备异常。</p>
	</div>
	<div class="row m-b-40">
		<div class="col-sm-12">
			<div class="table-responsive well no-padding white no-margin">

				<table class="table table-hover table-full m-b-60"
					id="table-warn-2172158">
					<thead>
						<tr fsm-sticky-header scroll-body="'#table-warn-2172158'"
							scroll-stop="64">
							<th>缺陷单号</th>
							<th class="text-center">缺陷来源</th>
							<th class="text-center">分类</th>
							<th>描述</th>
							<th class="text-center">当前状态</th>
							<th class="text-center">发生处理时间</th>
							<th class="text-center">最后处理时间</th>
							<th class="text-center">操作</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>W6538098863931393</td>
							<td class="text-center">司仲夏</td>
							<td class="text-center">故障</td>
							<td>出水温度超范围，当前温度56℃</td>
							<td class="text-center">未处理</td>
							<td class="text-center">2016-03-01 12:56:12</td>
							<td class="text-center">-</td>
							<td class="text-center" ng-click="$event.stopPropagation()">
								<button type="button" class="btn btn-link btn-round"
									data-title="详情" ng-click="edit(project)"
									data-placement="bottom" bs-tooltip>
									<i class="md md-description"></i>
								</button>
							</td>
						</tr>
						<tr>
							<td>W6538098863931394</td>
							<td class="text-center">系统</td>
							<td class="text-center">告警</td>
							<td>出水温度超范围，当前温度56℃</td>
							<td class="text-center">正在处理</td>
							<td class="text-center">2016-03-01 12:56:12</td>
							<td class="text-center">2016-03-02 10:22:42</td>
							<td class="text-center" ng-click="$event.stopPropagation()">
								<button type="button" class="btn btn-link btn-round"
									data-title="详情" ng-click="edit(project)"
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
		<div class="btn btn-primary btn-round " ng-click="create()"
			data-title="新增故障" bs-tooltip>
			<i class="md md-add"></i>
		</div>
		<div class="btn btn-default btn-round m-r-10 btn-footer"
			scroll-to="top" ng-hide="scroll<100" data-title="返回顶部" bs-tooltip>
			<i class="md md-arrow-drop-up"></i>
		</div>
	</div>
</section>