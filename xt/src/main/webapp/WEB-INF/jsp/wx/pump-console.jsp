<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="weui-tab">
	<div class="weui-tab__panel">
		<div class="page js_show">
		    <div class="second_page__hd">
			   <img data-ng-click="goBack()" src="../assets/wx/images/icon_close.png" style="vertical-align:middle;width:26px"/>
		    </div>
		    <div class="page__bd">
		    	<div id="c_base">
		    		<div class="weui-panel weui-panel_access">
					    
					    <div class="weui-panel__bd">
					    	<div class="weui-cells">
					            <div class="weui-cell pading15">
					                <div class="weui-cell__bd">
					                    <p>热泵名称</p>
					                </div>
					                <div class="weui-cell__ft"></div>
					            </div>
					            <div class="weui-cell pading15">
					                <div class="weui-cell__bd">
					                    <p>热泵编码</p>
					                </div>
					                <div class="weui-cell__ft"></div>
					            </div>
					            <div class="weui-cell pading15">
					                <div class="weui-cell__bd">
					                    <p>序列号</p>
					                </div>
					                <div class="weui-cell__ft"></div>
					            </div>
					            <div class="weui-cell pading15">
					                <div class="weui-cell__bd">
					                    <p>安装日期</p>
					                </div>
					                <div class="weui-cell__ft"></div>
					            </div>
					            <div class="weui-cell pading15">
					                <div class="weui-cell__bd">
					                    <p>所属项目</p>
					                </div>
					                <div class="weui-cell__ft"></div>
					            </div>
					            <div class="weui-cell pading15">
					                <div class="weui-cell__bd">
					                    <p>热泵业主</p>
					                </div>
					                <div class="weui-cell__ft"></div>
					            </div>
					            <div class="weui-cell pading15">
					                <div class="weui-cell__bd">
					                    <p>联系方式</p>
					                </div>
					                <div class="weui-cell__ft"></div>
					            </div>
					            <div class="weui-cell pading15">
					                <div class="weui-cell__bd">
					                    <p>项目地址</p>
					                </div>
					                <div class="weui-cell__ft"></div>
					            </div>
					        </div>
					    </div>
					</div>
		    	</div>
		    	<div id="c_realtime">
		    		<div class="weui-panel weui-panel_access">
		    			<div class="weui-panel__bd">
					    	<div class="weui-cells">
					            <div class="weui-cell pading15">
					                <div class="weui-cell__bd">
					                    <p>环境温度</p>
					                </div>
					                <div class="weui-cell__ft"></div>
					            </div>
					            <div class="weui-cell pading15">
					                <div class="weui-cell__bd">
					                    <p>室内温度</p>
					                </div>
					                <div class="weui-cell__ft"></div>
					            </div>
					            <div class="weui-cell pading15">
					                <div class="weui-cell__bd">
					                    <p>水箱温度</p>
					                </div>
					                <div class="weui-cell__ft"></div>
					            </div>
					            <div class="weui-cell pading15">
					                <div class="weui-cell__bd">
					                    <p>出水温度</p>
					                </div>
					                <div class="weui-cell__ft"></div>
					            </div>
					            <div class="weui-cell pading15">
					                <div class="weui-cell__bd">
					                    <p>回水温度</p>
					                </div>
					                <div class="weui-cell__ft"></div>
					            </div>
					            <div class="weui-cell pading15">
					                <div class="weui-cell__bd">
					                    <p>排气温度</p>
					                </div>
					                <div class="weui-cell__ft"></div>
					            </div>
					            <div class="weui-cell pading15">
					                <div class="weui-cell__bd">
					                    <p>回气温度</p>
					                </div>
					                <div class="weui-cell__ft"></div>
					            </div>
					            <div class="weui-cell pading15">
					                <div class="weui-cell__bd">
					                    <p>压缩机电流</p>
					                </div>
					                <div class="weui-cell__ft"></div>
					            </div>
					            <div class="weui-cell pading15">
					                <div class="weui-cell__bd">
					                    <p>工作模式</p>
					                </div>
					                <div class="weui-cell__ft"></div>
					            </div>
					            <div class="weui-cell pading15">
					                <div class="weui-cell__bd">
					                    <p>故障代码</p>
					                </div>
					                <div class="weui-cell__ft"></div>
					            </div>
					            <div class="weui-cell pading15">
					                <div class="weui-cell__bd">
					                    <p>最后采集时间</p>
					                </div>
					                <div class="weui-cell__ft"></div>
					            </div>
					        </div>
					    </div>
					</div>
		    	</div>
		    	<div id="c_history" style="background-color: #fff">
		    		<div class="weui-cell">
					    <div class="weui-cell__hd"><label for="" class="weui-label">选择日期</label></div>
					    <div class="weui-cell__bd" style="border-bottom:1px solid #ccc;height: 32px;">
					        <input class="weui-input" type="date" value="">
					    </div>
					</div>
					<div style="width:100%;height:440px;margin:10px auto;" id="c_h_chart"></div>
		    	</div>
		    	<div id="c_warn">
		    		<div class="weui-media-box weui-media-box_appmsg">
						<div class="weui-media-box__bd">
					    	<p class="weui-media-box__desc" style="line-height: 1.5em;margin: 0">由各种物质组成的巨型球状天体，叫做星球。星球有一定的形状，有自己的运行轨道。</p>
						    <ul class="weui-media-box__info">
								<li class="weui-media-box__info__meta">2017-03-31 22:12:11</li>
							</ul>
					   	</div>
					</div>
					<div class="weui-media-box weui-media-box_appmsg">
					    <div class="weui-media-box__bd">
					           <p class="weui-media-box__desc" style="line-height: 1.5em;margin: 0">由各种物质组成的巨型球状天体，叫做星球。星球有一定的形状，有自己的运行轨道。</p>
					           <ul class="weui-media-box__info">
								<li class="weui-media-box__info__meta">2017-03-31 22:12:11</li>
							</ul>
						</div>
					</div>
		    	</div>
		    </div>
			<div data-ng-include="'footer.jspx'"></div>
		</div>
	</div>
	<div class="weui-tabbar">
		<a href="javascript:;" data-ng-click="switchConsoleTab('c_base')" class="c_base weui-tabbar__item weui-bar__item_on" style="padding: 0">
			<p class="weui-tabbar__label" style="line-height: 52px;font-size: 14px;">基本信息</p>
		</a>
		<a href="javascript:;" data-ng-click="switchConsoleTab('c_realtime')" class="c_realtime weui-tabbar__item" style="padding: 0">
			<p class="weui-tabbar__label" style="line-height: 52px;font-size: 14px;">实时监控</p>
		</a>
		<a href="javascript:;" data-ng-click="switchConsoleTab('c_history')" class="c_history weui-tabbar__item" style="padding: 0">
			<p class="weui-tabbar__label" style="line-height: 52px;font-size: 14px;">历史数据</p>
		</a> 
		<a href="javascript:;" data-ng-click="switchConsoleTab('c_warn')" class="c_warn weui-tabbar__item" style="padding: 0">
			<p class="weui-tabbar__label" style="line-height: 52px;font-size: 14px;">采集告警</p>
		</a>
	</div>
</div>