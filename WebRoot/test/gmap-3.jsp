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
  
<!-- 
<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
-->

<script type="text/javascript" src="https://www.google.com/jsapi?key=ABQIAAAAqB2YFxXsaLOJdPOIbMhskxT2yXp_ZAY8_ufC3CFXhHIE1NvwkxTVAe2RGGil83ppFWkajAgd9p7adQ"></script>

<script type="text/javascript">
function initialize_google_map() {
	// Loading the Google Maps API
	google.load('maps', 3, {
		'other_params' : 'sensor=false&language=en'
	});

	// Getting the position
	if (google.loader.ClientLocation.latitude
			&& google.loader.ClientLocation.longitude) {

		// Defining the position
		var latLng = new google.maps.LatLng(
				google.loader.ClientLocation.latitude,
				google.loader.ClientLocation.longitude);

		// Creating the content for the InfoWindow
		var location = 'You are located in '
		location += google.loader.ClientLocation.address.city + ', ';
		location += google.loader.ClientLocation.address.country;

	} else {

		// Providing default values as a fallback
		var latLng = new google.maps.LatLng(0, 0);
		var location = 'Your location is unknown';

	}

	// Creating a map
	var options = {
		zoom : 2,
		center : latLng,
		mapTypeId : google.maps.MapTypeId.ROADMAP
	};

	var theMap = new google.maps.Map(document.getElementById('main_map_canvas'), options);

	// Adding a marker to the map
	var marker = new google.maps.Marker( {
		position : latLng,
		map : theMap
	});

	// Creating a InfoWindow
	var infoWindow = new google.maps.InfoWindow( {
		content : location
	});

	// Adding the InfoWindow to the map
	infoWindow.open(theMap, marker);
}
</script>

</head>



<body onload="initialize_google_map()">
<div id="main_map_canvas"></div>
</body>
</html>