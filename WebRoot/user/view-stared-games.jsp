<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
	if (session.getAttribute("user") == null) {
		response.sendRedirect(request.getContextPath() +  "/normal/login.jsp?previousPageURL=user/view-stared-games.jsp");
	}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
   
<title>Stared Games</title>

<%-- code example
import css:
<link href="<%=request.getContextPath()%>/css/niceform.css" rel="stylesheet" type="text/css" />

import javascript:
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.jqtransform.js"></script>
 --%>
 
<link href="<%=request.getContextPath()%>/css/seek_game_result_table.css" rel="stylesheet" type="text/css" />

</head>
  
<body>

<!-- insert navigation bar of my-profile -->
<jsp:include flush="false" page="/user/snippet/navigation.jsp" />

<table id="box-table-a">
	<thead>
		<tr>
			<th scope="col">
				Name
			</th>
			<th scope="col">
				Game Type
			</th>
			<th scope="col">
				Description
			</th>
		</tr>
	</thead>
	<tbody>
		<s:iterator value="staredGameInfoList" var="staredGameInfo"
			status="rowstatus">
			<s:if test="%{#staredGameInfo.gameType==1}">
				<tr>
					<td>
						<a href="<%=request.getContextPath()%>/inspiring_mode/showInspiringGameDetail.action?gameId=${staredGameInfo.gameId}">${staredGameInfo.gameName}</a>
					</td>
					<td>
						Inspiring Mark
					</td>
					<td>
						Placed By ${staredGameInfo.gameLauncher.name}
					</td>
				</tr>
			</s:if>
			<s:elseif test="%{#staredGameInfo.gameType==2}">
				<tr>
					<td>
						<a href="<%=request.getContextPath()%>/showPuzzleSolvingGameDetail.action?gameId=${staredGameInfo.gameId}">${staredGameInfo.gameName}</a>
					</td>
					<td>
						Puzzle Solving
					</td>
					<td>
						Placed By ${staredGameInfo.gameLauncher.name}
					</td>
				</tr>
			</s:elseif>
			
		</s:iterator>
	</tbody>
</table>

</body>
</html>
