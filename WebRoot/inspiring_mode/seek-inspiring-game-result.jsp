<%@ page language="java" import="java.util.*,com.qrms.bean.InspiringGameInfo" pageEncoding="UTF-8"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>Results</title>

<link href="<%=request.getContextPath()%>/css/seek_game_result_table.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/map.css" rel="stylesheet" type="text/css" />

<script
	src="http://maps.google.com/maps/api/js?sensor=false"
	type="text/javascript">
</script>
<script 
    src="<%=request.getContextPath()%>/js/markerclusterer_compiled.js" type="text/javascript">
</script>
<script type="text/javascript">
 function mark()
   {
    <%
      List<InspiringGameInfo> result=(List<InspiringGameInfo>)session.getAttribute("seekInspiringGameResult");
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
        var bounds = new google.maps.LatLngBounds();
        for(i=0;i<max;i++)
         {
          var point = new google.maps.LatLng(lat[i],lang[i]);
          var marker=new google.maps.Marker({
          map: map, 
          position: point
         });  
          markers.push(marker); 
          map.panTo(point);
          bounds.extend(point);
         }
        var markerCluster=new MarkerClusterer(map, markers);
        
        map.fitBounds(bounds);
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
  
<body onload="load()">

<div id="main_map_canvas" ></div>

<table id="box-table-a">
	<thead>
		<tr>
			<th scope="col">
				Name
			</th>
			<th scope="col">
				Place Date
			</th>
			<th scope="col">
				Description
			</th>
		</tr>
	</thead>
	<tbody>
		<s:iterator value="seekInspiringGameResult" id="seekInspiringGameResult" var="gameInfo"
			status="rowstatus">
			<tr>
				<td>
					<a href="showInspiringGameDetail.action?gameId=${gameInfo.id}">${gameInfo.gameName}</a>
				</td>
				<td>
					<fmt:formatDate value="${gameInfo.placeDate}" pattern="yyyy-MM-dd" />
				</td>
				<td>
					Placed By <a href="<%=request.getContextPath()%>/user/showUserProfile.action?userId=${gameInfo.user.id}" target="_blank">${gameInfo.user.name}</a>
				</td>
			</tr>
		</s:iterator>
	</tbody>
</table>

<br />
<p><a href="<%=request.getContextPath()%>/inspiring_mode/seek-inspiring-game.jsp">Seek More</a></p>


</body>
</html>
