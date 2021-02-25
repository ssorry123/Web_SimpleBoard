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
<script type="text/javascript" src="<c:url value="/js/board/update.js"/>"></script>
</head>
<body>
	<header>
		<%@ include file="sub/header.jsp"%>
	</header>
	<hr>

	<form action="<c:url value="/update?postNo=${post.no }"/>"
		method="post" enctype="multipart/form-data">
		<c:if test="${!empty post.picPath }">
			<img src="<c:url value="/${post.picPath }"/>" />
		</c:if>
		<table>
			<tr>
				<th>글번호</th>
				<td>${post.no }</td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" required
					value="${post.title }" /></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="content" rows="10" cols="50">${post.content }</textarea></td>
			</tr>
		</table>
		<input type="hidden" value="${post.userId }" name="postUserId" />
		<button type="submit">수정</button>
		<input type="hidden" value="${post.no }" id="postNo" />
		<button type="button" id="cancel">취소</button>
	</form>


	<hr>
	<footer>
		<%@ include file="sub/footer.jsp"%>
	</footer>

</body>
</html>