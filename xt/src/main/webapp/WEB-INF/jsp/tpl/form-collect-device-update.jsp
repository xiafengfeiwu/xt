<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="aside bs-docs-aside" tabindex="-1" role="dialog">
  <div class="close">
    <div class="btn btn-round btn-info" ng-click="$hide()"><i class="md md-close"></i></div>
  </div>
  <div class="aside-dialog">
    <div class="aside-body bs-sidebar">
      <form class="form-floating" novalidate="novalidate" ng-submit="changeCollectDevice()">
        <fieldset>
          <legend>修改采集设备 </legend>
          <div class="form-group filled">
            <label class="control-label">所属热泵</label>
            <input type="text" class="form-control" style="color:red" ng-model="pumpd.base.pumpName" disabled="disabled"/>
          </div>
          <div class="form-group filled">
            <label class="control-label">设备名称</label>
            <input type="text" class="form-control" ng-model="device.deviceName" required minlength=2 maxlength=20 />
          </div>
          <div class="form-group filled">
            <label class="control-label">设备序列号</label>
            <input type="text" class="form-control" ng-model="device.deviceSn" required minlength=2 maxlength=20 />
          </div>
          <div class="form-group filled" ng-if="products.length">
            <label class="control-label">厂家产品</label>
            <ui-select ng-model="products.selected" class="f13" theme="select2" search-enabled="false">
              <ui-select-match placeholder="选择一个产品"><span ng-bind="$select.selected.productName"></span></ui-select-match>
              <ui-select-choices repeat="product in products">
                <div ng-bind-html="product.productName"></div>
              </ui-select-choices>
            </ui-select>
          </div>
          <div class="form-group filled" ng-if="products.length">
            <label class="control-label">规格型号</label>
            <input type="text" class="form-control" data-ng-model="products.selected.productSpec" disabled="false" />
          </div>
          <div ng-if="!products.length">
          	<p style="color:red">* 无厂家采集产品信息</p>
          </div>
          <div class="form-group">
            <button type="button" data-ng-click="removeCollectDevice(device)" class="btn btn-primary">删除</button>
            <button type="submit" class="btn">提交</button>
          </div>
        </fieldset>
      </form>
    </div>
  </div>
</div>