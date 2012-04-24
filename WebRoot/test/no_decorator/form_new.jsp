<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
   
<title>your title here</title>

<%-- code example
import css:
<link href="<%=request.getContextPath()%>/css/niceform.css" rel="stylesheet" type="text/css" />

import javascript:
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.jqtransform.js"></script>
 --%>
 
<link href="<%=request.getContextPath()%>/css/form_new.css" rel="stylesheet" type="text/css" />

</head>
  
<body>

<s:form id="loginForm" name="loginForm" theme="simple" method="post" action="userLogin">
	<input type="hidden" name="previousPageURL" value="${param.previousPageURL}" />
	<p>
		<label class="mylabelstyle" for="loginEmail">LoginEmail: </label>
		<s:textfield cssClass="myinputstyle" id="loginEmail" name="user.loginEmail" size="25"/>
	</p>
	
	<p>
		<label class="mylabelstyle" for="password">Password: </label>
		<s:password cssClass="myinputstyle" id="password" name="user.password" size="25" />
	</p>

	<p>
		<label for="remember">
		<s:checkbox id="remember" name="remember"/>
			remember me
		</label>
		<s:select cssClass="myselectstyle" id="cookieTime" name="cookieTime" 
			list="%{#{1:'1 day', 2:'1 week',3:'1 month'}}">
		</s:select>
	</p>
	
	<br />
	<label>&nbsp;</label><s:submit cssClass="mysubmitstyle" value="submit" class="button_submit"></s:submit>
</s:form>

</body>
</html>
