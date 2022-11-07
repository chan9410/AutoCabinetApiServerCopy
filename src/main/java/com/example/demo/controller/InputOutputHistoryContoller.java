package com.example.demo.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.ApiItemTagInfoParam;
import com.example.demo.dto.IOHistotyVO;
import com.example.demo.dto.ListResult;
import com.example.demo.service.ApiService;
import com.example.demo.service.IOHistoryService;

@CrossOrigin("*")
@Controller
@RequestMapping("/api/IOHis")

public class InputOutputHistoryContoller {

	private IOHistoryService iOHistoryService;

	private ApiService apiService;

	@Autowired
	public InputOutputHistoryContoller(IOHistoryService iOHistoryService, ApiService apiService) {
		this.iOHistoryService = iOHistoryService;
		this.apiService = apiService;
	}

	// 입고 History 조회
	@PostMapping(value = "/inputHistorySearch", produces = "application/json")
	public @ResponseBody ListResult<IOHistotyVO> inputHistorySearch(@RequestBody HashMap<String, Object> map) {

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

		return apiService.getListResult(iOHistoryService.inputHistorySearch(param));
	}

	// 출고 History 조회
	@PostMapping(value = "/outputHistorySearch", produces = "application/json")
	public @ResponseBody ListResult<IOHistotyVO> outputHistorySearch(@RequestBody HashMap<String, Object> map) {

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

		return apiService.getListResult(iOHistoryService.outputHistorySearch(param));
	}

}
