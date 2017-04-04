<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<section class="cards" data-ng-controller="ConservationController">
	<div class="page-header">
		<h1>
			节能减排
		</h1>
		<p class="lead">展示根据耗电量进行换算计算出的各指标减排量和使用热泵相对其他采暖设备效能的对比分析。</p>
	</div>

	<div class="row well" style="margin-top: 18px;padding-top: 48px">
		<div class="col-sm-2 col-sm-offset-1">
			<div class="card">
				<div class="card-header" style="padding: 10px">
					<div class="card-title" style="font-size: 12px;">标准煤</div>
				</div>
				<div class="card-content">
					<div class="card-profile pull-right"
						style="margin-top: -75px; margin-right: -40px">
						<img src="assets/img/icons/icon-jn-bzm.png" alt="标准煤"
							style="width: 45px;">
					</div>
					<p class="text-center" style="white-space: nowrap">
						<span style="color: #F44336; font-size: 14px; font-weight: bold;"><span id="bzm_z">0</span>.<span style="font-size: 12px;" id="bzm_l">00</span></span>
					</p>
				</div>
			</div>
		</div>
		<div class="col-sm-2">
			<div class="card">
				<div class="card-header" style="padding: 10px">
					<div class="card-title" style="font-size: 12px;">粉尘量</div>
				</div>
				<div class="card-content">
					<div class="card-profile pull-right"
						style="margin-top: -75px; margin-right: -40px">
						<img src="assets/img/icons/icon-jn-yc.png" alt="粉尘量"
							style="width: 45px;">
					</div>
					<p class="text-center" style="white-space: nowrap">
						<span style="color: #F44336; font-size: 14px; font-weight: bold;"><span id="fc_z">0</span>.<span style="font-size: 12px;" id="fc_l">00</span></span>
					</p>
				</div>
			</div>
		</div>
		<div class="col-sm-2">
			<div class="card">
				<div class="card-header" style="padding: 10px">
					<div class="card-title" style="font-size: 12px;">二氧化碳</div>
				</div>
				<div class="card-content">
					<div class="card-profile pull-right"
						style="margin-top: -75px; margin-right: -40px">
						<img src="assets/img/icons/icon-jn-eyht.png" alt="二氧化碳"
							style="width: 45px;">
					</div>
					<p class="text-center" style="white-space: nowrap">
						<span style="color: #F44336; font-size: 14px; font-weight: bold;"><span id="co2_z">0</span>.<span style="font-size: 12px;" id="co2_l">00</span></span>
					</p>
				</div>
			</div>
		</div>
		<div class="col-sm-2">
			<div class="card">
				<div class="card-header" style="padding: 10px">
					<div class="card-title" style="font-size: 12px;">二氧化硫</div>
				</div>
				<div class="card-content">
					<div class="card-profile pull-right"
						style="margin-top: -75px; margin-right: -40px">
						<img src="assets/img/icons/icon-jn-eyhl.png" alt="二氧化硫"
							style="width: 45px;">
					</div>
					<p class="text-center" style="white-space: nowrap">
						<span style="color: #F44336; font-size: 14px; font-weight: bold;"><span id="so2_z">0</span>.<span style="font-size: 12px;" id="so2_l">00</span></span>
					</p>
				</div>
			</div>
		</div>
		<div class="col-sm-2">
			<div class="card">
				<div class="card-header" style="padding: 10px">
					<div class="card-title" style="font-size: 12px;">二氧化氮</div>
				</div>
				<div class="card-content">
					<div class="card-profile pull-right"
						style="margin-top: -75px; margin-right: -40px">
						<img src="assets/img/icons/icon-jn-eyhd.png" alt="二氧化氮"
							style="width: 45px;">
					</div>
					<p class="text-center" style="white-space: nowrap">
						<span style="color: #F44336; font-size: 14px; font-weight: bold;"><span id="nox_z">0</span>.<span style="font-size: 12px;" id="nox_l">00</span></span>
					</p>
				</div>
			</div>
		</div>
		<div class="col-sm-10 col-sm-offset-1">
			<p class="text-right lead">数值单位：(kg)</p>
		</div>
	</div>
	<div class="row well" style="margin-top: 18px">
		<div class="col-sm-10 col-sm-offset-1">
			<div id="container_pa" style="width: 100%; height: 320px"></div>
		</div>
	</div>
</section>


<script type="text/javascript">
	(function() {
		var paChart = echarts.init(document.getElementById("container_pa"));
		var baseVal = 21361.22;
		var paData = {
			title : '采暖设备耗能对比',
			axis : [ '空气源热泵', '燃煤锅炉', '天然气炉', '液化气锅炉', '电锅炉', '燃油锅炉' ],
			data : [ baseVal * 1, baseVal * 1.47, baseVal * 1.96,
					baseVal * 2.61, baseVal * 3.6, baseVal * 5.05 ]
		};
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
						show: false
					}
				},
			    toolbox: {
			        feature: {
			            saveAsImage: {
			                show : true,
			                title : '保存',
			                type : 'png',
			                lang : ['点击保存']
						}
			        }
			    },
				grid : {
					x : 5,
					y : 46,
					x2 : 0,
					y2 : 24
				},
				series : [ {
					name : '耗能',
					type : 'bar',
					barWidth : 25,
					barMinHeight : 25,
					itemStyle : {
						normal : {
							color : '#FFD4C4'
						},
						emphasis : {
							color : 'red'
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

		paChart.setOption(initOption(paData), true);
		
		$.get("monitor/pump-ele-constantly-data.jspx", function(result){
			$("#bzm_z").text(result.bzm[0]);
			$("#bzm_l").text(result.bzm[1]);
			$("#fc_z").text(result.fc[0]);
			$("#fc_l").text(result.fc[1]);
			$("#co2_z").text(result.co2[0]);
			$("#co2_l").text(result.co2[1]);
			$("#so2_z").text(result.so2[0]);
			$("#so2_l").text(result.so2[1]);
			$("#nox_z").text(result.nox[0]);
			$("#nox_l").text(result.nox[1]);
		});
	})()
</script>