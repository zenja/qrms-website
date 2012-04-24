<%@ page language="java" import="java.util.*,com.qrms.bean.InspiringGameInfo,com.qrms.bean.User" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
if(session.getAttribute("user") == null) {
	response.sendRedirect(request.getContextPath() + "/normal/login.jsp?previousPageURL=inspiring_mode/launch-inspiring-game.jsp");
}
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Launch a Game</title>

<!-- CSS -->
<link href="<%=request.getContextPath()%>/css/map.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/form_new.css" rel="stylesheet" type="text/css" />


<!-- js for google map v3 -->
<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false&language=en"></script>

<!-- js for google map support of launching game -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/launch_game_google_map_support.js"></script>

<!-- other js -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/tiny_mce/tiny_mce.js"></script>
<script type="text/javascript">
// O2k7 skin (silver)
tinyMCE.init({
	// General options
	mode : "exact",
	elements : "tiny_mce_textarea",
	theme : "advanced",
	skin : "o2k7",
	skin_variant : "silver",
	plugins : "pagebreak,style,layer,table,save,advhr,advimage,advlink,emotions,iespell,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template,inlinepopups,autosave",

	// Theme options
	theme_advanced_buttons1 : "save,newdocument,|,bold,italic,underline,strikethrough,|,justifyleft,justifycenter,justifyright,justifyfull,styleselect,formatselect,fontselect,fontsizeselect",
	theme_advanced_buttons2 : "cut,copy,paste,pastetext,pasteword,|,search,replace,|,bullist,numlist,|,outdent,indent,blockquote,|,undo,redo,|,link,unlink,anchor,image,cleanup,help,code,|,insertdate,inserttime,preview,|,forecolor,backcolor",
	theme_advanced_buttons3 : "tablecontrols,|,hr,removeformat,visualaid,|,sub,sup,|,charmap,emotions,iespell,media,advhr,|,print,|,ltr,rtl,|,fullscreen",
	theme_advanced_buttons4 : "insertlayer,moveforward,movebackward,absolute,|,styleprops,|,cite,abbr,acronym,del,ins,attribs,|,visualchars,nonbreaking,template,pagebreak,restoredraft",
	theme_advanced_toolbar_location : "top",
	theme_advanced_toolbar_align : "left",
	theme_advanced_statusbar_location : "bottom",
	theme_advanced_resizing : true,

	// Example content CSS (should be your site CSS)
	content_css : "<%=request.getContextPath()%>/css/none.css",

	// Drop lists for link/image/media/template dialogs
	template_external_list_url : "lists/template_list.js",
	external_link_list_url : "lists/link_list.js",
	external_image_list_url : "lists/image_list.js",
	media_external_list_url : "lists/media_list.js",

	// Replace values for the template plugin
	template_replace_values : {
		username : "Some User",
		staffid : "991234"
	}
});
</script>

<script type="text/javascript">
function body_onload() {
	initialize_google_map();
	quickLocateByAddress("${sessionScope.user.city}");
	theMap.setZoom(9);
}
</script>

<!-- js for jTip -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.qtip-1.0.min.js"></script>

<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.validate.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#launchInspiringGame_form").validate( {
		event: "blur",
		rules : {
			"gameInfo.gameName" : {
				required : true,
				minlength : 4,
				maxlength : 128
			},
			"gameInfo.latitude" : {
				required : true,
				number : true
			},
			"gameInfo.longitude" : {
				required : true,
				number : true
			},
			"gameInfo.nation" : {
				required : true,
			},
			"gameInfo.province" : {
				required : true,
			},
			"gameInfo.city" : {
				required : true,
			},
			"gameInfo.pictureUrl" : {
				url : true
			}
		},
		messages : {
			"gameInfo.gameName" : {
				required : "You must enter a game name",
				minlength : "The game name can not be less than {0} characters",
				maxlength : "The game name can not be more than {0} characters"
			},
			"gameInfo.latitude" : {
				required : "You must enter the latitude",
				number : "Latitude must be a number"
			},
			"gameInfo.longitude" : {
				required : "You must enter a the longitude",
				number : "Longitude must be a number"
			},
			"gameInfo.nation" : {
				required : "You must select a country",
			},
			"gameInfo.province" : {
				required : "You must enter the province",
			},
			"gameInfo.city" : {
				required : "You must enter the city",
			},
			"gameInfo.pictureUrl" : {
				url : "Picture's URL must be a valid url or empty"
			}
		}
	});
});
</script>

