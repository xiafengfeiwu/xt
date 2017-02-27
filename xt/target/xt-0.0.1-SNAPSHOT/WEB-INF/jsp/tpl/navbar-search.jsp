<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div>
  <div ng-if="showNavbarSearch" class="mat-slide-right pull-right">
    <form class="search-form form-inline ng-valid pull-left" ng-show="showNavbarSearch" ng-submit="submitNavbarSearch()">
      <div class="form-group">
        <label class="sr-only" for="search-input">检索</label>
        <input type="text" class="form-control" placeholder="检索..." autofocus>
      </div>
    </form>
  </div>

  <div class="pull-right">
    <button ng-click="toggleSearch()" class="btn btn-sm btn-link pull-left withoutripple">
      <i class="md md-search f20"></i>
    </button>
  </div>
</div>
