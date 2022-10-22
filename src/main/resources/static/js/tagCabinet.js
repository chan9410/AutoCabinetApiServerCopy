function createTable() {

	/*const columnCnt = $('#column_size_input').val();
	const rowCnt = $('#row_size_input').val();*/

	const columnCnt = 16;
	const rowCnt = 8;

	var z = 1;


	$("#createBox").append("<table id = 'newTable' border = 1>");

	for (let i = 0; i < rowCnt; i++) {

		$("#newTable").append("<tr>");

		for (let j = 0; j < columnCnt; j++) {

			$("#newTable").append("<td id = 'tdBox_" + z + "' class = 'cbBox' onclick = 'searchPort(this.id)''><p class = 'location'>" + z + "</p><p id = 'cnt_" + z + "' class = 'tag_cnt'>0</p></td>");

			z++;
		}
		$("#newTable").append("</tr>");
	}

	$("createBox").append("</table>");

}

function dataInsert() {

	var new_arr = new Array();
	new_arr = [{ LOCATION: 0, COUNT: 0 }]

	$.ajax({
		url: "http://119.196.33.217:7088/getCurrentCount",
		method: "GET",
		contentType: "application/json",
		success: function(data) {

			data.push.apply(data, new_arr);

			if (data.length > 0) {

				for (var i = 0; i < data.length; i++) {

					Location = data[i].LOCATION;
					Count = data[i].COUNT;

					$("#cnt_" + Location + "").text(Count);

				}
			}
		},
		error: function(error) {
			alert(error.responseJSON.message);
		}
	});
}

function searchPort(clicked_id) {

	var location = clicked_id.substring(6);

	var data = {
		location
	}

	$.ajax({
		url: "http://119.196.33.217:7088/getPortNo",
		method: "GET",

		contentType: "application/json",
		data: data,
		success: function(data) {

			$(".antenna-port").val(location);

			$(".antenna-result").text("");

			$.each(data, function(index, item) {
				let liElem = document.createElement("li");
				liElem.classList.add("antenna-result-item");
				liElem.innerText = `${item.TAG}`;

				$(".antenna-result").append(liElem);
			})

		},
		error: function(error) {
			alert(error.responseJSON.message);
		}
	})

}

function clearCachedData() {
	//박스 css 삭제
	clearCssOfBox();
	//로컬 스토리지 데이터 삭제
	clearLocalStorageData();
	//제품찾기 리스트 데이터 삭제
	clearSearchResultList();
}

function clearCssOfBox() {
	const boxes = document.querySelectorAll(".cbBox");
	boxes.forEach(item => item.classList.remove("check"));
}

function clearLocalStorageData() {
	["chkRowData_Tag", "chkRowData_Info", "groupSendDataTag", "groupSendData"].forEach(targetData => {
		if (localStorage.getItem(targetData) !== null) localStorage.removeItem(targetData);
	})
}

function clearSearchResultList() {
	const searchResult = document.querySelector(".product-search-result");
	searchResult.innerText = "";
	searchResult.childNodes = null;
}


//제품 찾기를 하려는 데이터가 없을 경우 동작 안함
//제품 찾기를 하려는 데이터가 있을 경우 동작
function processFindCabinetOfItem() {
	//해당 데이터 없을 경우 동작 안함
	if (!checkLocalStorageDataExist()) return;


	//해당 데이터가 존재한다면 데이터 타입에 따른 호출
	switch (checkWhichLocalStorageDataTypeExist()) {
		case "indiviualType":
			selectCabinetOfIndividualData();
			break;
		case "groupType":
			selectCabinetOfGroupData();
			break;
	}
}

function checkWhichLocalStorageDataTypeExist() {
	const isChkIndividualData = ["chkRowData_Tag", "chkRowData_Info"].every(target => localStorage.getItem(target) !== null);

	return isChkIndividualData === true ? "indiviualType" : "groupType";
}

function selectCabinetOfIndividualData() {
	const sendData_Tag = localStorage.getItem("chkRowData_Tag");
	const sendData_Info = localStorage.getItem("chkRowData_Info");

	const sendData = [];

	const sendIndividualDataArr = sendData_Info.split(",");

	const tagItemArr = sendIndividualDataArr.filter((_, i) => i % 2 === 0);
	const nameItemArr = sendIndividualDataArr.filter((_, i) => i % 2 === 1);


	const processedArr = new Array(tagItemArr.length).fill().map((_, i) => ({
		tag: tagItemArr.at(i),
		name: nameItemArr.at(i)
	}));

	processedArr.forEach((elem) => {
		const liElem = document.createElement("li");
		liElem.classList.add("product-search-item");
		liElem.innerText = `${elem.name} ${elem.tag}`;
		$(".product-search-result").append(liElem);

	})


	if (sendData_Tag != null) {
		var sendData_Tag_Text = sendData_Tag.split(',');
		for (i = 0; i < sendData_Tag_Text.length; i++) {
			sendData.push(sendData_Tag_Text[i]);
		}
	}

	const data = {
		sendData
	}

	$.ajax({
		url: "http://119.196.33.217:7088/getSelectCabinet",
		method: "GET",
		data: data,
		contentType: "application/json",
		success: function(data) {

			for (var i = 0; i < data.length; i++) {

				Location = data[i].LOCATION;

				const cbBoxElem = document.querySelector(`#tdBox_${Location}`);
				cbBoxElem.classList.add("check");
			}

		},
		error: function(error) {
			alert(error.responseJSON.message);
		}
	});
}

