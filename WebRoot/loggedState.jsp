<%@ page language="java" import="java.util.*,com.qrms.bean.User" pageEncoding="utf-8"%>
<div id="loggedState">
<%
	String previousPageFullURL = request.getRequestURI().toString();
	String queryString = request.getQueryString();
	if (queryString != null && "".equals(queryString) == false) {
		previousPageFullURL = previousPageFullURL + "?" + queryString;
	}
%>
<%
	User currentUser = (User) session.getAttribute("user");
	String username = null;

	if (currentUser != null) {
		username = currentUser.getName();
%>
<div id="user_profile_state">
	<%=username%><br/>
	<a href="<%=request.getContextPath()%>/user/showMyProfileMainPage.action" target="_blank">profile</a>
	<span>|</span>
	<a href="userLogout.action">sign out</a>
</div>
<%
	} else {
%>

<a id="sign_in_link" href="javascript:void(0);">
<img id="sign_in_img" src="<%=request.getContextPath()%>/images/signin.png"></img>
</a>

<div id="signin_form_div">
<form method="post" id="signin_form" action="userLogin">
	<%--NOTE: "previousPageFullURL" but not "previousPageURL"--%>
	<input type="hidden" name="previousPageFullURL" value="<%=previousPageFullURL%>"></input>
	<p>
		<label class="signin_label" for="username">
			Email:
		</label>
		<input class="signin_input" id="username" name="user.loginEmail" value="" title="username" type="text" />
	</p>
	<p>
		<label class="signin_label" for="password">
			Password:
		</label>
		<input class="signin_input" id="password" name="user.password" value="" title="password" type="password" />
	</p>
	<p class="remember">
		<input id="signin_submit" value="Sign in" tabindex="6" type="submit" />
	</p>
</form>
</div>
<%
	}
%>
</div>

