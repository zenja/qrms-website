<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
	//if not logged in, turn to login page
	if (session.getAttribute("user") == null) {
		response.sendRedirect(request.getContextPath() + "/normal/login.jsp?previousPageURL=showPuzzleSolvingGameDetail.action?gameId=" + request.getParameter("gameId"));
	}
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>Game Details</title>

<link href="<%=request.getContextPath()%>/css/gameDatail.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/map.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/form_new.css" rel="stylesheet" type="text/css" />
    
<!--导入Google Maps API库文件。-->
<script src="http://maps.google.com/maps/api/js?sensor=false&language=en" type="text/javascript"></script>

<script type="text/javascript">
function calcRoute() {
	if (mymarker.getMap() == null)
		addMarker();
	else {
		var selectedMode = document.getElementById("mode").value;
		var request = {
			origin : mymarker.getPosition(),
			destination : marker.getPosition(),
			// Note that Javascript allows us to access the constant
			// using square brackets and a string value as its
			// "property."
			travelMode : google.maps.DirectionsTravelMode[selectedMode]
		};
		directionsService.route(request, function(response, status) {
			if (status == google.maps.DirectionsStatus.OK) {
				directionsDisplay.setDirections(response);
			}
		});
	}
	
	//show the route
	showRoute();
}

function clearMarker() {
	mymarker.setMap(null);
	directionsDisplay.setMap(null);
	directionsDisplay.setPanel(null);
	document.getElementById("mode").value = "DEFAULT";
	infowindow.close();

	hideRoute();
}

function addMarker() {
	mymarker.setMap(map);
	directionsDisplay.setMap(map);
	directionsDisplay.setPanel(document.getElementById("directions_panel"));
	mymarker.setDraggable(true);
	mymarker.setPosition(center);
	infowindow.setContent("Dragge it to your position.");
	infowindow.open(map, mymarker);
}

function locate() {
	var longitude
=<%=request.getAttribute("puzzleSolvingGameInfo.longitude")%>;
     var latitude=<%=request.getAttribute("puzzleSolvingGameInfo.latitude")%>;
     return new google.maps.LatLng(latitude,longitude);
}

    var mymarker=null;
    var marker=null;
    var map;
    var center;
    var infowindow;
    var directionDisplay;
    var directionsService = new google.maps.DirectionsService();
    
    //添加GControl()控件
    function load() {
       center=locate();
       var myOptions = {
      zoom: 12,
      center: center,
      mapTypeId: google.maps.MapTypeId.ROADMAP
      }
         map = new google.maps.Map(document.getElementById("main_map_canvas"),myOptions);
         directionsDisplay = new google.maps.DirectionsRenderer({
         map:map,
         suppressMarkers:true
         });
         
         directionsDisplay.setPanel(document.getElementById("directions_panel"));
         
     //  var image=new google.maps.MarkerImage('images/logo.jpg');
        marker = new google.maps.Marker({
        draggable: false,
        position: center, 
        map: map
        });
        infowindow = new google.maps.InfoWindow({
           content: "infowindow"
       }); 
        
        google.maps.event.addListener(marker, "click", function(){
          infowindow.setContent(marker.getPosition().toUrlValue());
           infowindow.open(map,marker);
       });
        
        mymarker=new google.maps.Marker();
        google.maps.event.addListener(mymarker, "click", function(){
          infowindow.setContent(mymarker.getPosition().toUrlValue());
          infowindow.open(map,mymarker);
       });
        
		google.maps.event.addListener(mymarker, "dragstart", function() {
				infowindow.close();
		});
		google.maps.event.addListener(mymarker, "dragend", function() {
		infowindow.setContent("Just push it to your location...");
		infowindow.open(map,mymarker);
		calcRoute();
		});
		
		//hide the route
		hideRoute();
    }
    
    function showRoute() {
    	var mapDiv = document.getElementById("main_map_canvas");
    	var routeDiv = document.getElementById("directions_panel");
    	mapDiv.style.width="410px";
    	routeDiv.style.display="block";
    	google.maps.event.trigger(map, 'resize')
    }
    
    function hideRoute() {
    	var mapDiv = document.getElementById("main_map_canvas");
    	var routeDiv = document.getElementById("directions_panel");
    	mapDiv.style.width="700px";
    	routeDiv.style.display="none";
    	google.maps.event.trigger(map, 'resize');
    	routeDiv.innerHTML="";
    }
    
</script>

