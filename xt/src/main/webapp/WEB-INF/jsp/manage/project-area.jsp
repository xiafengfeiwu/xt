<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<section class="forms-basic" ng-controller="ProjectAreaController">
	<div class="page-header">
		<h1>
			<i class="md md-input"></i> 项目区域
		</h1>
		<p class="lead">
			此处展示的是平台项目开展的区域列表，只有管理员和区域负责人可以查看和管理该项目内容，区域负责人只能查看自己负责区域内的项目区域。
		</p>
		<p class="lead">
			<i class="md md-info"> 操作提示：点击图标“+”展开区域；点击图标“-”闭合区域；双击区域名称打开区域信息管理页面。</i>
		</p>
	</div>
	<div class="row m-b-40">
		<div class="col-md-12">
			当前节点：{{currentNode.name}} ({{currentNode.code}})
		</div>
		<div class="col-md-12">
			<div class="well white">
				<div treecontrol class="tree-boot" tree-model="projectAreas"
					options="treeOptions" on-selection="showSelected(node)"
					selected-node="currentNode"><span ng-click="create()">{{node.name}} ({{node.code}})</span></div>
			</div>
		</div>
	</div>
	
	<div class="footer-buttons">
		<div class="btn btn-primary btn-round " ng-click="create()" data-title="新增" bs-tooltip>
			<i class="md md-add"></i>
		</div>
	</div>

</section>