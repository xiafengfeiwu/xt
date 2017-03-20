<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="aside bs-docs-aside" tabindex="-1" role="dialog">
  <div class="close">
    <div class="btn btn-round btn-info" ng-click="$hide()"><i class="md md-close"></i></div>
  </div>
  <div class="aside-dialog">
    <div class="aside-body bs-sidebar">
      <form class="form-floating" novalidate="novalidate">
        <fieldset>
          <legend><i class="md md-quick-contacts-dialer light-green lighten-1 icon-color"></i> 供应商详情</legend>
          <div class="form-group filled">
            <label class="control-label">厂家名称</label>
            <p style="line-height: 40px;">{{ vender.venderName }}</p>
          </div>
          <div class="form-group filled">
            <label class="control-label">厂家联系人</label>
            <p style="line-height: 40px;">{{ vender.venderContacts }}</p>
          </div>
          <div class="form-group filled">
            <label class="control-label">厂家联系方式</label>
            <p style="line-height: 40px;">{{ vender.venderContactsTel }}</p>
          </div>
          <div class="form-group filled">
            <label class="control-label">厂家地址</label>
            <p style="line-height: 40px;">{{ vender.venderAddress }}</p>
          </div>
          <div class="form-group filled">
            <label class="control-label">备注</label>
            <p style="line-height: 40px;">{{ vender.venderRemark }}</p>
          </div>
          <div class="form-group filled">
            <label class="control-label">创建时间</label>
            <p style="line-height: 40px;">{{ vender.createTime | date: 'yyyy-MM-dd HH:mm:ss' }}</p>
          </div>
          <div class="form-group filled">
            <label class="control-label">最后修改时间</label>
            <p style="line-height: 40px;">{{ vender.modifyTime | date: 'yyyy-MM-dd HH:mm:ss' }}</p>
          </div>
        </fieldset>
      </form>

    </div>
  </div>
</div>