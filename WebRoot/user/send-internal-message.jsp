<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
	if (session.getAttribute("user") == null) {
		response.sendRedirect(request.getContextPath() +  "/normal/login.jsp?previousPageURL=user/send-internal-message.jsp");
	}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
   
<title>Send Internal Message</title>

<link href="<%=request.getContextPath()%>/css/form_new.css" rel="stylesheet" type="text/css" />

</head>
  
<body>

<s:form action="sendInternalMessage" method="POST" theme="simple">

	<input type="hidden" name="userIdTo" value="${param.userIdTo}" />

	<label class="mylabelstyle">From: ${sessionScope.user.name}</label>
	
	<label class="mylabelstyle">To: ${param.userNameTo}</label>

	<label class="mylabelstyle">Title: </label>
	<s:textfield cssClass="myinputstyle" name="title" size="25" />
	
	<label class="mylabelstyle">Content: </label>
	<s:textarea name="content" cssStyle="width: 700px; height: 300px">
	</s:textarea>
	
	<br />
	<br />
	
	<s:submit cssClass="mysubmitstyle" value="Send"></s:submit>

</s:form>


</body>
</html>
