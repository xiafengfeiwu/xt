<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="modal" tabindex="-1" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-ng-click="$hide()">&times;</button>
        <h4 class="modal-title">{{ pumpd.base.pumpName }} - 天气信息</h4>
      </div>
      <div class="modal-body">
      	<blockquote style="font-size: 12.68px;line-height: 34px;margin: 0 0 1px;border-left:0px solid rgba(255, 255, 255, 0)">
	      	<div class="row">
				<div class="col-xs-12">
					<div style="text-align:center;font-size: 16px;margin-top: -12px;">{{pumpd.weather.condTxt}} <img alt="{{pumpd.weather.condTxt}}" width="24px" data-ng-src="{{pumpd.weather.condCodeUrl}}"/></div>
				</div>
				<div class="col-xs-6">
					<div class="item-label">天气温度：</div>{{pumpd.weather.tmp}} ℃
				</div>
				<div class="col-xs-6">
					<div class="item-label">体感温度：</div>{{pumpd.weather.fl}} ℃
				</div>
				<div class="col-xs-6">
					<div class="item-label">相对湿度：</div>{{pumpd.weather.hum}} %
				</div>
				<div class="col-xs-6">
					<div class="item-label">降雨量：</div>{{pumpd.weather.pcpn}} mm
				</div>
				<div class="col-xs-6">
					<div class="item-label">气压：</div>{{pumpd.weather.pres}} hPa
				</div>
				<div class="col-xs-6">
					<div class="item-label">能见度：</div>{{pumpd.weather.vis}} km
				</div>
				<div class="col-xs-6">
					<div class="item-label">风向：</div>{{pumpd.weather.windDir}}
				</div>
				<div class="col-xs-6">
					<div class="item-label">风力：</div>{{pumpd.weather.windSc}} <span data-ng-if="pumpd.weather.windSc!='微风'">级</span>
				</div>
				<div data-ng-if="pumpd.weatherAlarm">
					<div class="col-xs-12">
						<div style="color:red;text-align:center;font-size: 16px;margin-top: 12px;">{{pumpd.weatherAlarm.earlyWarnTitle}}</div>
					</div>
					<div class="col-xs-6">
						<div class="item-label">预警类别：</div>{{pumpd.weatherAlarm.earlyWarnType}}
					</div>
					<div class="col-xs-6">
						<div class="item-label">预警级别：</div>{{pumpd.weatherAlarm.earlyWarnLevel}}
					</div>
					<div class="col-xs-6">
						<div class="item-label">预警状态：</div>{{pumpd.weatherAlarm.earlyWarnStat}}
					</div>
					<div class="col-xs-6">
						<div class="item-label">发布时间：</div>{{pumpd.weatherAlarm.earlyWarnTime | date: "yyyy-MM-dd"}}
					</div>
					<div class="col-xs-12">
						<div class="item-label">预警说明：</div>{{pumpd.weatherAlarm.earlyWarnTxt}}
					</div>
				</div>
			</div>
		</blockquote>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-ng-click="$hide()">关闭</button>
      </div>
    </div>
  </div>
</div>
