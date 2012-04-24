<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
   
<title>Getting Started</title>

<link href="<%=request.getContextPath()%>/css/getting_started.css" rel="stylesheet" type="text/css" />
   
</head>
  
<body>

<script type="text/javascript">
$(document).ready(function(){
	$('.class_signup_button_a').hover(function(){
		$(this).stop().animate({'opacity' : '0'}, 500);
	}, function(){$(this).stop().animate({'opacity' : '1'}, 500);});
});
</script>


<div class="getting_started">

<p id="signup_button_p"><a class="class_signup_button_a" id="signup_button_a" href="<%=request.getContextPath()%>/normal/registration.jsp"></a></p><br/>

<div id="catalog" class="div_title">
<p>
FAQ
</p>
</div>
<ul id="catalog">
	<li><a href="#what_is_a_qr_code">What is a QR?</a></li>
	<li><a href="#qr_is_lovely">QR is lovely</a></li>
	<li><a href="#inspiring_mark">Inspiring Mark</a></li>
	<li><a href="#puzzle_solving">Puzzle Solving</a></li>
	<li><a href="#conquest_and_defence">Conquest &amp; Defence</a></li>
	<li><a href="#qr_code_reader_software">QR Code Reader Software</a></li>
	<li><a href="#qr_code_software_applications">QR Code Software &amp; Applications</a></li>
	<li><a href="#basic_idea">The basic idea of QR Marks The Spot</a></li>
	<li><a href="#user_manual">User Manual</a></li>
</ul>


<div id="what_is_a_qr_code" class="div_title">
<p>
What is a QR?
<a href="#catalog" >
<img class="go_top" border="0" src="<%=request.getContextPath()%>/images/go_top.png" />
</a>
</p>
</div>
<div class="dotline"></div>
<p>A <a href="http://en.wikipedia.org/wiki/QR_Code" target="_blank">QR Code</a> is a matrix barcode (or two-dimensional code), readable by QR scanners, mobile phones with a camera, and smartphones. The code consists of black modules arranged in a square pattern on white background. The information encoded can be text, URL or other data.</p>
<p><img src="<%=request.getContextPath()%>/images/qrcode_example.png"/></p>
<p>There are <a href="http://www.qrstuff.com/qr_code_examples.html" target="_blank">more examples</a>.</p>
<p>You can generate your own QR code <a href="http://www.qrstuff.com" target="_blank">here</a>.</p>
<p>Related content:</p>
<p><a href="http://searchengineland.com/what-is-a-qr-code-and-why-do-you-need-one-27588" target="_blank">What Is A QR Code And Why Do You Need One?</a></p>


<div id="qr_is_lovely" class="div_title">
<p>
QR is lovely
<a href="#catalog" >
<img class="go_top" border="0" src="<%=request.getContextPath()%>/images/go_top.png" />
</a>
</p>
</div>
<div class="dotline"></div>
<p>You can use QR to do a lot of things. A QR code can contain the url of your blog, your telephone number, a SMS message and many other things. QR provides us with quick access to the information contained in it. But do not stop here. Since QR code can contain whatever information you like, you can give it a life. It's all up to you!</p>
<p>Below is some ideas about interesting usage of QR.</p>
<div style="width:425px" id="__ss_4635418"><strong style="display:block;margin:12px 0 4px"><a href="http://www.slideshare.net/Stutts/20-interesting-things-qr-codes" title="20 Interesting Things: QR Codes">20 Interesting Things: QR Codes</a></strong>
<object id="__sse4635418" width="425" height="355"><param name="movie" value="http://static.slidesharecdn.com/swf/ssplayer2.swf?doc=cdocumentsandsettingsdstuttsdesktop20interestingthingsqrcodesjune2010-100628104038-phpapp01&stripped_title=20-interesting-things-qr-codes&userName=Stutts" /><param name="allowFullScreen" value="true"/><param name="allowScriptAccess" value="always"/><embed name="__sse4635418" src="http://static.slidesharecdn.com/swf/ssplayer2.swf?doc=cdocumentsandsettingsdstuttsdesktop20interestingthingsqrcodesjune2010-100628104038-phpapp01&stripped_title=20-interesting-things-qr-codes&userName=Stutts" type="application/x-shockwave-flash" allowscriptaccess="always" allowfullscreen="true" width="425" height="355"></embed></object><div style="padding:5px 0 12px">View more <a href="http://www.slideshare.net/">presentations</a> from <a href="http://www.slideshare.net/Stutts">David Stutts</a>.</div></div>


