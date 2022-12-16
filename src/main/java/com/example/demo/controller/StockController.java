package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.ApiItemTagInfoParam;
import com.example.demo.dto.ApiSearchTagInfoVO;
import com.example.demo.dto.ApiTagCountVO;
import com.example.demo.dto.ApiTagInfoParam;
import com.example.demo.dto.CurrentCountSearchTagVO;
import com.example.demo.dto.IOHistotyVO;
import com.example.demo.dto.ListResult;
import com.example.demo.service.ApiService;
import com.example.demo.service.CurrentCountService;
import com.example.demo.service.IOHistoryService;

@CrossOrigin("*")
@Controller
@RequestMapping("/stockCon")

public class StockController {

	private CurrentCountService currentCountService;

	private IOHistoryService iOHistoryService;

	private ApiService apiService;

	@Autowired
	public StockController(CurrentCountService currentCountService, IOHistoryService iOHistoryService,
			ApiService apiService) {

		this.currentCountService = currentCountService;
		this.iOHistoryService = iOHistoryService;
		this.apiService = apiService;
	}

	// 실시간 카운트 불러오기
	@PostMapping(value = "/getCurrentStockCount", produces = "application/json")
	public @ResponseBody ListResult<ApiTagCountVO> getCurrentStockCount(@RequestBody HashMap<String, Object> map) {

		ApiTagInfoParam param = new ApiTagInfoParam();
		
		if(map.get("DEVICE_ID") == null || map.get("DEVICE_ID").toString() == "") {
			return apiService.getListResult(null, null, 111);
		} else {
		
		try {
			param.setDeviceId(map.get("DEVICE_ID").toString());
		}catch(NullPointerException e) {
			return apiService.getListResult(null, null, 111);
		}

		List<ApiTagCountVO> dataList = currentCountService.getCurrentStockCount(param);

		String chkDev = currentCountService.chkDeviceId(param);

		int statusCode;

		if (chkDev == null) {
			statusCode = 100;
		} else if (dataList.isEmpty()) {
			statusCode = 101;
		} else {
			statusCode = 200;
		}

		return apiService.getListResult("getCurrentStockCount", dataList, statusCode);
		}
	}

	// 클릭한 구분 영역 정보 불러오기
	@PostMapping(value = "/getCurrentLocationInfo", produces = "application/json")
	public @ResponseBody ListResult<ApiSearchTagInfoVO> getCurrentLocationInfo(@RequestBody HashMap<String, Object> map) {

		ApiTagInfoParam param = new ApiTagInfoParam();
		
		if(map.get("DEVICE_ID") == null || map.get("DEVICE_ID").toString() == "" ||
		   map.get("LOCATION") == null) {
			return apiService.getListResult(null, null, 111);
		} else {
		
		try {
			param.setLocation((int) map.get("LOCATION"));
			param.setDeviceId(map.get("DEVICE_ID").toString());
		}catch(NullPointerException e) {
			return apiService.getListResult(null, null, 111);
		}

		List<ApiSearchTagInfoVO> dataList = currentCountService.getCurrentLocationInfo(param);

		String chkDev = currentCountService.chkDeviceId(param);

		int statusCode;

		if (chkDev == null) {
			statusCode = 100;
		} else if (dataList.isEmpty()) {
			statusCode = 101;
		} else {
			statusCode = 200;
		}

		return apiService.getListResult("getCurrentLocationInfo", dataList, statusCode);
		}
	}

