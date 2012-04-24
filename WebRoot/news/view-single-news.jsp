<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
   
<title>News</title>

<link href="<%=request.getContextPath()%>/css/news_and_event.css" rel="stylesheet" type="text/css" />

</head>
  
<body>

<p id="news_or_event_title">${theSingleNews.title }</p>
<p id="news_or_event_date">
<fmt:formatDate value="${theSingleNews.date}" pattern="yyyy-MM-dd HH:mm" />
</p>
<p id="news_or_event_content">${theSingleNews.content }</p>

</body>
</html>
