<%@ page language="java" import="java.util.*,com.qrms.bean.PuzzleSolvingGameInfo" pageEncoding="utf-8"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>

    
<title>Seek Games -- Result</title>
<link href="<%=request.getContextPath()%>/css/seek_game_result.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/seek_game_result_table.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/form_common.css" rel="stylesheet" type="text/css" />
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
  
  	
  	
    <script type="text/javascript">

　　//传入 event 对象
        function ShowPrompt(objEvent) {
            var divObj = document.getElementById("promptDiv");
            divObj.style.visibility = "visible";

　　　//使用这一行代码，提示层将出现在鼠标附近(如要使用，记得注释 divOjb.style.left = 60+5;  这一句)

            //divObj.style.left = objEvent.clientX + 5;   //clientX 为鼠标在窗体中的 x 坐标值       
            divObj.style.left = 60 + 5;
            divObj.style.top = objEvent.clientY + 5;     //clientY 为鼠标在窗体中的 y 坐标值
        }

　　//隐藏提示框

        function HiddenPrompt() {
            divObj = document.getElementById("promptDiv");
            divObj.style.visibility = "hidden";
        }
       
    </script>
	
	
<div id="main_map_canvas" ></div>

<table id="box-table-a">
	<thead>
		<tr>
			<th>
				Overall Difficulty/
				<br />
				Terrain Difficulty
			</th>
			<th scope="col">
				Date
			</th>
			<th scope="col">
				Description
			</th>
		</tr>
	</thead>
	<tbody>
		<s:iterator value="seekPuzzleSolvingGameResult" id="seekPuzzleSolvingGameResult" var="gameInfo"
			status="rowstatus">
			<tr>
				<td>
					${gameInfo.difficultyLevel} / ${gameInfo.terrainLevel}
				</td>
				<td>
					<fmt:formatDate value="${gameInfo.placeDate}" pattern="yyyy-MM-dd" />
				</td>
				<td>
					<a
						href="showPuzzleSolvingGameDetail.action?gameId=${gameInfo.id}">${gameInfo.gameName}</a>
					Placed By <a href="<%=request.getContextPath()%>/user/showUserProfile.action?userId=${gameInfo.tblUserinfo.id}" target="_blank">${gameInfo.tblUserinfo.name}</a>
				</td>

			</tr>
		</s:iterator>
	</tbody>
</table>

<br />
<p><a href="Seek.jsp">Seek More</a></p>
    
</body>
</html>