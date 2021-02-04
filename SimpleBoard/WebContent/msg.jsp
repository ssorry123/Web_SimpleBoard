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

	<h1>메세지</h1>
	 : ${sessionScope.msg }

	<hr>
	<button type="button" id="home">홈으로</button>


	<script type="text/javascript">
		$('#home').click(function() {
			location.href = "./index.jsp";
		});
	</script>
</body>
</html>