<div id="inspiring_mark" class="div_title">
<p>
Inspiring Mark!
<a href="#catalog" >
<img class="go_top" border="0" src="<%=request.getContextPath()%>/images/go_top.png" />
</a>
</p>
</div>
<div class="dotline"></div>
<p id="inspiring_mark_main">
We can attach our ideas to the world. 
We can record what we think about and share our happiness, wisdom, stories or any other things with other people with a QR code.
Just write your words on our web site, and print the QR we generated for you and attach it to your destination.
So when someone finds the QR code you leaved, he or she will see what you have written down with a surprise 
and share the wonderful thoughts on it. 
</p>
<p>
<a href="<%=request.getContextPath()%>/inspiring_mode/" target="_blank">Getting started with Inspiring Mark!</a>
</p>


<div id="puzzle_solving" class="div_title">
<p>
Puzzle Solving
<a href="#catalog" >
<img class="go_top" border="0" src="<%=request.getContextPath()%>/images/go_top.png" />
</a>
</p>
</div>
<div class="dotline"></div>
<p id="puzzle_solving_main">
The second game scenario is Puzzle Solving. 
In this scenario, users make chain puzzles with QR code; others try to solve the puzzle. 
Let’s take an example to show how a game of Puzzle Solving is launched and participated. 
Tom, who lives in Paris, was going to launch a game. 
First, he selected three sites in advance, denoted by S1, S2 and S3. 
Then he registered (on the website) the first location of S1 and the contents of three QR codes (denoted by QR1, QR2 and QR3) on the website. 
The content of QR1 indicates the way to find S2, where you can get QR2. 
The content of QR2 help you find S3 and QR3, where the big surprise lies. 
The website generated these three QR codes for Tom; what he should do last is to put them to corresponding sites. 
By now a Puzzle Solving game has been successfully launched. 
Helen is a hardcore user of QR Marks the Spot and she is travelling around Paris. 
She searches for some Puzzle Solving games in Pairs and gets great interest in Tom’s game. 
She views the location of S1 and manages to get there. 
She refers to the hint leaved by Tom and finally she succeeds in finding the QR1 hidden there. 
She takes out her mobile phone, scans the QR code and finds the location of next site. 
She finds QR2 the same way as QR1, and finally, she finds QR3 and the big surprise in it. 
She is so happy and she cannot wait to share her experiences with others on the website!
</p>
<p>
<a href="<%=request.getContextPath()%>/puzzle-solving-index.jsp" target="_blank">Getting started with Puzzle Solving</a>
</p>


<div id="conquest_and_defence" class="div_title">
<p>
Conquest &amp; Defence
<a href="#catalog" >
<img class="go_top" border="0" src="<%=request.getContextPath()%>/images/go_top.png" />
</a>
</p>
</div>
<div class="dotline"></div>
<p id="conquest_and_defence_main">
The third game scenario is Conquest &amp; Defence. 
This game mode simulates war and the battlefield is the whole world. 
The weapon our players use is an android mobile phone. 
The users can use our client application to conquer and defend a stronghold which is a virtual territory that maps the real geographical location. 
To join this game you should install our game application in your android phone, 
and you will find the many strongholds around the world which are set by other players. 
If you want to conquer one and be an honorable lord, 
you just travel to the city or maybe it is in the city you stay in and find the exact location. 
If you are lucky enough, you will find a QR code there which is a key to break the stronghold. 
Now you press the conquer button and then shoot the QR code, here you completed a presentation of an attack. 
A stronghold can initially withstand 10 times of attacks, the last attacker will become the lords of the stronghold. 
Each player can only attack the same strongholds once per day. 
So there is a high probability that you attack a stronghold but you do not own the place. 
You should cheer up! 
Because the journey you take to find is that the stronghold weighs more than everything! 
The other way you can become a lord is that you set up a stronghold yourself. 
Firstly you should prepare a QR code as the mark of the stronghold. 
Secondly you should find a suitable location and place the QR code there, 
then you press the set up button, now you are required to photograph the QR code and the application will upload it to our server. 
Congratulations! You set up a new stronghold in the game world. 
Of course, your stronghold will be attacked. 
But you can fix the strongholds, you can only do the work of repair once per day, and each one repair can add additional 3 withstanding of attacks; of course the limit is 10. 
You can see the worldwide players setting up, attacking, and occupying the strongholds and the game experience they share. 
You will in your Conquest & Defence journey to find more interesting information.
</p>
<p>
<a href="<%=request.getContextPath()%>/conquest_and_defence/" target="_blank">Getting started with Conquest &amp; Defence</a>
</p>


