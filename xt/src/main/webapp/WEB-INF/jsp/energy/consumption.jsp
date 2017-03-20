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
				<input ng-show="tabFlag=='hour'" type="text" id="currentDate"
					class="form-control ng-valid text-center"
					style="cursor: pointer; width: 240px; color: #F44336"
					ng-model="currentDate" data-date-format="yyyy年MM月dd日"
					data-max-date="today" data-use-native=true data-autoclose=true
					bs-datepicker="" required> <input ng-show="tabFlag=='day'"
					type="text" class="form-control ng-valid text-center"
					style="cursor: pointer; width: 240px; color: #F44336"
					ng-model="currentDate" data-date-format="yyyy年MM月"
					data-max-date="today" data-use-native=true data-autoclose=true
					bs-datepicker="" required> <input
					ng-show="tabFlag=='month'" type="text"
					class="form-control ng-valid text-center"
					style="cursor: pointer; width: 240px; color: #F44336"
					ng-model="currentDate" data-date-format="yyyy年"
					data-max-date="today" data-use-native=true data-autoclose=true
					bs-datepicker="" required>
				<button class="btn btn-link pull-right" onclick="reload()"
					style="margin-top: -36px;">查询</button>
			</div>
			<div ng-show="tabFlag=='hour'">
				<div class="well white" style="margin: 10px auto">
					当日累计用电量：12.32kWh， 预计电费为：12.32 元。
				</div>
				<div id="container_hour" style="width: 100%; height: 320px"></div>
			</div>
			<div ng-show="tabFlag=='day'">
				<div class="well white" style="margin: 10px auto">
					当月累计用电量：382.32kWh， 预计电费为：382.32 元。
				</div>
				<div id="container_day" style="width: 100%; height: 320px"></div>
			</div>
			<div ng-show="tabFlag=='month'">
				<div class="well white" style="margin: 10px auto">
					当年累计用电量：4587.84kWh， 预计电费为：4587.84 元。
				</div>
				<div id="container_month" style="width: 100%; height: 320px"></div>
			</div>
			<div ng-show="tabFlag=='year'">
				<div class="well white" style="margin: 10px auto">
					总用电量：7150.84kWh， 预计电费为：7150.84 元。
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
		
		var hourData = {
			title:'分时耗电 （kWh）',
			axis : [ '00点', '01点', '02点', '03点', '04点', '05点', '06点', '07点', '08点',
					'09点', '10点', '11点', '12点', '13点', '14点', '15点', '16点',
					'17点', '18点', '19点', '20点', '21点', '22点', '23点'],
			// data : [ 15,15,15,15,16,16,16,17,17,18,18,19,20,21,22,22,23,24,24,25,25,25,26,26]
			data : []
		}
		
		for(var i=0;i<24;i++) {
			hourData.data[i] = 20 + Math.floor(Math.random()*3);
		}
		
		var dayData = {
			title : '每日耗电（kWh）',
			axis : [ '01日', '02日', '03日', '04日', '05日', '06日', '07日', '08日',
					'09日', '10日', '11日', '12日', '13日', '14日', '15日', '16日',
					'17日', '18日', '19日', '20日', '21日', '22日', '23日', '24日',
					'25日', '26日', '27日', '28日', '29日', '30日', '31日' ],
			// data : [220, 182, 191, 234, 290, 330, 310, 123, 442, 321, 90, 149, 210, 122, 133, 334, 198, 123, 125, 220, 210, 122, 133, 334, 198, 234, 290, 330, 310, 123, 123]
			data : [ ]
		};
		
		for(var i=0;i<31;i++) {
			dayData.data[i] = 120 + Math.floor(Math.random()*50);
		}
		
		var monthData = {
			title : '每月耗电（kWh）',
			axis : [ '01月', '02月', '03月', '04月', '05月', '06月', '07月', '08月',
					'09月', '10月', '11月', '12月' ],
			// data : [ 520, 682, 591, 534, 590, 530, 510, 523, 542, 521, 590, 549 ]
			data : []
		};
		
		for(var i=0;i<12;i++) {
			monthData.data[i] = 1000 + Math.floor(Math.random()*200);
		}
		
		var yearData = {
			title : '每年耗电（kWh）',
			axis : [ '2015年', '2016年', '2017年' ],
			data : [ 12200, 11800, 11901 ]
		};
		
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
		
		hourChart.setOption(initLineOption(hourData), true);
		dayChart.setOption(initOption(dayData), true);
		monthChart.setOption(initOption(monthData), true);
		yearChart.setOption(initOption(yearData), true);
		

		var currentDate = '';
		
		setTimeout(function(){
			currentDate = document.getElementById("currentDate").value
		}, 200)
		
		var reload = function(){
			if(document.getElementById("currentDate").value == currentDate) {
				return;
			} else {
				currentDate = document.getElementById("currentDate").value;
			}
			
			for(var i=0;i<24;i++) {
				hourData.data[i] = 20 + Math.floor(Math.random()*3);
			}
			
			for(var i=0;i<31;i++) {
				dayData.data[i] = 120 + Math.floor(Math.random()*50);
			}
			
			for(var i=0;i<12;i++) {
				monthData.data[i] = 1000 + Math.floor(Math.random()*200);
			}
			
			hourChart.setOption(initLineOption(hourData), true);
			dayChart.setOption(initOption(dayData), true);
			monthChart.setOption(initOption(monthData), true);
			yearChart.setOption(initOption(yearData), true);
		}
</script>