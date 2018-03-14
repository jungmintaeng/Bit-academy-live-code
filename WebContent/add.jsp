<%@page import="com.cafe24.email_list.dao.EmailListDao"%>
<%@page import="com.cafe24.email_list.vo.EmailListVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	request.setCharacterEncoding("utf-8");
    	String first_name = request.getParameter("fn");
    	String last_name = request.getParameter("ln");
  	  	String email = request.getParameter("email");
  	  	
  	  	System.out.println(first_name + last_name + email);
  	  	
  	 	EmailListDao dao = new EmailListDao();
  	  	EmailListVo vo = new EmailListVo();
  	  	vo.setEmail(email);
  	  	vo.setFirst_name(first_name);
  	  	vo.setLast_name(last_name);
  	  	dao.insert(vo);
  	  	response.sendRedirect("/email_list");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
</body>
</html>