<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
  	<%@ include file="../common/jsp_contants.jsp" %>
  	<%@ include file="../common/charisma_include.jsp" %>
  	<%@ include file="../common/highcharts_include.jsp" %>
    <title>渠道管理后台 </title>
  	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  </head>
<body> 
	<div class="container-fluid">
		<div class="row-fluid">
			<!-- content starts -->
			<div>
				<ul class="breadcrumb">
					<li>
						<a href="#">主页</a> <span class="divider">/</span>
					</li>
					<!-- <li>
						<a href="#">操作仓</a>
					</li> -->
				</ul>
			</div>
			
			<div class="row-fluid sortable">
				<div class="box span12">
					<div class="box-header well" data-original-title>
						<h2><i class="icon-picture"></i> 欢迎使用渠道管理系统，当前日期：<fmt:formatDate value='${nowDate}' type='date' pattern="yyyy-MM-dd"/></h2>
		 			</div>
			     </div>
			</div>
			
			<!-- <div class="row-fluid sortable">
				
				<div class="box">
					<div class="box-header well">
						<h2><i class="icon-list-alt"></i> 用户访问量趋势图</h2>
					</div>
					<div class="box-content">
						<div id="chart_container"  class="center" style="min-width:800px;height:300px" ></div>
					</div>
				</div>
			</div> -->
		</div><!--/fluid-row-->
	</div><!--/.fluid-container-->
</body>
</html>
