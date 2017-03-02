<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<section class="forms-basic" ng-controller="ReportController">
	<div class="page-header">
		<h1>
			<i class="md md-warn"></i> 用电耗能
		</h1>
		<p class="lead">此处展示的是热泵运行消耗的电量展示，可以按日用电，月用电，年用电视图分析用电量。</p>
	</div>
	<div class="row m-b-40">
	
		<div class="col-md-12 filters">
	      <div class="btn-group" role="group" aria-label="Filter todo's">
	        <button class="btn btn-default filter ng-binding ng-scope active">日统计<div class="ripple-wrapper"></div></button>
	        <button class="btn btn-default filter ng-binding ng-scope">月统计<div class="ripple-wrapper"></div></button>
	        <button class="btn btn-default filter ng-binding ng-scope">年统计<div class="ripple-wrapper"></div></button>
	      </div>
	    </div>
		<div class="col-sm-12 well">
			<div id="container_day" style="width: 100%; height: 500px"></div>
		</div>
		<div class="col-sm-12 well">
			<div id="container_month" style="width: 100%; height: 500px"></div>
		</div>
		<div class="col-sm-12 well">
			<div id="container_year" style="width: 100%; height: 500px"></div>
		</div>
	</div>
</section>

<script type="text/javascript">
	(function() {
		var dom = document.getElementById("container_day");
		var myChart = echarts.init(dom);
		var app = {};
		option = null;
		var dataAxis = [ '1', '2', '3', '4', '5', '6', '7', '8', '9', '10',
				'11', '12', '13', '14', '15', '16', '17', '18', '19', '20',
				'21', '22', '23', '24', '25', '26', '27', '28', '29', '30',
				'31' ];
		var data = [ 220, 182, 191, 234, 290, 330, 310, 123, 442, 321, 90, 149,
				210, 122, 133, 334, 198, 123, 125, 220, 210, 122, 133, 334,
				198, 234, 290, 330, 310, 123, 123 ];
		var yMax = 500;
		var dataShadow = [];

		for (var i = 0; i < data.length; i++) {
			dataShadow.push(yMax);
		}

		option = {
			xAxis : {
				data : dataAxis,
				axisLabel : {
					inside : true,
					textStyle : {
						color : '#fff'
					}
				},
				axisTick : {
					show : false
				},
				axisLine : {
					show : false
				},
				z : 10
			},
			yAxis : {
				axisLine : {
					show : false
				},
				axisTick : {
					show : false
				},
				axisLabel : {
					textStyle : {
						color : '#999'
					}
				}
			},
			dataZoom : [ {
				type : 'inside'
			} ],
			series : [
					{
						type : 'bar',
						itemStyle : {
							normal : {
								color : 'rgba(0,0,0,0.05)'
							}
						},
						barGap : '-100%',
						barCategoryGap : '40%',
						data : dataShadow,
						animation : false
					},
					{
						type : 'bar',
			            label: {
			                normal: {
			                    show: true,
			                    position: 'end',
			                    textStyle: {
			                    	color: '#000000'
			                    }
			                }
			            },
						itemStyle : {
							normal : {
								color : new echarts.graphic.LinearGradient(0,
										0, 0, 1, [ {
											offset : 0,
											color : '#83bff6'
										}, {
											offset : 0.5,
											color : '#188df0'
										}, {
											offset : 1,
											color : '#188df0'
										} ])
							},
							emphasis : {
								color : new echarts.graphic.LinearGradient(0,
										0, 0, 1, [ {
											offset : 0,
											color : '#2378f7'
										}, {
											offset : 0.7,
											color : '#2378f7'
										}, {
											offset : 1,
											color : '#83bff6'
										} ])
							}
						},
						data : data
					} ]
		};
		if (option && typeof option === "object") {
			myChart.setOption(option, true);
		}
	})()
</script>