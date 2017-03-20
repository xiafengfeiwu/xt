<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<section class="cards" ng-controller="AreaWeatherController">
	<div class="page-header">
		<h1>
			区域天气
		</h1>
		<p class="lead">选择查询各区域的天气信息。</p>
	</div>

	<div class="row" style="margin: 18px 0">
		<div class="col-xs-3">
			<ui-select ng-model="citys.selected" ng-change="change()">
	           <ui-select-match placeholder="选择区域 ">{{$select.selected.name}}</ui-select-match>
	           <ui-select-choices repeat="item in citys | filter: $select.search">
	             <div ng-bind-html="item.name | highlight: $select.search"></div>
	           </ui-select-choices>
	        </ui-select>
        </div>
        <div class="col-xs-3 col-xs-offset-6">
        	<button type="button" class="btn btn-link btn-round pull-right" data-title="刷新天气" ng-click="refresh()" data-placement="bottom" bs-tooltip>
				<i class="md md-refresh"></i>
			</button>
        </div>
	</div>
	<div class="row well" ng-show="!citys.selected">
		<div class="col-xs-12">
			请选择一个区域
		</div>
	</div>
	<div class="row well" ng-show="citys.selected">
		<div class="col-xs-6">
			<p>区域名称：{{citys.selected.name}}</p>
		</div>
		<div class="col-xs-6">
			<p>区域编码：{{citys.selected.code}}</p>
		</div>
		<p data-ng-show="!weatherData">正在加载天气数据...</p>
		<div data-ng-show="weatherData">
			<div class="col-xs-6">
				<p>最新天气：{{weatherData.condTxt}} <img style="height: 19px;margin-top: -3px;" alt="{{weatherData.condCode}}" src="{{weatherData.condCodeUrl}}"></p>
			</div>
			<div class="col-xs-6">
				<p>风力风向：{{weatherData.windSc}}级, {{weatherData.windDir}}</p>
			</div>
			<div class="col-xs-6">
				<p>采集温度：{{weatherData.tmp}} ℃</p>
			</div>
			<div class="col-xs-6">
				<p>体感温度：{{weatherData.fl}} ℃</p>
			</div>
			<div class="col-xs-6">
				<p>相对湿度：{{weatherData.hum}} %</p>
			</div>
			<div class="col-xs-6">
				<p>降水量：{{weatherData.pcpn}} mm</p>
			</div>
			<div class="col-xs-6">
				<p>大气气压：{{weatherData.pres/10}} kPa</p>
			</div>
			<div class="col-xs-6">
				<p>能见度：{{weatherData.vis}} km</p>
			</div>
			<div class="col-xs-12">
				<p>采集时间：{{weatherData.lastUpdateTime | date: "yyyy-MM-dd HH:mm:ss" }}</p>
			</div>
			<div class="col-xs-12">
				<p class="text-right lead">最短更新间隔时间为30分钟</p>
			</div>
		</div>
	</div>
	
	<div class="row well" data-ng-show="alarmData">
		<div class="col-xs-12">
			<p><span style="color: red">{{alarmData.earlyWarnTitle}}</span> </p>
		</div>
		<div class="col-xs-6">
			<p>预警类别：{{alarmData.earlyWarnType}}</p>
		</div>
		<div class="col-xs-6">
			<p>预警级别：{{alarmData.earlyWarnLevel}}</p>
		</div>
		<div class="col-xs-6">
			<p>预警状态：{{alarmData.earlyWarnStat}}</p>
		</div>
		<div class="col-xs-6">
			<p>发布时间：{{alarmData.earlyWarnTime | date: "yyyy-MM-dd"}}</p>
		</div>
		<div class="col-xs-12">
			<p>预警说明：{{alarmData.earlyWarnTxt}}</p>
		</div>
	</div>
	<div class="row well" data-ng-show="citys.selected && !alarmData">
		<div class="col-xs-12">
			无预警
		</div>
	</div>
	
</section>