
const grid = new tui.Grid({
	el: document.getElementById('grid'),
	data: [
	{
		WORKERNAME: '홍길동',
		TAG: '3000C00000000000000109140000',
		INPUTTAGTIME: '2022.10.11',
		OUTPUTTAGTIME: ''
	},
	{
		WORKERNAME: '홍길동',
		TAG: '3000C00000000000000109140000',
		INPUTTAGTIME: '2022.10.21',
		OUTPUTTAGTIME: '2022.10.24'
	},
	{
		WORKERNAME: '김남중',
		TAG: '3000C00000000000000109140000',
		INPUTTAGTIME: '2022.10.12',
		OUTPUTTAGTIME: ''
	},
	{
		WORKERNAME: '김남중',
		TAG: '3000C00000000000000109140000',
		INPUTTAGTIME: '2022.10.13',
		OUTPUTTAGTIME: '2022.10.25'
	},
	{
		WORKERNAME: '홍길동',
		TAG: '3000C00000000000000109140000',
		INPUTTAGTIME: '2022.10.14',
		OUTPUTTAGTIME: ''
	},
	{
		WORKERNAME: '김남중',
		TAG: '3000C00000000000000109140000',
		INPUTTAGTIME: '2022.10.15',
		OUTPUTTAGTIME: '2022.10.30'
	}
],
	scrollX: false,
	scrollY: true,
	rowHeaders: ['rowNum', 'checkbox'],
	bodyHeight: 700,
	columns: [
		{
			header: '근로자 성명',
			name: 'WORKERNAME',
			width : 300
		},
		{
			header: 'RFID TAG 값',
			name: 'TAG',
			width : 340
		},
		{
			header: '제품명',
			name: 'ITEMNAME',
			width : 300
		},
		{
			header: '입고일시',
			name: 'INPUTTAGTIME',
			width : 310
		},
		{
			header: '출고일시',
			name: 'OUTPUTTAGTIME',
			width : 310
		}
	]
});


/*$("#search-btn").click(function() {
	debugger;
	var searchWorker = $('#worker-id').val();

	var inputStartDate = $('#from-date').val();
	var inputLastDate = $('#to-date').val();

	var data = {
		searchWorker,
		inputStartDate,
		inputLastDate
	}

	$.ajax({
		url: '/report/getWorkerSearch',
		method: 'GET',
		data: data,
		contentType: "application/json",
		success: function(data) {

			console.log(data);

			alert('검색 완료.');
			grid.resetData(data);


		},
		error: function(error) {
			alert(error.responseJSON.message);
		},
	});


});*/
