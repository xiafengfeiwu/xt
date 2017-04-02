<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="page js_showe">
    <div class="second_page__hd">
	   <img data-ng-click="goBack()" src="../assets/wx/images/icon_close.png" style="vertical-align:middle;width:26px"/>
    </div>
	<div class="page__bd">
		<div class="weui-cells__title">原密码</div>
		<div class="weui-cells">
	         <div class="weui-cell">
	             <div class="weui-cell__bd">
	                 <input class="weui-input" type="password" placeholder="请输入账号的原始密码"/>
	             </div>
	         </div>
	    </div>
		<div class="weui-cells__title">新密码</div>
		<div class="weui-cells">
	          <div class="weui-cell">
	              <div class="weui-cell__bd">
	                  <input class="weui-input" type="password" placeholder="请输入账号的新密码"/>
	              </div>
	          </div>
	    </div>
		<div class="weui-cells__title">重复新密码</div>
		<div class="weui-cells">
	          <div class="weui-cell">
	              <div class="weui-cell__bd">
	                  <input class="weui-input" type="password" placeholder="请重复账号的新密码"/>
	              </div>
	          </div>
	    </div>
	    <div class="weui-btn-area">
	          <a class="weui-btn weui-btn_primary" href="javascript:;">提交</a>
	    </div>
	</div>
	<div data-ng-include="'footer.jspx'"></div>
</div>
