const Grid = tui.Grid;

//현황 갯수 정보 업데이트
function updateCountInfoCards(stockCount, inputCount, outputCount) {
	const stockCard = document.querySelector("#stock-count");
	const inputCard = document.querySelector("#input-count");
	const outputCard = document.querySelector("#output-count");

	stockCard.innerText = stockCount;
	inputCard.innerText = inputCount;
	outputCard.innerText = outputCount;
}

//재고 현황 그래프 시작
//재고 현황 그래프 => 그래프 구성
const labels = new Array(30).fill().map((_, i) => i + 1);

const stockDataset = {
	label: "현재 재고 현황",
	data: new Array(30).fill(),
	borderColor: "rgb(54, 162, 235)",
	borderWidth: 3
}

const inputDataset = {
	label: "현재 입고 현황",
	data: new Array(30).fill(),
	borderColor: 'rgb(75, 192, 192)',
	borderWidth: 3
}

const outputDataset = {
	label: "현재 출고 현황",
	data: new Array(30).fill(),
	borderColor: "rgb(255, 205, 86)",
	borderWidth: 3
}


const ctx = document.getElementById('total-stock-chart').getContext('2d');

const totalChartConfig = {
	type: 'line',
	data: {
		labels,
		datasets: [stockDataset, inputDataset, outputDataset],
	},
	options: {
		scales: {
			y: {
				beginAtZero: true,
			},
		},
	},
};

const totalChart = new Chart(ctx, totalChartConfig);

//디바이스 리스트 조회
const loadDeviceListData = async (jsonObject) => {
	/*JSON format should be like { COMP_ID: "a01" }*/
	const response = await fetch("http://119.196.33.217:7088/report/getReportDeviceListOfComp/", {
		headers: {
			"Content-Type": "application/json",
		},
		method: "POST",
		body: jsonObject
	});

	return response;
}

const processLoadDeviceListData = (jsonObject) => {
	const promise = loadDeviceListData(jsonObject);
	promise.then(response => response.json())
		.then(data => {
			const selectDeviceNode = document.querySelector(".report-device-list");
			data.forEach((device, i) => {
				const optionNode = document.createElement("option");
				optionNode.setAttribute("value", i + 1);
				optionNode.innerText = device;
				selectDeviceNode.append(optionNode);
			})
		})
}

//조회 버튼 클릭 이벤트 처리
const searchBtn = document.querySelector("#search-btn");
searchBtn.addEventListener("click", searchBtnClick)

function searchBtnClick(e) {
	//API 요청 파라미터 구성
	e.preventDefault();
	const deviceIdList = document.querySelector(".report-device-list");
	const selectedIndex = deviceIdList.value;
	const deviceId = deviceIdList.options[deviceIdList.selectedIndex].text;
	const fromDate = document.querySelector("#from-date").value;
	const toDate = document.querySelector("#to-date").value;

	if (selectedIndex === "0") {
		//전체 디바이스 검색 시 하단 요청으로 처리
		const jsonObject = JSON.stringify({ COMP_ID: "a01", "FROM": fromDate, "TO": toDate });
		processLoadTotalChartData(jsonObject);

		return;
	}

	//개별 디바이스 검색시 API 요청 파라미터 구성
	const jsonObject = JSON.stringify({
		DEVICE_ID: deviceId,
		FROM: fromDate,
		TO: toDate
	});

	processLoadCountDataOfDeviceId(jsonObject);
}

const loadCountDataOfDeviceId = async (jsonObject) => {
	/*JSON format should be like { DEVICE_ID : "c01", FROM: "2022-10-1", TO:"2022-10-10" }*/
	/*Or { DEVICE_ID : "c01"}*/

	const result = await fetch("http://119.196.33.217:7088/report/getReportCountsInfo", {
		headers: {
			"Content-Type": "application/json",
		},
		method: "POST",
		body: jsonObject
	});

	return result;
}

function processLoadCountDataOfDeviceId(jsonObject) {
	const promise = loadCountDataOfDeviceId(jsonObject);
	promise.then(response => response.json())
		.then(data => {

			if (data.length === 0) {
				alert("해당 기록이 없습니다");
				return;
			}

			//갯수 정보 업데이트
			const { STOCK_COUNT, INPUT_COUNT, OUTPUT_COUNT } = data.at(0);
			updateCountInfoCards(STOCK_COUNT, INPUT_COUNT, OUTPUT_COUNT);

			//그리드 업데이트
			updateGrid(data);

			//최근 날짜가 가장 뒤로 가도록 변경
			//차트 업데이트
			updateChart(data.reverse());
		})
}

//재고 현황 그래프 => 회사의 모든 장비의 재고 입고 출고 카운트 불러옴
const loadTotalChartData = async (jsonObject) => {
	/*JSON format should be like { COMP_ID: "a01" }*/
	const response = await fetch("http://119.196.33.217:7088/report/getTotalCountPerDayOfCompId", {
		headers: {
			"Content-Type": "application/json",
		},
		method: "POST",
		body: jsonObject
	});

	return response;
}

