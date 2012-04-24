<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<script type="text/javascript" src="<%=request.getContextPath() %>/js/news_event_ajax.js"></script>

</head>
  
<body onload='fetchNews();fetchEvents();'>

<div id="events_div"></div>
<div id="news_div"></div>

</body>
</html>
