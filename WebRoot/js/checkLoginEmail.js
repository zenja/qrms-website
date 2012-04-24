    var xmlHttpRequestForExists;
   function createXMLHttpRequestForExists() {
	try {
		xmlHttpRequestForExists = new XMLHttpRequest();
	} catch (e) {
		try {
			xmlHttpRequestForExists = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			try {
				xmlHttpRequestForExists = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
				alert("AJAX not supported by the explorer.");
				return false;
			}
		}
	}
}

function sendRequestPostForExists(url, param) {
	createXMLHttpRequestForExists();
	xmlHttpRequestForExists.open("POST", url, true);
	xmlHttpRequestForExists.setRequestHeader("Content-Type",
			"application/x-www-form-urlencoded");
	xmlHttpRequestForExists.onreadystatechange = processResponseForExists;
	xmlHttpRequestForExists.send(param);
}

function processResponseForExists() {
	if (xmlHttpRequestForExists.readyState == 4) {
		if (xmlHttpRequestForExists.status == 200) {
			var res = xmlHttpRequestForExists.responseText;
			var obj = eval('(' + res + ')');
			if(obj.exist == "yes") {
				alert("This email has already been registered. Please use another one");
			}
		} else {
			//do nothing
		}
	}
}
  function isExist()
  {
    var email=document.getElementById("email1");
    var url="loginEmailExists"+"?loginEmail="+email.value;
    var param="";
    sendRequestPostForExists(url,param);
  }