<%@ page language="java" import="java.util.*,com.qrms.bean.User" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<%
	User currentUser = null;
	Integer currentUserId = null;
	
	//If not logged in, turn to login page
	if(session.getAttribute("user") == null) {
		response.sendRedirect(request.getContextPath() +  "/normal/login.jsp?previousPageURL=user/edit-user-profile.jsp");
	} else {
		//set some variables to be used
		currentUser = (User)session.getAttribute("user");
		currentUserId = currentUser.getId();
	}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<link href="<%=request.getContextPath()%>/css/form_new.css" rel="stylesheet" type="text/css" />

</head>

<body>

<!-- insert navigation bar of my-profile -->
<jsp:include flush="false" page="/user/snippet/navigation.jsp" />

<!-- User Profile Editor Form -->
<s:form action="editUserProfile.action" method="post" enctype="multipart/form-data" theme="simple">
	<input type="hidden" name="currentUserId" value="<%=currentUserId %>" />
	<label class="mylabelstyle">Nation: </label>
	<s:textfield cssClass="myinputstyle" name="nation" value="%{#session['user'].nation}"></s:textfield>
	
	<label class="mylabelstyle">Province/State: </label>
	<s:textfield cssClass="myinputstyle" name="province" value="%{#session['user'].province}"></s:textfield>
	
	<label class="mylabelstyle">City: </label>
	<s:textfield cssClass="myinputstyle" name="city" value="%{#session['user'].City}"></s:textfield>
	
	<label class="mylabelstyle">Upload photo:</label>
	<s:file label="Upload Photo" name="file"></s:file>
	
	<br />
	<br />
	
	<s:submit cssClass="mysubmitstyle" value="modify"></s:submit>
</s:form>

</body>


</html>
