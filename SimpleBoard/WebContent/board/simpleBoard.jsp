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
	src="<c:url value="/js/board/simpleBoard.js" />"></script>
</head>
<body>
	<header>
		<form action="<c:url value="/logout"/>" method="post">
			<button type="submit">로그아웃</button>
		</form>
		<form action="<c:url value="/member/memberChange.jsp"/>" method="post">
			<button type="submit">회원정보수정</button>
		</form>
		<form action="<c:url value="/signOut"/>" method="post" id="signOut">
			<button type="submit">회원탈퇴</button>
		</form>
		<a>메뉴</a> <a>메뉴</a> <a>메뉴</a> <a>메뉴</a> <br>
		<h3>${member.name }님환영합니다.</h3>
	</header>
	<hr>
	<div>
		<table border="2">
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

			<c:forEach items="${sessionScope.boards }" var="board">
				<tr>
					<td>${board.no }</td>
					<td><a href="">${board.title }</a></td>
					<td>${board.user }</td>
					<td>${board.date }</td>
				</tr>
			</c:forEach>

		</table>
	</div>

</body>
</html>