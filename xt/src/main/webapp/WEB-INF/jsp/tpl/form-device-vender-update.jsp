<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="aside bs-docs-aside" tabindex="-1" role="dialog">
  <div class="close">
    <div class="btn btn-round btn-info" ng-click="$hide()"><i class="md md-close"></i></div>
  </div>
  <div class="aside-dialog">
    <div class="aside-body bs-sidebar">
      <form class="form-floating" novalidate="novalidate" ng-submit="update()">
        <fieldset>
          <legend>修改供应商 </legend>
          <div class="form-group filled">
            <label class="control-label">厂家名称</label>
            <input type="text" class="form-control" ng-model="vender.venderName" required minlength=2 maxlength=60 />
          </div>
          <div class="form-group filled">
            <label class="control-label">厂家联系人</label>
            <input type="text" class="form-control" ng-model="vender.venderContacts" required minlength=2 maxlength=20 />
          </div>
          <div class="form-group filled">
            <label class="control-label">厂家联系方式</label>
            <input type="text" class="form-control" ng-model="vender.venderContactsTel" required maxlength=11 pattern="^1\d{10}$" />
          </div>
          <div class="form-group filled">
            <label class="control-label">厂家地址</label>
            <input type="text" class="form-control" ng-model="vender.venderAddress" maxlength=78 />
          </div>
          <div class="form-group filled">
            <label class="control-label">备注</label>
            <textarea type="text" class="form-control" ng-model="vender.venderRemark" maxlength=180></textarea>
          </div>
          <div class="form-group">
            <button type="submit" class="btn btn-primary">提交</button>
          </div>
        </fieldset>
      </form>

    </div>
  </div>
</div>