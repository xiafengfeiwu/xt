<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<section class="forms-basic" data-ng-controller="SupportController">
	<div class="page-header">
		<h1>技术支持</h1>
		<p class="lead">此处展示的是常见问题处理建议和相关资讯，管理员可以新增分类和新增资源。</p>
	</div>
	<div class="m-b-40" style="width: 100%;">
		<div style="float: left;width: 220px;height: 100%;padding-right: 6px;">
			<div class="card">
				<ul class="list-group">
					<li data-ng-repeat="(key, type) in types" class="list-group-item" style="font-size: 13px;">
						<div class="list-actions" data-ng-if="!type.systemItem">
							<a href="javascript:;" data-ng-click="showChangeTypeForm(type)" class="btn btn-link" style="font-size: 14px;line-height: 31px;"><i class="md md-edit"></i></a>
						</div>
						<a href="javascript:;" data-ng-click="showTypeArticles(type.knowledgeTypeId)"><i class="md md-turned-in-not"></i> {{type.knowledgeTypeName}}</a>
					</li>
					<li class="list-group-item" style="font-size: 14px;text-align: center">
						<a href="javascript:;" data-ng-click="showCreateTypeForm()"><i class="md md-add-box"></i>新增类别</a>
					</li>
				</ul>
			</div>
		</div>
		<div style="height: 100%;margin-left:222px;background-color: #fff;min-height: 320px;padding: 26px 8px">
			<div class="pull-right">
				<div class="btn btn-round-sm btn-link ng-scope" style="margin-top: -11px" data-ng-click="showCreateArticleForm()" data-bs-tooltip data-title="新增文档"><i class="md md-add"></i></div>
			</div>
			<h4 style="margin-top: 0px;"> <i class="md md-assistant-photo"></i> {{currentType.knowledgeTypeName}}</h4>
			<div style="margin-top: 22px;">
				<div data-ng-repeat="(key, article) in articles">
					<p style="line-height: 24px;text-indent: 0.5em" class="p-title">
						<i class="md md-keyboard-arrow-right"></i> 
						<span style="cursor: pointer" data-ng-click="showArticleDetail(article.knowledgeId)">{{article.knowledgeTitle}}</span>
						<button data-ng-click="showChangeArticleForm(article.knowledgeId)" class="btn btn-link btn-xs f14" style="display:none"><i class="md md-edit"></i></button>
						<button data-ng-click="removeArticle(article.knowledgeId)" class="btn btn-link btn-xs f14" style="display:none"><i class="md md-delete"></i></button>
					</p>
				</div>
			</div>
		</div>
	</div>
	<div class="footer-buttons">
		<div class="btn btn-default btn-round m-r-10 btn-footer" data-scroll-to="top" data-ng-hide="!scroll || scroll<100" data-title="返回顶部" data-bs-tooltip>
			<i class="md md-arrow-drop-up"></i>
		</div>
	</div>
</section>