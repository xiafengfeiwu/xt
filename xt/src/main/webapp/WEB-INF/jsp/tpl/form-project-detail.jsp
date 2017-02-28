<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="aside bs-docs-aside" tabindex="-1" role="dialog">
  <div class="close">
    <div class="btn btn-round btn-info" ng-click="$hide()"><i class="md md-close"></i></div>
  </div>
  <div class="aside-dialog">
    <div class="aside-body bs-sidebar">
      <form class="form-floating" novalidate="novalidate">
        <fieldset>
          <legend>项目详情 </legend>
          <div class="form-group filled">
         		<label style="width: 80px;text-align: right;">项目名称：</label>{{project.userName}}
          </div>
        </fieldset>
      </form>
    </div>
  </div>
</div>