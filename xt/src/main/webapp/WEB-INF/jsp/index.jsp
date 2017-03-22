<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" ng-app="materialism" ng-class="{'full-page-map': isFullPageMap}">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="热泵在线">
  <meta name="author" content="Si ZhongXIa">
  <meta name="msapplication-TileColor" content="#9f00a7">
  <meta name="theme-color" content="#ffffff">
  <title ng-bind="(pageTitle||'loading...') + '-热泵在线 '"></title>
  <link rel="stylesheet" href="assets/css/vendors.min.css">
  <link rel="stylesheet" href="assets/css/styles.min.css">
  <link rel="stylesheet" href="assets/pulgins/ztree/css/metroStyle/metroStyle.css">
  <link rel="stylesheet" href="assets/pulgins/angular-tree/css/tree-control.css">
  <link rel="stylesheet" href="assets/pulgins/angular-tree/css/tree-control-attribute.css">
  <!--[if lt IE 9]>
  <script src="//oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="//oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
  <style type="text/css">
  	#spinner{position:absolute;top:50%;left:50%;margin:-30px -25px;width:50px;height:60px;text-align:center;font-size:10px}#spinner>div{display:inline-block;width:6px;height:100%;background-color:#67cf22;-webkit-animation:stretchdelay 1.2s infinite ease-in-out;animation:stretchdelay 1.2s infinite ease-in-out}#spinner .rect2{-webkit-animation-delay:-1.1s;animation-delay:-1.1s}#spinner .rect3{-webkit-animation-delay:-1s;animation-delay:-1s}#spinner .rect4{-webkit-animation-delay:-.9s;animation-delay:-.9s}#spinner .rect5{-webkit-animation-delay:-.8s;animation-delay:-.8s}@-webkit-keyframes stretchdelay{0%,40%,to{-webkit-transform:scaleY(.4)}20%{-webkit-transform:scaleY(1)}}@keyframes stretchdelay{0%,40%,to{-webkit-transform:scaleY(.4);transform:scaleY(.4)}20%{-webkit-transform:scaleY(1);transform:scaleY(1)}}.anchorBL{display:none}.item-label{display:inline-block;width:90px;text-align:right}@-webkit-keyframes rotation{0%{-webkit-transform:rotate(0deg)}to{-webkit-transform:rotate(360deg)}}.rotation{-webkit-transform:rotate(360deg);animation:rotation 3s linear infinite;-moz-animation:rotation 3s linear infinite;-webkit-animation:rotation 3s linear infinite;-o-animation:rotation 3s linear infinite}
  </style>
</head>
<body ng-controller="MainController" scroll-spy id="top" ng-class="[theme.template, theme.color]">
  <div id="spinner" ng-show="loading"><div class="rect1"></div>&nbsp;<div class="rect2"></div>&nbsp;<div class="rect3"></div>&nbsp;<div class="rect4"></div>&nbsp;<div class="rect5"></div></div>
  <main>
    <div ng-include src="'tpl/sidebar.jspx'"></div>
    <div class="main-container">
      <div ng-include src="'tpl/topnav.jspx'"></div>
      <div class="main-content" autoscroll="true" ng-cloak ng-view bs-affix-target></div>
    </div>
  </main>
  <!--[if lt IE 10 ]>
  <script>
    var browser_old = true;
  </script>
  <![endif]-->
  <script src="//cdn.bootcss.com/jquery/2.1.4/jquery.min.js"></script>
  <script src="assets/js/vendors.min.js"></script>
  <script src="assets/js/app.min.js"></script>
  <script src="assets/js/controller.min.js"></script>
  <script src="assets/pulgins/angular-tree/angular-tree-control.js"></script>
  <script src="//cdn.bootcss.com/layer/3.0/layer.min.js"></script>
  <!--//api.map.baidu.com/api?v=2.0&ak=ZUONbpqGBsYGXNIYHicvbAbM" -->
  <script src="//api.map.baidu.com/getscript?v=2.0&ak=ZUONbpqGBsYGXNIYHicvbAbM&services=&t=20170314113503"></script>
  <script src="assets/pulgins/echarts/echarts.min.js"></script>
  <script src="assets/pulgins/echarts/bmap.js"></script>
  <script src="assets/pulgins/jcanvas/jcanvas.min.js"></script>
  <script src="assets/pulgins/ztree/jquery.ztree.core.min.js"></script>
  <script type="text/javascript" src="assets/pulgins/nicedit/nicEdit.js"></script>
</body>
</html>