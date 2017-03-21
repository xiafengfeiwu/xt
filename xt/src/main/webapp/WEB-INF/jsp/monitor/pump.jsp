<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<section class="forms-basic" ng-controller="PumpController">
	<div class="row m-b-40">
		<div class="col-xs-12 col-sm-3 well white"ng style="overflow: auto;">
			<h5><i class="md md-location-city"></i> 区域/热泵</h5>
			<ul id="myPumpTree" class="ztree"></ul>
		</div>
		<div class="col-xs-12 col-sm-9 todo-app">
			<div class="well no-padding white text-center" ng-show="!showPumpInfo">
				<img id="loopImg" style="width: 128px;margin: 56px auto 10px" src="assets/img/loop.png">
				<p id="loopText" style="height: 42px;line-height: 42px;font-size: 14px;font-weight: bold;color: #686868;margin-bottom: 56px">请选择一个热泵节点</p>
			</div>
			<div class="well white filters" ng-show="showPumpInfo">
				<div class="btn-group" role="group">
					<button class="btn btn-link filter ng-binding ng-scope"
						ng-click="changeTab('base')"
						ng-class="{true: 'active', false: ''}[tabFlag=='base']">
						基本信息
						<div class="ripple-wrapper"></div>
					</button>
					<button class="btn btn-link filter ng-binding ng-scope"
						ng-click="changeTab('monitor')"
						ng-class="{true: 'active', false: ''}[tabFlag=='monitor']">
						实时监控
						<div class="ripple-wrapper"></div>
					</button>
					<button class="btn btn-link filter ng-binding ng-scope"
						ng-click="changeTab('monitor-history')"
						ng-class="{true: 'active', false: ''}[tabFlag=='monitor-history']">
						历史数据
						<div class="ripple-wrapper"></div>
					</button>
					<button class="btn btn-link filter ng-binding ng-scope"
						ng-click="changeTab('eser')"
						ng-class="{true: 'active', false: ''}[tabFlag=='eser']">
						耗能减排
						<div class="ripple-wrapper"></div>
					</button>
				</div>
				
				<div class="pull-right">
          			<button ng-show="tabFlag=='base'" class="btn btn-round-sm btn-link ng-scope" bs-tooltip data-title="更新定位" ng-click="getLocation(pumpd.base)">
          				<i class="md md-pin-drop"></i>
          			</button>
          			<button class="btn btn-round-sm btn-link ng-scope" bs-tooltip data-title="刷新" ng-click="refreshPump(pumpd.base.pumpId)">
          				<i class="md md-autorenew"></i>
          			</button>
				</div>
			</div>
			<div class="well no-padding white" ng-show="showPumpInfo">
			
				<blockquote ng-show="tabFlag=='base' || showAll" style="font-size: 12.68px;line-height: 34px;margin: 0 0 1px;border-left:0px solid rgba(255, 255, 255, 0)">
					<div class="row">
						<div class="col-xs-12">
							<h5><i class="md md-chevron-right"></i> 基本信息</h5>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-6">
							<div class="item-label">热泵名称：</div>{{pumpd.base.pumpName}}
						</div>
						<div class="col-xs-6">
							<div class="item-label">热泵编码：</div>{{pumpd.base.pumpCode}}
						</div>
						<div class="col-xs-6">
							<div class="item-label">序列号：</div>{{pumpd.base.pumpSn}}
						</div>
						<div class="col-xs-6">
							<div class="item-label">安装日期：</div>{{pumpd.base.installDate | date:"yyyy-MM-dd"}}
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12">
							<div class="pull-right">
								<div class="btn btn-round-sm btn-link ng-scope" data-ng-click="showPumpProductDetail()" data-bs-tooltip data-title="产品详情"><i class="md md-info-outline"></i></div>
							</div>
							<h5><i class="md md-chevron-right"></i> 产品信息</h5>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-6">
							<div class="item-label">产品名称：</div>{{pumpd.deviceProduct.productName}}
						</div>
						<div class="col-xs-6">
							<div class="item-label">规格型号：</div>{{pumpd.deviceProduct.productSpec}}
						</div>
						<div class="col-xs-6">
							<div class="item-label">设备厂家：</div>{{pumpd.deviceVender.venderName}}
						</div>
						<div class="col-xs-6">
							<div class="item-label">厂家联系人：</div>{{pumpd.deviceVender.venderContacts}}
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12">
							<h5><i class="md md-chevron-right"></i> 项目信息</h5>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-6">
							<div class="item-label">所属项目：</div>{{pumpd.project.projectName}}
						</div>
						<div class="col-xs-6">
							<div class="item-label">热泵业主：</div>{{pumpd.project.ownerName}}
						</div>
						<div class="col-xs-6">
							<div class="item-label">业主类型：</div>{{pumpd.project.ownerType}}
						</div>
						<div class="col-xs-6">
							<div class="item-label">联系方式：</div>{{pumpd.project.ownerPhoneNo}}
						</div>
						<div class="col-xs-6">
							<div class="item-label">供暖温度：</div>{{pumpd.project.heatingTemp}} ℃
						</div>
						<div class="col-xs-6">
							<div class="item-label">供暖面积：</div>{{pumpd.project.heatingArea}} ㎡
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12">
							<h5><i class="md md-chevron-right"></i> 地址信息</h5>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12">
							<div class="item-label">项目地址：</div>{{pumpd.project.projectAddress}}
						</div>
					</div>
					<div class="row" ng-show="showPumpMap" style="margin-top: 14px;">
						<div class="col-xs-12" style="height: 268px;background: rgb(245,243,240);">
							<div style="width:100%;height:100%;border:none;font-size:12px;overflow: hidden;" id="pumpd-map"></div>
						</div>
					</div>
					<div class="row" ng-show="!showPumpMap" style="margin-top: 14px;">
						<div class="col-xs-12 well">
							<div style="color:red">未设置经纬度</div>
						</div>
					</div>
				</blockquote>
				
				<blockquote ng-show="tabFlag=='monitor' || showAll" style="font-size: 12.68px;line-height: 34px;margin: 0 0 1px;text-align: left;border-left:0px solid rgba(255, 255, 255, 0)">
					<div class="row">
						<div class="col-xs-12">
							<div class="pull-right">
								<div class="btn btn-round-sm btn-link ng-scope" data-ng-click="showPumpWeatherDetail()" data-bs-tooltip data-title="天气"> <img style="width:26px" data-ng-if="!pumpd.weatherAlarm" alt="{{pumpd.weather.condTxt}}" data-ng-src="{{pumpd.weather.condCodeUrl}}"> <i data-ng-if="pumpd.weatherAlarm" class="md md-warning"></i> </div>
							</div>
							<h5><i class="md md-chevron-right"></i> 实时监控</h5>
						</div>
					</div>
					<div class="row m-b-40">
						<div class="col-sm-12 text-center">
							<img id="radiatorIcon" src="assets/img/pump-work-simple-v2.png" style="display: none" />
							<canvas id="myCanvas" width="649" height="398" style="margin: auto;"></canvas>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12">
							<h5><i class="md md-chevron-right"></i> 告警组
								<div class="pull-right" style="margin-top: -8px;">
         							<button type="button" data-ng-click="showPumpWarnAdd(pumpd.base.pumpId)" class="btn btn-round-sm btn-link ng-scope" data-placement="left" data-bs-tooltip data-title="新增告警组">
         								<i class="md md-add"></i>
         							</button>
         						</div>
         					</h5>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12">
							<div class="card">
						        <div class="list-group" data-ng-repeat="(key, warnGroup) in pumpd.warnGroup">
						          <a href="javascript:;" ng-click="showPumpWarnGroupItems(warnGroup.groupId)" class="list-group-item">
						          	<h4 class="list-group-item-heading">{{ warnGroup.groupName }}</h4>
						            <p class="list-group-item-text">{{ warnGroup.groupDescript }}</p>
						          </a>
						        </div>
							</div>
						</div>
					</div>
					<div class="row" data-ng-if="false">
						<div class="col-xs-12">
							<h5><i class="md md-chevron-right"></i> 监测控制</h5>
						</div>
					</div>
					<div class="row" data-ng-if="false">
						<div class="col-sm-12 text-center">
							<div class="row gutter-14 kpi-dashboard">
								
								<div class="col-xs-4">
									<div class="green lighten-1 p-10">
					                	<h4 class="no-margin white-text f14">设置温度</h4>
					             	</div>
									<div class="card">
										<div class="p-10">25 ℃</div>
									</div>
								</div>
								
								<div class="col-xs-4">
									<div class="green lighten-1 p-10">
					                	<h4 class="no-margin white-text f14">工作模式</h4>
					             	</div>
									<div class="card">
										<div class="p-10">制热</div>
									</div>
								</div>
								
								<div class="col-xs-4">
									<div class="green lighten-1 p-10">
					                	<h4 class="no-margin white-text f14">采集时间</h4>
					             	</div>
									<div class="card">
										<div class="p-10">2017-03-15 13:43:26</div>
									</div>
								</div>
								
							</div>
						</div>
					</div>
				</blockquote>
				
				<blockquote ng-show="tabFlag=='eser' || showAll" style="font-size: 12.68px;line-height: 34px;margin: 0 0 1px;border-left:0px solid rgba(255, 255, 255, 0)">
					<div class="row">
						<div class="col-xs-12">
							<h5>耗能减排</h5>
						</div>
					</div>
					<div class="row m-b-40">
						<div class="col-sm-12 text-center">
							<div>
								<div id="hn_container_hour" style="width: 100%; height: 320px"></div>
							</div>
						</div>
					</div>
				</blockquote>
				
				<blockquote ng-show="tabFlag=='monitor-history' || showAll" style="font-size: 12.68px;line-height: 34px;margin: 0 0 1px;border-left:0px solid rgba(255, 255, 255, 0)">
					<div class="row">
						<div class="col-xs-12">
							<h5>历史数据</h5>
						</div>
					</div>
				
				</blockquote>
			</div>
		</div>
	</div>
</section>
