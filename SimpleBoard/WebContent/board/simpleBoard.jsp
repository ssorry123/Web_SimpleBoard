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
		<%@ include file="sub/header.jsp"%>

	</header>
	<hr>
	<form action="<c:url value="/board/writePost.jsp"/>" method="post">
		<button type="submit">글쓰기</button>
	</form>
	<hr>
	<div>
		<form action="<c:url value="/showOnePost" />" method="post" id = "posts">
			<table border="2">
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자 ID</th>
					<th>시간</th>
				</tr>
				<tr>
					<td>sample</td>
					<td>sample</td>
					<td>sample</td>
					<td>sample</td>
				</tr>

				<c:forEach items="${sessionScope.posts }" var="post">
					<tr class="post">
						<td class="no">${post.no }</td>
						<td>${post.title }</td>
						<td>${post.userId }</td>
						<td>${post.dateTime }</td>
					</tr>
				</c:forEach>

			</table>
			<input type="hidden" name="postNo" id="postNo" value="-1"/>
		</form>
	</div>
	<hr>
	<footer>
		<%@ include file="sub/footer.jsp"%>
	</footer>

</body>
</html>