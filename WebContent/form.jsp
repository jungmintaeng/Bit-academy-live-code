<%@ page language='java' contentType='text/html; charset=UTF-8'
    pageEncoding='UTF-8'%>
<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>
<html>
<head>
<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
<title>Insert title here</title>
<style>

</style>
</head>
<body>
	<p>
		1 &gt; 2 false <!-- &lt는 <의 escape 문자 -->
	</p>
	<h1>회원가입</h1>
	<form method='POST' action='/servlet_jsp/join.jsp'>
		<span>이름 : &nbsp;&nbsp;&nbsp;</span><input id='name_text' type='text' name='n'/>
		<br/><br/>
		<span>이메일 : &nbsp;&nbsp;&nbsp;&nbsp;</span><input id='email_text' type='text' name='e'/>
		<br/><br/>
		<span>비밀번호 : &nbsp;</span><input id='pw_text' type='password' name='p'/>
		<br/><br/>
		<span>성별 : &nbsp;</span>
			남<input class='gender' type='radio' name='gender' value="남"/>
			여<input class='gender' type='radio' name='gender' value="여"/>
		<br/><br/>
		<span>출생년 : </span>
		<select name ='birth'>
			<option value="1981">1981</option>
			<option value="1982">1982</option>
			<option value="1983">1983</option>
			<option value="1984">1984</option>
			<option value="1985">1985</option>
			<option value="1986">1986</option>
			<option value="1987">1987</option>
		</select>
		<br/><br/>
		<span>취미 : </span>
		<input type='checkbox' name="hobby" value="잠자기"/> 잠자기
		<input type='checkbox' name="hobby" value="코딩"/> 코딩
		<input type='checkbox' name="hobby" value="농구"/> 농구
		<input type='checkbox' name="hobby" value="축구"/> 축구
		<br/><br/>
		<span>자기소개</span><br/><br/>
		<textarea name='introduce' cols='50' rows='100'></textarea>
		<br/><br/>
		<input type='submit' value='가입'/>
	</form>
</body>
</html>