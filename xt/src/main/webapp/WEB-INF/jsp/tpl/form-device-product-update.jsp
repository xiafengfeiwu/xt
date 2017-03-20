<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="aside bs-docs-aside" tabindex="-1" role="dialog">
  <div class="close">
    <div class="btn btn-round btn-info" ng-click="$hide()"><i class="md md-close"></i></div>
  </div>
  <div class="aside-dialog">
    <div class="aside-body bs-sidebar">
      <form class="form-floating placeholder-form" novalidate="novalidate" ng-submit="update()">
        <fieldset>
          <legend>修改产品 </legend>
          <div class="form-group filled">
            <label class="control-label">产品名称</label>
            <input type="text" class="form-control" ng-model="product.productName" required minlength=2 maxlength=60 />
          </div>
          <div class="form-group filled">
            <label class="control-label">设备厂家</label>
            <ui-select ng-model="deviceVenders.selected" class="f13" theme="select2" search-enabled="true" required>
              <ui-select-match placeholder="选择一个厂家"><span ng-bind="$select.selected.venderName"></span></ui-select-match>
              <ui-select-choices repeat="deviceVender in deviceVenders | filter: $select.search">
                <div ng-bind-html="deviceVender.venderName | highlight: $select.search"></div>
              </ui-select-choices>
            </ui-select>
          </div>
          <div class="form-group filled">
            <label class="control-label">产品型号</label>
            <input type="text" class="form-control" ng-model="product.productSpec" maxlength=36/>
          </div>
          <div class="form-group filled" ng-show="product.productType=='R'">
            <label class="control-label">产品匹数</label>
            <input type="text" class="form-control" ng-model="product.productPi" maxlength=20 />
          </div>
          <div class="form-group filled" ng-show="product.productType=='R'">
            <label class="control-label">功率规格</label>
            <input type="text" class="form-control" ng-model="product.productPowerSpec" maxlength=80 />
          </div>
          <div class="form-group filled">
            <label class="control-label">详细描述</label>
            <textarea type="text" class="form-control" ng-model="product.productDescript" maxlength=500></textarea>
          </div>
          <div class="form-group">
            <button type="submit" class="btn btn-primary">提交</button>
          </div>
        </fieldset>
      </form>
    </div>
  </div>
</div>