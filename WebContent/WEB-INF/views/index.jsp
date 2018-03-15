<%@page import="com.cafe24.guestbook.vo.GuestBookVo"%>
<%@page import="java.util.List"%>
<%@page import="com.cafe24.guestbook.dao.GuestBookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%!
	List<GuestBookVo> vos;
	GuestBookVo vo;
	@SuppressWarnings("unchecked")
%>
<%
	vos = (List<GuestBookVo>)request.getAttribute("list");
%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
<style>
	table {
		border : 1px solid black;
		width : 500px;
	}
	#tb{
		border : 1px solid black;
		width : 510px;
	}
	#tb td {
		border : 1px solid black;
		padding : 5px;
	}
</style>
</head>
<body>
	<form action="/guestbook2/gb" method="post">
		<input type='hidden' value='add' name='a'>
		<table>
			<tr>
				<td>이름</td><td><input type="text" name="name"></td>
				<td>비밀번호</td><td><input type="password" name="pass"></td>
			</tr>
			<tr>
				<td colspan=4><textarea name="content" cols='65' rows='5'></textarea></td>
			</tr>
			<tr>
				<td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
			</tr>
		</table>
	</form>
	<br>
	<table id='tb'>
		<%
			for(int i = 0 ; i < vos.size(); i++){
				vo = vos.get(i);
		%>
		<tr>
			<td>[<%= i + 1 %>]</td>
			<td><%= vo.getName() %></td>
			<td><%= vo.getReg_date() %></td>
			<td><a href="/guestbook2/gb?a=deleteform&target=<%= vo.getNo() %>">삭제</a></td>
		</tr>
		<tr>
			<td colspan="4">
			<%= vo.getContent().replaceAll("\n", "<br/>") %>
			</td>
		</tr>
			<% } %>
	</table>
</body>
</html>