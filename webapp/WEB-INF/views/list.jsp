<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
#tb {
	border: 1px solid black;
	text-align: right;
}

#tb td {
	border: 1px solid black;
	padding: 5px;
}
</style>
</head>
<body>
	<h1>메일 리스트에 가입되었습니다.</h1>
	<p>입력한 정보 내역입니다.</p>
	<table id="tb">
		<c:forEach items="${list}" var="vo">
			<tr>
				<td>First name:</td>
				<td>${vo.first_name }</td>
			</tr>
			<tr>
				<td>Last name:</td>
				<td>${vo.last_name }</td>
			</tr>
			<tr>
				<td>Email address:</td>
				<td>${vo.email }</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<p>
		<a href="${pageContext.servletContext.contextPath}/form">추가메일 등록</a>
	</p>
	<br>
</body>
</html>