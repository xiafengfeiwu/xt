<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="page js_showe">
    <div class="second_page__hd">
	   <img data-ng-click="goBack()" src="../assets/wx/images/icon_close.png" style="vertical-align:middle;width:26px"/>
    </div>
    <div class="page__bd">
		<div class="weui-cells__title">用户名</div>
		<div class="weui-cells">
            <div class="weui-cell">
                <div class="weui-cell__bd">
                    <input class="weui-input" type="text" placeholder="请输入新的用户名"/>
                </div>
            </div>
        </div>
		<div class="weui-cells__title">手机号</div>
		<div class="weui-cells">
            <div class="weui-cell">
                <div class="weui-cell__bd">
                    <input class="weui-input" type="text" placeholder="请输入新的手机号码"/>
                </div>
            </div>
        </div>
		<div class="weui-cells__title">验证码</div>
        <div class="weui-cells weui-cells_form">
			<div class="weui-cell weui-cell_vcode">
	            <div class="weui-cell__bd">
	                <input class="weui-input" type="text" placeholder="请输入手机验证码">
	            </div>
	            <div class="weui-cell__ft">
	                <button class="weui-vcode-btn">获取验证码</button>
	            </div>
	        </div>
        </div>
        <div class="weui-btn-area">
            <a class="weui-btn weui-btn_primary" href="javascript:;">提交</a>
        </div>
    </div>
	<div data-ng-include="'footer.jspx'"></div>
</div>