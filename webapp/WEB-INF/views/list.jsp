<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	pageContext.setAttribute("newLine", "\n");
%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
<link href="/mysite/assets/css/mysite.css" rel="stylesheet"
	type="text/css">
<style>
table {
	border: 1px solid black;
	width: 500px;
}

#tb {
	border: 1px solid black;
	width: 510px;
}

#tb td {
	border: 1px solid black;
	padding: 5px;
}

#container {
	text-align: center;
}
</style>
</head>
<body>
	<div id="container">
		<div id="wrapper">
			<div id="content">
				<form action="${pageContext.servletContext.contextPath}/add" method="post">
					<table>
						<tr>
							<td>이름</td>
							<td><input type="text" name="name"></td>
							<td>비밀번호</td>
							<td><input type="password" name="password"></td>
						</tr>
						<tr>
							<td colspan=4><textarea name="content" cols='65' rows='5'></textarea></td>
						</tr>
						<tr>
							<td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
						</tr>
					</table>
				</form>
				<br />
				<c:set var="count" value="${fn:length(list)}" />
				<table id='tb'>
					<c:forEach items="${list}" var="vo" varStatus="status">
						<tr>
							<td>${count-status.index}</td>
							<td>${vo.name }</td>
							<td>${vo.reg_date }</td>
							<td><a
								href="${pageContext.servletContext.contextPath}/deleteform?target=${vo.no }">삭제</a></td>
						</tr>
						<tr>
							<td colspan="4">${fn:replace(vo.content, newLine, "<br/>")}
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>