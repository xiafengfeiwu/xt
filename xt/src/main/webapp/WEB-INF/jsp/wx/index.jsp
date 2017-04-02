<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html data-ng-app="wxApp" data-ng-controller="wxCtrl">
<head>
<title data-ng-bind="title">Loadding...</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,user-scalable=0">
<link rel="stylesheet" href="../assets/wx/weui.min.css">
<link rel="stylesheet" href="../assets/wx/page.min.css">
</head>
<body>
	<div style="width: 100%;height: 100%" class="fad" data-ng-view></div>
	<input type="hidden" name="userId" value="${userId }">

	<script src="//cdn.bootcss.com/zepto/1.1.7/zepto.min.js"></script>
	
	<script src="//res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
	<script src="//res.wx.qq.com/open/libs/weuijs/1.0.0/weui.min.js"></script>

	<script src="//cdn.bootcss.com/angular.js/1.6.3/angular.min.js"></script>
	<script src="//cdn.bootcss.com/angular.js/1.6.3/angular-animate.min.js"></script>
	<script src="//cdn.bootcss.com/angular.js/1.6.3/angular-route.min.js"></script>
	
	<script src="//cdn.bootcss.com/echarts/3.5.0/echarts.common.min.js"></script>

	<script src="../assets/wx/app.js?v=1.0.0"></script>
	<script src="../assets/js/wx.app.min.js?v=1.0.0"></script>

</body>
</html>