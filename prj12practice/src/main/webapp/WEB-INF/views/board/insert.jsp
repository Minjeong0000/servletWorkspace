<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>게시글 작성하기</h1>
<hr>
<form action="/app12/board/insert" method ="post">
<br>
<input type="text" name="title" placeholder="제목">
<br>
<textarea name="content" placeholder="내용"></textarea>
<br>
<input type="submit" value="작성하기">
</form>


</body>
</html>