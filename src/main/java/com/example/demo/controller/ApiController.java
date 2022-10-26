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

import com.example.demo.dto.ApiColRowNumVO;
import com.example.demo.dto.ApiDeviceControllVO;
import com.example.demo.dto.ApiTagCountVO;
import com.example.demo.dto.ApiTagRegVO;
import com.example.demo.dto.ListResult;
import com.example.demo.service.ApiService;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin("*")
@Controller
@RequestMapping("/api")

public class ApiController {

	private ApiService apiService;

	@Autowired
	public ApiController(ApiService apiService) {
		this.apiService = apiService;
	}

	@Autowired
	private ObjectMapper mapper;

	// 장비 리스트 불러오기
	@GetMapping(value = "/getDeviceList", produces = "application/json")
	public @ResponseBody List<ApiDeviceControllVO> getDeviceList() {
		return apiService.getDeviceList();
	}

	// 장비 등록

	@PostMapping(value = "/saveDevice", produces = "application/json")
	public @ResponseBody Boolean saveDevice(@RequestBody HashMap<String, Object> map) {

		ApiDeviceControllVO param = new ApiDeviceControllVO();
		param.setDeviceId(map.get("DEVICEID").toString());
		param.setDeviceName(map.get("DEVICENAME").toString());

		Boolean result;

		result = apiService.saveDevice(param);

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
	public @ResponseBody ApiColRowNumVO getColRowNum(@RequestBody HashMap<String, Object> map) {

		ApiColRowNumVO param = new ApiColRowNumVO();

		param.setDeviceId(map.get("DEVICEID").toString());

		System.out.println(map.get("DEVICEID").toString());

		return apiService.getColRowNum(param);
	}

	// 실시간 카운트 수 불러오기
	@PostMapping(value = "/currentCount", produces = "application/json")
	public @ResponseBody ListResult<ApiTagCountVO> currentCount(@RequestBody HashMap<String, Object> map) {

		ApiTagCountVO param = new ApiTagCountVO();
		param.setDeviceId(map.get("DEVICEID").toString());

		System.out.println(map.get("DEVICEID").toString());

		// return apiService.currentCount(param);
		// return apiService.getSingleResult(apiService.currentCount(param));
		return apiService.getListResult(apiService.currentCount(param));
	}

	// 태그 등록
	@PostMapping(value = "/regTag", produces = "application/json")
	public @ResponseBody Boolean regTag(@RequestBody HashMap<String, Object> map) {

		ApiTagRegVO param = new ApiTagRegVO();
		param.setTag(map.get("TAG").toString());
		param.setItemCode(map.get("ITEMCODE").toString());
		param.setItemName(map.get("ITEMNAME").toString());
		param.setItemGroup(map.get("ITEMGROUP").toString());
		param.setItemStandard(map.get("ITEMSTANDARD").toString());
		param.setItemAdmin(map.get("ITEMADMIN").toString());
		param.setItemDepart(map.get("ITEMDEPART").toString());
		param.setItemSite(map.get("ITEMSITE").toString());
		param.setItemRoom(map.get("ITEMROOM").toString());
		param.setItemGetDate(map.get("ITEMGETDATE").toString());
		param.setItemGetPrice(map.get("ITEMGETPRICE").toString());
		param.setItemNote(map.get("ITEMNOTE").toString());

		System.out.println(map.get("TAG").toString());
		System.out.println(map.get("ITEMCODE").toString());
		System.out.println(map.get("ITEMNAME").toString());

		Boolean result;

		result = apiService.regTag(param);

		System.out.println(result);

		return result;
	}

	// 개별,그룹 검색 - 제품명 검색

	/*
	 * @PostMapping(value = "/searchCode", produces = "application/json")
	 * public @ResponseBody List<tagSearchVO> searchCode(@RequestBody
	 * HashMap<String, Object> map) {
	 * 
	 * tagSearchVO param = new tagSearchVO();
	 * param.setSearchCode(map.get("searchCode").toString());
	 * 
	 * return apiService.searchCode(param); }
	 */

	// 개별 검색 - SecondGrid에 체크 박스 선택한 Row 추가

	/*
	 * @PostMapping(value = "/addChkRow", produces = "application/json")
	 * public @ResponseBody List<tagSearchVO> addChkRow(@RequestBody HashMap<String,
	 * Object> map) {
	 * 
	 * tagSearchVO param = new tagSearchVO();
	 * //param.setChkRow(map.get("chkRow").toString());
	 * param.setChkRow(Arrays.toString(map.get("chkRowTagArr")));
	 * 
	 * System.out.println(Arrays.toString(map.get("chkRowTagArr")));
	 * 
	 * return apiService.addChkRow(param); }
	 */

	// 그룹 검색 - 제품코드로 데이터 검색

}