</head>
  
<body onload="body_onload()">


<!-- ************Google Map************ -->
<div id="main_map_canvas"></div>

<label id="quick_locate_label">
	Quick Locate:
</label>
<s:textfield cssClass="mygeneralinputstyle" id="quick_locate_textfield" onkeypress="checkQuickLocate()"></s:textfield>
<input type="button" value="Go!" onclick="quickLocate();theMap.setZoom(9);" />

<hr />

<!-- ************Forms************ -->
<s:form id="launchInspiringGame_form" action="launchInspiringGame" method="POST" theme="simple">


<input type="hidden" name="gameLauncherId" value="${sessionScope.user.id}" />

<ul class="form_ul">
<li>
<label class="mylabelstyle_inline">Game Name:</label>
<s:textfield cssClass="myinputstyle" name="gameInfo.gameName"></s:textfield>
</li>

<li>
<label class="mylabelstyle_inline">Latitude:</label>
<s:textfield cssClass="myinputstyle" id="latitude" name="gameInfo.latitude" onblur="change_marker_latlng()"></s:textfield>
</li>

<li>
<label class="mylabelstyle_inline">Longitude:</label>
<s:textfield cssClass="myinputstyle" id="longitude" name="gameInfo.longitude" onblur="change_marker_latlng()"></s:textfield>
</li>

<li>
<label class="mylabelstyle_inline">Country:</label>

