<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="com.jesus.sshframework.model.User"%>
<%@page import="com.jesus.sshframework.constant.SysConstant"%>
<%@page import="com.jesus.sshframework.util.WebCookies"%>


<%
	String toolRoot      = (String)session.getServletContext().getAttribute("toolRoot");
	String imageRoot     = (String)session.getServletContext().getAttribute("imageRoot");
	String jsRoot        = (String)session.getServletContext().getAttribute("jsRoot");
	String cssRoot       = (String)session.getServletContext().getAttribute("cssRoot");
	String uploadRoot    = (String)session.getServletContext().getAttribute("uploadRoot");
	User sessionStaff = (User)session.getAttribute(SysConstant.LOGINUSER); 
%>
