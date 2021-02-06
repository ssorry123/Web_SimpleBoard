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
</head>
<body>
	<!-- 닉네임 수정 -->
	<form action="<c:url value="/nickChange" />" method="post"
		id="nickChange">
		<h1>닉네임 수정</h1>
		<br> 회원 아이디 : ${member.id } <br>
		회원 닉네임 : <input type="text" placeholder="${member.name }" name="newNick"/><br>
		<button type="submit">닉네임 수정</button><br>
	</form>
	<hr>
	
	<!-- 비밀번호 수정 -->
	<form action="<c:url value="/passwdChange"/>" method="post"
		id="passwdChange">
		<h1>비밀번호 수정</h1>
		현재 비밀번호 : <input type="text" name="xPasswd" /><br>
		변경할 비밀번호 : <input type="text" name="newPasswd1" /><br>
		변경할 비밀번호 확인 : <input type="text" name="newPasswd2" /><br>
		<button type="submit">비밀번호 수정</button>
	</form>
</body>
</html>