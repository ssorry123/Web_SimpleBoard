<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SimpleBoard</title>
<script type="text/javascript"
	src="<c:url value="/lib/jquery-3.5.1.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/index.js"/>"></script>
</head>
<!-- post 로그인 유효 검사 -->
<!-- get 회원가입 이동 -->
<body>
	<header> </header>
	<form action="<c:url value="/login"/>" method="post">
		<h1>Simple Board</h1>
		<h2>Login</h2>
		아이디 :<input type="text" name="id" required /><br>
		비밀번호 :<input type="text" name="passwd" required /><br>
		<button type="submit">로그인</button>
		<button type="button" id="signUp">회원가입</button>
	</form>
</body>
</html>