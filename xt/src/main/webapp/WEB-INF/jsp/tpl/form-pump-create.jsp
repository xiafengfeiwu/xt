<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="modal" tabindex="-1" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" ng-click="$hide()">&times;</button>
        <h4 class="modal-title">新增热泵</h4>
      </div>
      <div class="modal-body">
		<form class="form-floating" novalidate="novalidate"">
	          <div class="row">
	          	<div class="col-xs-6">
		          <div class="form-group filled">
		            <label class="control-label">所属项目</label>
		            <input type="text" class="form-control" style="color:red" ng-model="project.projectName" disabled="disabled"/>
		          </div>
	          	</div>
	          	<div class="col-xs-6">
          		  <div class="form-group filled">
		            <label class="control-label">热泵名称</label>
		            <input type="text" class="form-control" ng-model="pump.pumpName" required minlength=2 maxlength=20 />
		          </div>
	          	</div>
	          	<div class="col-xs-6">
		          <div class="form-group filled">
		            <label class="control-label">热泵序列号</label>
		            <input type="text" class="form-control" ng-model="pump.pumpSn" required minlength=2 maxlength=20 />
		          </div>
	          	</div>
	          	<div class="col-xs-6">
		          <div class="form-group filled">
		            <label class="control-label">安装日期</label>
		            <input type="text" class="form-control ng-valid" ng-model="pump.installDate" data-date-format="yyyy-MM-dd" data-max-date="today" data-autoclose="1" bs-datepicker="" required>
		          </div>
	          	</div>
	          	<div class="col-xs-6">
		          <div class="form-group filled">
		            <label class="control-label">设备产品</label>
		            <ui-select ng-model="products.selected" class="f13" theme="select2" search-enabled="true" required>
		              <ui-select-match placeholder="选择一个设备产品"><span ng-bind="$select.selected.productName"></span></ui-select-match>
		              <ui-select-choices repeat="product in products | filter: $select.search">
		                <div ng-bind-html="product.productName | highlight: $select.search"></div>
		              </ui-select-choices>
		            </ui-select>
		          </div>
	          	</div>
	          	<div class="col-xs-6">
		          <div class="form-group filled">
		            <label class="control-label">产品型号</label>
		            <input type="text" class="form-control" ng-model="products.selected.productSpec" disabled="1" />
		          </div>
	          	</div>
	          	<div class="col-xs-6">
		          <div class="form-group filled">
		            <label class="control-label">产品匹数</label>
		            <input type="text" class="form-control" ng-model="products.selected.productPi" disabled="1" />
		          </div>
	          	</div>
	          	<div class="col-xs-6">
		          <div class="form-group filled">
		            <label class="control-label">电源规格</label>
		            <input type="text" class="form-control" ng-model="products.selected.productPowerSpec" disabled="1" />
		          </div>
	          	</div>
	          </div>
	      </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-ng-click="savePump()">提交</button>
        <button type="button" class="btn btn-default" data-ng-click="$hide()">关闭</button>
      </div>
    </div>
  </div>
</div>