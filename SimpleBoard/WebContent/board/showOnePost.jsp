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
	src="<c:url value="/js/board/showOnePost.js"/>"></script>
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
			<form action="<c:url value="/delete?postNo=${post.no }"/>"
				method="post">
				<button type="submit">글 삭제</button>
			</form>
			<!-- get 방식의 경우 쿼리스트링이 먹지 않는다. -->
			<form action="<c:url value="/update"/>" method="get">
				<input type="hidden" value="${post.no }" name="postNo" />
				<button type="submit">글 수정</button>
			</form>
		</c:if>
	</div>
	<h3>게시글</h3>
	<hr>
	<div>
		<c:if test="${!empty post.picPath }">
			<img src="<c:url value="/${post.picPath }"/>" />
		</c:if>
		<table border="2">
			<thead>
				<tr>
					<th>글 번호</th>
					<td>${post.no }</td>
					<th>글 제목</th>
					<td>${post.title }</td>
				</tr>
				<tr>
					<th>작성자 ID</th>
					<td>${post.userId }</td>
					<th>작성자 닉네임</th>
					<td>${post.userName }</td>
				</tr>
				<tr>
					<th>최초 작성 시간</th>
					<td>${post.dateTime }</td>
					<th>최근 수정 시간</th>
					<td>${post.newDateTime}</td>
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
	<h3>댓글</h3>
	<hr>
	<!-- 새로운 댓글 쓰는 곳 -->
	<div>
		댓글 쓰기 : <input type="text" id="writedComment" required maxlength="200" />
		<button type="button" id="ajaxBtn">댓글 작성</button>
		<input type="hidden" value="${post.no }" id="postNo" readonly /> <br>
	</div>
	<!-- 존재하는 댓글 -->
	<div>
		<table border="1" id="commentTable">
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
</body>
</html>