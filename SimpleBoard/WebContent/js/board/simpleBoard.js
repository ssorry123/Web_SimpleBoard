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
	
	// 게시글 볼려고 클릭하는 경우
	$('.post').click(function(){
		// 선택된 게시글 번호 히든에 등록
		console.log($(this).find('.no').text());
		const no = $(this).find('.no').text();
		$('#postNo').val(no);
		
		// form 제출
		$('#posts').submit();
	});
})