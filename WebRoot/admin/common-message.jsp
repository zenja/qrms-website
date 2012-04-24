<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!-- used to show any message -->
<%--
parameters:
msg: the main content of the message
type: the type of the message(success, error, warning, info)(CASE SENSITIVE!)
returnUrl: the url of the return link
returnText: the text of the return link
 --%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
   
<title>Message</title>

<link href="<%=request.getContextPath()%>/css/common_message.css" rel="stylesheet" type="text/css" />
   
</head>
  
<body>

<div 
class="
<c:if test="${empty param.type == true}">
info
</c:if>
${param.type}
">
${param.msg}
</div>

<div class="return_link">
	<c:if test="${empty param.returnUrl == false}">
		<p><a href="${param.returnUrl}">${param.returnText}</a></p>
	</c:if>
</div>

</body>
</html>


