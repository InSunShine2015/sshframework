<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<%@include file="../common/jsp_contants.jsp" %>
<%@ include file="../common/charisma_include.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  
<script> 
function changeclass(obj){
	   var a_s = document.getElementsByTagName("a"); 
	   for(var i=0;i<a_s.length;i++)
	   {
		   a_s[i].parentNode.className='';
	   }
	   obj.parentNode.className='active';
}
</script>
</head>

<body>

<div class="container-fluid">		
	<div class="row-fluid">
		<!-- left menu starts -->
			<div class="span2 main-menu-span">
				<div class="well sidebar-nav">
					<ul class="nav nav-tabs nav-stacked main-menu">
					   <c:forEach items="${mns}" var="mn">
					       <c:if test="${mn.url eq '' }">
					           <li class="nav-header hidden-tablet">${mn.name}</li>
					       </c:if>
					       <c:if test="${mn.url ne '' }">
						       <li><a class="ajax-link" onclick="changeclass(this);" href="${mn.url }" target="main"><i title="${mn.name }" class="icon-tasks"></i><span class="hidden-tablet">${mn.name }</span></a></li>
					       </c:if>
					   </c:forEach>
					</ul>
				</div><!--/.well -->
			</div><!--/span-->
			<!-- left menu ends -->
	</div>
</div>

</body>
</html>
