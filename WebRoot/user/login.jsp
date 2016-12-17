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
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		.error{
			border:none;	
		}	
		.error ul{
			margin:0px;
			padding:0px;
			list-style-type:none;
			font-size:12px;
			color:red;
			font-weight:bold;
		}
	</style>

  </head>
  
  <body>
  <s:i18n name="plan_%{#session.request_locale}"> 
  <h2><s:text name="login"></s:text></h2>
  <s:form action="user/login" method="post" theme="simple">
  	<table border="1">
  		<tr>
  			<th><s:text name="login.account"></s:text></th>
  			<td><s:textfield name="user.account"></s:textfield></td>
  			<td class="error"><s:fielderror fieldName="user.account"></s:fielderror></td>
  		</tr>
  		<tr>
  			<th><s:text name="login.password"></s:text></th>
  			<td><s:textfield name="user.password"></s:textfield></td>
  			<td class="error"><s:fielderror fieldName="user.password"></s:fielderror></td>
  		</tr>
  		<tr>
  			<td colspan="3" align="center"><s:submit value="%{getText('submit')}"></s:submit></td>
  		</tr>
  	</table>
  </s:form>
  </s:i18n>
  </body>
  <s:debug></s:debug>
</html>
