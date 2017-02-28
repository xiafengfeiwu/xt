<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="aside bs-docs-aside" tabindex="-1" role="dialog">
  <div class="close">
    <div class="btn btn-round btn-info" ng-click="$hide()"><i class="md md-close"></i></div>
  </div>
  <div class="aside-dialog">
    <div class="aside-body bs-sidebar">
      <form class="form-floating" novalidate="novalidate" ng-submit="update()">
        <fieldset>
          <legend>更新项目 </legend>
          <div class="form-group filled">
            <label class="control-label">项目名称</label>
            <input type="text" class="form-control" ng-model="project.projectName" required minlength=2 maxlength=20 />
          </div>
          <div class="form-group">
            <button type="submit" class="btn btn-primary">更改</button>
          </div>
        </fieldset>
      </form>
    </div>
  </div>
</div>