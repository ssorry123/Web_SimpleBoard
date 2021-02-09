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

	<form action="<c:url value="/update?postNo=${post.no }"/>"
		method="post">
		<input type="hidden" value="${post.userId }" name="postUserId" />
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
		<button type="submit">수정</button>
		<button type="button" id="cancel">취소</button>
		<input type="hidden" value="${post.no }" id="postNo" />
	</form>


	<hr>
	<footer>
		<%@ include file="sub/footer.jsp"%>
	</footer>

	<script type="text/javascript">
		const contextRoot = '/SimpleBoard'
		$(document).ready(function() {
			
			$('#cancel').click(function() {
				console.log("클릭");
				let postNo = $('#postNo').val();
				location.href = contextRoot + "/showOnePost?postNo=" + postNo;
			})
			
		});
	</script>
</body>
</html>