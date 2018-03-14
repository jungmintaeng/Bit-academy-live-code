<%@page import="com.cafe24.guestbook.vo.GuestBookVo"%>
<%@page import="com.cafe24.guestbook.dao.GuestBookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	long deleteNo = 0L;
	request.setCharacterEncoding("utf-8");
	String password = request.getParameter("password");
	String no = request.getParameter("target");
	System.out.println(no);
	try{
		deleteNo = Long.parseLong(no);
	}catch(Exception e){
		e.printStackTrace();
	}
	System.out.println("deleteNo : " + deleteNo);
	GuestBookDao dao = new GuestBookDao();
	GuestBookVo vo = dao.getRowByNo(deleteNo);
	
	if(password == null || !password.equals(vo.getPassword())){
%>
	<script type="text/javascript">
		alert('삭제할 수 없습니다.');
		document.location.href="/guestbook/index.jsp";
	</script>
	
<%
	}else{
		dao.delete(deleteNo);
		response.sendRedirect("/guestbook/index.jsp");
	}
%>