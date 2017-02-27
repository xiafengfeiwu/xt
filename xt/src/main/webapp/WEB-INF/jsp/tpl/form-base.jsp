<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="aside bs-docs-aside" tabindex="-1" role="dialog">
  <div class="close">
    <div class="btn btn-round btn-info" ng-click="$hide()"><i class="md md-close"></i></div>
  </div>
  <div class="aside-dialog">
    <div class="aside-body bs-sidebar">
      <form class="form-floating" novalidate="novalidate">
        <fieldset>
          <legend><button type="button" class="btn btn-link btn-text f12" ng-click="pumpMonitor(pump.id)"><i class="md md-desktop-windows" style="color:green"> 热泵监控</i></button></legend>
          <div class="form-group filled">
         		<label style="width: 80px;text-align: right;">名称：</label>{{pump.name}}
          </div>
        </fieldset>
      </form>
    </div>
  </div>
</div>