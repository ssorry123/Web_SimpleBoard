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
		<%@ include file="sub/header.jsp" %>
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
	<hr>
	<footer>
		<%@ include file="sub/footer.jsp" %>
	</footer>

</body>
</html>