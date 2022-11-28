package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.ApiDeviceControllVO;
import com.example.demo.dto.ApiTagInfoParam;
import com.example.demo.dto.GetTagVO;
import com.example.demo.dto.ListResult;
import com.example.demo.dto.SingleResult;
import com.example.demo.service.ApiService;
import com.example.demo.service.DevConService;
import com.example.demo.service.ItemTagService;

@CrossOrigin("*")
@Controller
@RequestMapping("/mwCon")

public class MiddleWareController {

	private DevConService devConService;

	private ItemTagService itemTagService;

	private ApiService apiService;

	@Autowired
	public MiddleWareController(DevConService devConService, ItemTagService itemTagService, ApiService apiService) {
		this.devConService = devConService;
		this.itemTagService = itemTagService;
		this.apiService = apiService;
	}

	// 장비 리스트 불러오기
	@GetMapping(value = "/getDeviceList", produces = "application/json")
	public @ResponseBody ListResult<ApiDeviceControllVO> getDeviceList() {

		List<ApiDeviceControllVO> dataList = devConService.getDeviceList();

		int statusCode;

		if (dataList.isEmpty()) {
			statusCode = 101;
		} else {
			statusCode = 200;
		}

		return apiService.getListResult(dataList, statusCode);
	}

	@PostMapping(value = "/updateColRowNum", produces = "application/json")
	public @ResponseBody SingleResult<Integer> updateColRowNum(@RequestBody HashMap<String, Object> map) {

		ApiTagInfoParam param = new ApiTagInfoParam();

		param.setColNum((int) map.get("COL_NUM"));

		param.setRowNum((int) map.get("ROW_NUM"));

		param.setDeviceId(map.get("DEVICE_ID").toString());

		return apiService.getSingleResult(devConService.updateColRowNum(param));
	}

	@GetMapping(value = "/getTag", produces = "application/json")
	public @ResponseBody ListResult<GetTagVO> getTag() {

		List<GetTagVO> data = itemTagService.getTag();

		System.out.println(data);

		int statusCode;

		if (data == null) {
			statusCode = 101;
		} else {
			statusCode = 200;
		}

		return apiService.getListResult(data, statusCode);
	}

}
