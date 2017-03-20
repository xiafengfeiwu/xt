<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<section class="forms-basic" ng-controller="HandlingController">
	<div class="page-header">
		<h1>
			故障处理
		</h1>
		<p class="lead">运维人员可以通过此功能查询系统产生和用户提交的热泵运行出现的故障，并及时响应处理。</p>
	</div>
	<div class="row todo-app">

		<div class="col-md-12 filters well">
			<div class="btn-group" role="group">
				<button class="btn btn-link filter ng-binding ng-scope"
					ng-click="changeTab('N')"
					ng-class="{true: 'active', false: ''}[tabFlag=='N']">
					未处理
					<div class="ripple-wrapper"></div>
				</button>
				<button class="btn btn-link filter ng-binding ng-scope"
					ng-click="changeTab('D')"
					ng-class="{true: 'active', false: ''}[tabFlag=='D']">
					正在处理
					<div class="ripple-wrapper"></div>
				</button>
				<button class="btn btn-link filter ng-binding ng-scope"
					ng-click="changeTab('Y')"
					ng-class="{true: 'active', false: ''}[tabFlag=='Y']">
					已处理
					<div class="ripple-wrapper"></div>
				</button>
			</div>
		</div>
	</div>
	<div class="row m-b-40">
		<div ng-show="tabFlag=='N'" class="col-sm-12 well">
			<p class="lead">系统设备自动产生的告警信息和用户提交的故障新增暂未被运维人员抢修处理的所有记录。</p>
			<div class="table-responsive well no-padding white no-margin">
				<table class="table table-hover table-full m-b-60" id="table-handling-n-2172158" >
					<thead>
						<tr fsm-sticky-header scroll-body="'#table-handling-n-2172158'" scroll-stop="64">
							<th width="156">工单编号</th>
							<th>热泵</th>
							<th>业主</th>
							<th class="text-center">联系方式</th>
							<th>故障描述</th>
							<th class="text-center">提交时间</th>
							<th class="text-center">操作</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>W6538098863931312</td>
							<td>热泵1</td>
							<td>司仲夏</td>
							<td class="text-center">18518436862</td>
							<td>{{'热泵故障描述' | cut:true:10:' ...'}}</td>
							<td class="text-center">2017-03-04</td>
							<td class="text-center" ng-click="$event.stopPropagation()">
								<button type="button" class="btn btn-link btn-round" ng-click="detail()" data-title="详情" data-placement="bottom" bs-tooltip>
									<i class="md md-info"></i>
								</button>
								<button type="button" class="btn btn-link btn-round" data-title="抢修" data-placement="bottom" bs-tooltip>
									<i class="md md-flash-on"></i>
								</button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div ng-show="tabFlag=='D'" class="col-sm-12 well">
			<p class="lead">运维人员正在抢修处理的记录。</p>
			<div class="table-responsive well no-padding white no-margin">
				<table class="table table-hover table-full m-b-60" id="table-handling-n-2172158" >
					<thead>
						<tr fsm-sticky-header scroll-body="'#table-handling-n-2172158'" scroll-stop="64">
							<th width="156">工单编号</th>
							<th>热泵</th>
							<th>业主</th>
							<th class="text-center">联系方式</th>
							<th>故障描述</th>
							<th class="text-center">最后处理时间</th>
							<th class="text-center">操作</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>W6538098863931313</td>
							<td>热泵1</td>
							<td>司仲夏</td>
							<td class="text-center">18518436862</td>
							<td>{{'热泵故障描述' | cut:true:10:' ...'}}</td>
							<td class="text-center">2017-03-04</td>
							<td class="text-center" ng-click="$event.stopPropagation()">
								<button type="button" class="btn btn-link btn-round" ng-click="detail()" data-title="处理" data-placement="bottom" bs-tooltip>
									<i class="md md-settings"></i>
								</button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div ng-show="tabFlag=='Y'" class="col-sm-12 well">
			<p class="lead">运维人员已经抢修处理完成的记录。</p>
			<div class="table-responsive well no-padding white no-margin">
				<table class="table table-hover table-full m-b-60" id="table-handling-n-2172158" >
					<thead>
						<tr fsm-sticky-header scroll-body="'#table-handling-n-2172158'" scroll-stop="64">
							<th width="156">工单编号</th>
							<th>热泵</th>
							<th>业主</th>
							<th class="text-center">联系方式</th>
							<th>故障描述</th>
							<th class="text-center">提交时间</th>
							<th class="text-center">处理时长</th>
							<th class="text-center">操作</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>W6538098863931314</td>
							<td>热泵1</td>
							<td>司仲夏</td>
							<td class="text-center">18518436862</td>
							<td>{{'热泵故障描述' | cut:true:10:' ...'}}</td>
							<td class="text-center">2017-03-04</td>
							<td class="text-center">1 天</td>
							<td class="text-center" ng-click="$event.stopPropagation()">
								<button type="button" class="btn btn-link btn-round" ng-click="detail()" data-title="详情" data-placement="bottom" bs-tooltip>
									<i class="md md-info"></i>
								</button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	
</section>