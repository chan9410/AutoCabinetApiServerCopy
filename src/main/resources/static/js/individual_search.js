var chkRowTagArr = [];
var chkRowData_Tag = [];
var chkRowData_Info = [];
var chkRowData = [];


const grid = new tui.Grid({
	el: document.getElementById('grid'),
	/*data: gridData,*/
	scrollX: false,
	scrollY: true,
	rowHeaders: ['rowNum', 'checkbox'],
	bodyHeight: 150,
	columns: [
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
			name: 'TAG'
		},
		{
			header: '입고일',
			name: 'INPUTTAGTIME'
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
			url: 'http://119.196.33.217:7088/getCodeSearch',
			method: 'GET',
			data: data,
			contentType: "application/json",
			success: function(data) {

				console.log(data);
				
				if(data.length === 0){
					alert('읽히지 않은 제품명입니다.');
					
				}else{

				alert('추가 되었습니다.');

				grid.resetData(data);
				}

			},
			error: function(error) {
				alert(error.responseJSON.message);
			},
		});
	}
});


const grid_second = new tui.Grid({
	el: document.getElementById('grid_second'),
	//data: gridData,
	scrollX: false,
	scrollY: true,
	rowHeaders: ['rowNum', 'checkbox'],
	bodyHeight: 150,
	columns: [
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
			name: 'TAG'
		},
		{
			header: '입고일',
			name: 'INPUTTAGTIME'
		}
	]
});

$('#add_btn').on('click', function() {

	var chk_datas = grid.getCheckedRows();

	for (i = 0; i < chk_datas.length; i++) {
		chkRowTagArr.push(chk_datas[i].TAG);
	}
	console.log(chkRowTagArr);

	if (chkRowTagArr == '') {
		alert('제품명을 선택해주세요.');
	} else {

		var data = {
			chkRowTagArr
		}

		$.ajax({
			url: 'http://119.196.33.217:7088/getCheckRowTag',
			method: 'GET',
			data: data,
			contentType: "application/json",
			success: function(data) {

				console.log(data);

				alert('추가 되었습니다.');

				grid_second.resetData(data);

			},
			error: function(error) {
				alert(error.responseJSON.message);
			},
		});
	}

});

$("#del_btn").click(function() {

	grid_second.removeCheckedRows();

});

function sendData() {

	var chk_datas = grid_second.getCheckedRows();

	for (i = 0; i < chk_datas.length; i++) {
		chkRowData_Tag.push(chk_datas[i].TAG);
		chkRowData_Info.push(chk_datas[i].TAG);
		chkRowData_Info.push(chk_datas[i].ITEMNAME);
	}
	console.log(chkRowData_Tag);
	console.log(chkRowData_Info);


	if (chkRowData_Tag == '') {
		alert('제품명을 선택해주세요.');
	} else {
		localStorage.setItem("chkRowData_Tag", chkRowData_Tag);
		localStorage.setItem("chkRowData_Info", chkRowData_Info);
		location.href = "/";
	}

}

$("#reset_btn").click(function() {
	const data = [];

	$('#search_item_code').val('');
	grid.resetData(data);
	grid_second.resetData(data);
});




