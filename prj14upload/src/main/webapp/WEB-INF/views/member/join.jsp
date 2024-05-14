<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="/app/member/join" method="post" enctype="multipart/form-data" >
      <input type="text" name="id" placeholder="아이디">
      <br>
      <input type="password" name="pwd" placeholder="비밀번호">
      <br>
      <input type="text" name="nick" placeholder="닉네임">
      <br>
      <span>프로필 사진 :</span> 
      <input type="file" name="f">
      <br>
      <input type="submit" value="회원가입">
   </form>

</body>
</html>