<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="aside bs-docs-aside" tabindex="-1" role="dialog">
  <div class="close">
    <div class="btn btn-round btn-info" ng-click="$hide()"><i class="md md-close"></i></div>
  </div>
  <div class="aside-dialog">
  	<div class="p-10" style="margin: 0">
  		&nbsp;当前经纬度：（<span ng-bind="local.lng"></span>, <span ng-bind="local.lat"></span>）
  		<button class="btn btn-link ng-scope" ng-click="setLocation()">
			<i class="md md-done"></i> 提交
		</button>
  	</div>
    <div class="aside-body bs-sidebar" id="select-location-map">
     </div>
  </div>
</div>