<div id="qr_code_reader_software" class="div_title">
<p>
QR Code Reader Software
<a href="#catalog" >
<img class="go_top" border="0" src="<%=request.getContextPath()%>/images/go_top.png" />
</a>
</p>
</div>
<div class="dotline"></div>
<img src="http://www.qrstuff.com/images/space.gif" width="1" height="7" vspace="0" hspace="0" border="0"><br>
<p>For your phone to be able to read QR Codes you will need to have QR Code barcode reading software installed on it.</p>
<p>The following sites offer the option of downloading via PC and then transferring to your phone, or visiting with your with your smartphone via browser for direct download and installation. Some also have the option of setting the application up on your phone as a device bookmark.</p>
<ul>
  <li><a href="http://click.linksynergy.com/fs-bin/stat?id=zkFoRaEN7XM&offerid=146261&type=3&subid=0&tmpid=1826&RD_PARM1=http%253A%252F%252Fitunes.apple.com%252Fus%252Fapp%252Foptiscan-qr-code-scanner-generator%252Fid304099767%253Fmt%253D8%2526uo%253D6%2526partnerId%253D30" target="_blank">Optiscan</a><p> - The best QR Code scanner for iPhones - it understands all the new trickier encoding types and has definitely kept up with development in QR code technology.</p></li>
  <li><a href="http://www.i-nigma.com/personal/GetReader.asp" target="_blank">I-Nigma</a><p> - Probably the most popular decoder/reader application and works on most of the popular smartphones. (<a href="http://www.i-nigma.com/personal/Devices.asp" target="_blank">Supported Devices</a>)</p></li>
  <li><a href="http://www.quickmark.com.tw/En/basic/download.asp" target="_blank">Quickmark</a><p> - For most phones, but most noticeably has an?<a href="http://www.quickmark.com.tw/En/Info/android.asp" target="_blank">Android version</a>?and a?<a href="http://www.quickmark.com.tw/En/tech/t2.asp" target="_blank">Windows Mobile version</a></p></li>
  <li><a href="http://code.google.com/p/zxing/wiki/GetTheReader" target="_blank">Barcode Scanner</a><p> - Another good Android QR code reader. Available in the Android Market in the Applications/Shopping category.</p></li>
  <li><a href="http://reader.kaywa.com/" target="_blank">Kaywa Reader</a></li>
  <li><a href="http://mobilecodes.nokia.com/scan.htm" target="_blank">Nokia</a><p> - Most Nokia's now come standard with the Nokia's own scanning software, but this one is good for N78, 6210 Navigator, N80, N96 and 6220 Classic</p></li>
  <li><a href="http://code.google.com/p/zxing/wiki/GetTheReader" target="_blank">Google Zxing</a><p> - For the Android and iPhone plus quite a few others, but not Windows Mobile</p></li>
  <li><a href="http://www.snapmaze.com/?q=node/7" target="_blank">SnapMaze</a><p> - QR code reader for Nokia, Sony Ericcson and Motorola phones (<a href="http://www.snapmaze.com/?q=node/4" target="_blank">Supported Devices</a>)</p></li>
  <li><a href="http://www.neoreader.com/download.html" target="_blank">NeoReader</a><p> - A good range of phones and mobile devices (including iPhone and Blackberry) and also available as AppStore download. (<a href="http://www.neoreader.com/pc.html" target="_blank">Supported Devices</a>)</p></li>
  <li><a href="http://www.jaxo-systems.com/solutions/snapabar/?lang=en_US" target="_blank">Jaxo Systems</a><p> - Runs on most Java-enabled phones (<a href="http://www.jaxo-systems.com/download/index.php?lang=en_US" target="_blank">Supported Devices</a>)</p></li>
  <li><a href="http://www.okotag.com/home/?lang=en_US" target="_blank">OkoTag</a><p> - The new one from Jaxo. Java, Blackberry, Windows Mobile and Android. (<a href="http://www.okotag.com/download/?lang=en_US" target="_blank">Supported Devices</a>)</p></li>
  <li><a href="http://na.blackberry.com/eng/services/blackberrymessenger/" target="_blank">Blackberry Messenger</a><p> - Comes standard with most Blackberry's these days</p></li>
  <li><a href="http://www.upcode.com/download" target="_blank">Upcode</a><p> - Support for a wide range of Symbian, UIQ, windows mobile, Iphone, Blackberry and Java phones. (<a href="http://www.upcode.com/page/1371365" target="_blank">Supported Devices</a>)</p></li>
