
var searchCode_arr = [];

$(".check_btn").click(function() {

	var searchCode = $('.search_input').val();

	if (searchCode == '') {

		alert('제품명을 입력해주세요.');

	} else {

		var data = {
			searchCode
		}

		$.ajax({
			url: 'http://119.196.33.217:7088/getCodeSearch',
			method: 'GET',
			data: data,
			contentType: "application/json",
			success: function(data) {

				console.log(data);
				//console.log(data[0].ITEMNAME);

				if(data.length === 0){
					alert('읽히지 않은 제품명입니다.');
					
				}else{
					alert('검색 되었습니다.');
				$(".search_input_datas").append("<p class = 'search_input_datas_text'>" + data[0].ITEMNAME + ' ' + '</p>');
				searchCode_arr.push(data[0].ITEMNAME);
					
				}

				console.log(searchCode_arr);
			},
			error: function(error) {
				alert(error.responseJSON.message);
			},
		});
	}

});

$(".select_btn").click(function() {

	var searchCode = $('.search_input').val();
	var searchCodeArr = searchCode_arr;
	var inputStartDate = $('#inputStartDate').val();
	var inputLastDate = $('#inputLastDate').val();

	var groupSendDataTag = [];
	var groupSendData = [];


	if (searchCode == '' || searchCodeArr == '') {
		alert('제품명을 검색해주세요.');
	} else if (inputStartDate == '' && inputLastDate != '') {
		alert('입고일의 입력상자를 모두 입력해주세요.');
	} else if (inputStartDate != '' && inputLastDate == '') {
		alert('입고일의 입력상자를 모두 입력해주세요.');
	} else {

		var data = {
			searchCodeArr,
			inputStartDate,
			inputLastDate
		}

		$.ajax({
			url: '/getItemSearch',
			method: 'GET',
			data: data,
			contentType: "application/json",
			success: function(data) {

				console.log(data);

				alert('검색 되었습니다.');

				for (i = 0; i < data.length; i++) {

					groupSendDataTag.push(data[i].TAG);
					groupSendData.push(data[i].TAG);
					groupSendData.push(data[i].ITEMNAME);

				}

				localStorage.setItem("groupSendDataTag", groupSendDataTag);
				localStorage.setItem("groupSendData", groupSendData);
				location.href = "/";

			},
			error: function(error) {
				alert(error.responseJSON.message);
			},
		});
	}
});

$(".reset_btn").click(function() {

	$('.search_input').val('');
	$('.search_input_datas_text').text('');
	$('#inputStartDate').val('');
	$('#inputLastDate').val('');
	
});

