<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입8</h1>
	<hr>
	<a href="http://127.0.0.1:8888/app08/home">홈페이지</a>
	<hr>
	<form action="http://127.0.0.1:8888/app08/member/join2" method="get">

		<input type="text" name="memberId" placeholder="아이디"> 
		<br>
		<input type="password" name="memberPwd" placeholder="비밀번호"> 
		<br>
		<input type="password" name="memberPwdCheck" placeholder="비밀번호확인">
		<br> 
		<input type="text" name="memberNick" placeholder="닉네임">
		<br> 
		<input type="submit" value="회원가입">
	</form>

</body>
</html>