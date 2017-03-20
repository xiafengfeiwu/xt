<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<section class="cards" data-ng-controller="WeatherSystemSetController">
	<div class="page-header">
		<h1>
			参数维护
		</h1>
		<p class="lead">管理员在此处可以更改“和风天气（http://www.heweather.com）”采集数据的Key值信息。</p>
	</div>
	<div class="row well white">
		<div class="col-sm-6">
        	<div class="form-group">
              <label class="control-label">Key1</label>
              <input type="text" class="form-control" data-ng-model="key1">
              <span class="help-block">获取天气基本信息的KEY</span>
            </div>
		</div>
		<div class="col-sm-6">
        	<div class="form-group">
              <label class="control-label">Key2</label>
              <input type="text" class="form-control" data-ng-model="key2">
              <span class="help-block">获取天气预警信息的KEY</span>
            </div>
		</div>
		<div class="col-xs-12">
			<div class="form-group">
            	<button type="button" data-ng-click="changeWeatherSystemSet()" class="btn btn-primary pull-right">更改</button>
            </div>
		</div>
		<p class="lead">两个Key来源两个和风天气官网账号，作用是相同的，账号注册地址：http://console.heweather.com/register。</p>
	</div>
</section>