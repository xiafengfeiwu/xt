<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="aside bs-docs-aside" tabindex="-1" role="dialog">
  <div class="close">
    <div class="btn btn-round btn-info" ng-click="$hide()"><i class="md md-close"></i></div>
  </div>
  <div class="aside-dialog">
    <div class="aside-body bs-sidebar">
      <form class="form-floating" novalidate="novalidate" ng-submit="update()">
        <fieldset>
          <legend>更改告警组 </legend>
          <div class="form-group filled">
            <label class="control-label">组名称</label>
            <input type="text" ng-model="warnGroup.groupName" class="form-control" required/>
          </div>
          <div class="form-group filled">
            <label class="control-label">组描述</label>
            <textarea ng-model="warnGroup.groupDescript" class="form-control" required></textarea>
          </div>
          <div class="form-group">
            <button type="submit" class="btn btn-primary">提交</button>
          </div>
        </fieldset>
      </form>
    </div>
  </div>
</div>