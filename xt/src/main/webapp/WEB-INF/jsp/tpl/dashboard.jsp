<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="dashboard grey lighten-3" data-ng-controller="DashboardController">
	<div class="row no-gutter">
		<div class="col-sm-12 col-md-12 col-lg-12">
			<div id="m-map" style="width: 100%; height: 1px;"></div>
			<div data-title="刷新数据" data-placement="left" data-bs-tooltip style="position:absolute;bottom:10px;right:10px;width:42px;height:42px;border:1px solid #ccc;background-color:hsla(0,0%,100%,.8);z-index:9999;">
				<button id="refreshMapDataBtn" data-ng-click="refreshMapData()" class="dropdown-toggle pointer btn btn-round-sm btn-link">
		          <i class="md md-refresh f20"></i>
		        </button>
			</div>
			<div data-ng-show="pumpBaseInfo" style="position:absolute;top:10px;left:10px;width:280px;height:10.5pc;border:1px solid #ccc;background-color:hsla(0,0%,100%,.8);z-index:9999;font-size:9pt;padding:12px;line-height:22px;">
				<button data-ng-click="hidePumpBaseInfoBox()" class="dropdown-toggle pointer btn btn-round-sm btn-link pull-right">
		          <i class="md md-clear f20"></i> 
		        </button>
				<h6>{{pumpBaseInfo.pumpName}} ({{pumpBaseInfo.status}})</h6>
				<table style="width: 100%">
					<tr>
						<td>回水温度：{{pumpBaseInfo.backWaterTemp || '-'}} ℃</td>
						<td>出水温度：{{pumpBaseInfo.outWaterTemp || '-'}} ℃</td>
					</tr>
					<tr>
						<td>回气温度：{{pumpBaseInfo.backAirTemp || '-'}} ℃</td>
						<td>排气温度：{{pumpBaseInfo.outAirTemp || '-'}} ℃</td>
					</tr>
					<tr>
						<td>压缩机电流：{{pumpBaseInfo.compressorCurrent || '-'}} A</td>
						<td>告警代码：{{pumpBaseInfo.warnCode || '-'}}</td>
					</tr>
					<tr>
						<td colspan="2">
							<p style="color:#ccc;line-height: 42px;">
								<i class="md md-timer"></i> {{(pumpBaseInfo.collectTime | date:'yyyy-MM-dd HH:mm:ss') || '无采集数据'}}
								<button data-ng-show="pumpBaseInfo.pumpId" type="button" class="btn btn-link btn-round pull-right" data-title="监控详情" data-ng-click="toPumpMonitor(pumpBaseInfo.pumpId)" style="width:42px;height: 42px; line-height: 42px;" data-placement="left" data-bs-tooltip>
									<i class="md md-laptop-chromebook"></i>
								</button>
							</p>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</div>