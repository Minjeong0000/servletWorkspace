<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>



<head>
<meta charset="UTF-8">
<title>KH홈페이지</title>

<%@ include file="/WEB-INF/views/layout/util.jsp"%>

<link rel="stylesheet" href="/app/resources/css/board/list.css">

</head>
<body>


	<%@ include file="/WEB-INF/views/layout/left-aside.jsp"%>
	<div id="wrap">
		<%@ include file="/WEB-INF/views/layout/header.jsp"%>

		<%@ include file="/WEB-INF/views/layout/nav.jsp"%>
		<main>
			<h1>게시글 목록</h1>

			<table border="1">
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
							<td><a href ="/app/board/detail?no=${vo.no}&writerNo=${vo.writerNo}">${vo.title}</a></td>
							<td>${vo.nick}</td>
							<td>${vo.categoryName}</td>
							<td>${vo.hit}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
			
			<%--<c:if test="${sessionScope.loginMemberVo ne null}"> --%>
			<%-- <c:if test="${not empty sessionScope.loginMemberVo}">--%>
			<c:if test="${sessionScope.loginMemberVo != null}">
				<div>
				<button onclick="location.href ='/app/board/insert'">게시글 작성</button>
				</div>
			</c:if>




		</main>

		<%@include file="/WEB-INF/views/layout/footer.jsp"%>
	</div>
	<%@ include file="/WEB-INF/views/layout/right-aside.jsp"%>


</body>
</html>