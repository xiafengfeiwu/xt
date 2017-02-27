<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<li>
  <a href="#" data-toggle="collapse" data-target="\#{{name | nospace}}" aria-expanded="false" aria-controls="{{name | nospace}}" class="collapsible-header waves-effect" ng-class="{active: isOpen()}">{{name}}</a>
  <ul id="{{name | nospace}}" class="collapse" ng-class="{in: isOpen()}" ng-transclude></ul>
</li>
