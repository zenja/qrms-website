<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
   
<title>Comment</title>

<%-- code example
import css:
<link href="<%=request.getContextPath()%>/css/niceform.css" rel="stylesheet" type="text/css" />

import javascript:
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.jqtransform.js"></script>
 --%>

</head>
  
<body>

<p>
<a href="<%=request.getContextPath()%>/user/showUserProfile?userId=${gameComment.user.id}">
${gameComment.user.name }
</a>
 posted at <fmt:formatDate value="${gameComment.time}" pattern="yyyy-MM-dd HH:mm" /></p>

<c:choose>
	<c:when test="${gameComment.commentType == 1}">
		<img title="found!" src="<%=request.getContextPath()%>/images/game_comment/found.png"/>
		<p><strong>Found!</strong></p>
	</c:when>
	
	<c:when test="${gameComment.commentType == 2}">
		<img title="didn't find" src="<%=request.getContextPath()%>/images/game_comment/not_found.png"/>
		<p>Didn't found</p>
	</c:when>
	
	<c:when test="${gameComment.commentType == 4}">
		<img title="need maintenance" src="<%=request.getContextPath()%>/images/game_comment/need_maintenance.png"/>
		<p>Need maintenance</p>
	</c:when>
</c:choose>

<p>${gameComment.textcomment }</p>

<c:choose>
	<c:when test="${empty gameComment.photo == false}">
		<p>Photo:</p>
		<img src="<%=request.getContextPath()%>/upload/${gameComment.photo}" style="max-width:690px;max-height:800px;"></img>
	</c:when>
</c:choose>

</body>
</html>
