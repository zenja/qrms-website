<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

String actionName = "showQRContent";
String paramName = "code";

List<String> codeList = (List<String>)request.getAttribute("codeList");
List<String> urlList = new ArrayList<String>();

for(int i = 0; i < codeList.size(); i++) {
	//the url of pics made by tinyMCE is based on the page of the editor,
	//bacause this page is shown directly under the project site,
	//no dummy folder should be used for showQRContent action
	String url = basePath + actionName + "?" + paramName + "=" + codeList.get(i);
	urlList.add(url);
}

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
   
<title>Congratulations!</title>

<%-- code example
import css:
<link href="<%=request.getContextPath()%>/css/niceform.css" rel="stylesheet" type="text/css" />

import javascript:
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.jqtransform.js"></script>
 --%>
 
<script type="text/javascript">
function doPrint() { 
	bdhtml=window.document.body.innerHTML; 
	sprnstr="<!--startprint-->";
	eprnstr="<!--endprint-->";
	prnhtml=bdhtml.substr(bdhtml.indexOf(sprnstr)+17); 
	prnhtml=prnhtml.substring(0,prnhtml.indexOf(eprnstr)); 
	window.document.body.innerHTML=prnhtml; 
	window.print(); 
}
</script>

<script type="text/javascript">
function change_qr_size(id, width, height, url) {
	var image = document.getElementById(id);
	var sizeString = width + "x" + height;
	image.setAttribute("src", "http://chart.googleapis.com/chart?chs=" + sizeString + "&cht=qr&chl=" + url + "&choe=UTF-8");
}
</script>

</head>




<body>

<p>
You have successfully launched a game. 
Below are the QR codes. 
Put them to the destinations you have specified in the previous form.
</p>




<!--startprint-->
<%
for(int i = 0; i < urlList.size(); i++) {
	String theUrl = urlList.get(i);
%>


	<p>
	<span>QR Code No.<%=i+1 %>: </span>
	<br />
	
	<input type="radio" name="qrcode_image_size_<%=i %>" value="240x240" onclick='change_qr_size("qrcode_img_<%=i %>", 240, 240, "<%=theUrl %>")' />160x160
	<input type="radio" name="qrcode_image_size_<%=i %>" value="320x320" onclick='change_qr_size("qrcode_img_<%=i %>", 320, 320, "<%=theUrl %>")' checked="checked" />320x320
	<input type="radio" name="qrcode_image_size_<%=i %>" value="480x480" onclick='change_qr_size("qrcode_img_<%=i %>", 480, 480, "<%=theUrl %>")' />480x480
	<br />

	<img id="qrcode_img_<%=i %>" src="http://chart.googleapis.com/chart?chs=320x320&cht=qr&chl=<%=theUrl %>&choe=UTF-8" alt="qrcode"  />
	</p>

<%
}
%>
<!--endprint-->

<!-- print it -->
<p><a href="#" target="_blank" onclick="doPrint()">Print all the QR codes</a></p>

</body>
</html>
