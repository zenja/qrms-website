

function checkCity(field,alerttxt){
	with(field){
	if (field.city.value==null||field.city.value=="")
	   {alert(alerttxt);return false}
	else {
		return true
		}
	}
}

function checkProv(field,alerttxt){
	with(field){
	if (field.prov.value==null||field.prov.value=="")
	   {alert(alerttxt);return false}
	else {
		return true
		}
	}
}
function checkCou(field,alerttxt){
	with(field){
	if (field.prov.cou.value==null||field.prov.cou.value=="")
	   {alert(alerttxt);return false}
	else {
		return true
		}
	}
}

function checkGPS1(field){
	with(field){
		var inte = /^[0-9]{1,}$/ ;
		var lath = field.lat_h.value;
		var lat_ms = field.lat_mmss.value;
		var longh = field.long_h.value;
		var long_ms = field.long_mmss.value;
		
		if(lath==""||lath==null){
			alert("No Lattitude is found.");
			field.lat_h.focus();
			return false;
		}
/*		if(lat_ms==""||lat_ms==null){
			alert("No Lattitude mmss is found.");
			field.lat_mmss.focus();
			return false;
		}*/
		if(longh==""||longh==null){
			alert("No Longitude is found.");
			field.long_h.focus;
			return false;
		}
/*		if(long_ms==""||long_ms==null){
			alert("No Longitude mmss is found.");
			field.long_mmss.focus();
			return false;
		}*/
		if(!lath.match(inte)){
			alert("Latitude must be an integer between 0 and 90.");
			field.lat_h.focus();
			return false;
		}
		if(Number(lath)>90 ||Number(lath)<0 ){
			alert("Latitude must be between 0 and 90 degrees to be valid.");
			field.lat_h.focus();
			return false;
		}
		if((lat_ms!=""||lat_ms!=null) && (Number(lat_ms)>60 || Number(lat_ms)<0)){
			alert("Latitude mmss must be between 0 and 60 degrees to be valid.");
			fieldlat_mmss.focus();
			return false;
		}
		if(!longh.match(inte)){
			alert("Longitude must be an integer.");
			field.long_h.focus();
			return false;
		}
		if(Number(longh)>180 ||Number(longh)<0 ){
			alert("Longitude must be between 0 and 180 degrees to be valid.");
			field.long_h.focus();
			return false;
		}
		if((long_ms!=""||long_ms!=null)&&(Number(long_ms)>60 || Number(long_ms)<0)){
			alert("Latitude mmss must be between 0 and 60 degrees to be valid.");
			field.long_mmss.focus();
			return false;
		}
	}
	return true;
}

function checkGPS2(field){
	with(field){
		var lat = field.origin_lat.value;
		var longt = field.origin_long.value;
		if(Number(lat)>90 || Number(lat)<-90){
			alert("Latitude must bet betwween -90 and 90 degree to be valide");
			field.origin_lat.focun();
			return false;
		}
		if(Number(longt)>180 || Number(longt)<-180){
			alert("Longitude must bet betwween -180 and 180 degree to be valide");
			field.origin_long.focus();
			return false;
		}
	}
	return true;
}