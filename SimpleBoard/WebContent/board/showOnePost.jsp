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
		<tfoot>
			<tr>
				<td>댓글 샘플</td>
			</tr>
		</tfoot>
	</table>
	<button type="button" id="back">뒤로가기</button>

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