<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
   
<title>About</title>

<link href="<%=request.getContextPath()%>/css/about.css" rel="stylesheet" type="text/css" />

</head>
  
<body>

<div class="div_title"><p>About this site</p></div>
<div class="dotline"></div>
<p>
This site is a product of the <a href="http://score-contest.org/2011/" target="_blank">SCORE 2011</a>. 
The name of the site is QR Marks The Spot. 
It provides a platform for people to play several kinds of games on QR code.
These games are location-based games that blend real and virtual worlds into a single, gaming world.
</p>

<div class="div_title"><p>About SCORE 2011</p></div>
<div class="dotline"></div>
<p id="about_score">
The SCORE Contest is aimed at promoting and fostering software engineering in universities worldwide. 
ICSE 2011 in Hawaii will see the second finals of the SCORE Software Engineering Contest. 
You can contact the SCORE 2011 organizers at <a href="mailto:score@elet.polimi">score@elet.polimi</a>. 
<br />
<a href="http://score-contest.org/2011/" target="_blank">Click here</a> to visit the website of SCORE 2011.
</p>

<div class="div_title"><p>About the team</p></div>
<div class="dotline"></div>
<table width="100%" border="0" cellspacing="10" cellpadding="10">
  <tr>
    <td><img class="img_portrait" src="<%=request.getContextPath()%>/images/portrait/wangxing.jpg" alt="" width="90" height="90" /> Wang Xing</td>
    <td><img class="img_portrait" src="<%=request.getContextPath()%>/images/portrait/yinshunming.jpg" alt="" width="90" height="90" /> Yin Shunming</td>
  </tr>
  <tr>
    <td><img class="img_portrait" src="<%=request.getContextPath()%>/images/portrait/zhaolu.jpg" alt="" width="90" height="90" /> Zhao Lu</td>
    <td><img class="img_portrait" src="<%=request.getContextPath()%>/images/portrait/zhangzu.jpg" alt="" width="90" height="90" /> Zhang Zu</td>
  </tr>
</table>
<p>
We come from Software Institute, Nanjing University, P.R.China.<br />
We major in software engineering in the same class.
</p>

<div class="div_title"><p>About the instructor</p></div>
<div class="dotline"></div>
<p id="instructor">
<strong>Dong Shao</strong><br />
Associate professor in the Software Institute at Nanjing University, P.R.China.<br />
Vice chair of the Department of Software Engineering, Software Institute at Nanjing University, P.R.China.<br />
<br />
<a href="http://software.nju.edu.cn/dongshao/" target="_blank">Click here</a> to visit his homepage.
</p>

<div class="div_title"><p>About Nanjing University</p></div>
<div class="dotline"></div>
<p id="nju">
Nanjing University, or Nanking University, 
is a national comprehensive university located in Nanjing (Nanking), China.<br />
Here are <a href="http://en.wikipedia.org/wiki/Nanjing_University" target="_blank">more about NJU.</a><br />
<br />
<a href="http://www.nju.edu.cn/cps/site/njueweb/fg/index.php" target="_blank">Click here</a> to visit the website of NJU.
</p>

<div class="div_title"><p>About Nanjing University, Software Institute</p></div>
<div class="dotline"></div>
<p id="swi">
<br />
<a href="http://software.nju.edu.cn" target="_blank">Click here</a> to visit the website of NJU, Software Institute.
<br />(This site has no English version, you may use Google Translate)
</p>

<div id="contact" class="div_title"><p>Contact</p></div>
<div class="dotline"></div>
<p>
You may contact the Wang Xing by sending him an email. 
<br />His email address is wx08@software.nju.edu.cn
</p>

</body>
</html>
