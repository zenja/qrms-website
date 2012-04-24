<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
   
<title>Admin Login</title>

<link href="<%=request.getContextPath()%>/css/form_new.css" rel="stylesheet" type="text/css" />

<%-- code example
import css:
<link href="<%=request.getContextPath()%>/css/niceform.css" rel="stylesheet" type="text/css" />

import javascript:
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.jqtransform.js"></script>
 --%>

</head>
  
<body>

<s:form theme="simple" method="post" action="adminLogin">
	<label class="mylabelstyle">username: </label>
	<s:textfield cssClass="myinputstyle" name="admin.username" size="25" />
	
	<label class="mylabelstyle">password: </label>
	<s:textfield cssClass="myinputstyle" name="admin.password" size="25" />
	
	<br />
	
	<s:submit cssClass="mysubmitstyle" value="submit"></s:submit>
</s:form>

</body>
</html>
