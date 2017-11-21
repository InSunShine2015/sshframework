<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String chartToolRoot      = (String)session.getServletContext().getAttribute("toolRoot");
%>

	<script src="<%=chartToolRoot%>/charisma-master/js/jquery-1.7.2.min.js"></script>
	<script src="<%=chartToolRoot%>/charisma-master/js/jquery-ui-1.8.21.custom.min.js"></script>

	<script>
	Highcharts.setOptions({
		lang: {
			months: ['一月', '二月', '三月', '四月', '五月', '六月',  '七月', '八月', '九月',
				 '十月', '十月', '十二月'],
			shortMonths: ['01', '02', '03', '04', '05', '06',  '07', '08', '09',
							 '10', '11', '12'],	 
			weekdays: ['星期一', '星期二', '星期三', '星期四', '星期五', '星期六', '星期天']
		}
	});
	</script>