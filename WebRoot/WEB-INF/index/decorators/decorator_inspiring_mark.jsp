<%@ page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%
String hostPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>
		QR Marks the Spot - <decorator:title default="Welcome" />
	</title>
	
	<!-- icon -->
	<link rel="shortcut icon" href="<%=request.getContextPath() %>/images/favicon.ico" />
	
	<!-- css -->
    <link href="<%=request.getContextPath() %>/css/decorator_new.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath() %>/css/head.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath() %>/css/logged_state.css" rel="stylesheet" type="text/css" />
    
    <link href="<%=request.getContextPath() %>/css/inspiring_decorator_special.css" rel="stylesheet" type="text/css" />

	
	<!-- js -->
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery1_3.js"></script>
	
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.blockUI.js"></script>
	
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/sliding_effect.js"></script>
	
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/news_event_ajax.js"></script>
	
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.dropshadow.js"></script>

		<decorator:head />
	
</head>

<decorator:usePage id="usePage" />

<body onload="<%=usePage.getProperty("body.onload")%>"
      onunload="<%=usePage.getProperty("body.onunload")%>">
      
<script type="text/javascript" src="<%=request.getContextPath()%>/js/signin-block.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	fetchNews("<%=request.getContextPath()%>");
	fetchEvents("<%=request.getContextPath()%>");
});
</script>

<script type="text/javascript">
var is_ie = !-[1,];
if(is_ie) {
	$(document).ready(function() {
		$(".sub_text").dropShadow({left: 0, top: 2, opacity: 0.8, color: "#000", blur: 2});
		$(".embedded_area").dropShadow({left: 1, top: 1, opacity: 0.8, color: "#444", blur: 1});
	});
}
</script>

<div class="main">
  <div class="header">
    <div class="block_header">
      <div class="logo"><a href="<%=request.getContextPath() %>/index.jsp"><img class="pic_logo" src="<%=request.getContextPath() %>/images/logo.gif" width="218" height="36" border="0" alt="logo" /></a></div>
      <div class="facebook-twitter">
        <a href="http://www.facebook.com/home.php#!/profile.php?id=100002063365439" target="_blank"><img id="facebook" src="<%=request.getContextPath() %>/images/facebook.png"  border="0"/></a>
        <a href="https://twitter.com/qrms_nju" target="_blank"><img id="twitter" src="<%=request.getContextPath() %>/images/twitter.png"  border="0"/></a>
      </div>
      <jsp:include flush="false" page="/loggedState.jsp" />
      <div class="menu">
        <ul>
          <li><a href="<%=request.getContextPath() %>/index.jsp"><span>Home</span></a></li>
          <li><a href="<%=request.getContextPath() %>/normal/about.jsp" target="_blank"><span> About Us</span></a></li>
          <li><a href="<%=request.getContextPath() %>/normal/registration.jsp"><span> Sign Up!</span></a></li>
        </ul>
      </div>
      <div class="clr"></div>
    </div>
  </div>
  <div class="sub_text">
    <div class="sub_text_resize">
      <h2><decorator:title default="Welcome" /></h2>
    </div>
    
  </div>
  <div class="clr"></div>
  <div class="body">
    <div class="body_resize">
      <div id="right-column">
        <div id="navigation-block">  
          <ul id="sliding-navigation">
            <li class="sliding-element"><h3>Inspiring Mark!</h3></li>
            <li class="sliding-element"><a href="<%=request.getContextPath()%>/inspiring_mode/index.jsp">Getting started</a></li>  
            <li class="sliding-element"><a href="<%=request.getContextPath()%>/inspiring_mode/seek-inspiring-game.jsp">Seek a game</a></li>  
            <li class="sliding-element"><a href="<%=request.getContextPath()%>/inspiring_mode/launch-inspiring-game.jsp">Launch a game</a></li>  
            <li class="sliding-element"><a href="<%=hostPath %>wordpress/" target="_blank">Our Blog</a></li>  
            <li class="sliding-element"><a href="<%=hostPath %>jforum/" target="_blank">Our Forum</a></li>
            <li class="sliding-element"><a href="<%=request.getContextPath()%>/user/showMyProfileMainPage.action">Personal area</a></li>
          </ul>
        </div>
        
        <div id="change_game_scenario_div">
	        <img src="<%=request.getContextPath()%>/images/change_game_scenario.png" />
	        <a id="change_game_scenario_a" href="javascript:void(0)">Change game scenario</a>
        </div>
        
        <!-- AddThis Button BEGIN -->
		<div class="addthis_toolbox addthis_default_style " id="share_bar">
		<a href="http://www.addthis.com/bookmark.php?v=250&amp;username=xa-4d189b3c1272bdbe" class="addthis_button_compact">Share</a>
		<span class="addthis_separator">|</span>
		<a class="addthis_button_facebook"></a>
		<a class="addthis_button_twitter"></a>
		<a class="addthis_button_favorites"></a>
		<a class="addthis_button_delicious"></a>
		</div>
		<!-- AddThis Button END -->
        
        <div class="right_column_block" id="news_div"><ul id="news_list"></ul></div>
        <div class="right_column_block" id="events_div"><ul id="events_list"></ul></div>
      </div>
    
      <div class="height-brick"></div>
      
      <div class="embedded_area">
      	<decorator:body /> <%-- 被装饰页面插入在这里 --%>
      </div>
      
      <div class="clr"></div>
    </div>
    <div class="clr"></div>
  </div>
  <jsp:include flush="false" page="/snippet/footer.jsp" />
  <jsp:include flush="false" page="/snippet/change_game_scenario.jsp" />
  
</div>

<!-- js for share button -->
<script type="text/javascript" src="http://s7.addthis.com/js/250/addthis_widget.js#username=xa-4d189b3c1272bdbe"></script>

</body>
</html>