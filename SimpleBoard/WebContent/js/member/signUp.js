var contextRoot = '/SimpleBoard'
$(document).ready(function() {
	// 메인페이지로 이동
	$('#home').click(function() {
		location.href = contextRoot + '/index.jsp';
	});
});