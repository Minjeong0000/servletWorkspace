<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>여기는 조인 jsp임</h1>
	<hr>
	<a href="http://127.0.0.1:8888/app07/home">홈페이지로</a>
	
	<hr>
	
	<form action="http://127.0.0.1:8888/app07/member/login2" method="get">
		<input type="text" name="memberId" placeholder="아이디"> 
		<br>
		<input type="password" name="memberPwd" placeholder="비밀번호">
		<br>
		<input type="submit" value="로그인">
	</form>
	
</body>
</html>