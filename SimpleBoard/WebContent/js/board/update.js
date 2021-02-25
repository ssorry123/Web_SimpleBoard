const contextRoot = '/SimpleBoard'
$(document).ready(function() {

	$('#cancel').click(function() {
		console.log("클릭");
		let postNo = $('#postNo').val();
		location.href = contextRoot + "/showOnePost?postNo=" + postNo;
	})

});