

$(document).ready(function() {
	let contextRoot = '/SimpleBoard'

	$('#back').click(function() {
		location.href = contextRoot + "/simpleBoard";
	})

	$('#ajaxBtn').click(function() {
		let postNo = $('#postNo').val();
		let comment = $('#writedComment').val();
		// 서버로 보낼 데이터 만들기
		let sendData = {
			'postNo': postNo,
			'comment': comment,
		};
		console.log(sendData);

		$.ajax({
			type: 'post',
			url: contextRoot + '/ajaxWriteComment',
			data: sendData,
			success: function(recData) {
				// JSON 형식으로 받기
				const recJson = JSON.parse(recData);
				console.log(recJson);
				
				// 댓글 추가
				let inputHtml = 
				`
				<tr>
					<td>${recJson.id}</td>
					<td>${recJson.name}</td>
					<td>${comment}</td>
					<td>방금</td>
				</tr>
				`;
				$('#commentTable').append(inputHtml);

			},
			error: function() {
				console.log("실패");
			}
		});
	});

})