	// 리스트 형식의 실시간 재고 페이지에서 특정 조건 조회.
	@SuppressWarnings("unchecked")
	@PostMapping(value = "/getCurrentStockInfo", produces = "application/json")
	public @ResponseBody ListResult<CurrentCountSearchTagVO> getCurrentStockInfo(
			@RequestBody HashMap<String, Object> map) {

		ApiItemTagInfoParam param = new ApiItemTagInfoParam();
		
		int statusCode;
		
		param.setTag((String) map.get("TAG"));
		param.setItemCode((String) map.get("ITEM_CODE"));
		param.setItemName((String) map.get("ITEM_NAME"));
		param.setItemGroup((String) map.get("ITEM_GROUP"));
		param.setItemStandard((String) map.get("ITEM_STANDARD"));
		param.setItemAdmin((String) map.get("ITEM_ADMIN"));
		param.setItemDepart((String) map.get("ITEM_DEPART"));
		param.setItemSite((String) map.get("ITEM_SITE"));
		param.setItemRoom((String) map.get("ITEM_ROOM"));
		param.setItemGetStartDate((String) map.get("ITEM_GET_START_DATE"));
		param.setItemGetEndDate((String) map.get("ITEM_GET_END_DATE"));
		param.setItemGetLowPrice((String) map.get("ITEM_GET_LOW_PRICE"));
		param.setItemGetHighPrice((String) map.get("ITEM_GET_HIGH_PRICE"));
		param.setItemNote((String) map.get("ITEM_NOTE"));

		if((List<String>) map.get("DEVICE_ID_ARR") == null) {
			return apiService.getListResult(null, null, 111);
		}else {
	    param.setDeviceIdArr((List<String>) map.get("DEVICE_ID_ARR"));
			
		List<CurrentCountSearchTagVO> dataList = currentCountService.getCurrentStockInfo(param);
		
			if (dataList.isEmpty()) {
				statusCode = 101;
			} else {
				statusCode = 200;
			}
		return apiService.getListResult("getCurrentStockInfo", dataList, statusCode);
		}
	}

	// 입출고 통합 History 조회
	@SuppressWarnings("unchecked")
	@PostMapping(value = "/getIOHistory", produces = "application/json")
	public @ResponseBody ListResult<IOHistotyVO> getIOHistory(@RequestBody HashMap<String, Object> map) {

		ApiItemTagInfoParam param = new ApiItemTagInfoParam();

		param.setTag((String) map.get("TAG"));
		param.setItemCode((String) map.get("ITEM_CODE"));
		param.setItemName((String) map.get("ITEM_NAME"));
		param.setItemGroup((String) map.get("ITEM_GROUP"));
		param.setItemStandard((String) map.get("ITEM_STANDARD"));
		param.setItemAdmin((String) map.get("ITEM_ADMIN"));
		param.setItemDepart((String) map.get("ITEM_DEPART"));
		param.setItemSite((String) map.get("ITEM_SITE"));
		param.setItemRoom((String) map.get("ITEM_ROOM"));
		param.setItemGetStartDate((String) map.get("ITEM_GET_START_DATE"));// 취득 일자
		param.setItemGetEndDate((String) map.get("ITEM_GET_END_DATE"));
		param.setItemGetLowPrice((String) map.get("ITEM_GET_LOW_PRICE"));// 취득 가격
		param.setItemGetHighPrice((String) map.get("ITEM_GET_HIGH_PRICE"));
		param.setItemNote((String) map.get("ITEM_NOTE"));
		param.setStartDateTime((String) map.get("START_DATE_TIME"));// 입출고 시간
		param.setEndDateTime((String) map.get("END_DATE_TIME"));
		param.setWorkerId((String) map.get("WORKER_ID"));
		param.setState((String) map.get("STATE"));
		
		if((List<String>) map.get("DEVICE_ID_ARR") == null) {
			return apiService.getListResult(null, null, 111);
		}else {

		param.setDeviceIdArr((List<String>) map.get("DEVICE_ID_ARR"));

		List<String> devIdArr = (List<String>) map.get("DEVICE_ID_ARR");

		List<IOHistotyVO> dataList;

		int statusCode;

		List<String> chkDevIdArr = iOHistoryService.chkDevIdArr(param);
		
		if (chkDevIdArr.containsAll(devIdArr) == false) {
			dataList = null;
			statusCode = 100;
		} else {

			dataList = iOHistoryService.getIOHistory(param);

			if (dataList.isEmpty()) {
				dataList = null;

				statusCode = 101;
			} else {
				statusCode = 200;
			}

		}
		return apiService.getListResult("getIOHistory", dataList, statusCode);
	}
}
}
