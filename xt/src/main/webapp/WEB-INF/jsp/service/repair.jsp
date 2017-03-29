<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<section class="forms-basic" data-ng-controller="RepairController">
	<div class="page-header">
		<h1>故障报修</h1>
		<p class="lead">用户可以通过此功能提交热泵运行出现的故障，以便运维人员及时报修。</p>
	</div>
	<div class="row m-b-40">
		<div class="col-sm-12">
			<div class="table-responsive well no-padding white no-margin">

				<table class="table table-hover table-full m-b-60" id="table-repair-2172158">
					<thead>
						<tr data-fsm-sticky-header
							data-scroll-body="'#table-repair-2172158'" data-scroll-stop="64">
							<th width="120px">工单编号</th>
							<th width="120px">热泵</th>
							<th>故障描述</th>
							<th width="146px" class="text-center">发生日期</th>
							<th width="80px" class="text-center">状态</th>
							<th width="78px" class="text-center">来源</th>
							<th width="48px" class="text-center">操作</th>
						</tr>
					</thead>
					<tbody>
						<tr data-ng-repeat="(key, stoppage) in data" data-ng-dblclick="detail(vender)">
							<td>{{stoppage.stoppageNo}}</td>
							<td>{{stoppage.pumpName}}</td>
							<td>{{stoppage.descript}}</td>
							<td class="text-center">{{stoppage.occurTime}}</td>
							<td class="text-center" data-ng-bind-html="formatStatus(stoppage.handleStatus)"></td>
							<td class="text-center">
								<span class="label orange" data-title="采集系统自动生成的故障信息" data-placement="top" data-bs-tooltip data-ng-if="stoppage.pumpWarnId">系统</span>
								<span class="label red" data-title="人为录入的故障信息" data-placement="top" data-bs-tooltip data-ng-if="!stoppage.pumpWarnId">人工</span>
							</td>
							<td class="text-center" data-ng-click="$event.stopPropagation()">
								<button type="button" class="btn btn-link btn-round" data-ng-click="detail(stoppage.stoppageId)" data-title="详情" data-placement="bottom" data-bs-tooltip>
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
		<div class="btn btn-primary btn-round " data-ng-click="create()"
			data-title="新增" data-bs-tooltip>
			<i class="md md-add"></i>
		</div>
		<div class="btn btn-default btn-round m-r-10 btn-footer" data-scroll-to="top" data-ng-hide="scroll<100" data-title="返回顶部" data-bs-tooltip>
			<i class="md md-arrow-drop-up"></i>
		</div>
	</div>
</section>

