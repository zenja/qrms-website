<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>CSS Table</title>
<link href="<%=request.getContextPath()%>/css/seek_game_result_table.css" rel="stylesheet" type="text/css" />

</head>
  
<body>

<table id="box-table-a" summary="Employee Pay Sheet">
	<thead>
		<tr>
			<th scope="col">
				Employee
			</th>
			<th scope="col">
				Salary
			</th>
			<th scope="col">
				Bonus
			</th>
			<th scope="col">
				Supervisor
			</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>
				Stephen C. Cox
			</td>
			<td>
				$300
			</td>
			<td>
				$50
			</td>
			<td>
				Bob
			</td>
		</tr>
		<tr>
			<td>
				Josephin Tan
			</td>
			<td>
				$150
			</td>
			<td>
				-
			</td>
			<td>
				Annie
			</td>
		</tr>
		<tr>
			<td>
				Joyce Ming
			</td>
			<td>
				$200
			</td>
			<td>
				$35
			</td>
			<td>
				Andy
			</td>
		</tr>
		<tr>
			<td>
				James A. Pentel
			</td>
			<td>
				$175
			</td>
			<td>
				$25
			</td>
			<td>
				Annie
			</td>
		</tr>
	</tbody>
</table>

	</body>
</html>
