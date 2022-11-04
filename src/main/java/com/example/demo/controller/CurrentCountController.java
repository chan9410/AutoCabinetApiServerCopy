package com.example.demo.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.ApiTagInfoVO;
import com.example.demo.dto.ListResult;
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
	public @ResponseBody ListResult<ApiTagInfoVO> currentCount(@RequestBody HashMap<String, Object> map) {

		ApiTagInfoVO param = new ApiTagInfoVO();
		param.setDeviceId(map.get("DEVICEID").toString());

		System.out.println(map.get("DEVICEID").toString());

		return apiService.getListResult(currentCountService.currentCount(param));
	}

	// 클릭한 구분영역의 정보 불러오기
	@PostMapping(value = "/chkLocationInfo", produces = "application/json")
	public @ResponseBody ListResult<ApiTagInfoVO> chkLocationInfo(@RequestBody HashMap<String, Object> map) {

		ApiTagInfoVO param = new ApiTagInfoVO();
		param.setLocation((int) map.get("LOCATION"));
		param.setDeviceId(map.get("DEVICEID").toString());

		System.out.println(map.get("DEVICEID").toString());
		System.out.println((int) map.get("LOCATION"));

		return apiService.getListResult(currentCountService.chkLocationInfo(param));
	}

}
