<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="aside bs-docs-aside" tabindex="-1" role="dialog">
  <div class="close">
    <div class="btn btn-round btn-info" ng-click="$hide()"><i class="md md-close"></i></div>
  </div>
  <div class="aside-dialog">
    <div class="aside-body bs-sidebar">
      <form class="form-floating" novalidate="novalidate">
        <fieldset>
          <legend>故障详情 </legend>
          <div class="form-group filled">
            <label class="control-label">故障单号</label>
            <input type="text" class="form-control" value="W6538098863931393" disabled="disabled" />
          </div>
          <div class="form-group filled">
            <label class="control-label">所属热泵</label>
            <input type="text" class="form-control" value="热泵1" disabled="disabled" />
          </div>
          <div class="form-group filled">
            <label class="control-label">发生时间</label>
            <input type="text" class="form-control" value="2017-03-04 12:23:11" disabled="disabled" />
          </div>
          <div class="form-group filled">
            <label class="control-label">故障详情</label>
            <textarea type="text" class="form-control" disabled="disabled">出水温度超范围，当前温度56℃</textarea>
          </div>
        </fieldset>
      </form>
    </div>
  </div>
</div>