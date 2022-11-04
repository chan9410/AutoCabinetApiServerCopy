package com.example.demo.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.ApiDeviceControllVO;
import com.example.demo.dto.ApiTagInfoVO;
import com.example.demo.dto.ListResult;
import com.example.demo.dto.SingleResult;
import com.example.demo.service.ApiService;
import com.example.demo.service.exeption.paramNotFoundException;

@CrossOrigin("*")
@Controller
@RequestMapping("/api/DevCon")

public class DeviceController {

	// private DevConService devConService;

	private ApiService apiService;

	/*
	 * @Autowired public DeviceController(DevConService devConService) {
	 * this.devConService = devConService; }
	 */

	@Autowired
	public DeviceController(ApiService apiService) {
		this.apiService = apiService;
	}

	// 장비 리스트 불러오기
	@GetMapping(value = "/getDeviceList", produces = "application/json")
	public @ResponseBody ListResult<ApiDeviceControllVO> getDeviceList() {
		return apiService.getListResult(apiService.getDeviceList());
	}

	// 장비 등록

	@PostMapping(value = "/saveDevice", produces = "application/json")
	public @ResponseBody Boolean saveDevice(@RequestBody HashMap<String, Object> map) throws paramNotFoundException {

		ApiDeviceControllVO param = new ApiDeviceControllVO();
		param.setDeviceId(map.get("DEVICEID").toString());
		param.setDeviceName(map.get("DEVICENAME").toString());

		Boolean result;

		result = apiService.saveDevice(param);

		if (result == false) {
			throw new paramNotFoundException(String.format("DB에 param'%s' 존재", map.get("DEVICEID").toString()));
		}

		System.out.println(result);

		return result;
	}

	// 장비 데이터 수정

	@PostMapping(value = "/updateDevice", produces = "application/json")
	public @ResponseBody Boolean updateDevice(@RequestBody HashMap<String, Object> map) {

		ApiDeviceControllVO param = new ApiDeviceControllVO();
		param.setDeviceId(map.get("DEVICEID").toString());
		param.setDeviceName(map.get("DEVICENAME").toString());

		System.out.println(map.get("DEVICEID").toString());
		System.out.println(map.get("DEVICENAME").toString());

		int result;

		result = apiService.updateDevice(param);

		if (result == 1) {
			return true;
		}

		return false;
	}

	// 장비 제거

	@PostMapping(value = "/delDevice", produces = "application/json")
	public @ResponseBody Boolean delDevice(@RequestBody HashMap<String, Object> map) {

		ApiDeviceControllVO param = new ApiDeviceControllVO();
		param.setDeviceId(map.get("DEVICEID").toString());

		System.out.println(map.get("DEVICEID").toString());

		Boolean result;

		result = apiService.delDevice(param);

		System.out.println(result);

		return result;
	}

	// COL,ROW 개수 불러오기
	@PostMapping(value = "/getColRowNum", produces = "application/json")
	public @ResponseBody SingleResult<ApiTagInfoVO> getColRowNum(@RequestBody HashMap<String, Object> map)
			throws paramNotFoundException {

		ApiTagInfoVO param = new ApiTagInfoVO();

		param.setDeviceId(map.get("DEVICEID").toString());

		/*
		 * if (map.get("DEVICEID").toString() == "") { throw new
		 * paramNotFoundException(String.valueOf("DEVICE ID 빈값")); } else if
		 * (apiService.getColRowNum(param) == null) { throw new
		 * paramNotFoundException(String.format("DB에 파라미터'%s' 없음",
		 * map.get("DEVICEID").toString())); }
		 */
		System.out.println(map.get("DEVICEID").toString());

		return apiService.getSingleResult(apiService.getColRowNum(param));
	}

}
