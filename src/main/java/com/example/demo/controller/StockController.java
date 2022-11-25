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

	// private ReportStatisticsService reportStatisticsService;

	private ApiService apiService;

	@Autowired
	public StockController(CurrentCountService currentCountService, IOHistoryService iOHistoryService,
			ApiService apiService) {
		/*
		 * @Autowired public StockController(CurrentCountService currentCountService,
		 * IOHistoryService iOHistoryService, ReportStatisticsService
		 * reportStatisticsService, ApiService apiService) {
		 */

		this.currentCountService = currentCountService;
		this.iOHistoryService = iOHistoryService;
		// this.reportStatisticsService = reportStatisticsService;
		this.apiService = apiService;
	}

	// 실시간 카운트 수 불러오기
	@PostMapping(value = "/currentCount", produces = "application/json")
	public @ResponseBody ListResult<ApiTagCountVO> currentCount(@RequestBody HashMap<String, Object> map) {

		ApiTagInfoParam param = new ApiTagInfoParam();
		param.setDeviceId(map.get("DEVICEID").toString());

		List<ApiTagCountVO> dataList = currentCountService.currentCount(param);

		String chkDev = currentCountService.chkDeviceId(param);

		int statusCode;

		if (chkDev == null) {
			statusCode = 100;
		} else if (dataList.isEmpty()) {
			statusCode = 101;
		} else {
			statusCode = 200;
		}

		return apiService.getListResult(dataList, statusCode);
	}

	// 클릭한 구분영역의 정보 불러오기
	@PostMapping(value = "/chkLocationInfo", produces = "application/json")
	public @ResponseBody ListResult<ApiSearchTagInfoVO> chkLocationInfo(@RequestBody HashMap<String, Object> map) {

		ApiTagInfoParam param = new ApiTagInfoParam();
		param.setLocation((int) map.get("LOCATION"));
		param.setDeviceId(map.get("DEVICEID").toString());

		List<ApiSearchTagInfoVO> dataList = currentCountService.chkLocationInfo(param);

		String chkDev = currentCountService.chkDeviceId(param);

		int statusCode;

		if (chkDev == null) {
			statusCode = 100;
		} else if (dataList.isEmpty()) {
			statusCode = 101;
		} else {
			statusCode = 200;
		}

		return apiService.getListResult(dataList, statusCode);
	}

	// 리스트 형식의 실시간 재고 페이지에서 특정 조건으로 검색.
	@SuppressWarnings("unchecked")
	@PostMapping(value = "/getCurrentCountSearch", produces = "application/json")
	public @ResponseBody ListResult<CurrentCountSearchTagVO> getCurrentCountSearch(
			@RequestBody HashMap<String, Object> map) {

		ApiItemTagInfoParam param = new ApiItemTagInfoParam();

		param.setItemCode((String) map.get("ITEMCODE"));
		param.setItemName((String) map.get("ITEMNAME"));
		param.setItemGroup((String) map.get("ITEMGROUP"));
		param.setItemStandard((String) map.get("ITEMSTANDARD"));
		param.setItemAdmin((String) map.get("ITEMADMIN"));
		param.setItemDepart((String) map.get("ITEMDEPART"));
		param.setItemSite((String) map.get("ITEMSITE"));
		param.setItemRoom((String) map.get("ITEMROOM"));
		param.setItemGetStartDate((String) map.get("ITEMGETSTARTDATE"));
		param.setItemGetEndDate((String) map.get("ITEMGETENDDATE"));
		param.setItemGetLowPrice((String) map.get("ITEMGETLOWPRICE"));
		param.setItemGetHighPrice((String) map.get("ITEMGETHIGHPRICE"));
		param.setItemNote((String) map.get("ITEMNOTE"));

		param.setDeviceIdArr((List<String>) map.get("DEVICEIDARR"));

		int statusCode;

		List<CurrentCountSearchTagVO> dataList;

		if ((List<String>) map.get("DEVICEIDARR") == null) {

			statusCode = 100;
			dataList = null;

		} else {

			dataList = currentCountService.getCurrentCountSearch(param);

			if (dataList.isEmpty()) {
				statusCode = 101;
			} else {
				statusCode = 200;
			}
		}
		return apiService.getListResult(dataList, statusCode);
	}

	// 입고 History 조회
	@SuppressWarnings("unchecked")
	@PostMapping(value = "/inputHistorySearch", produces = "application/json")
	public @ResponseBody ListResult<IOHistotyVO> inputHistorySearch(@RequestBody HashMap<String, Object> map) {

		ApiItemTagInfoParam param = new ApiItemTagInfoParam();

		param.setItemCode((String) map.get("ITEMCODE"));
		param.setItemName((String) map.get("ITEMNAME"));
		param.setItemGroup((String) map.get("ITEMGROUP"));
		param.setItemStandard((String) map.get("ITEMSTANDARD"));
		param.setItemAdmin((String) map.get("ITEMADMIN"));
		param.setItemDepart((String) map.get("ITEMDEPART"));
		param.setItemSite((String) map.get("ITEMSITE"));
		param.setItemRoom((String) map.get("ITEMROOM"));
		param.setItemGetStartDate((String) map.get("ITEMGETSTARTDATE"));
		param.setItemGetEndDate((String) map.get("ITEMGETENDDATE"));
		param.setItemGetLowPrice((String) map.get("ITEMGETLOWPRICE"));
		param.setItemGetHighPrice((String) map.get("ITEMGETHIGHPRICE"));
		param.setItemNote((String) map.get("ITEMNOTE"));

		param.setDeviceIdArr((List<String>) map.get("DEVICEIDARR"));

		System.out.println((List<String>) map.get("DEVICEIDARR"));

		List<IOHistotyVO> dataList;

		int statusCode;

		if ((List<String>) map.get("DEVICEIDARR") == null) {

			dataList = null;
			statusCode = 100;

		} else {

			dataList = iOHistoryService.inputHistorySearch(param);

			if (dataList.isEmpty()) {
				statusCode = 101;
			} else {
				statusCode = 200;
			}
		}

		return apiService.getListResult(dataList, statusCode);
	}

	// 출고 History 조회
	@SuppressWarnings("unchecked")
	@PostMapping(value = "/outputHistorySearch", produces = "application/json")
	public @ResponseBody ListResult<IOHistotyVO> outputHistorySearch(@RequestBody HashMap<String, Object> map) {

		ApiItemTagInfoParam param = new ApiItemTagInfoParam();

		param.setItemCode((String) map.get("ITEMCODE"));
		param.setItemName((String) map.get("ITEMNAME"));
		param.setItemGroup((String) map.get("ITEMGROUP"));
		param.setItemStandard((String) map.get("ITEMSTANDARD"));
		param.setItemAdmin((String) map.get("ITEMADMIN"));
		param.setItemDepart((String) map.get("ITEMDEPART"));
		param.setItemSite((String) map.get("ITEMSITE"));
		param.setItemRoom((String) map.get("ITEMROOM"));
		param.setItemGetStartDate((String) map.get("ITEMGETSTARTDATE"));
		param.setItemGetEndDate((String) map.get("ITEMGETENDDATE"));
		param.setItemGetLowPrice((String) map.get("ITEMGETLOWPRICE"));
		param.setItemGetHighPrice((String) map.get("ITEMGETHIGHPRICE"));
		param.setItemNote((String) map.get("ITEMNOTE"));

		param.setDeviceIdArr((List<String>) map.get("DEVICEIDARR"));

		System.out.println((List<String>) map.get("DEVICEIDARR"));

		List<IOHistotyVO> dataList;

		int statusCode;

		if ((List<String>) map.get("DEVICEIDARR") == null) {

			dataList = null;
			statusCode = 100;

		} else {

			dataList = iOHistoryService.outputHistorySearch(param);

			if (dataList.isEmpty()) {
				statusCode = 101;
			} else {
				statusCode = 200;
			}
		}

		return apiService.getListResult(dataList, statusCode);
	}

	// 입출고 통합 History 조회
	@SuppressWarnings("unchecked")
	@PostMapping(value = "/IOHistorySearch", produces = "application/json")
	public @ResponseBody ListResult<IOHistotyVO> IOHistorySearch(@RequestBody HashMap<String, Object> map) {

		ApiItemTagInfoParam param = new ApiItemTagInfoParam();

		param.setItemCode((String) map.get("ITEMCODE"));
		param.setItemName((String) map.get("ITEMNAME"));
		param.setItemGroup((String) map.get("ITEMGROUP"));
		param.setItemStandard((String) map.get("ITEMSTANDARD"));
		param.setItemAdmin((String) map.get("ITEMADMIN"));
		param.setItemDepart((String) map.get("ITEMDEPART"));
		param.setItemSite((String) map.get("ITEMSITE"));
		param.setItemRoom((String) map.get("ITEMROOM"));
		param.setItemGetStartDate((String) map.get("ITEMGETSTARTDATE"));// 취득 일자
		param.setItemGetEndDate((String) map.get("ITEMGETENDDATE"));
		param.setItemGetLowPrice((String) map.get("ITEMGETLOWPRICE"));// 취득 가격
		param.setItemGetHighPrice((String) map.get("ITEMGETHIGHPRICE"));
		param.setItemNote((String) map.get("ITEMNOTE"));
		param.setStartDateTime((String) map.get("STARTDATETIME"));// 입출고 시간
		param.setEndDateTime((String) map.get("ENDDATETIME"));
		param.setWorkerId((String) map.get("WORKERID"));
		param.setState((String) map.get("STATE"));

		param.setDeviceIdArr((List<String>) map.get("DEVICEIDARR"));

		System.out.println((List<String>) map.get("DEVICEIDARR"));

		List<IOHistotyVO> dataList;

		int statusCode;

		if ((List<String>) map.get("DEVICEIDARR") == null) {

			dataList = null;
			statusCode = 100;

		} else {

			dataList = iOHistoryService.IOHistorySearch(param);

			if (dataList.isEmpty()) {
				statusCode = 101;
			} else {
				statusCode = 200;
			}
		}

		return apiService.getListResult(dataList, statusCode);
	}
}
