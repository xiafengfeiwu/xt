<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="weui-tab">
	<div class="weui-tab__panel">
		<div class="page js_show">
		    <div class="page__hd">
		        <h1 class="page__title">我的</h1>
		    </div>
		    <div class="page__bd">
		    	<div class="baseinfo">
		    		<div class="weui-flex">
			            <div>
			            	<div class="placeholder">
			            		<img src="../assets/wx/images/icon/icon_me.png" />
			            	</div>
			            </div>
			            <div class="weui-flex__item">
			            	<div class="placeholder">
			            		<div class="userinfo">
			            			<p>司仲夏 (系统管理员)</p>
			            			<p>TEL: 18518436862</p>
			            		</div>
			            	</div>
			            </div>
			        </div>
		    	</div>
		    
		    
		    	<ul>
		    		<li>
		    			<div class="weui-flex js_category">
		                    <p class="weui-flex__item">已绑定当前微信</p>
		                    <a href="javascript:;" class="weui-btn weui-btn_mini weui-btn_warn" style="color:#efefef">解绑</a>
		                </div>
		    		</li>
		    		<li>
		    			<div class="weui-flex js_category">
		                    <a href="javascript:;" data-ng-click="gotoUrl('update_user_info')" class="weui-flex__item">修改基本信息</a>
		                </div>
		    			<div class="weui-flex js_category">
		                    <a href="javascript:;" data-ng-click="gotoUrl('update_pwd')" class="weui-flex__item">修改登陆密码</a>
		                </div>
		    		</li>
		    		<li>
		    			<div class="weui-flex js_category">
		                    <a href="javascript:;" data-ng-click="gotoUrl('about')" class="weui-flex__item">关于 (v1.0.0)</a>
		                </div>
		    		</li>
		    	</ul>
		    </div>
		    <div data-ng-include="'footer.jspx'"></div>
		</div>
	</div>
	
	<div class="weui-tabbar" data-ng-include="'tab.jspx'"></div>
</div>