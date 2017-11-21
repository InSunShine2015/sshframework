<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="common/jsp_contants.jsp" %>
<%@ include file="common/js_contants.jsp" %>
<script src="<%=jsRoot%>/lib/jquery.js" type="text/javascript"></script>
<script src="<%=jsRoot%>/lib/jquery.validate.js" type="text/javascript"></script>
<script src="<%=jsRoot%>/lib/jquery.metadata.js" type="text/javascript"></script>
<script src="<%=jsRoot%>/lib/messages_cn.js" type="text/javascript"></script>
<title>后台登录</title>
<link rel="stylesheet" href="<%=cssRoot%>/login/login.css"/>
</head>

<body style="height:100%">
<div class="mailLoginBox">
  <div class="mailLogin">
    <div class="headerBox">
      <div class="header clearfix">
        <h1 style="color:#3898d2">渠道管理系统</h1>
      </div>
    </div>
    
    <div class="mainBox bg1" style="background-image: url(<%=imageRoot%>/login/mainphoto1.png); background-attachment: scroll; background-color: rgb(56, 152, 210);/*background-color: rgb(247, 141, 23)*/; background-position: 50% 50%; background-repeat: no-repeat no-repeat;">
      <div class="main">
        <div class="positionBox clearfix">
          <div class="loginBox">
            <ul class="tit clearfix">
              <!--被选中的情况，在li上加入class为current-->
              <li class="current"> <a href="javascript:void(0);" onClick="return false;"> 后台登录 </a> </li>
            </ul>
            <div class="freeMailbox">
              <form name="subform" action="/sys/login.do" method="post">
                <div class="freeError" style="visibility:visble;"> 
                <span class="loginError tip11" style="">
                
                </span>
                </div>
                <!--错误信息提示-->
                <div class="usernameBox">
                  <input tabindex="1" id="username" type="text" name='userName' class="username" value="${username }">
                  
                </div>
                <span class="loginError" style="visibility:visible">${usermsg}</span>
                <div class="passwordBox">
                  <input tabindex="2" id="pwd" type="password" name='password' class="password" value="${password }">
                  
                </div>
                <span class="SecurityError" style="visibility:visible">${pwdmsg }${vercode}</span>
                <div class="SecurityBox">
                  <input  tabindex="3" id="Security" class="Security" name="verifycode" id="verifycode" type=text value="" maxLength=4 size=8/>
                  <img title='看不清 点一下' id="validatecodeimg" src="/verifycode.jsp" onclick='changeImg();' style='float:right;width: 134px;height: 34px; cursor:hand;'/>
                  <label for="Security" class="placeholder">请输入验证码</label>
                </div>
                <div class="loginOrRegister clearfix">
                  <INPUT class="loginBtn" id="loginBtn" style="cursor: pointer;" type="submit" tabindex="3" value="登录">
                </div>
              </form>
              <div class="loginFooter" style="display:" > <span>请输入用户名和密码，并正确输入验证码进行登录</span> </div>
              <!--补充信息提示-->
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="footerBox">
      <div class="footer clearfix">
        <p>北京银商融信有限公司&nbsp;&nbsp;&nbsp;&nbsp;Copyright&nbsp;&nbsp;2014&nbsp;HuiLiFang&nbsp;Corporation,&nbsp;All&nbsp;Rights&nbsp;Reserved</p>
      </div>
    </div>
  </div>
</div>
<script language='javascript'>
            $('#username').focus(function(){
                $('label[for=username]').hide();
                $('div.usernameBox').addClass('focus');
            })
            $('#username').blur(function(){
                if(!$('#username').val()){
                    $('label[for=username]').show();
                }
                $('div.usernameBox').removeClass('focus');
            })
			//
            $('#pwd').focus(function(){
                $('label[for=pwd]').hide();
                $('div.passwordBox').addClass('focus');
            })
            $('#pwd').blur(function(){
                if(!$('#pwd').val()){
                    $('label[for=pwd]').show();
                }
                $('div.passwordBox').removeClass('focus');
            })            
			//
			  $('#Security').focus(function(){
                $('label[for=Security]').hide();
                $('div.Security').addClass('focus');
            })
            $('#Security').blur(function(){
                if(!$('#Security').val()){
                    $('label[for=Security]').show();
                }
                $('div.SecurityBox').removeClass('focus');
            })
        function changeImg(){
	        document.getElementById("validatecodeimg").src="/verifycode.jsp?"+Math.random();
	    }        
        </script>
</body>
</html>

