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
	<link rel="stylesheet" type="text/css" href="css/report_add.css">
	
  </head>
  
  <body>
  <s:i18n name="plan_%{#session.request_locale}">
  <%@ include file="/public/head.jspf" %> 
  <%@ include file="/public/sidebar.jspf" %>
  <div id="content">
  	<s:form action="task/addTask" method="post" theme="simple">
  	<table>
  		<tr>
  			<th><s:text name="task.content"></s:text></th>
  		<tr>
  		<tr>
  			<td>
  				<s:textarea name="task.content"></s:textarea>
  			</td>
  		<tr>
  		<tr>
  			<th><s:text name="task.remark"></s:text></th>
  		<tr>
  		<tr>
  			<td>
  				<s:textarea name="task.remark"></s:textarea>
  			</td>
  		<tr>
  		<tr>
  			<td>
  				<!-- 获取当前时间 -->
  				<s:bean name="java.util.Date" var="now"></s:bean>
  				<!-- 
				<s:date name="#now" format="yyyy-MM-dd HH:mm:ss" var="now"/>
				-->
  				<s:hidden name="task.date" value="%{#now}"></s:hidden>
  			</td>
  		<tr>
  		<tr>
  			<td>
  				<!-- 任务状态(默认为未完成) -->
  				<s:hidden name="task.status" value="%{getText('task.status0')}"></s:hidden>
  			</td>
  		<tr>
  		<tr class="submit">
  			<td><s:submit value="%{getText('submit')}"></s:submit></td>
  		</tr>
  	</table>
  	</s:form>
  </div>
  <div style="clear:both">
  	<s:debug></s:debug>
  </div>
  </s:i18n>
  </body>
</html>
