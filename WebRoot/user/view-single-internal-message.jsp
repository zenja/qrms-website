<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
   
<title>Internal Message</title>


</head>
  
<body>

<!-- insert navigation bar of my-profile -->
<jsp:include flush="false" page="/user/snippet/navigation.jsp" />

<p>${internalMessage.title }</p>
<p>${internalMessage.content }</p>

</body>
</html>
