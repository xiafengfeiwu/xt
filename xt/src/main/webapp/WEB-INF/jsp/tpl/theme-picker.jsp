<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="dropdown-menu dropdown-menu-right theme-picker mat-grow-top-right">
  <div class="container-fluid m-v-15" ng-click="$event.stopPropagation()">
    <div class="pull-right m-r-10">
      <button type="button" class="close" ng-click="$hide()">&times;</button>
    </div>

    <h4 class="no-margin p-t-5"><i class="md md-filter"></i> 自定义系统主题</h4>
    <div class="row m-t-20">
      <div class="col-md-6">
        <div class="w300">主题</div>

        <div class="theme-item theme-template-default" ng-click="changeTemplateTheme('theme-template-default');">
          <div class="icon" ng-show="theme.template=='theme-template-default'"><i class="md md-check"></i></div>
          <div class="theme-sidenav"></div>
          <div class="theme-header"></div>
          <div class="theme-body"></div>
        </div>

        <div class="theme-item theme-template-dark" ng-click="changeTemplateTheme('theme-template-dark');">
          <div class="icon" ng-show="theme.template=='theme-template-dark'"><i class="md md-check"></i></div>
          <div class="theme-sidenav"></div>
          <div class="theme-header"></div>
          <div class="theme-body"></div>
        </div>

        <div class="theme-item theme-template-light" ng-click="changeTemplateTheme('theme-template-light');">
          <div class="icon" ng-show="theme.template=='theme-template-light'"><i class="md md-check"></i></div>
          <div class="theme-sidenav"></div>
          <div class="theme-header"></div>
          <div class="theme-body"></div>
        </div>

        <div class="theme-item theme-template-green" ng-click="changeTemplateTheme('theme-template-green');">
          <div class="icon" ng-show="theme.template=='theme-template-green'"><i class="md md-check"></i></div>
          <div class="theme-sidenav"></div>
          <div class="theme-header"></div>
          <div class="theme-body"></div>
        </div>

        <div class="theme-item theme-template-blue" ng-click="changeTemplateTheme('theme-template-blue');">
          <div class="icon" ng-show="theme.template=='theme-template-blue'"><i class="md md-check"></i></div>
          <div class="theme-sidenav"></div>
          <div class="theme-header"></div>
          <div class="theme-body"></div>
        </div>

      </div>
      <div class="col-md-6">

        <div class="w300">颜色</div>

        <div class="row gutter-10">
          <div ng-repeat="color in theme_colors" class="col-xs-2 col-sm-2 col-md-4 theme-colors">
            <div class="theme-item theme-{{color}}" ng-click="changeColorTheme('theme-'+color);">
              <div class="icon" ng-show="theme.color=='theme-'+color"><i class="md md-check"></i></div>
              <div class="theme-color-1"></div>
              <div class="theme-color-2"></div>
              <div class="theme-color-3"></div>
              <div class="theme-color-4"></div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>