<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
  <%@ include file="../common/jsp_contants.jsp" %>
  <%@ include file="../common/charisma_include.jsp" %> 
  <script language=JavaScript>
	function logout(){
		if (confirm("您确定要退出控制面板吗？"))
		top.location = "/sys/logout.do";
		return false;
	}
	</script>
	<meta http-equiv=Content-Type content=text/html;charset=utf-8>
	<base target="main">
</head>
<body leftmargin="0" topmargin="0">
	<!-- topbar starts -->
	<div class="navbar">
		<div class="navbar-inner">
			<div class="container-fluid">
				<a class="btn btn-navbar" data-toggle="collapse" data-target=".top-nav.nav-collapse,.sidebar-nav.nav-collapse">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</a>
				<a class="brand" href="index.html"> <img alt="Charisma Logo" src="<%=imageRoot %>/img/logo20.png" /> <span>渠道管理系统</span></a>
				
				<!-- theme selector starts -->
				<!-- theme selector ends -->
				
				<!-- user dropdown starts -->
				<div class="btn-group pull-right">
					<a class="btn btn-danger" a href="#" target="_self" onclick="logout();"><i class="icon-off icon-white"></i> 退出登录</a>
					<span class="btn btn-primary" href="#"><i class="icon-user icon-white"></i><b>${loguser.username }：您好！</b></a>
					<!--  sessionStaff.getUsername()-->
				</div>
				
			</div>
		</div>
	</div>
	<!-- topbar ends -->
</body>
</html>

