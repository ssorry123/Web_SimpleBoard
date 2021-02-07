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

	<form action="<c:url value="/write"/>" method="post">
		<table>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" required/></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="content" rows="10" cols="50">Write something here</textarea></td>
			</tr>
		</table>
		<button type="submit">글쓰기</button>
		<button type="button" id="cancel">취소</button>
	</form>


	<hr>
	<footer>
		<%@ include file="sub/footer.jsp"%>
	</footer>

	<script type="text/javascript">
		const contextRoot = '/SimpleBoard'
		$(document).ready(function() {
			$('#cancel').click(function() {
				location.href = contextRoot + "/simpleBoard";
			})
		});
	</script>
</body>
</html>