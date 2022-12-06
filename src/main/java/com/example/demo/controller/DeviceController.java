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
		param.setDeviceId(map.get("DEVICE_ID").toString());
		param.setDeviceName(map.get("DEVICE_NAME").toString());
		param.setRecentTime(now);

		return apiService.getSingleResult(devConService.saveDevice(param));

	}

	// 장비 데이터 수정

	@PostMapping(value = "/updateDevice", produces = "application/json")
	public @ResponseBody SingleResult<Integer> updateDevice(@RequestBody HashMap<String, Object> map) {

		ApiDeviceControllVO param = new ApiDeviceControllVO();
		param.setDeviceId(map.get("DEVICE_ID").toString());
		param.setDeviceName(map.get("DEVICE_NAME").toString());

		return apiService.getSingleResult(devConService.updateDevice(param));
	}

	// 장비 제거

	@PostMapping(value = "/delDevice", produces = "application/json")
	public @ResponseBody SingleResult<Integer> delDevice(@RequestBody HashMap<String, Object> map) {

		ApiDeviceControllVO param = new ApiDeviceControllVO();
		param.setDeviceId(map.get("DEVICE_ID").toString());

		return apiService.getSingleResult(devConService.delDevice(param));
	}

	// COL,ROW 개수 불러오기
	@PostMapping(value = "/getColRowNum", produces = "application/json")
	public @ResponseBody ReSingleResult<ApiColRowNumVO> getColRowNum(@RequestBody HashMap<String, Object> map) {

		ApiTagInfoParam param = new ApiTagInfoParam();

		param.setDeviceId(map.get("DEVICE_ID").toString());

		ApiColRowNumVO data = devConService.getColRowNum(param);

		String chkDev = devConService.chkDeviceId(param);

		int statusCode;

		if (chkDev == null) {
			statusCode = 100;
		} else if (data == null) {
			statusCode = 101;
		} else {
			statusCode = 200;
		}

		System.out.println(statusCode);

		return apiService.getSingleResult(data, statusCode);
	}

	// 선택한 장비의 정보 불러오기
	@PostMapping(value = "/chkDevInfo", produces = "application/json")
	public @ResponseBody ReSingleResult<ApiChkDevVO> chkDevInfo(@RequestBody HashMap<String, Object> map) {

		ApiTagInfoParam param = new ApiTagInfoParam();

		param.setDeviceId(map.get("DEVICE_ID").toString());

		ApiChkDevVO data = devConService.chkDevInfo(param);

		String chkDev = devConService.chkDeviceId(param);

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

	@PostMapping(value = "updateSysCode", produces = "application/json")
	public @ResponseBody SingleResult<Integer> updateSysCode(@RequestBody HashMap<String, Object> map) {

		SysCodeParam param = new SysCodeParam();

		param.setCodeValue((int) map.get("CODE_VALUE"));
		param.setCodeName(map.get("CODE_NAME").toString());
		// param.setUseYn((String) map.get("USE_YN"));

		int result = devConService.updateSysCode(param);

		return apiService.getSingleResult(result);
	}

}
