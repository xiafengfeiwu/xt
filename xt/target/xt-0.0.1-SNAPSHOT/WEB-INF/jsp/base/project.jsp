<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div ng-controller="ProjectController">
	<div class="table-responsive well no-padding white no-margin">
      	<div class="card">
	        <div class="card-header">
	          <div class="actions">
	            <a href="" class="btn btn-link btn-icon" bs-dropdown="dropdown" data-template="tpl/dropdown-list-example.jspx" data-animation="mat-grow-top-right"><i class="md md-more-vert"></i></a>
	          </div>
	          <div class="card-title">共 <span ng-bind="data.length"></span> 条记录</div>
              <div class="small grey-text"> 此处展示的是平台的项目管理，只有系统管理员和区域管理员有权限查看和进行相应修改。</div>
	        </div>
		</div>
		<table class="table table-full m-b-60" id="table-area-1" >
			<thead>
				<tr fsm-sticky-header scroll-body="'#table-area-1'" scroll-stop="64">
					<th><input type="checkbox" class="relative" ng-model="selectAll" ng-click="checkAll()" /></th>
					<th>项目名称</th>
					<th>所在区域</th>
					<th>项目类型</th>
					<th>业主</th>
					<th>联系方式</th>
					<th>供暖面积</th>
					<th>供暖温度</th>
					<th>创建时间</th>
					<th class="text-center">操作</th>
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="(key, item) in data" ng-click="item.selected=!item.selected" ng-dblclick="editItem(item)">
					<td><input type="checkbox" class="relative" ng-model="item.selected" ng-click="$event.stopPropagation()" /></td>
					<td>{{ item.name }}</td>
					<td>{{ item.count }}</td>
					<td>{{ item.count }}</td>
					<td>{{ item.count }}</td>
					<td>{{ item.count }}</td>
					<td>{{ item.count }}</td>
					<td>{{ item.count }}</td>
					<td>{{ item.createTime }}</td>
					<td class="text-center" ng-click="$event.stopPropagation()">
						<button type="button" class="btn btn-link btn-round" data-title="编辑区域" ng-click="editItem(item)">
							<i class="md md-edit"></i>
						</button>
						<button type="button" class="btn btn-link btn-round" data-title="查看区域" ng-click="viewItem(item)">
							<i class="md md-info"></i>
						</button>
						<button type="button" class="btn btn-link btn-round" data-title="删除区域" ng-click="remove(item)">
							<i class="md md-delete"></i>
						</button>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="footer-buttons">
		<div class="btn btn-primary btn-round m-r-10 btn-footer" ng-show="(data|filter:{selected: true}).length" ng-click="remove()" data-title="移除 {{(data|filter:{selected: true}).length}} 条记录" bs-tooltip>
			<i class="md md-delete"></i>
		</div>
		<div class="btn btn-primary btn-round " ng-click="createItem()" data-title="新增项目" bs-tooltip>
			<i class="md md-add"></i>
		</div>
		<div class="btn btn-default btn-round m-r-10 btn-footer" scroll-to="top" ng-hide="scroll<100" data-title="Scroll to top" bs-tooltip>
			<i class="md md-arrow-drop-up"></i>
		</div>
	</div>
</div>