<select id="nation" class="myselectstyle_inline" name="gameInfo.nation">
	<optgroup label="">
		<option value="" selected="selected">Select Country</option> 
	</optgroup>
	<optgroup label="Common choices">
		<option value="United States">United States</option> 
		<option value="China">China</option> 
		<option value="United Kingdom">United Kingdom</option> 
		<option value="France">France</option> 
		<option value="Germany">Germany</option> 
		<option value="Spain">Spain</option> 
		<option value="Italy">Italy</option> 
		<option value="Canada">Canada</option> 
	</optgroup>
	<optgroup label="Other countries">
		<option value="Afghanistan">Afghanistan</option> 
		<option value="Albania">Albania</option> 
		<option value="Algeria">Algeria</option> 
		<option value="American Samoa">American Samoa</option> 
		<option value="Andorra">Andorra</option> 
		<option value="Angola">Angola</option> 
		<option value="Anguilla">Anguilla</option> 
		<option value="Antarctica">Antarctica</option> 
		<option value="Antigua and Barbuda">Antigua and Barbuda</option> 
		<option value="Argentina">Argentina</option> 
		<option value="Armenia">Armenia</option> 
		<option value="Aruba">Aruba</option> 
		<option value="Australia">Australia</option> 
		<option value="Austria">Austria</option> 
		<option value="Azerbaijan">Azerbaijan</option> 
		<option value="Bahamas">Bahamas</option> 
		<option value="Bahrain">Bahrain</option> 
		<option value="Bangladesh">Bangladesh</option> 
		<option value="Barbados">Barbados</option> 
		<option value="Belarus">Belarus</option> 
		<option value="Belgium">Belgium</option> 
		<option value="Belize">Belize</option> 
		<option value="Benin">Benin</option> 
		<option value="Bermuda">Bermuda</option> 
		<option value="Bhutan">Bhutan</option> 
		<option value="Bolivia">Bolivia</option> 
		<option value="Bosnia and Herzegovina">Bosnia and Herzegovina</option> 
		<option value="Botswana">Botswana</option> 
		<option value="Bouvet Island">Bouvet Island</option> 
		<option value="Brazil">Brazil</option> 
		<option value="British Indian Ocean Territory">British Indian Ocean Territory</option> 
		<option value="Brunei Darussalam">Brunei Darussalam</option> 
		<option value="Bulgaria">Bulgaria</option> 
		<option value="Burkina Faso">Burkina Faso</option> 
		<option value="Burundi">Burundi</option> 
		<option value="Cambodia">Cambodia</option> 
		<option value="Cameroon">Cameroon</option> 
		<option value="Canada">Canada</option> 
		<option value="Cape Verde">Cape Verde</option> 
		<option value="Cayman Islands">Cayman Islands</option> 
		<option value="Central African Republic">Central African Republic</option> 
		<option value="Chad">Chad</option> 
		<option value="Chile">Chile</option> 
		<option value="China">China</option> 
		<option value="Christmas Island">Christmas Island</option> 
		<option value="Cocos (Keeling) Islands">Cocos (Keeling) Islands</option> 
		<option value="Colombia">Colombia</option> 
		<option value="Comoros">Comoros</option> 
		<option value="Congo">Congo</option> 
		<option value="Congo, The Democratic Republic of The">Congo, The Democratic Republic of The</option> 
		<option value="Cook Islands">Cook Islands</option> 
		<option value="Costa Rica">Costa Rica</option> 
		<option value="Cote D'ivoire">Cote D'ivoire</option> 
		<option value="Croatia">Croatia</option> 
		<option value="Cuba">Cuba</option> 
		<option value="Cyprus">Cyprus</option> 
		<option value="Czech Republic">Czech Republic</option> 
		<option value="Denmark">Denmark</option> 
		<option value="Djibouti">Djibouti</option> 
		<option value="Dominica">Dominica</option> 
		<option value="Dominican Republic">Dominican Republic</option> 
		<option value="Ecuador">Ecuador</option> 
		<option value="Egypt">Egypt</option> 
		<option value="El Salvador">El Salvador</option> 
		<option value="Equatorial Guinea">Equatorial Guinea</option> 
		<option value="Eritrea">Eritrea</option> 
		<option value="Estonia">Estonia</option> 
		<option value="Ethiopia">Ethiopia</option> 
		<option value="Falkland Islands (Malvinas)">Falkland Islands (Malvinas)</option> 
		<option value="Faroe Islands">Faroe Islands</option> 
		<option value="Fiji">Fiji</option> 
		<option value="Finland">Finland</option> 
		<option value="France">France</option> 
		<option value="French Guiana">French Guiana</option> 
		<option value="French Polynesia">French Polynesia</option> 
		<option value="French Southern Territories">French Southern Territories</option> 
		<option value="Gabon">Gabon</option> 
		<option value="Gambia">Gambia</option> 
		<option value="Georgia">Georgia</option> 
		<option value="Germany">Germany</option> 
		<option value="Ghana">Ghana</option> 
		<option value="Gibraltar">Gibraltar</option> 
		<option value="Greece">Greece</option> 
		<option value="Greenland">Greenland</option> 
		<option value="Grenada">Grenada</option> 
		<option value="Guadeloupe">Guadeloupe</option> 
		<option value="Guam">Guam</option> 
		<option value="Guatemala">Guatemala</option> 
		<option value="Guinea">Guinea</option> 
		<option value="Guinea-bissau">Guinea-bissau</option> 
		<option value="Guyana">Guyana</option> 
		<option value="Haiti">Haiti</option> 
		<option value="Heard Island and Mcdonald Islands">Heard Island and Mcdonald Islands</option> 
		<option value="Holy See (Vatican City State)">Holy See (Vatican City State)</option> 
		<option value="Honduras">Honduras</option> 
		<option value="Hong Kong">Hong Kong</option> 
		<option value="Hungary">Hungary</option> 
		<option value="Iceland">Iceland</option> 
		<option value="India">India</option> 
		<option value="Indonesia">Indonesia</option> 
		<option value="Iran, Islamic Republic of">Iran, Islamic Republic of</option> 
		<option value="Iraq">Iraq</option> 
		<option value="Ireland">Ireland</option> 
		<option value="Israel">Israel</option> 
		<option value="Italy">Italy</option> 
		<option value="Jamaica">Jamaica</option> 
		<option value="Japan">Japan</option> 
		<option value="Jordan">Jordan</option> 
		<option value="Kazakhstan">Kazakhstan</option> 
		<option value="Kenya">Kenya</option> 
		<option value="Kiribati">Kiribati</option> 
		<option value="Korea, Democratic People's Republic of">Korea, Democratic People's Republic of</option> 
		<option value="Korea, Republic of">Korea, Republic of</option> 
		<option value="Kuwait">Kuwait</option> 
		<option value="Kyrgyzstan">Kyrgyzstan</option> 
		<option value="Lao People's Democratic Republic">Lao People's Democratic Republic</option> 
		<option value="Latvia">Latvia</option> 
		<option value="Lebanon">Lebanon</option> 
		<option value="Lesotho">Lesotho</option> 
		<option value="Liberia">Liberia</option> 
		<option value="Libyan Arab Jamahiriya">Libyan Arab Jamahiriya</option> 
		<option value="Liechtenstein">Liechtenstein</option> 
		<option value="Lithuania">Lithuania</option> 
		<option value="Luxembourg">Luxembourg</option> 
		<option value="Macao">Macao</option> 
		<option value="Macedonia, The Former Yugoslav Republic of">Macedonia, The Former Yugoslav Republic of</option> 
		<option value="Madagascar">Madagascar</option> 
		<option value="Malawi">Malawi</option> 
		<option value="Malaysia">Malaysia</option> 
		<option value="Maldives">Maldives</option> 
		<option value="Mali">Mali</option> 
		<option value="Malta">Malta</option> 
		<option value="Marshall Islands">Marshall Islands</option> 
		<option value="Martinique">Martinique</option> 
		<option value="Mauritania">Mauritania</option> 
		<option value="Mauritius">Mauritius</option> 
		<option value="Mayotte">Mayotte</option> 
		<option value="Mexico">Mexico</option> 
		<option value="Micronesia, Federated States of">Micronesia, Federated States of</option> 
		<option value="Moldova, Republic of">Moldova, Republic of</option> 
		<option value="Monaco">Monaco</option> 
		<option value="Mongolia">Mongolia</option> 
		<option value="Montserrat">Montserrat</option> 
		<option value="Morocco">Morocco</option> 
		<option value="Mozambique">Mozambique</option> 
		<option value="Myanmar">Myanmar</option> 
		<option value="Namibia">Namibia</option> 
		<option value="Nauru">Nauru</option> 
		<option value="Nepal">Nepal</option> 
		<option value="Netherlands">Netherlands</option> 
		<option value="Netherlands Antilles">Netherlands Antilles</option> 
		<option value="New Caledonia">New Caledonia</option> 
		<option value="New Zealand">New Zealand</option> 
		<option value="Nicaragua">Nicaragua</option> 
		<option value="Niger">Niger</option> 
		<option value="Nigeria">Nigeria</option> 
		<option value="Niue">Niue</option> 
		<option value="Norfolk Island">Norfolk Island</option> 
		<option value="Northern Mariana Islands">Northern Mariana Islands</option> 
		<option value="Norway">Norway</option> 
		<option value="Oman">Oman</option> 
		<option value="Pakistan">Pakistan</option> 
		<option value="Palau">Palau</option> 
		<option value="Palestinian Territory, Occupied">Palestinian Territory, Occupied</option> 
		<option value="Panama">Panama</option> 
		<option value="Papua New Guinea">Papua New Guinea</option> 
		<option value="Paraguay">Paraguay</option> 
		<option value="Peru">Peru</option> 
		<option value="Philippines">Philippines</option> 
		<option value="Pitcairn">Pitcairn</option> 
		<option value="Poland">Poland</option> 
		<option value="Portugal">Portugal</option> 
		<option value="Puerto Rico">Puerto Rico</option> 
		<option value="Qatar">Qatar</option> 
		<option value="Reunion">Reunion</option> 
		<option value="Romania">Romania</option> 
		<option value="Russian Federation">Russian Federation</option> 
		<option value="Rwanda">Rwanda</option> 
		<option value="Saint Helena">Saint Helena</option> 
		<option value="Saint Kitts and Nevis">Saint Kitts and Nevis</option> 
		<option value="Saint Lucia">Saint Lucia</option> 
		<option value="Saint Pierre and Miquelon">Saint Pierre and Miquelon</option> 
		<option value="Saint Vincent and The Grenadines">Saint Vincent and The Grenadines</option> 
		<option value="Samoa">Samoa</option> 
		<option value="San Marino">San Marino</option> 
		<option value="Sao Tome and Principe">Sao Tome and Principe</option> 
		<option value="Saudi Arabia">Saudi Arabia</option> 
		<option value="Senegal">Senegal</option> 
		<option value="Serbia and Montenegro">Serbia and Montenegro</option> 
		<option value="Seychelles">Seychelles</option> 
		<option value="Sierra Leone">Sierra Leone</option> 
		<option value="Singapore">Singapore</option> 
		<option value="Slovakia">Slovakia</option> 
		<option value="Slovenia">Slovenia</option> 
		<option value="Solomon Islands">Solomon Islands</option> 
		<option value="Somalia">Somalia</option> 
		<option value="South Africa">South Africa</option> 
		<option value="South Georgia and The South Sandwich Islands">South Georgia and The South Sandwich Islands</option> 
		<option value="Spain">Spain</option> 
		<option value="Sri Lanka">Sri Lanka</option> 
		<option value="Sudan">Sudan</option> 
		<option value="Suriname">Suriname</option> 
		<option value="Svalbard and Jan Mayen">Svalbard and Jan Mayen</option> 
		<option value="Swaziland">Swaziland</option> 
		<option value="Sweden">Sweden</option> 
		<option value="Switzerland">Switzerland</option> 
		<option value="Syrian Arab Republic">Syrian Arab Republic</option> 
		<option value="Taiwan, Province of China">Taiwan, Province of China</option> 
		<option value="Tajikistan">Tajikistan</option> 
		<option value="Tanzania, United Republic of">Tanzania, United Republic of</option> 
		<option value="Thailand">Thailand</option> 
		<option value="Timor-leste">Timor-leste</option> 
		<option value="Togo">Togo</option> 
		<option value="Tokelau">Tokelau</option> 
		<option value="Tonga">Tonga</option> 
		<option value="Trinidad and Tobago">Trinidad and Tobago</option> 
		<option value="Tunisia">Tunisia</option> 
		<option value="Turkey">Turkey</option> 
		<option value="Turkmenistan">Turkmenistan</option> 
		<option value="Turks and Caicos Islands">Turks and Caicos Islands</option> 
		<option value="Tuvalu">Tuvalu</option> 
		<option value="Uganda">Uganda</option> 
		<option value="Ukraine">Ukraine</option> 
		<option value="United Arab Emirates">United Arab Emirates</option> 
		<option value="United Kingdom">United Kingdom</option> 
		<option value="United States">United States</option> 
		<option value="United States Minor Outlying Islands">United States Minor Outlying Islands</option> 
		<option value="Uruguay">Uruguay</option> 
		<option value="Uzbekistan">Uzbekistan</option> 
		<option value="Vanuatu">Vanuatu</option> 
		<option value="Venezuela">Venezuela</option> 
		<option value="Viet Nam">Viet Nam</option> 
		<option value="Virgin Islands, British">Virgin Islands, British</option> 
		<option value="Virgin Islands, U.S.">Virgin Islands, U.S.</option> 
		<option value="Wallis and Futuna">Wallis and Futuna</option> 
		<option value="Western Sahara">Western Sahara</option> 
		<option value="Yemen">Yemen</option> 
		<option value="Zambia">Zambia</option> 
		<option value="Zimbabwe">Zimbabwe</option>
	</optgroup>
