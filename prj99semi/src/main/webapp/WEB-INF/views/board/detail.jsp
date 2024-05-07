<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KH홈페이지</title>

<%@ include file="/WEB-INF/views/layout/util.jsp" %>
</head>

<body>


	<%@ include file="/WEB-INF/views/layout/left-aside.jsp" %>
    <div id="wrap">
	<%@ include file="/WEB-INF/views/layout/header.jsp" %>
	<%@ include file="/WEB-INF/views/layout/nav.jsp" %>
        <main>
        	<h1 align = "center">게시글 상세 조회</h1>
        	<div>제목 : ${requestScope.vo.title }</div>
        	<div>작성자 : ${requestScope.vo.writerNo}</div>
        	<div>내용 : ${requestScope.vo.content}</div>
        	<div>조회수 : ${requestScope.vo.hit}</div>
        	<div>작성일시 : ${requestScope.vo.createDate}</div>
        	<div>카테고리번호: ${requestScope.vo.categoryNo}</div>
        	
        	
        </main>

		<%@include file="/WEB-INF/views/layout/footer.jsp" %>
    </div>
	<%@ include file="/WEB-INF/views/layout/right-aside.jsp" %>


</body>
</html>