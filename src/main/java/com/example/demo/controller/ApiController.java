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
import com.example.demo.dto.ApiItemTagInfoVO;
import com.example.demo.dto.ApiTagInfoVO;
import com.example.demo.dto.ListResult;
import com.example.demo.dto.SingleResult;
import com.example.demo.service.ApiService;
import com.example.demo.service.exeption.paramNotFoundException;

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

	// 실시간 카운트 수 불러오기
	@PostMapping(value = "/currentCount", produces = "application/json")
	public @ResponseBody ListResult<ApiTagInfoVO> currentCount(@RequestBody HashMap<String, Object> map) {

		ApiTagInfoVO param = new ApiTagInfoVO();
		param.setDeviceId(map.get("DEVICEID").toString());

		System.out.println(map.get("DEVICEID").toString());

		return apiService.getListResult(apiService.currentCount(param));
	}

	// 클릭한 구분영역의 정보 불러오기
	@PostMapping(value = "/chkLocationInfo", produces = "application/json")
	public @ResponseBody ListResult<ApiTagInfoVO> chkLocationInfo(@RequestBody HashMap<String, Object> map) {

		ApiTagInfoVO param = new ApiTagInfoVO();
		param.setLocation((int) map.get("LOCATION"));
		param.setDeviceId(map.get("DEVICEID").toString());

		System.out.println(map.get("DEVICEID").toString());
		System.out.println((int) map.get("LOCATION"));

		return apiService.getListResult(apiService.chkLocationInfo(param));
	}

	// 등록 현황 품목 조회
	@PostMapping(value = "/getSearchTag", produces = "application/json")
	public @ResponseBody ListResult<ApiItemTagInfoVO> getSearchTag(@RequestBody HashMap<String, Object> map) {

		ApiItemTagInfoVO param = new ApiItemTagInfoVO();
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

		System.out.println((String) map.get("TAG"));
		System.out.println((String) map.get("ITEMCODE"));
		System.out.println((String) map.get("ITEMNAME"));
		System.out.println((String) map.get("ITEMNOTE"));

		return apiService.getListResult(apiService.getSearchTag(param));
	}

	// 등록 현황 단일 품목 등록

	@PostMapping(value = "/regTag", produces = "application/json")
	public @ResponseBody Boolean regTag(@RequestBody HashMap<String, Object> map) {
		Boolean result;

		ApiItemTagInfoVO param = new ApiItemTagInfoVO();

		param.setTag(map.get("TAG").toString());
		param.setItemCode(map.get("ITEMCODE").toString());
		param.setItemName(map.get("ITEMNAME").toString());
		param.setItemGroup((String) map.get("ITEMGROUP"));
		param.setItemStandard((String) map.get("ITEMSTANDARD"));
		param.setItemAdmin((String) map.get("ITEMADMIN"));
		param.setItemDepart((String) map.get("ITEMDEPART"));
		param.setItemSite((String) map.get("ITEMSITE"));
		param.setItemRoom((String) map.get("ITEMROOM"));
		param.setItemGetDate((String) map.get("ITEMGETDATE"));
		param.setItemGetPrice((String) map.get("ITEMGETPRICE"));
		param.setItemNote((String) map.get("ITEMNOTE"));

		// TAG, ITEMCODE, ITEMNAME 필수로 필요
		System.out.println(map.get("TAG").toString());
		System.out.println(map.get("ITEMCODE").toString());
		System.out.println(map.get("ITEMNAME").toString());

		result = apiService.regTag(param);

		System.out.println(result);

		return result;
	}

	// 등록 현황 품목 수정
	@PostMapping(value = "/updateTag", produces = "application/json")
	public @ResponseBody Boolean updateTag(@RequestBody HashMap<String, Object> map) {
		Boolean result;

		ApiItemTagInfoVO param = new ApiItemTagInfoVO();
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

		param.setTag(map.get("TAG").toString());

		result = apiService.updateTag(param);

		System.out.println(result);

		return result;
	}

	// 등록 현황 품목 삭제
	@PostMapping(value = "/deleteTag", produces = "application/json")
	public @ResponseBody Boolean deleteTag(@RequestBody HashMap<String, Object> map) {
		Boolean result;

		ApiItemTagInfoVO param = new ApiItemTagInfoVO();

		param.setTag(map.get("TAG").toString());

		result = apiService.deleteTag(param);

		System.out.println(result);

		return result;
	}

	// 입고 History 조회
	@PostMapping(value = "/inputHistorySearch", produces = "application/json")
	public @ResponseBody ListResult<ApiItemTagInfoVO> inputHistorySearch(@RequestBody HashMap<String, Object> map) {

		ApiItemTagInfoVO param = new ApiItemTagInfoVO();
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

		param.setDeviceId(map.get("DEVICEID").toString());

		return apiService.getListResult(apiService.inputHistorySearch(param));
	}

	// 출고 History 조회
	@PostMapping(value = "/outputHistorySearch", produces = "application/json")
	public @ResponseBody ListResult<ApiItemTagInfoVO> outputHistorySearch(@RequestBody HashMap<String, Object> map) {

		ApiItemTagInfoVO param = new ApiItemTagInfoVO();
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

		param.setDeviceId(map.get("DEVICEID").toString());

		return apiService.getListResult(apiService.outputHistorySearch(param));
	}

}
