<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<aside class="sidebar fixed">
  <div class="brand-logo">
    <div id="logo">
      <div class="foot1"></div>
      <div class="foot3"></div>
    </div>
   	 热泵在线
  </div>
  <div class="user-logged-in">
    <div class="content">
      <div class="user-name">Admin <span class="text-muted f9">系統管理员</span></div>
      <div class="user-email">18518436862</div>
      <div class="user-actions">
        <i class="md md-person"></i>
        <a menu-link class="m-r-5" href="#/auth/user-info" name="个人中心" style="list-style-type:none;display: inline;">个人中心</a> |  
        <a menu-link class="m-r-5" href="https://www.team-union.com" name="退出" style="list-style-type:none;display: inline;">退出</a>
      </div>
    </div>
  </div>
  <ul ng-cloak>
    <a menu-link href="#/dashboard" icon="md md-blur-on">全局监控（GIS）</a>
    <li menu-toggle path="/monitor" name="运行监控" icon="md md-camera">
      <a menu-link href="#/monitor/pump" name="热泵监控" icon="md md-subject">热泵监控</a>
      <a menu-link href="#/monitor/warn" name="故障告警" icon="md md-warning">故障告警</a>
      <a menu-link href="#/monitor/report" name="监控报表" icon="md md-equalizer">监控报表</a>
    </li>
    <li menu-toggle path="/energy" name="用电耗能" icon="md md-trending-up">
      <a menu-link href="#/energy/consumption" name="用电耗能" icon="md md-flash-on">用电耗能</a>
      <a menu-link href="#/energy/conservation" name="节能减排" icon="md md-wrap-text">节能减排</a>
    </li>
    <li menu-toggle path="/manage" name="综合管理" icon="md md-now-widgets">
      <a menu-link href="#/manage/project" name="项目管理" icon="md md-style">项目管理</a>
      <a menu-link href="#/manage/device" name="设备管理" icon="md md-memory">设备管理</a>
    </li>
    <li menu-toggle path="/service" name="售后服务" icon="md md-mood">
      <a menu-link href="#/service/support" name="技术支持" icon="md md-help">技术支持</a>
      <a menu-link href="#/service/repair" name="故障报修" icon="md md-error">故障报修</a>
      <a menu-link href="#/service/handling" name="故障处理" icon="md md-new-releases">故障处理</a>
    </li>
    <li menu-toggle path="/auth" name="用户授权" icon="md md-verified-user">
      <a menu-link href="#/auth/users" name="用户管理" icon="md md-people">用户管理</a>
      <a menu-link href="#/auth/roles" name="角色授权" icon="md md-vpn-key">角色授权</a>
    </li>
    <li menu-toggle path="/weather" name="天气信息" icon="md md-brightness-5">
      <a menu-link href="#/weather/area-weather" name="区域天气" icon="md md-brightness-4">区域天气</a>
      <a menu-link href="#/weather/early-warning" name="发布预警" icon="md md-brightness-high">发布预警</a>
      <a menu-link href="#/weather/system-set" name="参数维护" icon="md md-settings-applications">参数维护</a>
    </li>
  </ul>
</aside>