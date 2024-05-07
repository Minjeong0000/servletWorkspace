<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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