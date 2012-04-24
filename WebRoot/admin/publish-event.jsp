<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
   
<title>Publish Event</title>

<link href="<%=request.getContextPath()%>/css/form_new.css" rel="stylesheet" type="text/css" />

</head>
  
<body>

<s:form theme="simple" method="post" action="publishEvent">

	<label class="mylabelstyle">Title: </label>
	<s:textfield cssClass="myinputstyle" name="title" size="25" />
	
	<label class="mylabelstyle">Content: </label>
	<s:textarea name="content" cssStyle="width: 710px; height: 300px">
	</s:textarea>
	
	<br />
	
	<s:submit cssClass="mysubmitstyle" value="publish"></s:submit>

</s:form>

</body>
</html>
