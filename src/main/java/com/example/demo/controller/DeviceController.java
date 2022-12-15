package com.example.demo.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

import com.example.demo.dto.ApiChkDevVO;
import com.example.demo.dto.ApiColRowNumVO;
import com.example.demo.dto.ApiDevTotalValueVO;
import com.example.demo.dto.ApiDeviceControllVO;
import com.example.demo.dto.ApiTagInfoParam;
import com.example.demo.dto.ListResult;
import com.example.demo.dto.ReSingleResult;
import com.example.demo.dto.SingleResult;
import com.example.demo.dto.SysCodeParam;
import com.example.demo.service.ApiService;
import com.example.demo.service.DevConService;

@CrossOrigin("*")
@Controller
@RequestMapping("/devCon")

public class DeviceController {

	private DevConService devConService;

	private ApiService apiService;

	@Autowired
	public DeviceController(DevConService devConService, ApiService apiService) {
		this.devConService = devConService;
		this.apiService = apiService;
	}

	// 장비 등록
	@PostMapping(value = "/saveDevice", produces = "application/json")
	public @ResponseBody SingleResult<Integer> saveDevice(@RequestBody HashMap<String, Object> map) {

		String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

		ApiTagInfoParam param = new ApiTagInfoParam();
		
		param.setRecentTime(now);

		try {
			param.setDeviceId(map.get("DEVICE_ID").toString());
			param.setDeviceName(map.get("DEVICE_NAME").toString());

		}catch(NullPointerException e) {
			return apiService.getSingleResult(null, 111);
		}
		
		return apiService.getSingleResult("saveDevice", devConService.saveDevice(param));

	}

	// 장비 데이터 수정

	@PostMapping(value = "/updateDevice", produces = "application/json")
	public @ResponseBody SingleResult<Integer> updateDevice(@RequestBody HashMap<String, Object> map) {

		ApiDeviceControllVO param = new ApiDeviceControllVO();
		
		try {
			param.setDeviceId(map.get("DEVICE_ID").toString());
			param.setDeviceName(map.get("DEVICE_NAME").toString());
		} catch(NullPointerException e) {
			return apiService.getSingleResult(null, 111);
		}
		
		return apiService.getSingleResult("updateDevice", devConService.updateDevice(param));
	}

	// 장비 제거

	@PostMapping(value = "/deleteDevice", produces = "application/json")
	public @ResponseBody SingleResult<Integer> deleteDevice(@RequestBody HashMap<String, Object> map) {

		ApiDeviceControllVO param = new ApiDeviceControllVO();
		
		try {
			param.setDeviceId(map.get("DEVICE_ID").toString());
		}catch(NullPointerException e) {
			return apiService.getSingleResult(null, 111);
		}

		return apiService.getSingleResult("deleteDevice", devConService.deleteDevice(param));
	}

	// COL,ROW 개수 불러오기
	@PostMapping(value = "/getColRowNum", produces = "application/json")
	public @ResponseBody ReSingleResult<ApiColRowNumVO> getColRowNum(@RequestBody HashMap<String, Object> map) {

		ApiTagInfoParam param = new ApiTagInfoParam();
		
		ApiColRowNumVO data;

		try {
			param.setDeviceId(map.get("DEVICE_ID").toString());
			data = devConService.getColRowNum(param);
		}catch(NullPointerException e) {
			data = null;
			return apiService.getSingleResult(null, null, 111);
		}

		String chkDev = devConService.chkDeviceId(param);

		int statusCode;

		if (chkDev == null) {
			statusCode = 100;
		} else if (data == null) {
			statusCode = 101;
		} else {
			statusCode = 200;
		}
		return apiService.getSingleResult("getColRowNum", data, statusCode);
	}

	// 선택한 장비의 정보 불러오기
	@PostMapping(value = "/getDeviceInfo", produces = "application/json")
	public @ResponseBody ReSingleResult<ApiChkDevVO> getDeviceInfo(@RequestBody HashMap<String, Object> map) {

		ApiTagInfoParam param = new ApiTagInfoParam();
		
		ApiChkDevVO data;
		
		try {
			param.setDeviceId(map.get("DEVICE_ID").toString());
			data = devConService.getDeviceInfo(param);
		}catch(NullPointerException e) {
			data = null;
			return apiService.getSingleResult(null, null, 111);
		}

		String chkDev = devConService.chkDeviceId(param);

		int statusCode;

		if (chkDev == null) {
			statusCode = 100;
		} else if (data == null) {
			statusCode = 101;
		} else {
			statusCode = 200;
		}

		return apiService.getSingleResult("getDeviceInfo", data, statusCode);

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

		return apiService.getListResult("getDeviceList", dataList, statusCode);
	}

	// SysCode Value 값 수정
	@PostMapping(value = "updateSysCodeValue", produces = "application/json")
	public @ResponseBody SingleResult<Integer> updateSysCodeValue(@RequestBody HashMap<String, Object> map) {

		SysCodeParam param = new SysCodeParam();
		
		try {
			param.setCodeValue((int) map.get("CODE_VALUE"));
			param.setCodeName(map.get("CODE_NAME").toString());
			// param.setUseYn((String) map.get("USE_YN"));
		}catch(NullPointerException e) {
			return apiService.getSingleResult(null, 111);
		}

		return apiService.getSingleResult("updateSysCodeValue", devConService.updateSysCodeValue(param));
	}

	// 디바이스 값과 상태값을 동시 출력
	@GetMapping(value = "/getDeviceStateList", produces = "application/json")
	public @ResponseBody ListResult<ApiDevTotalValueVO> getDeviceStateList() {

		List<ApiDevTotalValueVO> dataList = devConService.getDeviceStateList();

		int statusCode;

		if (dataList.isEmpty()) {
			statusCode = 101;
		} else {
			statusCode = 200;
		}

		return apiService.getListResult("getDeviceStateList", dataList, statusCode);

	}
}
