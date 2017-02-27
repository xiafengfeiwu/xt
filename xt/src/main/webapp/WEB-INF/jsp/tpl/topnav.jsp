<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav class="navbar navbar-default navbar-fixed-top" ng-class="{scroll: (scroll>10)}">
  <div class="container-fluid">
    <div class="navbar-header pull-left">
      <button type="button" class="navbar-toggle pull-left m-15" data-activates=".sidebar">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <ul class="breadcrumb">
        <li>热泵在线</li>
        <li ng-bind="pageTitle" class="active">全局监控（GIS）</li>
      </ul>
    </div>

    <ul class="nav navbar-nav navbar-right navbar-right-no-collapse">
       <%-- <li class="dropdown pull-right">
        <button class="dropdown-toggle pointer btn btn-round-sm btn-link withoutripple" bs-dropdown
                data-template="tpl/dropdown-navbar.jspx" data-animation="mat-grow-top-right">
          <i class="md md-more-vert f20"></i> 
        </button>
      </li> --%>
      <li class="dropdown pull-right">
        <button class="dropdown-toggle pointer btn btn-round-sm btn-link withoutripple" bs-dropdown
                data-template="tpl/theme-picker.jspx">
          <i class="md md-settings f20"></i> 
        </button>
      </li>

      <%-- <li navbar-search class="pull-right"></li> --%>
    </ul>
  </div>
</nav>
