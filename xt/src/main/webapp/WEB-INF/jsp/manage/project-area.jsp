<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<section class="forms-basic" ng-controller="ProjectAreaController">
	<div class="page-header">
		<div class="actions">
	  		<a menu-link class="btn black-text" href="#/manage/project" name="项目管理" data-title="点击返回项目管理" data-placement="left" bs-tooltip>
	  			<i class="md md-reply f12" style="color:#33cc99">返回项目管理</i>
	  		</a>
	    </div>
		<h1>
			<i class="md md-input"></i> 项目区域
		</h1>
		<p class="lead">
			此处展示的是平台项目开展的区域列表，只有管理员和区域负责人可以查看和管理该项目内容，区域负责人只能查看自己负责区域内的项目区域。
		</p>
		<p class="lead">
			<i class="md md-info"> 操作提示：点击图标“+”展开区域；点击图标“-”闭合区域；单击区域名称打开区域信息管理页面；只有无子级区域并且没有关联项目的区域可以被删除。</i>
		</p>
	</div>
	<div class="row m-b-40">
		<div class="col-sm-3">
			<div class="card bordered small">
		      	<div class="card-header">
		          <div class="card-title"><i class="md md-location-on"></i> 区域树级结构</div>
		        </div>
		        <div class="card-content">
		          <div treecontrol class="tree-boot" tree-model="projectAreas"
					options="treeOptions" selected-node="currentNode">{{node.areaName}}</div>
		        </div>
		    </div>
		</div>
		<div class="col-sm-9">
			<div class="well white" ng-show="currentNode">
		         <div class="p-20 clearfix">
			        <div class="pull-right">
			          <div class="btn btn-link black-text" ng-click="create(currentNode)" bs-tooltip title="点击新增下级区域"><i class="md md-add f12" style="color:deep-orange"> 增加下级区域</i></div>
			        </div>
			        <h4 class="grey-text">
			          <i class="md md-dashboard"></i>
			          <span class="hidden-xs">区域信息</span>
			        </h4>
			      </div>
		        
				<form class="form-floating" novalidate="novalidate" ng-submit="remove(currentNode)">
					<div class="row">
						<div class="col-sm-6">
				            <div class="form-group filled">
				              <label class="control-label">区域名称</label>
				              <input type="text" class="form-control" ng-model="currentNode.areaName" disabled="disabled"/>
				            </div>
				        </div>
						<div class="col-sm-6">
				            <div class="form-group filled">
				              <label class="control-label">区域编码</label>
				              <input type="text" class="form-control" ng-model="currentNode.areaCode" disabled="disabled"/>
				            </div>
				        </div>
						<div class="col-sm-6">
				            <div class="form-group filled">
				              <label class="control-label">天气编码</label>
				              <input type="text" class="form-control" ng-model="currentNode.weatherCode" disabled="disabled"/>
				            </div>
				        </div>
						<div class="col-sm-6">
				            <div class="form-group filled">
				              <label class="control-label">创建时间</label>
				              <input type="text" class="form-control" value="{{currentNode.createTime  | date: 'yyyy-MM-dd HH:mm:ss' }}" disabled="disabled"/>
				            </div>
				        </div>
						<div class="col-sm-12">
							<div class="row">
						     </div>
				        </div>
						<div class="col-sm-12" ng-show="currentNode.children.length==0 && currentNode.areaCode!='110000'">
				            <div class="form-group">
				              <button type="submit" class="btn btn-primary">删除</button>
				            </div>
				        </div>
				    </div>
				</form>
			</div>
			<div class="well white text-center" ng-hide="currentNode">
				<img src="assets/img/icons/select_area_icon.png" style="width: 80%;max-width: 380px" class="img-rounded"/>
			</div>
		</div>
	</div>
</section>