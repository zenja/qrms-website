var xmlHttpRequestForEvents;
var xmlHttpRequestForNews;

var website_base_name;

function createXMLHttpRequestForEvents() {
	try {
		xmlHttpRequestForEvents = new XMLHttpRequest();
	} catch (e) {
		try {
			xmlHttpRequestForEvents = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			try {
				xmlHttpRequestForEvents = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
				alert("AJAX not supported by the explorer.");
				return false;
			}

		}
	}
}

function createXMLHttpRequestForNews() {
	try {
		xmlHttpRequestForNews = new XMLHttpRequest();
	} catch (e) {
		try {
			xmlHttpRequestForNews = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			try {
				xmlHttpRequestForNews = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
				alert("AJAX not supported by the explorer.");
				return false;
			}
		}
	}
}

function sendRequestPostForEvents(url, param) {
	createXMLHttpRequestForEvents();
	xmlHttpRequestForEvents.open("POST", url, true);
	xmlHttpRequestForEvents.setRequestHeader("Content-Type",
			"application/x-www-form-urlencoded");
	xmlHttpRequestForEvents.onreadystatechange = processResponseForEvents;
	xmlHttpRequestForEvents.send(param);
}

function processResponseForEvents() {
	if (xmlHttpRequestForEvents.readyState == 4) {
		if (xmlHttpRequestForEvents.status == 200) {
			var res = xmlHttpRequestForEvents.responseText;
			var obj = eval('(' + res + ')');
			var list = document.getElementById('events_list');
			
			for(var i = 0; i < obj.latestEventsList.length; i++) {
				var newNode = document.createElement("li");
				var newLink = document.createElement("a");
				newLink.setAttribute("href", website_base_name + "/event/viewSingleEvent?id=" + obj.latestEventsList[i].id);
				newLink.setAttribute("target", "_blank");
				var newTextNode = document.createTextNode(obj.latestEventsList[i].title);
				newLink.appendChild(newTextNode);
				newNode.appendChild(newLink);
				list.appendChild(newNode);
			}
		} else {
			//do nothing
		}
	}
}

function sendRequestPostForNews(url, param) {
	createXMLHttpRequestForNews();
	xmlHttpRequestForNews.open("POST", url, true);
	xmlHttpRequestForNews.setRequestHeader("Content-Type",
			"application/x-www-form-urlencoded");
	xmlHttpRequestForNews.onreadystatechange = processResponseForNews;
	xmlHttpRequestForNews.send(param);
}

function processResponseForNews() {
	if (xmlHttpRequestForNews.readyState == 4) {
		if (xmlHttpRequestForNews.status == 200) {
			var res = xmlHttpRequestForNews.responseText;
			var obj = eval('(' + res + ')');
			var list = document.getElementById('news_list');
			
			for(var i = 0; i < obj.latestNewsList.length; i++) {
				var newNode = document.createElement("li");
				var newLink = document.createElement("a");
				newLink.setAttribute("href", website_base_name + "/news/viewSingleNews?id=" + obj.latestNewsList[i].id);
				newLink.setAttribute("target", "_blank");
				var newTextNode = document.createTextNode(obj.latestNewsList[i].title);
				newLink.appendChild(newTextNode);
				newNode.appendChild(newLink);
				list.appendChild(newNode);
			}
		} else {
			//do nothing
		}
	}
}

function fetchEvents(base_name) {
	var url = "retrieveLatestEvents";
	var param = "";
	
	website_base_name = base_name;
	
	sendRequestPostForEvents(url, param);
}

function fetchNews(base_name) {
	var url = "retrieveLatestNews";
	var param = "";
	
	website_base_name = base_name;
	
	sendRequestPostForNews(url, param);
}