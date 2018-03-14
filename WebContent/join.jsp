<%
request.setCharacterEncoding("utf-8");
String email = request.getParameter("e");
String password = request.getParameter("p");
String name = request.getParameter("n");
String gender = request.getParameter("gender");
String birth = request.getParameter("birth");
String[] hobbies = request.getParameterValues("hobby");
String intro = request.getParameter("introduce");
%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><%=email %></h1>
	<h1><%=password %></h1>
	<h1><%=name %></h1>
	<h1><%=gender %></h1>
	<h1><%=birth %></h1>
	<%
		if(hobbies != null)
			for (String s : hobbies)
				out.println("<h1>" + s + "</h1>");
	%>
	<h1><%=intro %></h1>
</body>
</html>