<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
.BMap_cpyCtrl, .anchorBL, .BMapLabel{display:none;}
</style>
<div class="dashboard grey lighten-3" ng-controller="DashboardController">
	<div class="row no-gutter">
		<div class="col-sm-12 col-md-12 col-lg-12">
			<div id="m-map" style="width: 100%; height: 1px;">
			</div>
		</div>
	</div>
</div>
<script>
	var obj = document.getElementById("m-map");
	
	obj.style.height = document.body.clientHeight - 65 + 'px';
	window.onresize = function() {
		obj.style.height = document.body.clientHeight - 65 + 'px';
	}
	
	var myChart = echarts.init(obj);
	
	var data = [ {
		"id" : "6510323052117000",
		"name" : "热泵1",
		"value" : [ "116.403393", "39.923595", '#33CC99' ]
	}, {
		"id" : "6510323052117001",
		"name" : "热泵2",
		"value" : [ "116.303353", "39.903565", '#FC5D62' ]
	}, {
		"id" : "6510323052117002",
		"name" : "热泵3",
		"value" : [ "116.503353", "39.883565", '#F3A93E' ]
	} ];

	option = {
		tooltip : {
			trigger: 'item',
			enterable: true,
			formatter: function(val) {
				return val.name + " " + val.value[2]
			}
		},
		bmap : {
			center : [ 116.403851, 39.915194 ],
			zoom : 12,
			roam : true,
			mapStyle : {
				styleJson : [{
	                'featureType': 'water',
	                'elementType': 'all'
	            }, {
	                'featureType': 'land',
	                'elementType': 'all',
	                'stylers': {
	                    'color': '#f3f3f3'
	                }
	            }, {
	                'featureType': 'railway',
	                'elementType': 'all',
	                'stylers': {
	                    'visibility': 'off'
	                }
	            }, {
	                'featureType': 'highway',
	                'elementType': 'all',
	                'stylers': {
	                    'color': '#fdfdfd'
	                }
	            }, {
	                'featureType': 'highway',
	                'elementType': 'labels',
	                'stylers': {
	                    'visibility': 'on'
	                }
	            }, {
	                'featureType': 'arterial',
	                'elementType': 'geometry',
	                'stylers': {
	                    'color': '#fefefe'
	                }
	            }, {
	                'featureType': 'arterial',
	                'elementType': 'geometry.fill',
	                'stylers': {
	                    'color': '#fefefe'
	                }
	            }, {
	                'featureType': 'green',
	                'elementType': 'all',
	                'stylers': {
	                    'visibility': 'on'
	                }
	            }, {
	                'featureType': 'subway',
	                'elementType': 'all',
	                'stylers': {
	                    'visibility': 'off'
	                }
	            }, {
	                'featureType': 'manmade',
	                'elementType': 'all',
	                'stylers': {
	                    'color': '#d1d1d1'
	                }
	            }, {
	                'featureType': 'local',
	                'elementType': 'all',
	                'stylers': {
	                    'color': '#d1d1d1'
	                }
	            }, {
	                'featureType': 'arterial',
	                'elementType': 'labels',
	                'stylers': {
	                    'visibility': 'off'
	                }
	            }, {
	                'featureType': 'boundary',
	                'elementType': 'all',
	                'stylers': {
	                    'color': '#fefefe'
	                }
	            }, {
	                'featureType': 'building',
	                'elementType': 'all',
	                'stylers': {
	                    'color': '#d1d1d1'
	                }
	            }, {
	                'featureType': 'label',
	                'elementType': 'labels.text.fill',
	                'stylers': {
	                    'visibility': 'off'
	                }
	            }]
			}
		},
		series : [ {
			name : function(val) {
				return val.name;
			},
			type : 'effectScatter',
			coordinateSystem : 'bmap',
			data : data,
			symbolSize : function(val) {
				return 10;
			},
			showEffectOn : 'render',
			rippleEffect : {
				brushType : 'stroke'
			},
			hoverAnimation : true,
			label : {
				normal : {
					formatter : '{b}',
					position : 'right',
					show : true
				}
			},
			itemStyle : {
				normal : {
					color : function(val) {
						return val.value[2]
					},
					shadowBlur : 10,
					shadowColor : '#333'
				}
			},
			zlevel : 1
		} ]
	};
	myChart.setOption(option);
	myChart.on('click', function (val) {
		showPumpBaseInfo(val)
	});
	
	function showPumpBaseInfo(obj) {
		var appElement = document.querySelector('[ng-controller=DashboardController]'),
		$scope = angular.element(appElement).scope(); 
		$scope.baseInfo(obj.name);
		$scope.$apply();
	}

</script>