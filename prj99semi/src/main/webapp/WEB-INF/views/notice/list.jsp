<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KH홈페이지</title>


<%@ include file="/WEB-INF/views/layout/util.jsp" %>
<script src="/app/resources/js/notice/list.js"></script>

</head>
<body>





	<%@ include file="/WEB-INF/views/layout/left-aside.jsp" %>
    <div id="wrap">
	<%@ include file="/WEB-INF/views/layout/header.jsp" %>

	<%@ include file="/WEB-INF/views/layout/nav.jsp" %>
        <main>

			<h1>공지사항 목록 조회</h1>
			
			<table>

				
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>조회수</th>
					<th>작성일</th>
				</tr>			
			</thead>
			
		<tbody>
			<c:forEach items ="${voList}" var="vo">
					<tr>
						<td>${vo.no}</td>
						<td>${vo.title}</td>
						<td>${vo.writerNick}</td>
						<td>${vo.hit}</td>
						<td>${vo.createDate}</td>
					
					</tr>
			</c:forEach>
			
			
				
		</tbody>
			
			
			</table>


 
        </main>

		<%@include file="/WEB-INF/views/layout/footer.jsp" %>
    </div>
	<%@ include file="/WEB-INF/views/layout/right-aside.jsp" %>


</body>
</html>