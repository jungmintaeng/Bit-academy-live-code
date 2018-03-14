<%@page import="com.cafe24.guestbook.vo.GuestBookVo"%>
<%@page import="java.util.List"%>
<%@page import="com.cafe24.guestbook.dao.GuestBookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%!
	GuestBookDao dao;
	List<GuestBookVo> vos;
	GuestBookVo vo;
%>
<%
	dao = new GuestBookDao();
	vos = dao.getList();
%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
	<form action="/guestbook/add.jsp" method="post">
		<table border="1" width="500">
			<tr>
				<td>이름</td><td><input type="text" name="name"></td>
				<td>비밀번호</td><td><input type="password" name="pass"></td>
			</tr>
			<tr>
				<td colspan=4><textarea name="content" cols=60 rows=5></textarea></td>
			</tr>
			<tr>
				<td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
			</tr>
		</table>
	</form>
	<br>
	<table width="510" border="1">
		<%
			for(int i = 0 ; i < vos.size(); i++){
				vo = vos.get(i);
		%>
		<tr>
			<td>[<%= i + 1 %>]</td>
			<td><%= vo.getName() %></td>
			<td><%= vo.getReg_date() %></td>
			<td><a href="/guestbook/deleteform.jsp?target=<%= vo.getNo() %>">삭제</a></td>
		</tr>
		<tr>
			<td colspan="4">
			<%= vo.getContent() %>
			</td>
		</tr>
			<% } %>
	</table>
</body>
</html>