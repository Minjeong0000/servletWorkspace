<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/app/resources/css/home.css">
<script src="/app/resources/js/home.js"></script>


<script>
	<c:if test="${not empty alertMsg}">
		alert("${alertMsg}");
	</c:if>
</script>

<c:remove var="alertMsg" scope = "session"/>

</head>
<body>




   <aside>광고1</aside>
    <div id="wrap">
        <header>
            <div>빈칸</div>
            <div>로고</div>
            <div>

<c:if test="${loginMemberVo != null}">

	            <span>프로필</span>
	            <br>
	            <span>아이디 :${sessionScope.loginMemberVo.id} </span>
	            <br>
	            <span>닉네임 :${sessionScope.loginMemberVo.nick} </span>
	            <br>
	            <button onclick="location.href = '/app/member/logout'">로그아웃</button>
</c:if>
<c:if test="${loginMemberVo == null}">
            	<button onclick="location.href = '/app/member/join'">회원가입</button>
            	<button onclick="location.href = '/app/member/login'">로그인</button>
</c:if>

            </div>
        </header>
        <nav>
            <a href="">공지사항</a>
            <a href="">게시판</a>
            <a href="">갤러리</a>
            <a href="/app/member/edit">마이페이지</a>
        </nav>
        <main>
            <h1 align="center">환영합니다 ~ ^^</h1>
        </main>
        <footer>
            <p>&copy; KH corp.</p>
            <div>
                <a href="">회사소개</a>
                <a href="">인재채용</a>
                <a href="">제휴제안</a>
                <a href="">이용약관</a>
                <a href="">개인정보처리방침</a>
                <a href="">고객센터</a>
            </div>
        </footer>
    </div>
   <aside>광고2</aside>

</body>
</html>