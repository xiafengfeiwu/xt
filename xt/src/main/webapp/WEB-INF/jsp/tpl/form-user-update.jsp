<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="aside bs-docs-aside" tabindex="-1" role="dialog">
  <div class="close">
    <div class="btn btn-round btn-info" ng-click="$hide()"><i class="md md-close"></i></div>
  </div>
  <div class="aside-dialog">
    <div class="aside-body bs-sidebar">
      <form class="form-floating" novalidate="novalidate" ng-submit="update()">
        <fieldset>
          <legend>更新用户 </legend>
          <div class="form-group filled">
            <label class="control-label">姓名</label>
            <input type="text" class="form-control" ng-model="user.userName" required minlength=2 maxlength=20 />
          </div>
          <div class="form-group filled">
            <label class="control-label">登录名称</label>
            <input type="text" class="form-control" ng-model="user.userLoginName" required pattern="\w{2,20}$" />
          </div>
          <div class="form-group filled">
            <label class="control-label">联系方式</label>
            <input type="text" class="form-control" ng-model="user.userPhone" required maxlength=11 pattern="^1\d{10}$" />
          </div>
          <div class="form-group filled">
            <label class="control-label">角色</label>
            <ui-select ng-model="roles.selected" theme="select2" search-enabled="false" required>
              <ui-select-match placeholder="选择一个角色"><span ng-bind="$select.selected.roleName"></span></ui-select-match>
              <ui-select-choices repeat="role in roles | filter: $select.search">
                <div ng-bind-html="role.roleName | highlight: $select.search"></div>
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