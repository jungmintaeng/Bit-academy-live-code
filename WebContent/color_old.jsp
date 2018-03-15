<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String color = request.getParameter("color");
	if("0".equals(color)){
		color = "red";
	} else if("1".equals(color)){
		color = "blue";
	} else if("2".equals(color)){
		color = "yellow";
	} else if("3".equals(color)){
		color = "green";
	} else {
		color = "black";
	} 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 style="color:<%= color %>">HELLO WORLD!!</h1>
</body>
</html>