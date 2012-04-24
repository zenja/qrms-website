var theMap;
var infowindow;
var marker;
var geocoder;

function initialize_google_map() {
	var center = new google.maps.LatLng(25, 120);
	var myOptions = {
		zoom : 2,
		center : center,
		mapTypeId : google.maps.MapTypeId.ROADMAP
	}
	theMap = new google.maps.Map(document.getElementById("main_map_canvas"),
			myOptions);

	infowindow = new google.maps.InfoWindow();
	infowindow.setContent('Just put me to your location');
  
	marker = new google.maps.Marker( {
		position : center,
		draggable : true,
		map : theMap
	});
	infowindow.open(theMap, marker);
	geocoder = new google.maps.Geocoder();

	google.maps.event.addListener(marker, "click", function() {
		infowindow.open(theMap, marker);
	});

	google.maps.event.addListener(marker, "dragstart", function() {
		infowindow.close();
	});

	google.maps.event.addListener(marker, "dragend", function() {
		var marker_position = marker.getPosition();
		infowindow.open(theMap, marker);
		
		//fill longitude and latitude
		fillLatitudeAndLongitudeByLatLng(marker_position);

		//fill nation, province, city
		fillNationAndProvinceAndCityByLatLng(marker_position);
	});

}

function quickLocate() {
	var address = document.getElementById('quick_locate_textfield').value;
	geocoder.geocode( {
		'address' : address
	}, locate);
}

function quickLocateByLatLng(latlng) {
	geocoder.geocode( {
		'latLng' : latlng
	}, locate);
}

function quickLocateByAddress(address) {
	geocoder.geocode( {
		'address' : address
	}, locate);
}

function locate(result, status) {
	if (status == "OK") {
		var point = result[0].geometry.location; // lat,lng
		theMap.panTo(point);
		marker.setPosition(point);
		var longitude = document.getElementById("longitude");
		var latitude = document.getElementById("latitude");
		 longitude.value = point.lng();
		 latitude.value = point.lat();
		//fill in country automatically
		 fillNationAndProvinceAndCityByResult(result[0]);
	} else {
		document.getElementById("nation").value = "";
		document.getElementById("province").value = "";
		document.getElementById("city").value = "";
	}
}

function fillNationAndProvinceAndCityByResult(result) {
	var nation_textfield = document.getElementById("nation");
	var province_textfield = document.getElementById("province");
	var city_textfield = document.getElementById("city");

	//clean old data first
	nation_textfield.value = "";
	province_textfield.value = "";
	city_textfield.value = "";

	//document.getElementById("city").value = result.formatted_address;
	for ( var i in result.address_components) {
		if (isNation(result.address_components[i])) {
			nation_textfield.value = result.address_components[i].long_name;
		} else if (isProvince(result.address_components[i])) {
			province_textfield.value = result.address_components[i].long_name;
		} else if (isCity(result.address_components[i])) {
			city_textfield.value = result.address_components[i].long_name;
		}
	}
}

function fillNationAndProvinceAndCityByLatLng(position) {
	geocoder.geocode( {
		'latLng' : position
	}, function(result, status) {
		if (status == "OK") {
			//fill in country automatically
			fillNationAndProvinceAndCityByResult(result[0]);
		} else {
			document.getElementById("nation").value = "";
			document.getElementById("province").value = "";
			document.getElementById("city").value = "";
		}
	});
}

function isNation(component) {
	for ( var i in component.types) {
		if (component.types[i] == "country") {
			return true;
		}
	}

	return false;
}

function isProvince(component) {
	for(var i in component.types) {
		if(component.types[i] == "administrative_area_level_1") {
			return true;
		}
	}
	
	return false;
}

function isCity(component) {
	for(var i in component.types) {
		if(component.types[i] == "locality") {
			return true;
		}
	}
	
	return false;
}

function fillLatitudeAndLongitudeByLatLng(marker_position) {
	var latitude = document.getElementById("latitude");
	var longitude = document.getElementById("longitude");
	longitude.value = marker_position.lng();
	latitude.value = marker_position.lat();
}


function change_marker_latlng() {
	var latitude = document.getElementById("latitude");
	var longitude = document.getElementById("longitude");
	if (longitude.value != "" && latitude.value != "") {
		if(isFloat(latitude.value)&&isFloat(longitude.value)){
		theMap.panTo(new google.maps.LatLng(latitude.value, longitude.value));
		marker.setPosition(new google.maps.LatLng(latitude.value,
				longitude.value));
		}
	}
}

function isFloat(theFloat)    
{    
	var type="^(-?\\+?\\d+)(\\.\\d+)?$";
	var re   =new RegExp(type);
	if(theFloat.match(re)==null) {
		return false;
	}
	return true;
}


/***************************************************************/

function checkQuickLocate() {
	if (event.keyCode == 13) {
		quickLocate();
		theMap.setZoom(9);
	}
}