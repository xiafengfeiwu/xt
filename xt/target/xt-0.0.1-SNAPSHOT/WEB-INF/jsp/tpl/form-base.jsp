<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="aside bs-docs-aside" tabindex="-1" role="dialog">
  <div class="close">
    <div class="btn btn-round btn-info" ng-click="$hide()"><i class="md md-close"></i></div>
  </div>
  <div class="aside-dialog">
    <div class="aside-body bs-sidebar">
      <form class="form-floating" novalidate="novalidate">
        <fieldset>
          <legend>热泵基本信息 </legend>
          <div class="form-group filled">
         		<label style="width: 120px;text-align: right;">名称：</label>{{pump.pumpName}}
          </div>
        </fieldset>
      </form>
    </div>
  </div>
</div>