<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:if test ="${result == 1}">
	<h1>게시글 작성 성공!</h1>
</c:if>
<c:if test = "${result !=1 }">
	<h1>게시글 작성 실패...</h1>
</c:if>
	
	
</body>
</html>