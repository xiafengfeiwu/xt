<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div ng-controller="PumpController">
	<div class="table-responsive well no-padding white no-margin">
		<div class="row">
	      <div class="col-sm-8">
	        <h3 class="table-title">共有 <span ng-bind="data.length || 0"></span> 条记录</h3>
	      </div>
	      <div class="col-sm-4">
	      	<form class="form-floating">
          		<fieldset>
			      	<div class="form-group has-success">
		              <label class="control-label" for="inputSuccess">通过热泵名称或区域检索</label>
		              <input type="text" class="form-control" ng-model="keyword">
		            </div>
	            </fieldset>
	        </form>
	      </div>
	    </div>
		<table class="table table-hover table-full m-b-60" id="table-user-2172158" >
			<thead>
				<tr fsm-sticky-header scroll-body="'#table-user-2172158'" scroll-stop="64">
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