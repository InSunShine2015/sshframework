<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
			String classid = "";
%>
<script>
var webRoot = '<%=basePath%>
	';
	var ifr1 = window.parent.document.getElementById('td1');
	ifr1.style.display = "none";
</script>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="utf-8">
<title>文件上传</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description"
	content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
<meta name="author" content="Muhammad Usman">
<%@ include file="common/jsp_contants.jsp"%>
<%@ include file="common/js_contants.jsp"%>
<%@ include file="common/charisma_include.jsp"%>

<!-- 验证 -->
<link rel="stylesheet"
	href="<%=toolRoot%>/validata/validationEngine.css">
<script src="<%=toolRoot%>/validata/jquery.validationEngine.js"></script>
<script src="<%=toolRoot%>/validata/jquery.validationEngine-zh_CN.js"></script>

<!-- 文件上传 -->
<script type="text/javascript"
	src="<%=toolRoot%>/jquery.form.js?v=<%=new Date()%>"></script>
<!-- 日历控件 -->
<script type="text/javascript"
	src="<%=toolRoot%>/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
	//ajax 方式上传文件操作  
	$(document).ready(function() {
		$('#btn').click(function() {
			if (checkData()) {
				$('#form1').ajaxSubmit({
					url : 'ajaxUpload.do',
					dataType : 'text',
					success : resutlMsg,
					error : errorMsg
				});
				function resutlMsg(msg) {
					alert(msg);
					$("#upfile").val("");
				}
				function errorMsg() {
					alert("导入excel出错！");
				}
			}
		});
	});

	//JS校验form表单信息  
	function checkData() {
		var fileDir = $("#upfile").val();
		var suffix = fileDir.substr(fileDir.lastIndexOf("."));
		if ("" == fileDir) {
			alert("选择需要导入的Excel文件！");
			return false;
		}
		if (".xls" != suffix && ".xlsx" != suffix) {
			alert("选择Excel格式的文件导入！");
			return false;
		}
		return true;
	}
</script>
<!-- 文件上传结束 -->
<style type="text/css">
.radio {
	text-align: left;
	width: 100px;
}
</style>
</head>

<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div id="content" class="span12">
				<!-- content starts -->
				<div class="row-fluid sortable">
					<div class="box span9">
						<div class="box-header well" data-original-title>
							<h2>
								<i class="icon-edit"></i> 文件上传
							</h2>
						</div>
						<div class="box-content">
							<form class="form-horizontal" id='form1'
								enctype="multipart/form-data" name='subform' method="post"
								action="${pageContext.request.contextPath}/upload.do">
								<fieldset>
									<div class="control-group">
										<label class="control-label" for="focusedInput">上传文件</label>
										<div class="controls">
											<input id="upfile" type="file" name="upfile">
										</div>
									</div>
									<div class="form-actions">
										<input type="button" class="btn btn-primary" value="上传文件"
											id="btn" name="btn">
									</div>
								</fieldset>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<hr>
</body>
</html>






