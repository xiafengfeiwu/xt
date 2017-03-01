<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="aside bs-docs-aside" tabindex="-1" role="dialog">
  <div class="close">
    <div class="btn btn-round btn-info" ng-click="$hide()"><i class="md md-close"></i></div>
  </div>
  <div class="aside-dialog">
    <div class="aside-body bs-sidebar">
      <form class="form-floating" novalidate="novalidate" ng-submit="save()" ng-show="childAreas.length>0">
        <fieldset>
          <legend>新增区域 </legend>
          <div class="form-group filled">
            <label class="control-label">父级区域</label>
            <input type="text" class="form-control" value="{{parentArea.areaName}}" disabled="disabled" />
          </div>
          <div class="form-group filled">
            <label class="control-label">子级区域</label>
            <ui-select ng-model="childAreas.selected" class="f13" theme="select2" search-enabled="false" required>
              <ui-select-match placeholder="选择一个区域"><span ng-bind="$select.selected.areaName"></span></ui-select-match>
              <ui-select-choices repeat="area in childAreas | filter: $select.search">
                <div ng-bind-html="area.areaName | highlight: $select.search"></div>
              </ui-select-choices>
            </ui-select>
          </div>
          <div class="form-group filled" ng-show="childAreas.selected">
            <label class="control-label">区域编码</label>
            <input type="text" class="form-control" value="{{childAreas.selected.areaCode}}" disabled="disabled" />
          </div>
          <div class="form-group filled" ng-show="childAreas.selected">
            <label class="control-label">天气编码</label>
            <input type="text" class="form-control" value="{{childAreas.selected.areaWeatherCode}}" disabled="disabled" />
          </div>
          <div class="form-group">
            <button type="submit" class="btn btn-primary">提交</button>
          </div>
        </fieldset>
      </form>
    </div>
  </div>
</div>