<script type="text/javascript">
	var isStared = ${isStared};
	var xmlHttpRequestForStaredGame;

	function createXMLHttpRequestForStaredGame() {
		try {
			xmlHttpRequestForStaredGame = new XMLHttpRequest();
		} catch (e) {
			try {
				xmlHttpRequestForStaredGame = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				try {
					xmlHttpRequestForStaredGame = new ActiveXObject("Microsoft.XMLHTTP");
				} catch (e) {
					alert("AJAX not supported by the explorer.");
					return false;
				}
	
			}
		}
	}

    function check_stared(isStarted_param) {
    	var star_p = document.getElementById("title_star");
    	var star_a = document.getElementById("title_star_a");
    	if(isStarted_param == true) {
    		star_p.className="stared";
    		star_a.innerHTML = "unstar this game";
    	} else {
    		star_p.className="not_stared";
    		star_a.innerHTML = "star this game";
    	}
    }
    
    function sendRequestPostForStaredGame(url, param) {
    	createXMLHttpRequestForStaredGame();
    	var queryString = url + "?" + param;
		xmlHttpRequestForStaredGame.open("POST", queryString, true);
		xmlHttpRequestForStaredGame.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded");
		xmlHttpRequestForStaredGame.onreadystatechange = processResponseForStaredGame;
		xmlHttpRequestForStaredGame.send("");
    }
    
    function processResponseForStaredGame() {
    	if (xmlHttpRequestForStaredGame.readyState == 4) {
			if (xmlHttpRequestForStaredGame.status == 200) {
				var res = xmlHttpRequestForStaredGame.responseText;
				var obj = eval('(' + res + ')');
				
				isStared = obj.isStared;
				check_stared(isStared);
			} else {
				//DEBUG
				alert("processResponseForStaredGame: returning an error");
			}
		}
    }
    
    function starOrUnstarGame(gameType) {
    	var url = "starGame";
    	var param;
    	
    	if(isStared == false) {	//game not stared, star it
    		//NOTE: modify to the right gameType
    		param = "isStared=true" +
    		"&userId=" + ${sessionScope.user.id} +
    		"&gameType=" + gameType +
    		"&gameId=" + ${puzzleSolvingGameInfo.id};	
    	} else {				//game was stared, unstar it
    		//NOTE: modify to the right gameType
    		param = "isStared=false" +
    		"&userId=" + ${sessionScope.user.id} +
    		"&gameType=" + gameType +
    		"&gameId=" + ${puzzleSolvingGameInfo.id};	
    	}
    	
    	sendRequestPostForStaredGame(url, param);
    }
    
</script>

 <script type="text/javascript">
var geocoder;
var lng;
var lat;
var address;
function init()
{
  geocoder = new google.maps.Geocoder();
}
function queryLL()
{
   address ="${puzzleSolvingGameInfo.city}";
   if(address=="")
   {
	     alert("city is empty.Please reenter");
   }
   else
   {
   if (geocoder) {
   geocoder.geocode( {
	   'address' : address
	}, function(results, status) {
		if (status == google.maps.GeocoderStatus.OK) {
			getLL(results[0]);
		} 
		else {
			alert("Can't find!Please rewrite city!");
		}
	});
   }
   else
   {
	    alert("Please wait geocoder!");
   }
   }
}
function getLL(result)
{
  var radius1=100;
  var lnglat=result.geometry.location;
  lng=lnglat.lng();
  lat=lnglat.lat();
  var newaddress="radius1";
  var scheme="<%=request.getScheme()%>";
  var serverName="<%=request.getServerName()%>";
  var serverPort="<%=request.getServerPort()%>";
  var contextPath="<%=request.getContextPath()%>";
  newaddress=scheme+"://"+serverName+":"+serverPort+contextPath+"/byCity?"+"lng="+lng+"&lat="+lat+"&radius1="+radius1;;
  window.location.href=newaddress;
}
</script>

</head>

<!--use load()，注意加上onunload="GUnload()"防止内存泄露-->
<body onload="load(),init()" onunload="GUnload()">

<script type="text/javascript">
	$(document).ready(function() {
		check_stared(${isStared});
	});
o</script>

<div id="map_whole">
	<div id="directions_panel" ></div> 
	<div id="main_map_canvas"></div>
</div>

<div id="route_select_div">
	<span>To find a way:</span>
	<select id="mode" onchange="calcRoute();">
	        <option value="DEFAULT">Choose your traffic</option>
	        <option value="DRIVING">Driving</option>
	        <option value="WALKING">Walking</option>
	        <option value="BICYCLING">Bicycling</option>  
	</select>
	<button id="clear" name="clear" onclick="clearMarker();">
	cancel
	</button>
</div>

<hr />



<div id="title_div">
	<p id="title_gameName">
	${puzzleSolvingGameInfo.gameName}
	</p>
	<p id="title_star"><a id="title_star_a" href="javascript:starOrUnstarGame(2);">star this game</a></p>
</div>

<!--  
<div id="facebook_share_button">
	<fb:share-button class="url" type="icon_link" href=<%=request.getRequestURL()%>></fb:share-button>
</div>
-->

