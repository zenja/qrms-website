<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  
  <title>Sign in</title>
  
  <link href="<%=request.getContextPath()%>/css/form_new.css" rel="stylesheet" type="text/css" />
  
</head>
  
<body>

<s:div id="loginDiv">

	<s:form id="loginForm" name="loginForm" theme="simple" method="post"
		action="userLogin">
		<input type="hidden" name="previousPageURL"
			value="${param.previousPageURL}" />
		<label class="mylabelstyle" for="loginEmail">
			Email:
		</label>
		<s:textfield cssClass="myinputstyle" id="loginEmail"
			name="user.loginEmail" size="25" />

		<label class="mylabelstyle" for="password">
			Password:
		</label>
		<s:password cssClass="myinputstyle" id="password"
			name="user.password" size="25" />

		<br />
		<br />

		<s:submit cssClass="mysubmitstyle" value="Sign in"></s:submit>
	</s:form>
	<br />
	<p>
		Do not have an account? You can
		<a href="<%=request.getContextPath()%>/normal/registration.jsp">register one</a>
	</p>
</s:div>

	</body>
</html>