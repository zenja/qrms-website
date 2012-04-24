<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
   
<title>Conquest &amp; Defence</title>

<link href="<%=request.getContextPath()%>/css/game_scenario_home_page.css" rel="stylesheet" type="text/css" />

<link href='http://fonts.googleapis.com/css?family=Irish+Growler' rel='stylesheet' type='text/css'>

</head>
  
<body>

<div class="game_scenario_homepage_top_display">
	<img src="<%=request.getContextPath()%>/images/android.png" />
	<h1>Conquest &amp; Defence for Android</h1>
	<p>
	Conquest &amp; Defence for Android lets you build your own kingdom. 
	Make a QR code to establish a territory and you can attack other user's territories to conquer them.
	Carefully defend your territories to prevent then from attack.
	</p>
	<p>
	<a href="<%=request.getContextPath()%>/conquest_and_defence/C&D-0.1.apk"><img border="0" src="<%=request.getContextPath()%>/images/download_button.png" /></a>
	</p>
</div>

<div class="game_scenario_homepage_column_main" id="column_div_1">
<p class="game_scenario_homepage_column_title"><span>What is Conquest &amp; Defence</span></p>
<p>
Conquest &amp; Defence is a location-based application for mobile devices which is based on QR codes. 
In Conquest &amp; Defence, QR code is used to mark the territory that was established by some player. 
Every player can choose either to establish a new territory or to attach a existed territory by simply taking a photo of the corresponding QR code. 
</p>
<p>
When playing this game, you can also communicate with other players nearby. 
In this way, this game is a fun provider as well as a platform to make friends. 
</p>
</div>

<div class="game_scenario_homepage_column_main" id="column_div_2">
<p class="game_scenario_homepage_column_title"><span>Easy Steps to Conquest &amp; Defence</span></p>
<ol>
	<li>
	First you need a smart phone supporting GPS. Currently only android-based mobile phones are supported.
	</li>
	<li>
	<a href="<%=request.getContextPath()%>/normal/registration.jsp" target="_blank">Register</a> for a free membership
	</li>
	<li>
	<a href="#" target="_blank">Download</a> the client application for mobile phones
	</li>
	<li>
	Use the registered account to sign in.
	</li>
	<li>
	Check territories nearby on google map or search a territory by input the name.
	</li>
	<li>
	Find the QR code which marks a territory and take a photo of it by the client.
	</li>
	<li>
	Share your experience with others.
	</li>
</ol>
</div>

<div class="game_scenario_homepage_column" id="column_div_3">
<p class="game_scenario_homepage_column_title"><span>How to view the information of a stronghold</span></p>
<p>
There is a Google Map in the main interface to show all the strongholds around you. 
Each stronghold is noted by a marker. You can view the detailed information of a stronghold by clicking the marker on it. 
A new interface will take you to the stronghold with everything you need inside it. 
</p>
</div>

<div class="game_scenario_homepage_column" id="column_div_4">
<p class="game_scenario_homepage_column_title"><span>How to search for strongholds</span></p>
<p>
In the bottom of the main interface, we provide a button that introduces the searching interface. 
In the searching interface, the players can input keywords of the stronghold in an input box. 
After the search button is pressed, a list of related strongholds will appear. 
</p>
</div>

<div class="game_scenario_homepage_column" id="column_div_5">
<p class="game_scenario_homepage_column_title"><span>How to set up a stronghold</span></p>
<p>
First, the player should prepare a tangible QR code that contains any content the player like to add. 
Then the player should go to the location and place the QR code and remember to ensure that the QR code can be found and can stay there as long as it can. 
After this, the player should press the set up button in the menu of the main interface, 
then a camera interface will appear, if the player shoot the QR code correctly, 
there will be a hint indicates that the setting up is successful.
</p>
</div>

<div class="game_scenario_homepage_column" id="column_div_6">
<p class="game_scenario_homepage_column_title"><span>How to occupy a stronghold</span></p>
<p>
In the bottom of the main interface, we provide a button that introduces the searching interface. 
In the searching interface, the players can input keywords of the stronghold in an input box. 
After the search button is pressed, a list of related strongholds will appear. 
</p>
</div>

<div class="game_scenario_homepage_column" id="column_div_7">
<p class="game_scenario_homepage_column_title"><span>How to reinforce your stronghold</span></p>
<p>
In the “My Strongholds” interface we provide a button that can reinforce the strongholds. 
One stronghold can be reinforced once within 24 hours. 
Each reinforcement can add three health points to the stronghold. 
</p>
</div>




</body>
</html>
