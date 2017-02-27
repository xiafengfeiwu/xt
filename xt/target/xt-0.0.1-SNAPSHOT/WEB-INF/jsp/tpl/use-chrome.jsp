<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="alert" ng-class="[type ? 'alert-' + type : null]">
  <button type="button" class="close" ng-click="$hide()">&times;</button>
  <div class="strong" ng-bind="title"></div>
  <div ng-bind-html="content"></div>

  <div class="row m-t-20 m-b-10">
    <div class="col-xs-3 text-center">
      <img src="assets/img/chrome_icon_64x64.png">
    </div>
    <div class="col-xs-9">
      <div class="strong">下载</div>
      <p>
      	点击<a href="http://sw.bos.baidu.com/sw-search-sp/software/1c5131aea1842/ChromeStandalone_56.0.2924.87_Setup.exe" target="_blank"> 此处 </a>或下面的链接下载谷歌浏览器<br/>
      	<a href="http://sw.bos.baidu.com/sw-search-sp/software/1c5131aea1842/ChromeStandalone_56.0.2924.87_Setup.exe" target="_blank">http://rj.baidu.com/soft/detail/14744.html</a>
      </p>
    </div>
  </div>
  <div class="row">
    <div class="col-xs-11 col-sm-offset-1">
    	<input type="checkbox" class="relative" ng-click="noShowUseChromeNotify()"> 不再显示
    </div>
  </div>
</div>