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

import com.example.demo.dto.ApiVO;
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
	public @ResponseBody List<ApiVO> getDeviceList() {
		return apiService.getDeviceList();
	}

	/*
	 * //장비 등록
	 * 
	 * @PostMapping(value = "/saveDevice" , produces = "application/json")
	 * public @ResponseBody List<tagCountVO> saveDevice(@RequestBody HashMap<String,
	 * Object> map) {
	 * 
	 * tagCountVO param = new tagCountVO();
	 * param.setDeviceId(map.get("DEVICEID").toString());
	 * 
	 * return apiService.saveDevice(param); }
	 * 
	 * //장비 데이터 수정
	 * 
	 * @PostMapping(value = "/updateDevice" , produces = "application/json")
	 * public @ResponseBody List<tagCountVO> updateDevice(@RequestBody
	 * HashMap<String, Object> map) {
	 * 
	 * tagCountVO param = new tagCountVO();
	 * param.setDeviceId(map.get("DEVICEID").toString());
	 * 
	 * return apiService.updateDevice(param); }
	 * 
	 * //장비 제거
	 * 
	 * @PostMapping(value = "/delDevice" , produces = "application/json")
	 * public @ResponseBody List<tagCountVO> delDevice(@RequestBody HashMap<String,
	 * Object> map) {
	 * 
	 * tagCountVO param = new tagCountVO();
	 * param.setDeviceId(map.get("DEVICEID").toString());
	 * 
	 * return apiService.delDevice(param); }
	 */
	// 실시간 카운트 수 불러오기
	@PostMapping(value = "/currentCount", produces = "application/json")
	public @ResponseBody List<ApiVO> currentCount(@RequestBody HashMap<String, Object> map) {

		ApiVO param = new ApiVO();
		param.setDeviceId(map.get("DEVICEID").toString());

		System.out.println(map.get("DEVICEID").toString());

		return apiService.currentCount(param);
	}

	/*
	 * // 개별,그룹 검색 - 제품명 검색
	 * 
	 * @PostMapping(value = "/searchCode", produces = "application/json")
	 * public @ResponseBody List<tagSearchVO> searchCode(@RequestBody
	 * HashMap<String, Object> map) {
	 * 
	 * tagSearchVO param = new tagSearchVO();
	 * param.setSearchCode(map.get("searchCode").toString());
	 * 
	 * return apiService.searchCode(param); }
	 * 
	 * // 개별 검색 - SecondGrid에 체크 박스 선택한 Row 추가
	 * 
	 * @PostMapping(value = "/addChkRow", produces = "application/json")
	 * public @ResponseBody List<tagSearchVO> addChkRow(@RequestBody HashMap<String,
	 * Object> map) {
	 * 
	 * tagSearchVO param = new tagSearchVO();
	 * param.setChkRow(map.get("chkRow").toString());
	 * 
	 * return apiService.addChkRow(param); }
	 * 
	 * // 그룹 검색 - 제품코드로 데이터 검색
	 * 
	 * @PostMapping(value = "/searchGroupItem", produces = "application/json")
	 * public @ResponseBody List<tagSearchVO> searchGroupItem(@RequestBody
	 * HashMap<String, Object> map) {
	 * 
	 * tagSearchVO param = new tagSearchVO();
	 * param.setChkRow(map.get("searchCodeArr[]").toString());
	 * 
	 * return apiService.searchGroupItem(param); }
	 */

}
