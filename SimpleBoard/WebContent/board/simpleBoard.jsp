<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SimpleBoard</title>
</head>
<body>
	<header>
		<form action="<c:url value="/logout"/>" method="post">
			<button type="submit">로그아웃</button>
		</form>
		<a>메뉴</a>
		<a>메뉴</a>
		<a>메뉴</a>
		<a>메뉴</a>
		<br>
		<h3>${sessionScope.id }님 환영합니다.</h3>
	</header>
	<hr>
	<div>
		<table border = "2">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>시간</th>
			</tr>
			<tr>
				<td>sample</td>
				<td>sample</td>
				<td>sample</td>
				<td>sample</td>
			</tr>
			<tr>
				<td>sample</td>
				<td>sample</td>
				<td>sample</td>
				<td>sample</td>
			</tr>
		</table>
	</div>

</body>
</html>