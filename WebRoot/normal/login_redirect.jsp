<%
	String going_to = (String)session.getAttribute("GOING_TO");

	String previousPageURL = (String)request.getParameter("previousPageURL");
	String previousPageFullURL = (String)request.getParameter("previousPageFullURL");

	
	if (going_to != null) {
		//session GOING_TO is used when "action -> userLogin.action"
		//session GOING_TO is created by UserAuthIntercepter.java
		//and is cleaned by userLogout.action
		//Note: session GOING_TO has a higher previlige over previousPageURL and previousPageFullURL, 
		//		this is because login.jsp always makes previousPageURL,
		//		but session GOING_TO is only made when action is used.
		//		So, the session GOING_TO needs to be removed in time
		
		session.removeAttribute("going_to");	//essential!
		response.sendRedirect(going_to);
	} else if(previousPageFullURL != null && "".equals(previousPageFullURL) == false) {
		//previousPageFullURL is used when "loggedState.jsp -> userLogin.action"
		//previousPageFullURL is passed like this: "loggedState.jsp -> userLogin.action -> login_redirect.jsp"
		//Note: previousPageFullURL has a higher previlige over previousPageURL
		
		response.sendRedirect(previousPageFullURL);
	} else if(previousPageURL != null && "".equals(previousPageURL) == false) {
		//previousPageURL is used when "jsp -> userLogin.action"
		//previousPageURL is passed like this: "login.jsp -> userLogin.action -> login_redirect.jsp"
		
		response.sendRedirect(request.getContextPath() + "/" + previousPageURL);
	} else {
		response.sendRedirect(request.getContextPath() + "/index.jsp");
	}
	
%>
