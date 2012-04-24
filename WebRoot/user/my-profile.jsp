<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
	if (session.getAttribute("user") == null) {
		response.sendRedirect(request.getContextPath() +  "/normal/login.jsp?previousPageURL=user/my-profile.jsp");
	}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
   
<title>My Profile -- ${sessionScope.user.name}</title>

<link href="<%=request.getContextPath()%>/css/seek_game_result_table.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/form_new.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/my-profile.css" rel="stylesheet" type="text/css" />

</head>


<body>

<!-- insert navigation bar of my-profile -->
<jsp:include flush="false" page="/user/snippet/navigation.jsp" />

<c:choose>
	<c:when test="${empty sessionScope.user.photo == false}">
		<div id="user_photo">
			<img src="<%=request.getContextPath()%>/upload/${sessionScope.user.photo}" style="max-width:250px;max-height:350px;"></img>
		</div>
	</c:when>
	
	<c:otherwise>
		<div id="user_photo">
			<img src="<%=request.getContextPath()%>/images/anonymous.png"></img>
		</div>
	</c:otherwise>
	
</c:choose>

<s:form action="editUserProfile.action" method="post" enctype="multipart/form-data" theme="simple">

<label class="mylabelstyle_inline">Country:</label>
<s:textfield cssClass="myinputstyle" name="nation" value="%{#session['user'].nation}"></s:textfield>

<label class="mylabelstyle_inline">Province/State:</label>
<s:textfield cssClass="myinputstyle" name="province" value="%{#session['user'].province}"></s:textfield>

<label class="mylabelstyle_inline">City:</label>
<s:textfield cssClass="myinputstyle" name="city" value="%{#session['user'].City}"></s:textfield>

<label class="mylabelstyle_inline">Upload Photo:</label>
<s:file name="file"></s:file>

<br />
<br />

<label class="mylabelstyle_inline">&nbsp;</label>
<s:submit cssClass="mysubmitstyle" value="Modify"></s:submit>

</s:form>

<hr />

<p><span>Games launched by me:</span></p>

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
				QR Code
			</th>
			<th scope="col">
				Modify
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
					<a href="<%=request.getContextPath()%>/inspiring_mode/recountInspiringGameQRCode.action?gameId=${gameInfo.id}" target="_blank">Recover</a>
				</td>
				<td>
					<a href="<%=request.getContextPath()%>/inspiring_mode/showModifyInspiringGamePage.action?gameId=${gameInfo.id}" target="_blank">modify</a>
				</td>
			</tr>
		</s:iterator>
	</tbody>
</table>



<p>Puzzle Solving:</p>

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
				QR Codes
			</th>
			<th scope="col">
				Modify
			</th>
		</tr>
	</thead>
	<tbody>
		<s:iterator value="launchedPuzzleSolvingGameInfoList" id="launchedPuzzleSolvingGameInfoList" var="gameInfo"
			status="rowstatus">
			<tr>
				<td>
					<a href="<%=request.getContextPath()%>/showPuzzleSolvingGameDetail.action?gameId=${gameInfo.id}">${gameInfo.gameName}</a>
				</td>
				<td>
					<fmt:formatDate value="${gameInfo.placeDate}" pattern="yyyy-MM-dd" />
				</td>
				<td>
					<a href="<%=request.getContextPath()%>/inspiring_mode/recountPuzzleSolvingGameQRCode.action?gameId=${gameInfo.id}" target="_blank">Recover</a>
				</td>
				<td>
					<a href="<%=request.getContextPath()%>/showModifyPuzzleSolvingGamePage.action?gameId=${gameInfo.id}" target="_blank">modify</a>
				</td>

			</tr>
		</s:iterator>
	</tbody>
</table>



</body>
</html>