//재고 현황 그래프 => 그래프에 보여질 데이터 처리
const processLoadTotalChartData = (jsonObject) => {
	const responsePromise = loadTotalChartData(jsonObject);
	responsePromise
		.then(response => response.json())
		.then(data => {
			if (data.length === 0) {
				alert("해당 기록이 없습니다");
				return;
			}

			//갯수 정보 업데이트
			const { STOCK_COUNT, INPUT_COUNT, OUTPUT_COUNT } = data.at(0);
			updateCountInfoCards(STOCK_COUNT, INPUT_COUNT, OUTPUT_COUNT)

			//그리드 업데이트
			updateGrid(data);

			//최근 날짜가 가장 뒤로 가도록 변경
			//차트 업데이트
			updateChart(data.reverse());
		});
}

function updateChart(data) {
	const processedLabels = processLableData(data);
	const processedStockDataset = processStockData(data);
	const processedInputDataset = processInputData(data);
	const processedOutputDataset = processOutputData(data);

	totalChart.data.labels = processedLabels;
	totalChart.data.datasets = [processedStockDataset, processedInputDataset, processedOutputDataset]
	totalChart.update();
}

//재고 현황 그래프 => 현재 재고 그래프 하단 레이블 구성 처리 함수
function processLableData(dataArray) {
	return dataArray.map(item => item.DATE);
}

//재고 현황 그래프 => 현재 재고 현황 그래프 데이터 처리 함수
function processStockData(dataArray) {
	const processedData = dataArray.map(item => item.STOCK_COUNT);

	const processedStockDataset = {
		...stockDataset,
		data: processedData
	}

	return processedStockDataset;
}

//재고 현황 그래프 => 현재 입고 현황 그래프 데이터 처리 함수
function processInputData(dataArray) {
	const processedData = dataArray.map(item => item.INPUT_COUNT);

	const processedInputDataset = {
		...inputDataset,
		data: processedData
	}

	return processedInputDataset;
}

//재고 현황 그래프 => 현재 출고 현황 그래프 데이터 처리 함수
function processOutputData(dataArray) {
	const processedData = dataArray.map(item => item.OUTPUT_COUNT);

	const processedOutputDataset = {
		...outputDataset,
		data: processedData
	}

	return processedOutputDataset;
}


//현재 재고 현황 그래프 끝


//현재 재고 현황 그리드 시작

//그리드 생성
const stockGrid = new Grid(makeGridConfig(document.getElementById('report-stock-grid'), "재고 현황"));
const inputGrid = new Grid(makeGridConfig(document.getElementById('report-input-grid'), "입고 현황"));
const outputGrid = new Grid(makeGridConfig(document.getElementById('report-output-grid'), "출고 현황"));

//그리드 config 설정 함수
function makeGridConfig(
	targetDomElem,
	headerName
) {
	const config = {
		el: targetDomElem,
		scrollY: true,
		scrollX: false,
		bodyHeight: 250,
		columnOptions: {
			resizable: true
		},
		header: {
			height: 50,
			complexColumns: [
				{
					header: headerName,
					name: "titleColumn",
					childNames: ["id", "date", "count"]
				}
			],
		},
		columns: [
			{
				header: '번호',
				name: 'id',
				width: 50
			},
			{
				header: '날짜',
				name: 'date',
				editor: 'text',
			},
			{
				header: '현황',
				name: 'count'
			},
		],
		data: null,
	}

	return config;
}

function updateTargetGrid(gridElem, processedGridData) {
	const targetGrid = gridElem;
	targetGrid.resetData(processedGridData);
}

function processStockCountGridData(data) {
	return data.map((item, i) => ({ id: i + 1, date: item.DATE, count: item.STOCK_COUNT }));
}

function processInputCountGridData(data) {
	return data.map((item, i) => ({ id: i + 1, date: item.DATE, count: item.INPUT_COUNT }));
}

function processOuputCountGridData(data) {
	return data.map((item, i) => ({ id: i + 1, date: item.DATE, count: item.OUTPUT_COUNT }));
}

function updateGrid(data) {
	updateTargetGrid(stockGrid, processStockCountGridData(data));
	updateTargetGrid(inputGrid, processInputCountGridData(data));
	updateTargetGrid(outputGrid, processOuputCountGridData(data));
}
//메인 통계 화면에서 즉시 실행 함수 설정
(function() {
	//디바이스 리스트 조회 실행
	processLoadDeviceListData(JSON.stringify({ COMP_ID: "a01" }));

	//재고 현황 그래프 => 차트데이터 로딩
	processLoadTotalChartData(JSON.stringify({ COMP_ID: "a01", "FROM": "", "TO": "" }));
	//재고 현황 그래프 => DB에서 재고현황 그래프 데이터 로딩 시간주기 설정
	//const processId = setInterval(processLoadTotalChartData, 10000);
})()