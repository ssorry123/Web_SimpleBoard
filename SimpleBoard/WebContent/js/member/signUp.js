const contextRoot = '/SimpleBoard'
$(document).ready(function() {
	// 메인페이지로 이동
	$('#home').click(function() {
		location.href = contextRoot + '/index.jsp';
	});

	$('#signUp').submit(function(event) {
		event.preventDefault();

		let pw1 = $('#passwd1').val();
		let pw2 = $('#passwd2').val();

		if (pw1 != pw2) {
			alert("비밀번호가 일치하지 않습니다.");
			$('#passwd1').focus();
			return false;
		}

		return this.submit();
	});

});