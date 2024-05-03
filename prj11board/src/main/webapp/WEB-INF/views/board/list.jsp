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

<h1>게시글 리스트</h1>

<a href="http://127.0.0.1:8888/app11/home">홈페이지로</a>


	<%--
		List<BoardVo> voList = (List<BoardVo>)request.getAttribute("boardVoList");

		out.write("<table>");
		out.write("<tbody>");
		
		for(BoardVo vo : voList){
			out.write("<tr>");		
			out.write("<td>"+vo.getNo()+"</td>");		
			out.write("<td>"+vo.getTitle()+"</td>");		
			out.write("<td>"+vo.getWriterNick()+"</td>");		
			out.write("<td>첫번째 제목 ㅋㅋ</td>");		
			out.write("<td>홍길동</td>");		
			out.write("</tr>");		
		}
		
		out.write("</tbody>");
		out.write("</table>");
		
	--%>
	
</body>
</html>