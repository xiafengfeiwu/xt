<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="modal" tabindex="-1" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" ng-click="$hide()">&times;</button>
        <h4 class="modal-title">产品详情</h4>
      </div>
      <div class="modal-body">
      	<blockquote style="font-size: 12.68px;line-height: 34px;margin: 0 0 1px;border-left:0px solid rgba(255, 255, 255, 0)">
	      	<div class="row">
				<div class="col-xs-6">
					<div class="item-label">产品名称：</div>{{ product.productName }}
				</div>
				<div class="col-xs-6">
					<div class="item-label">产品类别：</div>{{ product.productType=='R'?'热泵产品':'其他产品' }}
				</div>
				<div class="col-xs-6">
					<div class="item-label">产品厂家：</div>{{ product.productVenderName }}
				</div>
				<div class="col-xs-6">
					<div class="item-label">产品匹数：</div>{{ product.productPi }}
				</div>
				<div class="col-xs-6">
					<div class="item-label">产品型号：</div>{{ product.productSpec }}
				</div>
				<div class="col-xs-6">
					<div class="item-label">电源规格：</div>{{ product.productPowerSpec }}
				</div>
				<div class="col-xs-12">
					<div class="item-label">产品描述：</div>{{ product.productDescript }}
				</div>
				<div class="col-xs-6">
					<div class="item-label">创建时间：</div>{{ product.createTime | date: 'yyyy-MM-dd HH:mm:ss' }}
				</div>
				<div class="col-xs-6">
					<div class="item-label">最后修改时间：</div>{{ product.modifyTime | date: 'yyyy-MM-dd HH:mm:ss' }}
				</div>
			</div>
		</blockquote>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" ng-click="$hide()">关闭</button>
      </div>
    </div>
  </div>
</div>