<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>QR Marks the Spot</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<link href="<%=request.getContextPath()%>/css/index.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/head.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/logged_state.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery1_3.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/slideshow.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.blockUI.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/news_event_ajax.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.dropshadow.js"></script>

<!-- icon -->
<link rel="shortcut icon" href="<%=request.getContextPath()%>/images/favicon.ico" />

</head>

<body>

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
		$("#slider-container").dropShadow({left: 4, top: 4, opacity: 0.8, color: "#000", blur: 3});
	});
}
</script>

<div class="main">
  <div class="header">
    <div class="block_header">
      <div class="logo"><a href="<%=request.getContextPath() %>/index.jsp"><img src="images/logo.gif" width="218" height="36" border="0" alt="logo" /></a></div>
      <div class="facebook-twitter">
        <a href="http://www.facebook.com/home.php#!/profile.php?id=100002063365439" target="_blank"><img id="facebook" src="<%=request.getContextPath() %>/images/facebook.png" border="0" /></a>
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
  <div class="header_box">
    <div class="header_box_resize">
      <div class="slider">
      	<div id="slider-container">
      	  <div id="gallery">
				<a href="<%=request.getContextPath()%>/normal/getting-started.jsp#basic_idea" target="_blank" class="show">
					<img src="<%=request.getContextPath() %>/images/slides/slide_main.jpg" alt="QR Marks The Spot!" width="507" height="315" title="" alt="" rel='<h3>QR Marks The Spot!</h3><p class="slide-text">In QR Marks the Spot, you can launch or participate in a QR-based game of different interesting game scenarios.</p>'/>
				</a>
			
				<a href="<%=request.getContextPath()%>/normal/getting-started.jsp#inspiring_mark" target="_blank">
					<img src="<%=request.getContextPath() %>/images/slides/slide_inspiring.jpg" alt="Inspiring Mark" width="507" height="315" title="" alt="" rel='<h3>Inspiring Mark</h3><p class="slide-text">Play to your greatest imagination, you can give your QR a life. A story? A poem? Or just a funny joke? QR can be inspiring! </p>'/>
				</a>
			
				<a href="<%=request.getContextPath()%>/normal/getting-started.jsp#puzzle_solving" target="_blank">
					<img src="<%=request.getContextPath() %>/images/slides/slide_puzzlesolving.jpg" alt="Puzzle Solving" width="507" height="315" title="" alt="" rel='<h3>Puzzle Solving</h3><p class="slide-text">Wanna solve a big puzzle? Or travel around the city? With QR Marks The Spot, you can combine these all. </p>'/>
				</a>
				
				<a href="<%=request.getContextPath()%>/normal/getting-started.jsp#conquest_and_defence" target="_blank">
					<img src="<%=request.getContextPath() %>/images/slides/slide_qd.jpg" alt="Conquest &amp; Defence" width="507" height="315" title="" alt="" rel='<h3>Conquest &amp; Defence</h3><p class="slide-text">Hurry up! You can use your QR to occupy cities. Defend your cities from being conquered. You can be the ruler of the world! </p>'/>
				</a>
			
				<div class="caption"><div class="content"></div></div>
			</div>
			
			<div class="clr"></div>
        </div>
	  </div>
      <div class="header_text">
        <h2>Let's mark the world.</h2>
        <p>QR Marks the Spot is for creating and hosting exciting QR-based games</p>
        <p><a href="<%=request.getContextPath()%>/normal/getting-started.jsp" target="_blank"><img src="images/more_information.gif" alt="picture" width="157" height="42" border="0" /></a></p>
      </div>
    </div>
  </div>
  <div class="FBG_resize">
    <div class="FBG">
      <div class="Recent"><a href="<%=request.getContextPath()%>/inspiring_mode"><img src="<%=request.getContextPath()%>/images/inspiring.png" alt="picture" width="72" height="72" border="0"/></a>
        <p><a href="<%=request.getContextPath()%>/inspiring_mode"><span>Inspiring Mark! </span></a><br />
          Play to your greatest imagination, you can give your QR a life. A story? A poem? Or just a funny joke? QR can be inspiring!</p>
        <a href="<%=request.getContextPath()%>/inspiring_mode"><img src="<%=request.getContextPath()%>/images/fbg_read_more.gif" alt="picture" width="66" height="25" border="0" /></a></div>
      <div class="Recent"><a href="<%=request.getContextPath()%>/puzzle-solving-index.jsp"><img src="<%=request.getContextPath()%>/images/puzzle.png" alt="picture" width="72" height="72"  border="0"/></a>
        <p><a href="<%=request.getContextPath()%>/puzzle-solving-index.jsp"><span>Puzzle Solving </span></a><br />
          Wanna solve a big puzzle? Or travel around the city? With QR Marks The Spot, you can combine these all. Let's Go!</p>
        <a href="<%=request.getContextPath()%>/puzzle-solving-index.jsp"><img src="<%=request.getContextPath()%>/images/fbg_read_more.gif" alt="picture" width="66" height="25" border="0" /></a></div>
      <div class="Recent"><a href="<%=request.getContextPath()%>/conquest_and_defence/"><img src="<%=request.getContextPath()%>/images/defend.png" alt="picture" width="72" height="72"  border="0"/></a>
        <p><a href="<%=request.getContextPath()%>/conquest_and_defence/"><span>Conquest &amp; Defence </span></a><br />
          Hurry up! You can use your QR to occupy cities. Defend your cities from being conquered. You can be the ruler of the world! </p>
        <a href="<%=request.getContextPath()%>/conquest_and_defence"><img src="<%=request.getContextPath()%>/images/fbg_read_more.gif" alt="picture" width="66" height="25" border="0" /></a></div>
      <div class="clr"></div>
    </div>
  </div>
  <div class="clr"></div>
  <div class="body">
    <div class="body_resize">
      <div class="right">
        <h2>Events</h2>
        <img class="border_img" src="<%=request.getContextPath()%>/images/events_block.png" alt="picture" width="274" height="116" />
        <ul id="events_list"></ul>
      </div>
      <div class="right">
        <h2>Our Philosophy</h2>
        <img class="border_img" src="<%=request.getContextPath()%>/images/philosophy_block.png" alt="picture" width="274" height="116" />
        <ul id="philosophy_list">
        	<li><a>Bring inspiring things to others</a></li>
        	<li><a>Play to your greatest imagination</a></li>
        	<li><a>Be responsible for your games</a></li>
        	<li><a>Exchange your ideas and experiences</a></li>
        	<li><a>Enjoy the process</a></li>
        </ul>
      </div>
      <div class="right">
        <h2>News</h2>
        <img class="border_img" src="<%=request.getContextPath()%>/images/news_block.png" alt="picture" width="274" height="116" />
        <ul id="news_list"></ul>
      </div>
      <div class="clr"></div>
    </div>
    <div class="clr"></div>
  </div>
  <jsp:include flush="false" page="/snippet/footer.jsp" />
</div>



</body>
</html>