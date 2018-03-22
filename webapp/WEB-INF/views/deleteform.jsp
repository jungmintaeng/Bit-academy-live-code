<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
<link href="/mysite/assets/css/mysite.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<div id="wrapper">
			<div id="content">
				<form method="POST" action="${pageContext.servletContext.contextPath}/delete">
					<input type="hidden" name="target" value="${param.target}">
					<table>
						<tr>
							<td>비밀번호</td>
							<td><input type="password" name="password"></td>
							<td><input type="submit" value="확인"></td>
						</tr>
					</table>
				</form>
				<a href="${pageContext.servletContext.contextPath}/list">목록으로 돌아가기</a>	
			</div>
		</div>
	</div>
</body>
</html>