package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.ApiDeviceControllVO;
import com.example.demo.dto.ListResult;
import com.example.demo.service.ApiService;

@CrossOrigin("*")
@Controller
@RequestMapping("/api")

public class ApiController {

	private ApiService apiService;

	@Autowired
	public ApiController(ApiService apiService) {
		this.apiService = apiService;
	}

	// 장비 리스트 불러오기
	@GetMapping(value = "/getDeviceList", produces = "application/json")
	public @ResponseBody ListResult<ApiDeviceControllVO> getDeviceList() {

		List<ApiDeviceControllVO> dataList = apiService.getDeviceList();

		int statusCode;

		if (dataList.isEmpty()) {
			statusCode = 101;
		} else {
			statusCode = 200;
		}

		return apiService.getListResult(dataList, statusCode);
	}

}
