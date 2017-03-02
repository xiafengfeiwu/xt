<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<section class="forms-basic" ng-controller="ReportController">
	<div class="page-header">
		<h1>
			<i class="md md-warn"></i> 用电耗能
		</h1>
		<p class="lead">此处展示的是热泵运行消耗的电量展示，可以按日用电，月用电，年用电视图分析用电量。</p>
	</div>
	<div class="row m-b-40">

		<div class="col-sm-12 col-md-6">
	      <div class="card small bar-chart">
	        <div class="card-header">
	          <div class="card-title">Bar charts</div>
	        </div>
	        <div class="card-content">
	          <c3chart bindto-id="bar-chart">
	            <chart-column column-id="Data 2"
	                          column-values="130,100,140,200,150,50"
	                          column-type="bar"/>
	            <chart-column column-id="Data 1"
	                          column-values="30,200,100,400,150,250"
	                          column-type="bar"/>
	            <chart-colors color-pattern="{{color_pattern}}"/>
	          </c3chart>
	        </div>
	      </div>
	    </div>

	</div>
</section>