<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="modal" tabindex="-1" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" ng-click="$hide()">&times;</button>
        <h4 class="modal-title">{{ warnGroup.groupName }}</h4>
      </div>
      <div class="modal-body">
		<table class="table table-striped table-full table-full-small">
			<thead>
				<tr>
					<th width="135">监测项</th>
					<th width="120">监测项编码</th>
					<th width="60" class="text-center">操作符</th>
					<th width="80" class="text-center">阈值</th>
					<th width="120">告警编码</th>
					<th width="80" class="text-center">告警级别</th>
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="(key, warnGroupItem) in warnGroupItems">
					<td>{{ warnGroupItem.itemName }}</td>
					<td>{{ warnGroupItem.itemCode }}</td>
					<td class="text-center"><span bs-tooltip data-placement="bottom" data-html="true" data-title="<p style='text-align:left'><br/>'>'：大于<br/>'<'：小于<br/>'='：等于<br/>'≥'：大于等于<br/>'≤'：小于等于</p>">{{ warnGroupItem.itemOperators }}</span></td>
					<td class="text-center">{{ warnGroupItem.itemThreshold }}</td>
					<td><span bs-tooltip data-placement="bottom" data-html="true" data-title="<p style='text-align:left'><br/>告警描述：{{warnGroupItem.warnDescript}}<br/>处理建议：{{warnGroupItem.warnScheme}}</p>"><i class="md md-info"></i> {{ warnGroupItem.warnCode }}</span></td>
					<td class="text-center"><span ng-show="warnGroupItem.warnLevel==='信息'" style="color:green">{{ warnGroupItem.warnLevel }}</span><span ng-show="warnGroupItem.warnLevel==='告警'" style="color:orange">{{ warnGroupItem.warnLevel }}</span><span ng-show="warnGroupItem.warnLevel==='故障'" style="color:red">{{ warnGroupItem.warnLevel }}</span></td>
				</tr>
			</tbody>
		</table>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" ng-click="removePumpWarnGroup(pumpd.base.pumpId, currentWarnGroupId)">移除</button>
        <button type="button" class="btn btn-default" ng-click="$hide()">关闭</button>
      </div>
    </div>
  </div>
</div>
