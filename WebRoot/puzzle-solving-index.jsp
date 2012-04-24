<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
   
<title>Puzzle Solving</title>

<link href="<%=request.getContextPath()%>/css/game_scenario_home_page.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/puzzle_solving/index.css" rel="stylesheet" type="text/css" />

<link href='http://fonts.googleapis.com/css?family=Irish+Growler' rel='stylesheet' type='text/css'>

</head>
  
<body>

<div id="section_header" class="section">
<img class="flushleft" width="350" height="469" border="0"
	src="<%=request.getContextPath()%>/images/puzzle_solving/logo.jpg" />
<p class="section_title">Wanna solve a big puzzle?</p>
<p class="section_content">Try to solve a chain puzzle in your city or design your own puzzle.</p>
<a title="seek a game" id="seek_button_a" href="<%=request.getContextPath()%>/Seek.jsp" target="_blank"></a>
<a title="launch a game" id="launch_button_a" href="<%=request.getContextPath()%>/LaunchPuzzleSolvingGame.jsp" target="_blank"></a>
</div>

<div class="game_scenario_homepage_column_main" id="column_div_1">
<p class="game_scenario_homepage_column_title"><span>What is Puzzle Solving</span></p>
<p>
Puzzle Solving is the second game scenario in QR Marks the Spot. 
In this game scenario, you are going to solve a chain puzzle. 
A chain puzzle is made up of several QR codes. One QR code indicates the hint to find the next QR code. 
When you find the final QR code, you succeeds in solving this puzzle. 
You can also launch your own game. Have fun!
</p>

</div>


<div class="game_scenario_homepage_column_main" id="column_div_2">
<p class="game_scenario_homepage_column_title"><span>How to solve a puzzle</span></p>
<ol>
	<li>
	<a href="<%=request.getContextPath()%>/normal/registration.jsp" target="_blank">Register</a> for a free membership.
	</li>
	<li>
	Click <a href="<%=request.getContextPath()%>/Seek.jsp" target="_blank">"Seek a game"</a> on the web page of Puzzle Solving.
	</li>
	<li>
	Input some information to search for a game.
	</li>
	<li>
	Choose a game that you’re interested in.
	</li>
	<li>
	In the search result, choose a game that you’re interested in, 
	and you will see the details of this game.
	There are several QR codes in one game and the location of the first QR code is provided on the page. 
	All you need to do is to find it and get the information in it, which contains tips on how to find the next QR code.
	</li>
	<li>
	At last, you’ll find the last QR code which shows where the real treasure locates. :)
	</li>
	<li>
	And don’t forget to share your experiences on our website! :)
	</li>
</ol>
</div>



<div class="game_scenario_homepage_column" id="column_div_3">
<p class="game_scenario_homepage_column_title"><span>How to launch a game of Puzzle Solving</span></p>
<ol>
	<li>
	<a href="<%=request.getContextPath()%>/normal/registration.jsp" target="_blank">Register</a> for a free membership.
	</li>
	<li>
	Design your chain puzzle in mind. 
	Remember a careful design is the key of a successful puzzle. 
	Think how many QR codes you need and how to guide the explorers.
	Don't forget to put a big surprise into the final QR code.
	</li>
	<li>
	Click <a href="<%=request.getContextPath()%>/LaunchPuzzleSolvingGame.jsp" target="_blank">"Launch a game"</a> on the side of the page.
	</li>
	<li>
	Fill in the form on the new page.
	Click the "Launch" button.
	</li>
	<li>
	You will see a page telling you that you have successfully registered a game. 
	On this page, you will see some QR codes and you can change the size of them. 
	Print them and hide them to the corresponding locations separately you have specified in the previous form.
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



</body>
</html>
