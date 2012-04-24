<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
   
<title>Inspiring Mark!</title>

<link href="<%=request.getContextPath()%>/css/inspiring_mark/index.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/game_scenario_home_page.css" rel="stylesheet" type="text/css" />

<link href='http://fonts.googleapis.com/css?family=Irish+Growler' rel='stylesheet' type='text/css'>

</head>
  
<body>

<script type="text/javascript">
$(document).ready(function() { 
	$('#quick_manual_link').click(function() { 
		$.blockUI({ message: $('#__ss_7092446'), css:{textAlign: 'left', left: '30%', top: '80px', width: '435px', height: '420px', padding: '0 35px'} });
	
		$('.blockOverlay').attr('title','Click to unblock').click($.unblockUI);
	});
});
</script>

<div id="section_header" class="section">
<img class="flushleft" width="350" height="282" border="0"
	src="<%=request.getContextPath()%>/images/inspiring_mark/logo.jpg" />
<p class="section_title">Aha, I find it!</p>
<p class="section_content">QR can be inspiring. <br />You can spread your inspiration through a QR code.</p>
<p class="section_content"><a id="quick_manual_link" href="javascript:void(0);">Quick Manual</a></p>
<a title="seek a game" id="seek_button_a" href="<%=request.getContextPath()%>/inspiring_mode/seek-inspiring-game.jsp" target="_blank"></a>
<a title="launch a game" id="launch_button_a" href="<%=request.getContextPath()%>/inspiring_mode/launch-inspiring-game.jsp" target="_blank"></a>
</div>

<div class="game_scenario_homepage_column_main" id="column_div_1">
<p class="game_scenario_homepage_column_title"><span>What is Inspiring Mark</span></p>
<p>
Inspiring Mark is the simplest game scenario in QR Marks the Spot, but it can provide great excitement. 
You can put something into a QR code and hide it to somewhere. Other people can try to find it. 
You can also try to find other people's QR code to share his or her inspiring things.
What makes this simple game scenario interesting, 
meaningful and dynamic is that we encourage you to put inspiring things into a QR code with your greatest imagination. 
Such inspiring things can be anything, 
for example, happy things, reflection on life, beautiful poetries, and introduction to the buildings nearby. 
There is no limitation of what types of inspiring things you should note on a QR code, so just play to your greatest imagination. 
Have fun!
</p>

</div>


<div class="game_scenario_homepage_column_main" id="column_div_2">
<p class="game_scenario_homepage_column_title"><span>How to find an inspiring mark</span></p>
<ol>
	<li>
	<a href="<%=request.getContextPath()%>/normal/registration.jsp" target="_blank">Register</a> for a free membership.
	</li>
	<li>
	Click <a href="<%=request.getContextPath()%>/inspiring_mode/seek-inspiring-game.jsp" target="_blank">"Seek a game"</a> on the right side of the page.
	</li>
	<li>
	Input some information to search for a game.
	</li>
	<li>
	In the search result, choose a game that you’re interested in, 
	and you will see the details of this game, including the position of the mark and some hint.
	</li>
	<li>
	Keep the location of the destination and the hint provided by the game launcher in mind, and set out to find that mark.
	</li>
	<li>
	When you succeed in finding the mark, make use of the QR code reader software in your mobile phone to scan the QR code.
	In the QR code, you will find an URL which will take you to the mysterious inspiring things! :)
	You can find lots of QR code reader software <a href="<%=request.getContextPath()%>/normal/getting-started.jsp#qr_code_reader_software" target="_blank">here</a>.
	</li>
	<li>
	And don’t forget to share your experiences on our website! :)
	</li>
</ol>
</div>


<div class="game_scenario_homepage_column_main" id="column_div_3">
<p class="game_scenario_homepage_column_title"><span>How to launch a game of Inspiring Mark</span></p>
<ol>
	<li>
	<a href="<%=request.getContextPath()%>/normal/registration.jsp" target="_blank">Register</a> for a free membership.
	</li>
	<li>
	Design your inspiring thing in mind.
	</li>
	<li>
	Click <a href="<%=request.getContextPath()%>/inspiring_mode/launch-inspiring-game.jsp" target="_blank">"Launch a game"</a> on the side of the page.
	</li>
	<li>
	Fill in the form on the new page and click the "Launch" button.
	</li>
	<li>
	You will see a page telling you that you have successfully registered a game. 
	On this page, you will see an QR code and you can change the size of it. 
	Print it and hide it to the location you have specified in the previous form.
	</li>
	<li>
	Till now you have successfully launched your game! :)
	</li>
</ol>
</div>




<div class="game_scenario_homepage_column" id="column_div_4">
<p class="game_scenario_homepage_column_title"><span>Play for fun</span></p>
<ol>
	<li>
	Remember that happiness exists for sharing. Why not take your relatives and friends to work together?
	</li>
	<li>
	Be mindful of the thread that indicates the QR code. It may not as simple as it seems.
	</li>
	<li>
	Difficulties there may be, but sharp eyes solve everything. Pay your attention to anywhere that may hide a QR code.
	</li>
	<li>
	It will really a remarkable thing if you successfully find the treasure. Just leave a message and upload your photos to show off!
	</li>
</ol>
</div>

<!-- Quick Manual Presentation -->
<div style="width:425px;display:none" id="__ss_7092446">
<strong style="display:block;margin:12px 0 4px">
<a href="http://www.slideshare.net/wangxing/quick-manual-of-inspiring-mark" title="Quick Manual of Inspiring Mark">Quick Manual of Inspiring Mark</a>
</strong>
<object id="__sse7092446" width="425" height="355"><param name="movie" value="http://static.slidesharecdn.com/swf/ssplayer2.swf?doc=quick-manual-inspiring-mark-110228120214-phpapp01&stripped_title=quick-manual-of-inspiring-mark&userName=wangxing" />
<param name="allowFullScreen" value="true"/><param name="allowScriptAccess" value="always"/>
<embed name="__sse7092446" src="http://static.slidesharecdn.com/swf/ssplayer2.swf?doc=quick-manual-inspiring-mark-110228120214-phpapp01&stripped_title=quick-manual-of-inspiring-mark&userName=wangxing" type="application/x-shockwave-flash" allowscriptaccess="always" allowfullscreen="true" width="425" height="355"></embed>
</object>
<div style="padding:5px 0 12px">View more <a href="http://www.slideshare.net/">presentations</a> from <a href="http://www.slideshare.net/wangxing">wangxing</a>.
</div>
</div>

</body>
</html>
