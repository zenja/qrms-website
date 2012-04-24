<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.qrms.bean.PuzzleSolvingGameInfo"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:v="urn:schemas-microsoft-com:vml">
 <head>
   <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <!--导入Google Maps API库文件。-->
<script
	src="http://maps.google.com/maps/api/js?sensor=false"
	type="text/javascript">
</script>
<script 
    src=js/markerclusterer_compiled.js type=text/javascript>
</script>
<script type="text/javascript">
 function mark()
   {
    <%
      List<PuzzleSolvingGameInfo> result=(List<PuzzleSolvingGameInfo>)session.getAttribute("seekPuzzleSolvingGameResult");
    %>
        var max=<%=result.size()%>;
        var lang=new Array();
        var lat=new Array();
        <%
          for(int i=0;i<result.size();i++)
         {
        %>
          lang.push("<%=result.get(i).getLongitude()%>");
          lat.push("<%=result.get(i).getLatitude()%>");
        <%
         }
        %>
        var i=0;
        var markers = [];
        for(i=0;i<max;i++)
         {
          var point = new google.maps.LatLng(lat[i],lang[i]);
          var marker=new google.maps.Marker({
          map: map, 
          position: point
         });  
          markers.push(marker); 
          map.panTo(point);
         }
        var markerCluster=new MarkerClusterer(map, markers);
   }
    var map;
    function load() { 
        //显示地图，并设置其中心，缩放值
        var center=new google.maps.LatLng(39,116);
        var myOptions = {
        zoom: 10,
        center: center,
        mapTypeId: google.maps.MapTypeId.ROADMAP
       } 
        map = new google.maps.Map(document.getElementById("main_map_canvas"),myOptions);
        mark();     
    }
</script>

</head>

<!--加载时调用load()函数加载地图，注意加上onunload="GUnload()"防止内存泄露-->
<body onload="load()" onunload="GUnload()">
<div id="main_map_canvas" ></div>
</body>
</html>