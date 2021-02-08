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
	<header>
		<%@ include file="sub/header.jsp"%>
	</header>
	<hr>
	<div>
		<button type="button" id="back">뒤로가기</button>
		<!-- 자신이 쓴 글일경우 삭제 요청 버튼 활성화 -->
		<c:if test="${post.userId == sessionScope.member.id }">
			<form action="<c:url value="/delete"/>" method="post">
				<input type="hidden" value="${post.no }" name="postNo" />
				<button type="submit">글 삭제</button>
			</form>
		</c:if>
	</div>
	<div>
		<table border="2">
			<thead>
				<tr>
					<th>글 번호</th>
					<td>${post.no }</td>
					<th>글 제목</th>
					<td colspan="2">${post.title }</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>${post.userId }</td>
					<td>${post.userName }</td>
					<th>작성 시각</th>
					<td>${post.dateTime }</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td colspan="5">${post.content }</td>
				</tr>
			</tbody>
		</table>
	</div>
	<hr>
	<!-- 새로운 댓글 쓰는 곳 -->
	<div>
		<form action="<c:url value="/writeComment?postNo=${post.no }" />" method="post">
			댓글 쓰기 : <input type="text" name="writeComment" required maxlength="200"/>
			<button type="submit">댓글 작성</button>
			<br>
		</form>
	</div>

	<!-- 존재하는 댓글 -->
	<div>
		<table border="1">
			<c:forEach items="${comments }" var="comment">
				<tr>
					<td>${comment.userId }</td>
					<td>${comment.userName }</td>
					<td>${comment.comment }</td>
					<td>${comment.dateTime }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<hr>
	<footer>
		<%@ include file="sub/footer.jsp"%>
	</footer>

	<script type="text/javascript">
		const contextRoot = '/SimpleBoard'
		$(document).ready(function() {
			$('#back').click(function() {
				location.href = contextRoot + "/simpleBoard";
			})
		});
	</script>
</body>
</html>