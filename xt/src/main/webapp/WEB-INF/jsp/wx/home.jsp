<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="weui-tab">
	<div class="weui-tab__panel">
	
		<div class="page js_show">
		    <div class="page__hd">
		        <h1 class="page__title">主页</h1>
		    </div>
		    <div class="page__bd" style="background-color: #fff;padding: 10px 0">
		    	
		    	<div class="weui-flex">
		            <div class="weui-flex__item">
		            	<p class="home-item">今日用电：</p>
		            </div>
		            <div class="weui-flex__item">
						<p class="home-item">累计用电：</p>
					</div>
		        </div>
		    	<div class="weui-flex">
		            <div class="weui-flex__item">
		            	<p class="home-item">在线热泵：</p>
		            </div>
		            <div class="weui-flex__item">
						<p class="home-item">离线热泵：</p>
					</div>
		        </div>
		        
				<div class="weui-cells__title" style="text-align: center;">日用电详情</div>
			    <div id="all_gc_chart" style="width: 100%;height:320px"></div>
			    
		    	<div class="weui-grids">
			        <div class="weui-grid">
			            <div class="weui-grid__icon">
			                <img src="../assets/wx/images/jp_icon/CO2.png" alt="">
			            </div>
			            <p class="weui-grid__label">141 kg</p>
			        </div>
			        <div class="weui-grid">
			            <div class="weui-grid__icon">
			                <img src="../assets/wx/images/jp_icon/SO2.png" alt="">
			            </div>
			            <p class="weui-grid__label">141 kg</p>
			        </div>
			        <div class="weui-grid">
			            <div class="weui-grid__icon">
			                <img src="../assets/wx/images/jp_icon/NO2.png" alt="">
			            </div>
			            <p class="weui-grid__label">141 kg</p>
			        </div>
			        <div class="weui-grid">
			            <div class="weui-grid__icon">
			                <img src="../assets/wx/images/jp_icon/Coal.png" alt="">
			            </div>
			            <p class="weui-grid__label">231 kg</p>
			        </div>
			        <div class="weui-grid">
			            <div class="weui-grid__icon">
			                <img src="../assets/wx/images/jp_icon/Dust.png" alt="">
			            </div>
			            <p class="weui-grid__label">111 kg</p>
			        </div>
			        <div class="weui-grid">
			            <div class="weui-grid__icon">
			                <img src="../assets/wx/images/jp_icon/Tree.png" alt="">
			            </div>
			            <p class="weui-grid__label">20 棵</p>
			        </div>
			    </div>
			    
		    </div>
		    <div data-ng-include="'footer.jspx'"></div>
		</div>
	</div>
	<div class="weui-tabbar" data-ng-include="'tab.jspx'"></div>
</div>