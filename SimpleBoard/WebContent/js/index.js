$(document).ready(function() {
	let contextRoot = '/SimpleBoard'

	// 회원가입 페이지로 이동
	$('#signUp').click(function() {
		location.href = contextRoot + '/member/signUp.jsp';
	});

});