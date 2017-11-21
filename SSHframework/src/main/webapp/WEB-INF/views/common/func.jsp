
<%@page import="java.util.List"%>
<%!
	public static String titleSub(String sourceStr,int count,String view){
		if (view == null)view = "";
		if (sourceStr == null || "null".equals(sourceStr) || "".equals(sourceStr))return "";
		int len = sourceStr.length();
		if (len <= count)return sourceStr;
		return sourceStr.substring(0,count) + view;
	}
 %>
