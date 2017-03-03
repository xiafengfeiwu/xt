<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<section class="forms-basic" ng-controller="UserController">
	<div class="page-header">
		<h1>
			系统用户
		</h1>
		<p class="lead">此处展示的是在您的权限范围内的用户数据，系统管理员可以查看所有用户的数据并有用户所有的操作权限，区域管理员只对自己授权内的用户有修改、删除等敏感权限，运维人员没有修改、删除的权限，普通用户没有查看用户的权限。</p>
	</div>
	<div class="row m-b-40">

		<div class="col-sm-12" style="margin-top: -58px">
			<form class="form-floating pull-right" style="width: 260px">
          		<fieldset>
			      	<div class="form-group has-success">
		              <label class="control-label" for="inputSuccess">通过用户名称、登录名、手机号等检索用户</label>
		              <input type="text" class="form-control" ng-model="keyword">
		            </div>
	            </fieldset>
	        </form>
		</div>

		<div class="col-sm-12">

			<div class="table-responsive well no-padding white no-margin">

				<table class="table table-hover table-full m-b-60" id="table-user-2172158" >
			<thead>
				<tr fsm-sticky-header scroll-body="'#table-user-2172158'" scroll-stop="64">
					<th width="30px"><input type="checkbox" class="relative" ng-model="selectAll" ng-click="checkAll()" /></th>
					<th width="50px"></th>
					<th>姓名</th>
					<th>登录名称</th>
					<th>联系方式</th>
					<th>注册时间</th>
					<th width="50px" class="text-center">状态</th>
					<th class="text-center">操作</th>
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="(key, user) in data" ng-dblclick="detail(user)" ng-if="keyword=='' || (user.userLoginName.indexOf(keyword)>=0 || user.userName.indexOf(keyword)>=0 || user.userNamePy.indexOf(keyword)>=0 || user.userPhone.indexOf(keyword)>=0)">
					<td><input type="checkbox" class="relative" ng-model="user.selected" ng-click="$event.stopPropagation()" /></td>
					<td><img ng-src="{{user.userPortraitPath}}" class="light-green darken-1 icon-color"/></td>
					<td>{{ user.userName }}</td>
					<td>{{ user.userLoginName }}</td>
					<td>{{ user.userPhone }}</td>
					<td>{{ user.userRegistTime | date: "yyyy-MM-dd" }}</td>
					<td class="text-center">
						<span ng-if="!user.userDisableStatus">
							<button type="button" class="btn btn-link black-text" data-title="点击禁用用户" ng-click="toggleUserStatus(user)" data-placement="bottom" bs-tooltip>
								<i class="md md-beenhere f12" style="color:#33cc99">正常</i>
							</button>
						</span>
						<span ng-if="user.userDisableStatus">
							<button type="button" class="btn btn-link black-text" data-title="点击解除禁用" ng-click="toggleUserStatus(user)" data-placement="bottom" bs-tooltip>
								<i class="md md-cancel f12" style="color:#fc5d62">禁用</i>
							</button>
						</span>
					</td>
					<td class="text-center" ng-click="$event.stopPropagation()">
						<button type="button" class="btn btn-link btn-round" data-title="编辑" ng-click="edit(user)" data-placement="bottom" bs-tooltip>
							<i class="md md-edit"></i>
						</button>
						<button type="button" class="btn btn-link btn-round" data-title="详情" ng-click="detail(user)" data-placement="bottom" bs-tooltip>
							<i class="md md-person"></i>
						</button>
						<button type="button" class="btn btn-link btn-round" data-title="删除" ng-click="remove(user)" data-placement="bottom" bs-tooltip>
							<i class="md md-delete"></i>
						</button>
					</td>
				</tr>
			</tbody>
		</table>
			</div>
		</div>
	</div>
	<div class="footer-buttons">
		<div class="btn btn-primary btn-round m-r-10 btn-footer" ng-show="(data|filter:{selected: true}).length>0" ng-click="removeMore()" data-title="删除 {{(data|filter:{selected: true}).length}} 条记录" bs-tooltip>
			<i class="md md-delete"></i>
		</div>
		<div class="btn btn-primary btn-round " ng-click="create()" data-title="新增" bs-tooltip>
			<i class="md md-person-add"></i>
		</div>
		<div class="btn btn-default btn-round m-r-10 btn-footer" scroll-to="top" ng-hide="scroll<100" data-title="返回顶部" bs-tooltip>
			<i class="md md-arrow-drop-up"></i>
		</div>
	</div>
</section>

