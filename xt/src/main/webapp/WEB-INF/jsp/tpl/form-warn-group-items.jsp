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
			当前告警组：{{currentWarnGroup.groupName}}
			<div class="btn btn-primary btn-text btn-sm pull-right" ng-click="createItem(currentWarnGroup.groupId)">
				<i class="md md-add"></i> 新增监测项
			</div>
			<table class="table table-striped table-full table-full-small" style="margin-top: 24px;">
				<thead>
					<tr>
						<th width="135">监测项</th>
						<th width="120">监测项编码</th>
						<th width="60" class="text-center">操作符</th>
						<th width="80" class="text-center">阈值</th>
						<th width="120">告警编码</th>
						<th width="80" class="text-center">告警级别</th>
						<th width="140" class="text-center">创建时间</th>
						<th width="80"></th>
					</tr>
				</thead>
				<tbody>
					<tr ng-repeat="(key, warnGroupItem) in items">
						<td>{{ warnGroupItem.itemName }}</td>
						<td>{{ warnGroupItem.itemCode }}</td>
						<td class="text-center"><span bs-tooltip data-placement="bottom" data-html="true" data-title="<p style='text-align:left'><br/>'>'：大于<br/>'<'：小于<br/>'='：等于<br/>'≥'：大于等于<br/>'≤'：小于等于</p>">{{ warnGroupItem.itemOperators }}</span></td>
						<td class="text-center">{{ warnGroupItem.itemThreshold }}</td>
						<td><span bs-tooltip data-placement="bottom" data-html="true" data-title="<p style='text-align:left'><br/>告警描述：{{warnGroupItem.warnDescript}}<br/>处理建议：{{warnGroupItem.warnScheme}}</p>"><i class="md md-info"></i> {{ warnGroupItem.warnCode }}</span></td>
						<td class="text-center"><span ng-show="warnGroupItem.warnLevel==='信息'" style="color:green">{{ warnGroupItem.warnLevel }}</span><span ng-show="warnGroupItem.warnLevel==='告警'" style="color:orange">{{ warnGroupItem.warnLevel }}</span><span ng-show="warnGroupItem.warnLevel==='故障'" style="color:red">{{ warnGroupItem.warnLevel }}</span></td>
						<td class="text-center">{{ warnGroupItem.createTime | date:'yyyy-MM-dd HH:mm:ss'}}</td>
						<td>
							<button type="button" class="btn btn-link btn-round" data-title="编辑" ng-click="editItem(warnGroupItem)" data-placement="bottom" bs-tooltip>
								<i class="md md-edit"></i>
							</button>
							<button type="button" class="btn btn-link btn-round" data-title="删除" ng-click="removeItem(warnGroupItem)" data-placement="bottom" bs-tooltip>
								<i class="md md-delete"></i>
							</button>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>