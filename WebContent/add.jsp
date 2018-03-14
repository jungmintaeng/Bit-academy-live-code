<%@page import="com.cafe24.guestbook.vo.GuestBookVo"%>
<%@page import="com.cafe24.guestbook.dao.GuestBookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	String password = request.getParameter("pass");
	String content = request.getParameter("content");
	
	if(name == null || password == null || content == null){
%>
		<script type="text/javascript">
			alert("잘못된 입력값입니다.");
		</script>
		
<%		response.sendRedirect("/guestbook/index.jsp");
		return;
	}
	
	GuestBookVo vo = new GuestBookVo();
	GuestBookDao dao = new GuestBookDao();

	vo.setName(name);
	vo.setPassword(password);
	vo.setContent(content);
	dao.insert(vo);
	response.sendRedirect("/guestbook/index.jsp");
%>