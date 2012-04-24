<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <base href="<%=basePath%>">
  
  <title>Google Map Test</title>
  
  <link href="<%=request.getContextPath()%>/css/map.css" rel="stylesheet" type="text/css" />
  
  <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script> 
  <script type="text/javascript"> 
  function initialize_google_map() {
      var myLatlng = new google.maps.LatLng(-34.397, 150.644);
      var myOptions = {
        zoom: 8,
        center: myLatlng,
        mapTypeId: google.maps.MapTypeId.ROADMAP
      }
      var map = new google.maps.Map(document.getElementById("main_map_canvas"), myOptions);
    }
  </script> 

</head>
  
<body onload="initialize_google_map()">
<div id="main_map_canvas"></div>
</body>
</html>