</select>
</li>

<li>
<label class="mylabelstyle_inline">Province:</label>
<s:textfield id="province" cssClass="myinputstyle" name="gameInfo.province"></s:textfield>
</li>

<li>
<label class="mylabelstyle_inline">City:</label>
<s:textfield id="city" cssClass="myinputstyle" name="gameInfo.city"></s:textfield>
</li>

<li>
<label class="mylabelstyle_inline">Picture's Url:</label>
<s:textfield cssClass="myinputstyle" name="gameInfo.pictureUrl"></s:textfield>
</li>
</ul>

<p>
<label class="mylabelstyle">Hint:</label>
<s:textarea name="gameInfo.hint" rows="10" cssStyle="width: 710px;"></s:textarea>
</p>

<p>
<label class="mylabelstyle">QR Content</label><br />
<%-- qrRawContent is a string; it will be made into an QRContent object by the action --%>
<s:textarea id="tiny_mce_textarea" name="qrRawContent" rows="80" cols="80" cssStyle="width: 710px; height: 500px">
</s:textarea>
</p>

<br />

<s:submit cssClass="mysubmitstyle" value="Launch"></s:submit>


</s:form>

<!-- use jTip -->
<script type="text/javascript">
$('#quick_locate_textfield').qtip({
	content: 'Enter your destination and click Go! button to locate it',
	style: { 
		name: 'green'
	},
	show: 'mouseover',
	hide: 'mouseout'
})

$('#quick_locate_label').qtip({
	content: 'Enter your destination and click Go! button to locate it',
	style: { 
		name: 'green'
	},
	show: 'mouseover',
	hide: 'mouseout'
})
</script>

</body>
</html>
