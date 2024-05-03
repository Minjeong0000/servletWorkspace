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

<form action="/app/board/insert" method="post">
    <input type="text" name="title" placeholder="제목을 입력하세요">    
    <select name="category" >
        <option value = "1">자유</option>
        <option value = "2">운동</option>
        <option value = "3">게임</option>
        <option value = "4">개발</option>
        <option value = "5">자바</option>
        
        
    </select>
    <br>
    <textarea name="content" placeholder="내용을 입력하세요"></textarea>
    <br>
    <input type="file" name="f">
    <input type="submit" value="작성하기">
</form>
</body>
</html>