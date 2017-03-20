<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="aside bs-docs-aside" tabindex="-1" role="dialog">
  <div class="close">
    <div class="btn btn-round btn-info" ng-click="$hide()"><i class="md md-close"></i></div>
  </div>
  <div class="aside-dialog">
    <div class="aside-body bs-sidebar">
      <form class="form-floating" novalidate="novalidate">
        <fieldset>
          <legend>产品详情</legend>
          <div class="form-group filled">
            <label class="control-label">产品名称</label>
            <p style="line-height: 40px;">{{ product.productName }}</p>
          </div>
          <div class="form-group filled">
            <label class="control-label">产品类别</label>
            <p style="line-height: 40px;">{{ product.productType=='R'?'热泵产品':'其他产品' }}</p>
          </div>
          <div class="form-group filled">
            <label class="control-label">产品厂家</label>
            <p style="line-height: 40px;">{{ product.productVenderName }}</p>
          </div>
          <div class="form-group filled">
            <label class="control-label">产品型号</label>
            <p style="line-height: 40px;">{{ product.productSpec }}</p>
          </div>
          <div class="form-group filled" ng-show="product.productType=='R'">
            <label class="control-label">产品匹数</label>
            <p style="line-height: 40px;">{{ product.productPi }}</p>
          </div>
          <div class="form-group filled" ng-show="product.productType=='R'">
            <label class="control-label">功率规格</label>
            <p style="line-height: 40px;">{{ product.productPowerSpec }}</p>
          </div>
          <div class="form-group filled">
            <label class="control-label">产品描述</label>
            <p style="line-height: 40px;">{{ product.productDescript }}</p>
          </div>
          <div class="form-group filled">
            <label class="control-label">创建时间</label>
            <p style="line-height: 40px;">{{ product.createTime | date: 'yyyy-MM-dd HH:mm:ss' }}</p>
          </div>
          <div class="form-group filled">
            <label class="control-label">最后修改时间</label>
            <p style="line-height: 40px;">{{ product.modifyTime | date: 'yyyy-MM-dd HH:mm:ss' }}</p>
          </div>
        </fieldset>
      </form>

    </div>
  </div>
</div>