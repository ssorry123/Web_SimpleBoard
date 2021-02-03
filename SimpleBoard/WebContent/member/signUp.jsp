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
<script type="text/javascript" src="<c:url value="/js/member/signUp.js"/>"></script>
</head>
<body>
	<h1>회원가입</h1>
	<br>
	<hr>
	<!-- doPost signUp -->
	<form action="<c:url value="/signUp"/>" method="post">
		아이디 : <input type="text" name="id" required /> <br>
		비밀번호 : <input type="text" name="passwd" required /> <br>
		<hr>
		<button type="submit">제출</button>
		<button type="button" id="home">홈으로</button>
	</form>
</body>
</html>