<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="aside bs-docs-aside" tabindex="-1" role="dialog">
  <div class="close">
    <div class="btn btn-round btn-info" ng-click="$hide()"><i class="md md-close"></i></div>
  </div>
  <div class="aside-dialog">
    <div class="aside-body bs-sidebar">
      <form class="form-floating" novalidate="novalidate" ng-submit="updatePump()">
        <fieldset>
          <legend>修改热泵设备 </legend>
          
          <div class="form-group filled">
            <label class="control-label">热泵名称</label>
            <input type="text" class="form-control" ng-model="pump.pumpName" required minlength=2 maxlength=20 />
          </div>
          
          <div class="form-group filled">
            <label class="control-label">热泵序列号</label>
            <input type="text" class="form-control" ng-model="pump.pumpSn" required minlength=2 maxlength=20 />
          </div>
          
          <div class="form-group filled">
            <label class="control-label">安装日期</label>
            <input type="text" class="form-control ng-valid" ng-model="pump.installDate" data-date-format="yyyy-MM-dd" data-max-date="today" data-autoclose="1" bs-datepicker="" required>
          </div>
          
          <div class="form-group filled">
            <label class="control-label">设备产品</label>
            <ui-select ng-model="products.selected" class="f13" theme="select2" search-enabled="true" required>
              <ui-select-match placeholder="选择一个设备产品"><span ng-bind="$select.selected.productName"></span></ui-select-match>
              <ui-select-choices repeat="product in products | filter: $select.search">
                <div ng-bind-html="product.productName | highlight: $select.search"></div>
              </ui-select-choices>
            </ui-select>
          </div>
          
          <div class="form-group filled">
            <label class="control-label">产品型号</label>
            <input type="text" class="form-control" ng-model="products.selected.productSpec" disabled="1" />
          </div>
          <div class="form-group filled">
            <label class="control-label">产品匹数</label>
            <input type="text" class="form-control" ng-model="products.selected.productPi" disabled="1" />
          </div>
          <div class="form-group filled">
            <label class="control-label">功率规格</label>
            <input type="text" class="form-control" ng-model="products.selected.productPowerSpec" disabled="1" />
          </div>

          <div class="form-group">
            <button type="submit" class="btn btn-primary">提交</button>
          </div>
        </fieldset>
      </form>
    </div>
  </div>
</div>