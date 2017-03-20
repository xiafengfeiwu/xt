<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<section class="cards" ng-controller="WeatherWarningController">
	<div class="page-header">
		<h1>发布预警</h1>
		<p class="lead">管理员在此处可以手动创建区域预警信息。</p>
	</div>
	<div class="row well white">
		<div class="col-xs-4">
			<ui-select ng-model="citys.selected">
	           <ui-select-match placeholder="选择区域 ">{{$select.selected.name}}</ui-select-match>
	           <ui-select-choices repeat="item in citys | filter: $select.search">
	             <div ng-bind-html="item.name | highlight: $select.search"></div>
	           </ui-select-choices>
	        </ui-select>
        </div>
		<div class="col-xs-4">
			<ui-select ng-model="types.selected">
	           <ui-select-match placeholder="选择类别 ">{{$select.selected.name}}</ui-select-match>
	           <ui-select-choices repeat="item in types | filter: $select.search">
	             <div ng-bind-html="item.name | highlight: $select.search"></div>
	           </ui-select-choices>
	        </ui-select>
        </div>
		<div class="col-xs-4">
			<ui-select ng-model="levels.selected">
	           <ui-select-match placeholder="选择级别 ">{{$select.selected.name}}</ui-select-match>
	           <ui-select-choices repeat="item in levels | filter: $select.search">
	             <div ng-bind-html="item.name | highlight: $select.search"></div>
	           </ui-select-choices>
	        </ui-select>
        </div>
        <form class="form-floating">
			<div class="col-sm-6">
	        	<div class="form-group">
	              <label class="control-label">标题</label>
	              <input type="text" class="form-control" data-ng-model="earlyWarnTitle">
	            </div>
			</div>
			<div class="col-xs-12">
	            <div class="form-group">
	              <label class="control-label">说明</label>
	              <textarea class="form-control vertical" data-ng-model="earlyWarnTxt"></textarea>
	              <span class="help-block">简单描述天气预警信息</span>
	            </div>
			</div>
		</form>
		<div class="col-xs-12">
			<div class="form-group">
            	<button type="button" data-ng-click="releaseWeatherWarn()" class="btn btn-primary pull-right">发布</button>
            </div>
		</div>
	</div>
</section>