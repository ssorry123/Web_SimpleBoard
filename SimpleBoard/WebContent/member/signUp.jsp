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
<script type="text/javascript"
	src="<c:url value="/js/member/signUp.js"/>"></script>
</head>
<body>
	<h1>회원가입</h1>
	<br>
	<hr>
	<!-- doPost signUp -->
	<form action="<c:url value="/signUp"/>" method="post" id="signUp">
		아이디 : <input type="text" name="id" required maxlength="10"/> <br>
		비밀번호 : <input type="text" name="passwd1" id="passwd1" required maxlength="20"/><br>
		비밀번호 확인 : <input type="text" name="passwd2" id="passwd2" required /> <br>
		이름 : <input type="text" name="name" required /> <br>
		<hr>
		<button type="submit">제출</button>
		<button type="button" id="home">홈으로</button>
	</form>
</body>
</html>