</ul>


<div id="qr_code_software_applications" class="div_title">
<p>
QR Code Software &amp; Applications
<a href="#catalog" >
<img class="go_top" border="0" src="<%=request.getContextPath()%>/images/go_top.png" />
</a>
</p>
</div>
<div class="dotline"></div>
<ul>
  <li><a href="http://www.jaxo-systems.com/solutions/barcapture/?lang=en_US" target="_blank">Bar Capture</a><p> - Capture and decode QR Codes from your computer screen</p></li>
  <li><a href="http://zxing.org/w/decode.jspx" target="_blank">Online Decoder</a><p> - Decode QR Codes online via direct image file URL or image download</p></li>
  <li><a href="http://blog.anthonywong.net/qr-code-wordpress-plugin/" target="_blank">Wordpress QR Code Plug-In</a></li>
  <li><a href="http://www.blitztools.com/plugins/indesign.html" target="_blank">InDesign CS3 QR Code Plug-In</a></li>
  <li><a href="https://addons.mozilla.org/en-US/firefox/addon/2780" target="_blank">Firefox Mobile Barcode Add-On</a></li>
  <li><a href="http://www.facebook.com/apps/application.php?id=2398528540&b&ref=pd" target="_blank">Facebook QR Codes application</a></li>
  <li><a href="https://chrome.google.com/extensions/detail/bcfddoencoiedfjgepnlhcpfikgaogdg" target="_blank">QR-Code Tag</a><p> - Google Chrome QR Code Plug-In</p></li>
</ul>


<div id="basic_idea" class="div_title">
<p>
The basic idea of QR Marks The Spot
<a href="#catalog" >
<img class="go_top" border="0" src="<%=request.getContextPath()%>/images/go_top.png" />
</a>
</p>
</div>
<div class="dotline"></div>
<p>
QR Marks The Spot provides a platform to play QR-code-based games that blend real and virtual worlds into a single, gaming world. 
Our slogan is <em>Let's Mark The World</em>. With a QR, we can achieve a lot of things. 
</p>
<p>
We can attach our ideas to the world. 
We can record what we think about and share our happiness, wisdom, stories or any other things with other people with a QR.
Just write your words on our website, and print the QR we generated for you and attach it to your destination.
So when someone finds the QR you leaved, he or she will see what you have written down with a surprise 
and share the wonderful thoughts on it. 
</p>
<p>
Or you can explorer the city to solve the mysterious puzzles. 
By finding the first QR of the puzzle, you can get the clue of where the next QR is. 
When you find the last QR of the puzzle, you are the winner. 
<em>Conquest &amp; Defence</em> is the third game type.
</p> 
<p>
To play it you should have an mobile phone(by now only Android platform is supported). 
In this game scenarios you can rule the world. 
By putting an QR to a position, you can be the owner of this area. 
You defence it by checking it out. And you can attack a site by checking out the QR put by other players.
</p>

<div id="user_manual" class="div_title">
<p>
User Manual
<a href="#catalog" >
<img class="go_top" border="0" src="<%=request.getContextPath()%>/images/go_top.png" />
</a>
</p>
</div>
<div class="dotline"></div>
<p>
Your can view the user manual via <a href="<%=request.getContextPath()%>/normal/user-manual.jsp" target="_blank">this</a>.
</p>


<p id="signup_button_p"><a class="class_signup_button_a" id="signup_button_a" href="<%=request.getContextPath()%>/normal/registration.jsp"></a></p><br/>
<br />

</div>

</body>

</html>