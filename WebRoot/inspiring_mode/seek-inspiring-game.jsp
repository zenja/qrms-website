<%-- Display the html content of QR's content --%>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
   
  <title>Seek Games</title>
  
  <script src="<%=request.getContextPath()%>/js/SeekGameCheck.js" charset="utf-8"  type="text/javascript"></script>
  
  <link href="<%=request.getContextPath()%>/css/form_new.css" rel="stylesheet" type="text/css" />	
  <script type="text/javascript"  src="http://maps.google.com/maps/api/js?sensor=false&language=en"></script>
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
   address = document.getElementById("city").value;
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
  var radius1=document.getElementById("radius1").value;
  var lnglat=result.geometry.location;
  lng=lnglat.lng();
  lat=lnglat.lat();
  var newaddress="radius1";
  var scheme="<%=request.getScheme()%>";
  var serverName="<%=request.getServerName()%>";
  var serverPort="<%=request.getServerPort()%>";
  var contextPath="<%=request.getContextPath()%>";
  newaddress=scheme+"://"+serverName+":"+serverPort+contextPath+"/inspiring_mode/seekInspiringGameByCity?"+"lng="+lng+"&lat="+lat+"&radius1="+radius1;
  window.location.href=newaddress;
}
</script>
</head>
  
<body onload="init()">
  <label class="mylabelstyle" >By Address: </label>
  <input class="myinputstyle" id="city" type="text" size="30" name="city" maxlength="100" />&nbsp;
  <input class="mygeneralbuttonstyle" id="submit1" type="submit" value="Go" onClick="queryLL()" /><br />
  <input class="mygeneralinputstyle" id="radius1" type="text" size="3" name="radius1" value="100" />&nbsp;<small>Mile(s) Radius</small>
	
<form id="loginForm" name="loginForm" action="seekInspiringGameByProvince" method="post" onsubmit="return checkProv(this,'No Province/State Found!');">
  <label class="mylabelstyle" >by Province/State: </label>
  <input class="myinputstyle" id="prov" type="text" size="30" name="prov" maxlength="100" />&nbsp;
  <input class="mygeneralbuttonstyle" id="submit2" type="submit" value="Go"/><br />
</form>
  
<form id="loginForm" name="loginForm" action="seekInspiringGameByNation" method="post" onsubmit="return checkCou(this,'No Country Found!');">
  <label class="mylabelstyle" >by Country: </label>
  <input class="myinputstyle" id="cou" type="text" size="30" name="cou" maxlength="100" />&nbsp;
  <input class="mygeneralbuttonstyle" id="submit3" type="submit" value="Go" />
</form>

<br />

<fieldset class="myfieldsetstyle">
<legend>WGS84 Datum</legend>
<form id="loginForm" name="loginForm" action="seekInspiringGameByLatLong" method="post" onsubmit="return checkGPS1(this);">
  <label class="mylabelstyle" >Latitude: </label>
              <select id="select1" size="1" name="latns">
                 <option value="1" selected="selected">N</option>
                 <option value="-1">S</option>
              </select>&nbsp;
              <input class="mygeneralinputstyle" id="Text2" type="text" maxlength="3" size="5" name="lath" />&nbsp;
              <input class="mygeneralinputstyle" id="Text3" type="text" maxlength="10" size="20" name="latmmss" />
              <br />
               <small>(N/S HDDD MM.MM)</small>
               
  <label class="mylabelstyle" >Longitude: </label>
  <select id="Select2" size="1" name="longew">
      <option value="-1" selected="selected">W</option>
      <option value="1">E</option>
  </select>&nbsp;
  <input class="mygeneralinputstyle" id="Text4" type="text" maxlength="3" size="5" name="longh" />&nbsp;
  <input class="mygeneralinputstyle" id="Text5" type="text" maxlength="10" size="20" name="longmmss" />
  <br />
       <small>(W/E HDDD MM.MM)</small>
       
  <label class="mylabelstyle" >Radius: </label>
             <input class="mygeneralinputstyle" id="radius2"  name="radius2" type="text" size="3" value="100"/>&nbsp;Mile(s) Radius&nbsp;
             <input id="submit4" type="submit" value="Search" name="submit4" />
</form>
</fieldset>


<fieldset class="myfieldsetstyle">
<legend>Decimal Format</legend>
<form id="loginForm" name="loginForm" action="seekInspiringGameByOriginLatLong" method="post" onsubmit="return checkGPS2(this);">
  <label class="mylabelstyle">Latitude: </label>
  <input class="myinputstyle" id="Text6" type="text" size="10" name="originlat" /><br />
      <small>(33.5111)</small>
      
  <label class="mylabelstyle">Longitude: </label>
  <input class="myinputstyle" id="Text7" type="text" size="10" name="originlong" /><br />
     <small>(-112.125)</small>
     
  <label class="mylabelstyle">Radius: </label>
  <input class="mygeneralinputstyle" id="radius3" type="text" size="3" name="radius3" value="100"/>Mile(s) Radius&nbsp;
  <input id="Submit5" type="submit" value="Search" name="submit5" />
 </form>
 </fieldset>

</body>
</html>
