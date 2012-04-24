<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  
  <title>Google Map Test</title>
  
  <link href="<%=request.getContextPath()%>/css/map.css" rel="stylesheet" type="text/css" />
  
<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
<script type="text/javascript">
function initialize_google_map() {
	// Creating an object literal containing the properties
	// you want to pass to the map
	var options = {
		zoom : 3,
		center : new google.maps.LatLng(37.09, -95.71),
		mapTypeId : google.maps.MapTypeId.ROADMAP
	};
	
	// Creating the map
	var map = new google.maps.Map(document.getElementById('main_map_canvas'), options);
	
	// Creating a LatLngBounds object
	var bounds = new google.maps.LatLngBounds();
	
	// Creating an array which will contain the coordinates
	// for New York, San Francisco and Seattle
	var places = [];
	
	// Adding a LatLng object for each city
	places.push(new google.maps.LatLng(40.756, -73.986));
	places.push(new google.maps.LatLng(37.775, -122.419));
	places.push(new google.maps.LatLng(47.620, -122.347));
	places.push(new google.maps.LatLng(-22.933, -43.184));
	
	// Creating a variable that will hold the InfoWindow object
	var infowindow = new google.maps.InfoWindow();
	
	// Looping through the places array
	for ( var i = 0; i < places.length; i++) {
		// Adding the markers
		var marker = new google.maps.Marker( {
			position : places[i],
			map : map,
			title : 'Place number ' + i
		});
		
		// Wrapping the event listener inside an anonymous function
		// that we immediately invoke and passes the variable i to.
		(function(i, marker) {
			// Creating the event listener. It now has access to the values of
			// i and marker as they were during its creation
			google.maps.event.addListener(marker, 'click', function() {
				// Setting the content of the InfoWindow
					infowindow.setContent('Place number ' + i);
					// Tying the InfoWindow to the marker
					infowindow.open(map, marker);
				});
		})(i, marker);
		
		// Extending the bounds object with each LatLng
		bounds.extend(places[i]);
	}
	
	// Adjusting the map to new bounding box
	map.fitBounds(bounds);
}
</script>

</head>



<body onload="initialize_google_map()">
<div id="main_map_canvas"></div>
</body>
</html>