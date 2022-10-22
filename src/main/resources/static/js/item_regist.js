const grid = new tui.Grid({
	el: document.getElementById('grid'),
	/*data: gridData,*/
	scrollX: false,
	scrollY: true,
	rowHeaders: ['rowNum', 'checkbox'],
	bodyHeight: 540,
	columns: [
		{
			header: '번호',
			name: 'TAG'
		},
		{
			header: '회사',
			name: 'COMPANYID'
		},
		{
			header: '제품명',
			name: 'ITEMNAME'
		},
		{
			header: 'Tag Code',
			name: 'ITEM_CODE'
		},
		{
			header: '입고일',
			name: 'input_date'
		}
	]
});


$('#check_btn').on('click', function() {

	var searchCode = $('#search_item_code').val();

	if (searchCode == '') {

		alert('제품명을 입력해주세요.');

	} else {

		var data = {
			searchCode
		}

		$.ajax({
			url: 'http://119.196.33.217:7088/getItemSearch',
			method: 'GET',
			data: data,
			contentType: "application/json",
			success: function(data) {

				console.log(data);

				alert('검색 되었습니다.');

				grid.resetData(data);

			},
			error: function(error) {
				alert(error.responseJSON.message);
			},
		});
	}
});



