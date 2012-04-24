<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
	if (session.getAttribute("admin") == null) {
		response.sendRedirect("login.jsp");
	}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
   
<title>Administration</title>

<%-- code example
import css:
<link href="<%=request.getContextPath()%>/css/niceform.css" rel="stylesheet" type="text/css" />

import javascript:
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.jqtransform.js"></script>
 --%>

</head>
  
<body>

<p><a href="adminLogout.action">Log out</a></p>
<p><a href="publish-news.jsp">Publish News</a></p>
<p><a href="publish-event.jsp">Publish an Event</a></p>

</body>
</html>
