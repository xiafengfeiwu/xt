<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="modal" tabindex="-1" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-ng-click="$hide()">&times;</button>
        <h4 class="modal-title">处理评价</h4>
      </div>
      <div class="modal-body" style="height: 380px;overflow: auto;">
      	<blockquote style="font-size: 12.68px;line-height: 34px;margin: 0 0 1px;border-left:0px solid rgba(255, 255, 255, 0)">
			<form class="form-floating" novalidate="novalidate" data-ng-submit="saveEvaluate()">
		      	<div class="form-group filled">
		           <label class="control-label">等级</label>
		           <ui-select ng-model="evaluateLevels.selected" class="f13" theme="select2" search-enabled="false" required>
		             <ui-select-match placeholder="选择一个等级"><span ng-bind="$select.selected.name"></span></ui-select-match>
		             <ui-select-choices repeat="level in evaluateLevels | filter: $select.search">
		               <div ng-bind-html="level.name | highlight: $select.search"></div>
		             </ui-select-choices>
		           </ui-select>
		      	</div>
		      	<div class="form-group filled">
					<label class="control-label">评价描述</label>
					<textarea data-ng-model="currentHandle.evaluateDescript" class="form-control" required></textarea>
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-primary pull-right">提交</button>
				</div>
	      	</form>
		</blockquote>
      </div>
    </div>
  </div>
</div>