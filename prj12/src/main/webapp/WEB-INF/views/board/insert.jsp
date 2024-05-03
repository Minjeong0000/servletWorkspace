<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

    <h1>게시글 작성</h1>
    <hr>
<!-- ip,port번호 지워도 됨, 현재 웹페이지에 떠 있는 ip와port를 자동으로 붙여줌 -->
    <form action="/app12/board/insert" method ="post">
    <input type="text" name="title" placeholder="제목">
    <br>
    <textarea name="content" placeholder="내용"></textarea>
    <br>
    <input type="submit" value="게시글 작성">
    </form>
</body>
</html>