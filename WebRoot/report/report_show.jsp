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

	<link rel="stylesheet" type="text/css" href="css/sidebar.css">
	<link rel="stylesheet" type="text/css" href="css/head.css">
	<link rel="stylesheet" type="text/css" href="css/report_show.css">
	
  </head>
  
  <body>
  <%@ include file="/public/head.jspf" %>
  <%@ include file="/public/sidebar.jspf" %>
  <div id="content">
  	<table>
  		<tr>
  			<th><s:text name="account"></s:text></th>
  			<th><s:text name="report.date"></s:text></th>
  			<th><s:text name="report.task"></s:text></th>
  			<th><s:text name="report.question"></s:text></th>
  			<th><s:text name="report.plan"></s:text></th>
  			<th><s:text name="report.remark"></s:text></th>
  		</tr>
  		<s:iterator value="rList" var="report">
	  		<tr>
	  			<td><s:property value="#report.user.account"></s:property></td>
	  			<td><s:date name="#report.date" format="yyyy-MM-dd HH:ss:mm"></s:date></td>
	  			<td><s:property value="#report.task"></s:property></td>
	  			<td><s:property value="#report.question"></s:property></td>
	  			<td><s:property value="#report.plan"></s:property></td>
	  			<td><s:property value="#report.remark"></s:property></td>
	  		</tr>
  		</s:iterator>
  	</table>
  </div>
  <div style="clear:both">
  	<s:debug></s:debug>
  </div>
  </body>
</html>