function selectCabinetOfGroupData() {
	const sendGroupData_Tag = localStorage.getItem("groupSendDataTag");
	const sendGroupData_Info = localStorage.getItem("groupSendData");

	const sendData = [];

	const sendGroupDataArr = sendGroupData_Info.split(",");

	const tagItemArr = sendGroupDataArr.filter((_, i) => i % 2 === 0);
	const nameItemArr = sendGroupDataArr.filter((_, i) => i % 2 === 1);


	const processedArr = new Array(tagItemArr.length).fill().map((_, i) => ({
		tag: tagItemArr.at(i),
		name: nameItemArr.at(i)
	}));

	processedArr.forEach((elem) => {
		const liElem = document.createElement("li");
		liElem.classList.add("product-search-item");
		liElem.innerText = `${elem.name} ${elem.tag}`;
		$(".product-search-result").append(liElem);

	})

	if (sendGroupData_Tag != null) {
		var sendGroupData_Tag_Text = sendGroupData_Tag.split(',');
		for (i = 0; i < sendGroupData_Tag_Text.length; i++) {
			sendData.push(sendGroupData_Tag_Text[i]);
		}
	}

	const data = {
		sendData
	}

	$.ajax({
		url: "http://119.196.33.217:7088/getSelectCabinet",
		method: "GET",
		data: data,
		contentType: "application/json",
		success: function(data) {

			for (var i = 0; i < data.length; i++) {

				Location = data[i].LOCATION;

				const cbBoxElem = document.querySelector(`#tdBox_${Location}`);
				cbBoxElem.classList.add("check");
			}

		},
		error: function(error) {
			alert(error.responseJSON.message);
		}
	});
}


function checkLocalStorageDataExist() {
	const processOrNot = [
		{
			value: ["chkRowData_Tag", "chkRowData_Info"]
		},
		{
			value: ["groupSendDataTag", "groupSendData"]
		}
	].some(({ value }) => value.every(targetData => localStorage.getItem(targetData) !== null ? true : false));
	return processOrNot;
}


function processLoadInputHistory() {
	clearInputHistory();
	loadInputHistory();
}

function clearInputHistory() {
	//입고시에만 데이터가 들어오는 기틍 추가시 현재 함수해서 리스트 초기화 필요함
	const resultElem = document.querySelector(".input-history-result");
}

function loadInputHistory() {

	$.ajax({
		url: "http://119.196.33.217:7088/getInputHistory",
		method: "GET",
		contentType: "application/json",
		success: function(data) {

			$.each(data, function(index, item) {
				let liElem = document.createElement("li");
				liElem.classList.add("input-history-item");
				liElem.innerText = `${item.TAGTIME} #${item.LOCATION} ${item.WORKERNAME} ${item.TAG} ${item.ITEMNAME}`;

				$(".input-history-result").append(liElem);
			})

		},
		error: function(error) {
			alert(error.responseJSON.message);
		}
	});

}

function processLoadOutputHistory() {
	clearOutputHistory();
	loadOutputHistory();
}

function clearOutputHistory() {
	//출고시에만 데이터가 들어오는 기틍 추가시 현재 함수해서 리스트 초기화 필요함
}

function loadOutputHistory() {

	$.ajax({
		url: "http://119.196.33.217:7088/getOutputHistory",
		method: "GET",
		contentType: "application/json",
		success: function(data) {
			$(".output-history-content-body").text("");

			$.each(data, function(index, item) {
				let liElem = document.createElement("li");
				liElem.classList.add("output-history-item")
				liElem.innerText = `${item.TAGTIME} #${item.LOCATION} ${item.WORKERNAME} ${item.TAG} ${item.ITEMNAME}`;
				$(".output-history-result").append(liElem);
			})

		},
		error: function(error) {
			alert(error.responseJSON.message);
		}
	});

}

function onIndividualSearchBtnClick() {
	clearCachedData();
	location.href = '/individual_search';
}


function onGroupSearchBtnClick() {
	clearCachedData();
	location.href = '/group_search';
}

function onResetSearchDataBtnClick() {
	clearCachedData();
}

(function() {
	//버튼 이벤트 리스터 등록
	$("#individual-search-btn").on('click', onIndividualSearchBtnClick);
	$("#group-search-btn").on("click", onGroupSearchBtnClick);
	$("#reset-search-data-btn").on("click", onResetSearchDataBtnClick);

	//테이블 생성
	createTable();
	//테이블 데이터 구성
	dataInsert();

	//현재 상품이 들어있는 캐비넷 찾기
	processFindCabinetOfItem();

	//입고 History 데이터 처리
	processLoadInputHistory();
	//출고 History 데이터 불러오기
	processLoadOutputHistory();
	
	//캐비넷 데이터 업데이트 주기 설정
	setInterval(dataInsert, 2000);
}
)();

function deviceList() {

	$.ajax({
		url: "/api/getDeviceList",
		method: "GET",
		contentType: "application/json",
		success: function(data) {

			console.log(data);
		}
	});
}

function currentCount() {

	$.ajax({
		url: "/api/currentCount",
		method: "POST",
		contentType: "application/json",
		success: function(data) {

			console.log(data);
		}
	});
}

deviceList();
currentCount();


