<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="modal" tabindex="-1" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-ng-click="$hide()">&times;</button>
        <h4 class="modal-title">{{ pumpd.base.pumpName }} - 产品信息</h4>
      </div>
      <div class="modal-body">
      	<blockquote style="font-size: 12.68px;line-height: 34px;margin: 0 0 1px;border-left:0px solid rgba(255, 255, 255, 0)">
	      	<div class="row">
				<div class="col-xs-6">
					<div class="item-label">产品名称：</div>{{pumpd.deviceProduct.productName}}
				</div>
				<div class="col-xs-6">
					<div class="item-label">规格型号：</div>{{pumpd.deviceProduct.productSpec}}
				</div>
				<div class="col-xs-6">
					<div class="item-label">产品匹数：</div>{{pumpd.deviceProduct.productPi}}
				</div>
				<div class="col-xs-6">
					<div class="item-label">电源规格：</div>{{pumpd.deviceProduct.productPowerSpec}}
				</div>
				<div class="col-xs-12">
					<div class="item-label">产品描述：</div>{{pumpd.deviceProduct.productDescript}}
				</div>
				<div class="col-xs-6">
					<div class="item-label">设备厂家：</div>{{pumpd.deviceVender.venderName}}
				</div>
				<div class="col-xs-6">
					<div class="item-label">厂家联系人：</div>{{pumpd.deviceVender.venderContacts}}
				</div>
				<div class="col-xs-6">
					<div class="item-label">联系电话：</div>{{pumpd.deviceVender.venderContactsTel}}
				</div>
				<div class="col-xs-6">
					<div class="item-label">联系地址：</div>{{pumpd.deviceVender.venderAddress}}
				</div>
				<div class="col-xs-12">
					<div class="item-label">厂家备注：</div>{{pumpd.deviceVender.venderRemark}}
				</div>
			</div>
		</blockquote>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-ng-click="$hide()">关闭</button>
      </div>
    </div>
  </div>
</div>
