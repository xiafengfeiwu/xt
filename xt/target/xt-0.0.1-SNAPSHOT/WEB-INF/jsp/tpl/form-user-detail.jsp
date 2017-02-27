<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="aside bs-docs-aside" tabindex="-1" role="dialog">
  <div class="close">
    <div class="btn btn-round btn-info" ng-click="$hide()"><i class="md md-close"></i></div>
  </div>
  <div class="aside-dialog">
    <div class="aside-body bs-sidebar">
      <form class="form-floating" novalidate="novalidate">
        <fieldset>
          <legend>用户详情 </legend>
          <div class="form-group filled">
         		<label style="width: 120px;text-align: right;">姓名：</label>{{user.userName}}
          </div>
          <div class="form-group filled">
            	<label style="width: 120px;text-align: right;">登录名称：</label>{{user.userLoginName}}
          </div>
          <div class="form-group filled">
           		<label style="width: 120px;text-align: right;">联系方式：</label>{{user.userPhone}}
          </div>
          <div class="form-group filled">
            	<label style="width: 120px;text-align: right;">角色：</label>{{user.roleName}}
          </div>
          <div class="form-group filled">
            	<label style="width: 120px;text-align: right;">绑定微信：</label><span ng-show="user.userWxOpenId!=null">已绑定({{user.userWxOpenId}})</span><span ng-show="user.userWxOpenId==null">未绑定</span>
          </div>
          <div class="form-group filled">
            	<label style="width: 120px;text-align: right;">当前状态：</label><span ng-show="!user.userDisableStatus">正常</span><span ng-show="user.userDisableStatus">禁用</span>
          </div>
          <div class="form-group filled">
           		<label style="width: 120px;text-align: right;">注册时间：</label>{{user.userRegistTime  | date: 'yyyy-MM-dd HH:mm:ss' }}
          </div>
          <div class="form-group filled">
				<label style="width: 120px;text-align: right;">最后更新时间：</label>{{user.userModifyTime  | date: 'yyyy-MM-dd HH:mm:ss' }}
          </div>
        </fieldset>
      </form>
    </div>
  </div>
</div>