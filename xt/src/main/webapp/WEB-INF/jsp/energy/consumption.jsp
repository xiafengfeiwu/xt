<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<section class="forms-basic" ng-controller="ConsumptionController">
	<div class="page-header">
		<h1>
			用电耗能
		</h1>
		<p class="lead">此处展示的是热泵运行消耗的电量展示，可以按日用电，月用电，年用电视图分析用电量。</p>
	</div>
	<div class="row m-b-40 todo-app">



		<div class="col-md-12 filters well">

			<div class="btn-group" role="group">
				<button class="btn btn-link filter ng-binding ng-scope"
					ng-click="changeTab('hour')"
					ng-class="{true: 'active', false: ''}[tabFlag=='hour']">
					日统计
					<div class="ripple-wrapper"></div>
				</button>
				<button class="btn btn-link filter ng-binding ng-scope"
					ng-click="changeTab('day')"
					ng-class="{true: 'active', false: ''}[tabFlag=='day']">
					月统计
					<div class="ripple-wrapper"></div>
				</button>
				<button class="btn btn-link filter ng-binding ng-scope"
					ng-click="changeTab('month')"
					ng-class="{true: 'active', false: ''}[tabFlag=='month']">
					年统计
					<div class="ripple-wrapper"></div>
				</button>
				<button class="btn btn-link filter ng-binding ng-scope"
					ng-click="changeTab('year')"
					ng-class="{true: 'active', false: ''}[tabFlag=='year']">
					总统计
					<div class="ripple-wrapper"></div>
				</button>
			</div>
			<div class="pull-right"
				style="width: 300px; height: 37px; overflow: hidden;">
				<input type="text" id="currentDate"
					class="form-control ng-valid text-center"
					style="cursor: pointer; width: 240px; color: #F44336" data-date-format="yyyy-MM-dd" data-ng-model="currentDate"
					data-max-date="today" data-min-date="2015-1-1" data-use-native=true data-autoclose=true
					data-bs-datepicker="" required>
				<button class="btn btn-link pull-right" onclick="loadConsumptionData()"
					style="margin-top: -36px;">查询</button>
			</div>
			<div ng-show="tabFlag=='hour'">
				<div class="well white" style="margin: 10px auto">
					当日累计用电量：<span id="dayT">0.00</span>kWh， 预计电费为：<span id="dayH">0.00</span>元。
				</div>
				<div id="container_hour" style="width: 100%; height: 320px"></div>
			</div>
			<div ng-show="tabFlag=='day'">
				<div class="well white" style="margin: 10px auto">
					当月累计用电量：<span id="monthT">0.00</span>kWh， 预计电费为：<span id="monthH">0.00</span>元。
				</div>
				<div id="container_day" style="width: 100%; height: 320px"></div>
			</div>
			<div ng-show="tabFlag=='month'">
				<div class="well white" style="margin: 10px auto">
					当年累计用电量：<span id="yearT">0.00</span>kWh， 预计电费为：<span id="yearH">0.00</span>元。
				</div>
				<div id="container_month" style="width: 100%; height: 320px"></div>
			</div>
			<div ng-show="tabFlag=='year'">
				<div class="well white" style="margin: 10px auto">
					总用电量：<span id="allT">0.00</span>kWh， 预计电费为：<span id="allH">0.00</span>元。
				</div>
				<div id="container_year" style="width: 100%; height: 320px"></div>
			</div>
		</div>
	</div>
</section>

<script type="text/javascript">

		var hourChart = echarts.init(document.getElementById("container_hour"));
		var dayChart = echarts.init(document.getElementById("container_day"));
		var monthChart = echarts.init(document.getElementById("container_month"));
		var yearChart = echarts.init(document.getElementById("container_year"));
		
		function initLineOption(data) {
			return {
			    title: {
			        text: data.title,
					x : 'center'
			    },
			    tooltip: {
			        trigger: 'axis'
			    },
				grid : {
					x : 42,
					y : 46,
					x2 : 66,
					y2 : 24
				},
			    xAxis: {
			        type: 'category',
			        boundaryGap: false,
			        data: data.axis
			    },
			    yAxis: {
			        type: 'value'
			    },
			    series: [
			        {
			            name:'当前用电量',
			            type:'line',
			            data:data.data
			        }
			    ]
			}
		}
		
		function initOption(data) {
			return {
				title : {
					text : data.title,
					x : 'center'
				},
				xAxis : {
					data : data.axis,
					axisLabel : {
						inside : false,
						textStyle : {
							color : '#484848'
						}
					},
					z : 10
				},
				yAxis : {
					axisLabel : {
						textStyle : {
							color : '#999'
						}
					}
				},
				grid : {
					x : 42,
					y : 46,
					x2 : 66,
					y2 : 24
				},
				tooltip : {
					trigger : 'item'
				},
				dataZoom : [ {
					type : 'inside'
				} ],
				series : [ {
					name : '用电量',
					type : 'bar',
					barWidth : 25,
					barMinHeight : 25,
					label : {
						normal : {
							show : true,
							position : 'end',
							textStyle : {
								color : '#000000'
							}
						}
					},
					itemStyle : {
						normal : {
							color : new echarts.graphic.LinearGradient(0, 0, 0,
									1, [ {
										offset : 0,
										color : '#FFE4C4'
									}, {
										offset : 0.5,
										color : '#F44336'
									}, {
										offset : 1,
										color : '#F44336'
									} ])
						},
						emphasis : {
							color : new echarts.graphic.LinearGradient(0, 0, 0,
									1, [ {
										offset : 0,
										color : '#EEEED1'
									}, {
										offset : 0.7,
										color : '#EECBAD'
									}, {
										offset : 1,
										color : '#EECBAD'
									} ])
						}
					},
					markLine : {
						data : [ {
							type : 'average',
							name : '平均值'
						} ]
					},
					data : data.data
				} ]
			};
		}
		
		
		var loadConsumptionData = function(){
			$.get("monitor/pump-ele-data.jspx?date=" + document.getElementById("currentDate").value, function(result){
				if(!result.success) {
					alert(result.message);
					return;
				}
				var hourData = {
					title:'分时耗电 （kWh）',
					axis : [ '00点', '01点', '02点', '03点', '04点', '05点', '06点', '07点', '08点', '09点', '10点', '11点', '12点', '13点', '14点', '15点', '16点', '17点', '18点', '19点', '20点', '21点', '22点', '23点'],
					data : result.days
				}
				
				var dayData = {
					title : '每日耗电（kWh）',
					axis : result.dayAxis,
					data : result.months
				};
				
				var monthData = {
					title : '每月耗电（kWh）',
					axis : [ '01月', '02月', '03月', '04月', '05月', '06月', '07月', '08月', '09月', '10月', '11月', '12月' ],
					data : result.years
				};
				
				var yearData = {
					title : '每年耗电（kWh）',
					axis : result.yearAxis,
					data : result.alls
				};

				$("#dayT").text(result.dayT);
				$("#dayH").text(result.dayH);
				$("#monthT").text(result.monthT);
				$("#monthH").text(result.monthH);
				$("#yearT").text(result.yearT);
				$("#yearH").text(result.yearH);
				$("#allT").text(result.allT);
				$("#allH").text(result.allH);
				
				hourChart.setOption(initLineOption(hourData), true);
				dayChart.setOption(initOption(dayData), true);
				monthChart.setOption(initOption(monthData), true);
				yearChart.setOption(initOption(yearData), true);
			});
		}

		setTimeout(function(){
			loadConsumptionData();
		}, 20)
</script>