<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>  
	<head> 
	<%@ include file="../common/jsp_contants.jsp" %>	  	
		<title>银商融信支付技术渠道管理系统</title>
	</head>
	<frameset rows="64,*" frameborder="NO" border="0" framespacing="0">
		<frame src="/def/top/" noresize="noresize" frameborder="NO"
			name="topFrame" scrolling="no" marginwidth="0" marginheight="0"
			target="main" />
		<frameset cols="200,*" rows="680,*" id="frame">
			<frame src="/def/left/" name="leftFrame" noresize="noresize"
				marginwidth="0" marginheight="0" frameborder="0" scrolling="yes"
				target="main" />
			<frame src="/def/right/" name="main" marginwidth="0" marginheight="0"
				frameborder="0" scrolling="auto" target="_self" />
		</frameset>
	</frameset>
</html>

