$(document).ready(function() {
	$('#signOut').submit(function(e) {
		console.log("!23");
		e.preventDefault();

		let ret = confirm("정말로 탈퇴하시겠습니까?");
		if (!ret) {
			return false;
		}
		return this.submit();
	});
})