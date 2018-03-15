<%@page import="servlet.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	UserVo vo1 = new UserVo();
	vo1.setNo(1L);
	pageContext.setAttribute("vo1",vo1);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>데이터 타입</h1>
	<p>
		iVal : ${iVal} <br/>
		iVal : ${lVal} <br/>
		iVal : ${fVal} <br/>
		iVal : ${bVal} <br/>
		iVal : ${not empty obj} <br/>
	</p>
	<h1>요청 파라미터</h1>
	<p>
		${param.a + 100}<br>
		${param.n}<br>
		<%= request.getParameter("a") + 100 %>
	</p>
	
		<h1>Application Scope</h1>
	<p>
		Application Scope : ${applicationScope.vo4.no }<br/>
		session Scope : ${sessionScope.vo3.no }<br/>
		request Scope : ${requestScope.vo2.no }<br/>
		page Scope : ${pageScope.vo1.no }<br/>
	</p>
</body>
</html>