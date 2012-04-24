<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
if(session.getAttribute("user") == null) {
	response.sendRedirect(request.getContextPath() + "/normal/login.jsp?previousPageURL=inspiring_mode/launch-inspiring-game.jsp");
}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
   
<title>My Internal Messages</title>

<link href="<%=request.getContextPath()%>/css/message_table.css" rel="stylesheet" type="text/css" />

</head>
  
<body>

<!-- insert navigation bar of my-profile -->
<jsp:include flush="false" page="/user/snippet/navigation.jsp" />

<table id="pattern-style-a">
	<thead>
		<tr>
			<th scope="col">
				Title
			</th>
			<th scope="col">
				Time
			</th>
			<th scope="col">
				From
			</th>
		</tr>
	</thead>
	<tbody>
		<s:iterator value="internalMessageList" var="internalMessage" status="rowstatus">
			<tr>
				<td>
					<a target="_blank" href="<%=request.getContextPath()%>/user/viewSingleInternalMessage.action?internalMessageId=${internalMessage.id}" >
					${internalMessage.title}
					</a>
				</td>
				<td>
					<fmt:formatDate value="${internalMessage.time}" pattern="yyyy-MM-dd HH:mm" />
				</td>
				<td>
					<a target="_blank" href="<%=request.getContextPath()%>/user/showUserProfile.action?userId=${internalMessage.userByUserFrom.id}">
					${internalMessage.userByUserFrom.name}
					</a>
				</td>
			</tr>
		</s:iterator>
	</tbody>
</table>

</body>
</html>
