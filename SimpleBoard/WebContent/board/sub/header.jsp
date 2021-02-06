<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<form action="<c:url value="/logout"/>" method="post">
	<button type="submit">로그아웃</button>
</form>
<form action="<c:url value="/member/memberChange.jsp"/>" method="post">
	<button type="submit">회원정보수정</button>
</form>
<form action="<c:url value="/signOut"/>" method="post" id="signOut">
	<button type="submit">회원탈퇴</button>
</form>
<a>메뉴</a>
<a>메뉴</a>
<a>메뉴</a>
<a>메뉴</a>
<br>
<h3>${member.name }님환영합니다.</h3>