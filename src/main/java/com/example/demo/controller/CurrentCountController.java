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
import com.example.demo.dto.ListResult;
import com.example.demo.dto.ReSingleResult;
import com.example.demo.service.ApiService;
import com.example.demo.service.CurrentCountService;

@CrossOrigin("*")
@Controller
@RequestMapping("/api/currentCnt")

public class CurrentCountController {

	private CurrentCountService currentCountService;

	private ApiService apiService;

	@Autowired
	public CurrentCountController(CurrentCountService currentCountService, ApiService apiService) {
		this.currentCountService = currentCountService;
		this.apiService = apiService;
	}

	// 실시간 카운트 수 불러오기
	@PostMapping(value = "/currentCount", produces = "application/json")
	public @ResponseBody ListResult<ApiTagCountVO> currentCount(@RequestBody HashMap<String, Object> map) {

		ApiTagInfoParam param = new ApiTagInfoParam();
		param.setDeviceId(map.get("DEVICEID").toString());

		System.out.println(map.get("DEVICEID").toString());

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
	public @ResponseBody ReSingleResult<ApiSearchTagInfoVO> chkLocationInfo(@RequestBody HashMap<String, Object> map) {

		ApiTagInfoParam param = new ApiTagInfoParam();
		param.setLocation((int) map.get("LOCATION"));
		param.setDeviceId(map.get("DEVICEID").toString());

		System.out.println(map.get("DEVICEID").toString());
		System.out.println((int) map.get("LOCATION"));

		ApiSearchTagInfoVO data = currentCountService.chkLocationInfo(param);

		String chkDev = currentCountService.chkDeviceId(param);

		int statusCode;

		if (chkDev == null) {
			statusCode = 100;
		} else if (data == null) {
			statusCode = 101;
		} else {
			statusCode = 200;
		}

		return apiService.getSingleResult(data, statusCode);
	}

	// 리스트 형식의 실시간 재고 페이지에서 특정 조건으로 검색.
	@PostMapping(value = "/getCurrentCountSearch", produces = "application/json")
	public @ResponseBody ListResult<CurrentCountSearchTagVO> getCurrentCountSearch(
			@RequestBody HashMap<String, Object> map) {

		ApiItemTagInfoParam param = new ApiItemTagInfoParam();
		param.setTag((String) map.get("TAG"));
		param.setItemCode((String) map.get("ITEMCODE"));
		param.setItemName((String) map.get("ITEMNAME"));
		param.setItemGroup((String) map.get("ITEMGROUP"));
		param.setItemStandard((String) map.get("ITEMSTANDARD"));
		param.setItemAdmin((String) map.get("ITEMADMIN"));
		param.setItemDepart((String) map.get("ITEMDEPART"));
		param.setItemSite((String) map.get("ITEMSITE"));
		param.setItemRoom((String) map.get("ITEMROOM"));
		param.setItemGetDate((String) map.get("ITEMGETDATE"));
		param.setItemGetPrice((String) map.get("ITEMGETPRICE"));
		param.setItemNote((String) map.get("ITEMNOTE"));

		param.setDeviceId((String) map.get("DEVICEID"));

		List<CurrentCountSearchTagVO> dataList = currentCountService.getCurrentCountSearch(param);

		int statusCode;

		if (dataList.isEmpty()) {
			statusCode = 101;
		} else {
			statusCode = 200;
		}

		return apiService.getListResult(dataList, statusCode);
	}

}
