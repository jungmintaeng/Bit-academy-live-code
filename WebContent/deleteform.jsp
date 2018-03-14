<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<%
	String no = request.getParameter("target");
%>
<body>
	<%= no %>
	<form method="POST" action="/guestbook/delete.jsp">
		<input type="hidden" name="target" value="<%=no%>">
		<table>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="password"></td>
				<td><input type="submit" value="확인"></td>
			</tr>
		</table>
	</form>
	<a href="/guestbook/index.jsp">메인으로 돌아가기</a>
</body>
</html>