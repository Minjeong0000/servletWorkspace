<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.kh.app.board.vo.BoardVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>게시글 목록</h1>
<table border="1px">
    <thead>
        <tr>
            <th>제목</th>
            <th>작성자</th>
            <th>카테고리</th>
            <th>조회수</th>
        </tr>
    </thead>
    <tbody>
    
    
    <c:forEach items="${voList}" var="vo">
    	<tr>
    		<td>${vo.title}</td>
    		<td>${vo.writerNo}</td>
    		<td>${vo.categoryNo}</td>
    		<td>${vo.hit}</td>
    	</tr>
    
    </c:forEach>

    </tbody>
</table>

	<c:if test="${10>3}">
		<h1>트루~~</h1>	
	</c:if>
	<c:if test="${10<=3}">
		<h1>폴스~~</h1>	
	</c:if>
	
	<c:choose>
		<c:when test="조건식"></c:when>	
		<c:when test="조건식"></c:when>	
		<c:when test="조건식"></c:when>	
		<c:otherwise></c:otherwise>
	</c:choose>
	
	<% 
	for(int i =1;i<=5;++i){
		out.write("<h3>"+i+"<h3>");
	}
	
	%>
	
	<c:forEach var="i" begin="1" end="5" step="">
		<h3>${i}</h3>
	
	</c:forEach>
	
	

</body>
</html>