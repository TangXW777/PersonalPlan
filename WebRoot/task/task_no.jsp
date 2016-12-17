<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'add_report.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="css/head.css">
	<link rel="stylesheet" type="text/css" href="css/sidebar.css">
	
  </head>
  
  <body>
  <s:i18n name="plan_%{#session.request_locale}">  
  <%@ include file="/public/head.jspf" %> 
  <%@ include file="/public/sidebar.jspf" %>
  <div style="float:left;margin:160px 0 0 40px;">
  	<h2>
  		<s:text name="task.notask"></s:text>
  	</h2>
  </div>
  </s:i18n>
  </body>
</html>
