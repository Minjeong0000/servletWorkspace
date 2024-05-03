<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/join.css">
<script src="/app/resources/js/join.js"></script>
</head>
<body>
	<h1>회원가입</h1>

<form action="/app/member/join" method="post">
    <input type="text" name="id" placeholder="아이디">
    <br>
    <input type="text" name="pwd" placeholder="비밀번호">
    <br>
    <input type="text" name="pwd2" placeholder="비밀번호 확인">
    <br>
    <input type="text" name="nick" placeholder="닉네임">
    <br>
    <input type="submit" value="회원가입">

</form>



</body>
</html>