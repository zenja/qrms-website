<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

String actionName = "showQRContent";
String paramName = "code";

//the url of pics made by tinyMCE is based on the page of the editor,
//bacause this page is shown under /inspiring_mode,
//a dummy folder must be used for showQRContent action
String url = basePath + "aha/" + actionName + "?" + paramName + "=" + request.getAttribute("code").toString();

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
   
<title>Recount QR Code</title>

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
function change_qr_size(id, width, height) {
	var image = document.getElementById(id);
	var sizeString = width + "x" + height;
	image.setAttribute("src", "http://chart.googleapis.com/chart?chs=" + sizeString + "&cht=qr&chl=<%=url%>&choe=UTF-8");
}
</script>

</head>
  
<body>

<input type="radio" name="qrcode_image_size" value="240x240" onclick='change_qr_size("qrcode_img", 240, 240)' />160x160
<input type="radio" name="qrcode_image_size" value="320x320" onclick='change_qr_size("qrcode_img", 320, 320)' checked="checked" />320x320
<input type="radio" name="qrcode_image_size" value="480x480" onclick='change_qr_size("qrcode_img", 480, 480)' />480x480
<br />

<!-- picture of the QR Code -->
<!--startprint-->
<img id="qrcode_img" src="http://chart.googleapis.com/chart?chs=320x320&cht=qr&chl=<%=url%>&choe=UTF-8" alt="qrcode" />
<!--endprint-->

<!-- print it -->
<p><a href="#" target="_blank" onclick="doPrint()">Print the QR code</a></p>

</body>
</html>
