<%@page import="com.cafe24.email_list.vo.EmailListVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.cafe24.email_list.dao.EmailListDao" %>
<%
	EmailListDao dao = new EmailListDao();
	List<EmailListVo> vos = dao.getList();
%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>메일 리스트에 가입되었습니다.</h1>
	<p>입력한 정보 내역입니다.</p>
	<table border="1" cellpadding="5" cellspacing="2">
		<%
			for(EmailListVo vo : vos){
		%>
		<tr>
			<td align=right>First name: </td>
			<td><%= vo.getFirst_name() %></td>
		</tr>
		<tr>
			<td align="right" width="110">Last name: </td>
			<td width="110"><%= vo.getLast_name() %></td>
		</tr>
		<tr>
			<td align=right>Email address: </td>
			<td><%= vo.getEmail() %></td>
		</tr>
	<% 		} %>
	</table>
	<br>
	<p>
		<a href="/email_list/form.jsp">추가메일 등록</a>
	</p>
	<br>
</body>
</html>