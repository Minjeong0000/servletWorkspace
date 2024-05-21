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


<h1>리스트</h1>

<table>
	<thead>
		<tr>
			<th>제목</th>
			<th>내용</th>
		</tr>
	</thead>
	
	<tbody>
	
	<c:forEach items ="${voList}" var="x">
		<tr>
			<td>${x.title}</td>
			<td>${x.content}</td>
		</tr>	
	</c:forEach>
	</tbody>


</table>


</body>
</html>