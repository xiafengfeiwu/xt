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
          <div class="form-group filled">
            <label class="control-label">项目编码</label>
            <input type="text" class="form-control" ng-model="project.projectCode" disabled="disabled" />
          </div>
          <div class="form-group filled">
            <label class="control-label">项目业主</label>
            <input type="text" class="form-control" ng-model="project.ownerName" required minlength=2 maxlength=20 />
          </div>
          <div class="form-group filled">
            <label class="control-label">联系方式</label>
            <input type="text" class="form-control" ng-model="project.ownerPhoneNo" required maxlength=11 pattern="^1\d{10}$"/>
          </div>
          <div class="form-group filled">
            <label class="control-label">业主类型</label>
            <ui-select ng-model="types.selected" class="f13" theme="select2" search-enabled="false" required>
              <ui-select-match placeholder="选择一个业主类型"><span ng-bind="$select.selected.name"></span></ui-select-match>
              <ui-select-choices repeat="type in types | filter: $select.search">
                <div ng-bind-html="type.name | highlight: $select.search"></div>
              </ui-select-choices>
            </ui-select>
          </div>
          <div class="form-group">
            <button type="submit" class="btn btn-primary">更改</button>
          </div>
        </fieldset>
      </form>
    </div>
  </div>
</div>