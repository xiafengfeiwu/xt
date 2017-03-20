<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<section class="forms-basic" ng-controller="RepairController">
	<div class="page-header">
		<h1>
			设备报修
		</h1>
		<p class="lead">用户可以通过此功能提交热泵运行出现的故障，以便运维人员及时报修。</p>
	</div>
	<div class="row m-b-40">

		<div class="col-sm-12">

			<div class="table-responsive well no-padding white no-margin">

				<table class="table table-hover table-full m-b-60" id="table-repair-2172158" >
					<thead>
						<tr fsm-sticky-header scroll-body="'#table-repair-2172158'" scroll-stop="64">
							<th width="50px"></th>
							<th>工单编号</th>
							<th>热泵</th>
							<th>故障</th>
							<th width="120px" class="text-center">提交日期</th>
							<th width="50px" class="text-center">状态</th>
							<th width="120px" class="text-center">最后处理日期</th>
							<th width="50px" class="text-center">操作</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="f20 ng-binding"><i
										class="md md-warning light-green lighten-1 icon-color"></i></td>
							<td>W6538098863931398</td>
							<td>热泵1</td>
							<td>故障描述详细说明</td>
							<td class="text-center">2017-03-03</td>
							<td class="text-center">
								<button type="button" class="btn btn-link black-text">
									<i class="md md-beenhere f12" style="color:#33cc99">已处理</i>
								</button>
							</td>
							<td class="text-center">2017-03-03</td>
							<td class="text-center" ng-click="$event.stopPropagation()">
								<button type="button" class="btn btn-link btn-round" data-title="详情" data-placement="bottom" bs-tooltip>
									<i class="md md-info"></i>
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
		<div class="btn btn-default btn-round m-r-10 btn-footer" scroll-to="top" ng-hide="scroll<100" data-title="返回顶部" bs-tooltip>
			<i class="md md-arrow-drop-up"></i>
		</div>
	</div>
</section>