<div id="gameBriefHeading">
	<p id="game_type"><span>Game Type: </span>Puzzle Solving</p>
	<p>
		<span id="gameLauncher">Launched by: <a href="<%=request.getContextPath()%>/user/showUserProfile?userId=${puzzleSolvingGameInfo.tblUserinfo.id}" target="_blank">${puzzleSolvingGameInfo.tblUserinfo.name}</a></span>
		<span id="gamePlacedDate">Hidden: </span><fmt:formatDate value="${puzzleSolvingGameInfo.placeDate}" pattern="yyyy-MM-dd" />
	</p>
</div>

<div id="gameDetailHeading">
	<p id="QRNumber">QR Number: <img src="<%=request.getContextPath()%>/images/glass_numbers_${puzzleSolvingGameInfo.qrNum}.png"  /></p>
	<p>
		<span id="difficulty">Difficulty: 
		<img src="<%=request.getContextPath()%>/images/stars${puzzleSolvingGameInfo.difficultyLevel}.gif"  /></span>
		<span id="terrain">Terrain: <img src="<%=request.getContextPath()%>/images/stars${puzzleSolvingGameInfo.terrainLevel}.gif"  />
		</span>
	</p>
	<p id="coordinate">
		<span id="longitude">Longitude: ${puzzleSolvingGameInfo.longitude}</span>
		<span id="latitude">Latitude: ${puzzleSolvingGameInfo.latitude}</span>
	</p>
	
	<p id="location">
	<a onclick="javascript:queryLL(); return false"; href="javascript:void(0)" target="_blank">${puzzleSolvingGameInfo.city}, </a>
	<a href="byProv.action?prov=${puzzleSolvingGameInfo.province}" target="_blank">${puzzleSolvingGameInfo.province}, </a>
	<a href="byCou.action?cou=${puzzleSolvingGameInfo.nation}" target="_blank">${puzzleSolvingGameInfo.nation}</a>
	</p>
</div>

<p class="gameDetail_item" >
	<span class="gameDetail_title">Description:</span>
	<s:property value="puzzleSolvingGameInfo.longDescription" />
</p>
<p class="gameDetail_item" >
	<span class="gameDetail_title">Hint:</span>
	<s:property value="puzzleSolvingGameInfo.hint" />
</p>
<p class="gameDetail_item" >
	<span class="gameDetail_title">Related Picture URL:</span>
	<a href="<s:property value="puzzleSolvingGameInfo.pictureUrl" />" target="_blank"><s:property value="puzzleSolvingGameInfo.pictureUrl" /></a>
</p>

<p id="log_your_visit">
	<a id="make_comment_a" href="javascript:viod(0);">Make a comment</a>
</p>
   

<p>
  <img id="index_head_img" title="found!" src="<%=request.getContextPath()%>/images/game_comment/found.png"/>${foundNum}&nbsp;
  <img id="index_head_img" title="didn't find" src="<%=request.getContextPath()%>/images/game_comment/not_found.png"/>${notFoundNum}&nbsp;
  <img id="index_head_img" title="need maintenance" src="<%=request.getContextPath()%>/images/game_comment/need_maintenance.png"/>${needMaintenanceNum}&nbsp;
</p>
   
<!-- User Logs  -->
<h2>
	Game Comments
</h2>
<s:iterator value="gameCommentList" var="gameComment">
	<div class="comment">
			
			<p class="comment_head" >
				
				<c:choose>
					<c:when test="${empty gameComment.user.photo == false}">
						<img src="<%=request.getContextPath()%>/upload/${gameComment.user.photo}" width="50" height="50"></img>
					</c:when>
					
					<c:otherwise>
						<img src="<%=request.getContextPath()%>/images/anonymous.png" width="50" height="50"></img>
					</c:otherwise>
				</c:choose>
				
				<!-- NOTE: url below might need to be modified -->
				<span class="comment_userName"><a href="<%=request.getContextPath()%>/user/showUserProfile.action?userId=${gameComment.user.id}" target="_blank">${gameComment.user.name}</a></span> 
				<span class="comment_at">at</span> 
				<span class="comment_time">${gameComment.time }</span>
			</p>
			
			<p class="comment_content" >${ gameComment.textcomment }</p>
			<!-- Change To Corresponding Game Type -->
			<p><span class="comment_viewlog" ><a href="<%=request.getContextPath()%>/comment/viewGameComment.action?commentId=${ gameComment.commentId }" target="_blank">view this comment</a></span></p>
	</div>
</s:iterator>

<jsp:include page="/snippet/make-game-comment-for-puzzle-solving.jsp"></jsp:include>

<script type="text/javascript">
$(document).ready(function() { 
	$('#make_comment_a').click(function() {
		$.blockUI({ message: $('#make_comment_form_div'), css:{textAlign: 'left',top: '20%', width: '300px', padding: '0 35px'} });
	
		$('.blockOverlay').attr('title','Click to unblock').click($.unblockUI);
	});
});
</script>
	
</body>
</html>
