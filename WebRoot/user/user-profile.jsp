<%@ page language="java" import="java.util.*,com.qrms.bean.User" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>

<title>User Profile -- ${userInfo.name}</title>

<link href="<%=request.getContextPath()%>/css/seek_game_result_table.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/user-profile.css" rel="stylesheet" type="text/css" />
	
</head>

<body>
	
<c:choose>
	<c:when test="${empty userInfo.photo == false}">
		<div id="user_photo">
			<img src="<%=request.getContextPath()%>/upload/${userInfo.photo}" style="max-width:250px;max-height:350px;"></img>
		</div>
	</c:when>
	
	<c:otherwise>
		<div id="user_photo">
			<img src="<%=request.getContextPath()%>/images/anonymous.png"></img>
		</div>
	</c:otherwise>
	
</c:choose>

<p><span>Name: </span>${userInfo.name}</p>
<p><span>Nation: </span>${userInfo.nation}</p>
<p><span>Province: </span>${userInfo.province}</p>
<p><span>City: </span>${userInfo.city}</p>

<br />

<p>
<img src="<%=request.getContextPath()%>/images/message_small.png">
<a href="<%=request.getContextPath()%>/user/send-internal-message.jsp?userIdTo=${userInfo.id}&userNameTo=${userInfo.name}" target="_blank">
Send him/her a message
</a>
</p>

<p><span>Games launched by ${userInfo.name}:</span></p>

<p>Inspiring Mark:</p>
<table id="box-table-a">
	<thead>
		<tr>
			<th scope="col">
				Name
			</th>
			<th scope="col">
				Place Date
			</th>
			<th scope="col">
				Description
			</th>
		</tr>
	</thead>
	<tbody>
		<s:iterator value="launchedInspiringGameInfoList" id="launchedInspiringGameInfoList" var="gameInfo"
			status="rowstatus">
			<tr>
				<td>
					<a href="<%=request.getContextPath()%>/inspiring_mode/showInspiringGameDetail.action?gameId=${gameInfo.id}">${gameInfo.gameName}</a>
				</td>
				<td>
					<fmt:formatDate value="${gameInfo.placeDate}" pattern="yyyy-MM-dd" />
				</td>
				<td>
					Placed By ${gameInfo.user.name}
				</td>
			</tr>
		</s:iterator>
	</tbody>
</table>

<p>Puzzle Solving:</p>

<table id="box-table-a">
	<thead>
		<tr>
			<th>
				Overall Difficulty/
				<br />
				Terrain Difficulty
			</th>
			<th scope="col">
				Date
			</th>
			<th scope="col">
				Description
			</th>
		</tr>
	</thead>
	<tbody>
		<s:iterator value="launchedPuzzleSolvingGameInfoList" id="launchedPuzzleSolvingGameInfoList" var="gameInfo"
			status="rowstatus">
			<tr>
				<td>
					${gameInfo.difficultyLevel} / ${gameInfo.terrainLevel}
				</td>
				<td>
					<fmt:formatDate value="${gameInfo.placeDate}" pattern="yyyy-MM-dd" />
				</td>
				<td>
					<a
						href="<%=request.getContextPath()%>/showPuzzleSolvingGameDetail.action?gameId=${gameInfo.id}">${gameInfo.gameName}</a>
					Placed By ${gameInfo.tblUserinfo.name}
				</td>

			</tr>
		</s:iterator>
	</tbody>
</table>
	

</body>


</html>
