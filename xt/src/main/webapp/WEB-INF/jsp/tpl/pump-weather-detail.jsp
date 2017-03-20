<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="modal" tabindex="-1" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" ng-click="$hide()">&times;</button>
        <h4 class="modal-title">{{ pumpd.base.pumpName }} - 天气信息</h4>
      </div>
      <div class="modal-body">
      	<blockquote style="font-size: 12.68px;line-height: 34px;margin: 0 0 1px;border-left:0px solid rgba(255, 255, 255, 0)">
	      	<div class="row">
				<div class="col-xs-6">
					<div class="item-label">天气：</div>{{pumpd.weather.condTxt}}
				</div>
				<div class="col-xs-6">
					<div class="item-label">温度：</div>{{pumpd.weather.fl}} ℃
				</div>
			</div>
		</blockquote>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" ng-click="$hide()">关闭</button>
      </div>
    </div>
  </div>
</div>
