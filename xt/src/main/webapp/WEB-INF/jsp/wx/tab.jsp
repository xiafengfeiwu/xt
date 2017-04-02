<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<a href="javascript:;" data-ng-click="gotoUrl('home')" class="home weui-tabbar__item" data-ng-class="{true: 'weui-bar__item_on', false: ''}[currentTab=='home']">
	<span style="display: inline-block; position: relative;">
		<img src="../assets/wx/images/icon/icon_home.png" alt="home" class="weui-tabbar__icon">
	</span>
	<p class="weui-tabbar__label">主页</p>
</a>
<a href="javascript:;" data-ng-click="gotoUrl('pump')" class="pump weui-tabbar__item" data-ng-class="{true: 'weui-bar__item_on', false: ''}[currentTab=='pump']">
	<span style="display: inline-block; position: relative;">
		<img src="../assets/wx/images/icon/icon_pump.png" alt="pump" class="weui-tabbar__icon">
	</span>
	<p class="weui-tabbar__label">热泵</p>
</a>
<a href="javascript:;" data-ng-click="gotoUrl('warn')" class="warn weui-tabbar__item" data-ng-class="{true: 'weui-bar__item_on', false: ''}[currentTab=='warn']">
	<span style="display: inline-block; position: relative;">
		<img src="../assets/wx/images/icon/icon_warn.png" alt="warn" class="weui-tabbar__icon">
		<span class="weui-badge weui-badge_dot" style="position: absolute; top: 0; right: -6px;"></span>
	</span>
	<p class="weui-tabbar__label">告警</p>
</a> 
<a href="javascript:;" data-ng-click="gotoUrl('user')" class="user weui-tabbar__item" data-ng-class="{true: 'weui-bar__item_on', false: ''}[currentTab=='user']">
	<span style="display: inline-block; position: relative;">
		<img src="../assets/wx/images/icon/icon_me.png" alt="user" class="weui-tabbar__icon">
	</span>
	<p class="weui-tabbar__label">我的</p>
</a>