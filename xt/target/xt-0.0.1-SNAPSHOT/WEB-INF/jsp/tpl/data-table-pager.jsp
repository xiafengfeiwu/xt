<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="p-20">
  <ul class="pager ng-cloak">
    <li ng-repeat="page in pages"
        ng-class="{'disabled': !page.active, 'previous': page.type == 'prev', 'next': page.type == 'next'}"
        ng-show="page.type == 'prev' || page.type == 'next'" ng-switch="page.type">
      <button type="button" ng-switch-when="prev" ng-click="params.page(page.number)" class="btn btn-default pull-left">&laquo; Previous</button>
      <button type="button" ng-switch-when="next" ng-click="params.page(page.number)" class="btn btn-default pull-right">Next &raquo;</button>
    </li>
    <li>
      <div class="btn-group">
        <button type="button" ng-class="{'active':params.count() == 10}" ng-click="params.count(10)" class="btn btn-default">10</button>
        <button type="button" ng-class="{'active':params.count() == 25}" ng-click="params.count(25)" class="btn btn-default">25</button>
        <button type="button" ng-class="{'active':params.count() == 50}" ng-click="params.count(50)" class="btn btn-default">50</button>
        <button type="button" ng-class="{'active':params.count() == 100}" ng-click="params.count(100)" class="btn btn-default">100</button>
      </div>
    </li>
  </ul>
</div>
