package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.ApiItemTagInfoParam;
import com.example.demo.dto.GetSearchTagVO;
import com.example.demo.dto.ListResult;
import com.example.demo.dto.SingleResult;
import com.example.demo.service.ApiService;
import com.example.demo.service.ItemTagService;

@CrossOrigin("*")
@Controller
@RequestMapping("/itemCon")

public class RegistrationItemController {

	private ItemTagService itemTagService;

	private ApiService apiService;

	@Autowired
	public RegistrationItemController(ItemTagService itemTagService, ApiService apiService) {
		this.itemTagService = itemTagService;
		this.apiService = apiService;
	}

	// 등록 현황 품목 조회
	@PostMapping(value = "/getSearchTag", produces = "application/json")
	public @ResponseBody ListResult<GetSearchTagVO> getSearchTag(@RequestBody HashMap<String, Object> map) {

		ApiItemTagInfoParam param = new ApiItemTagInfoParam();

		param.setItemCode((String) map.get("ITEM_CODE"));
		param.setItemName((String) map.get("ITEM_NAME"));
		param.setItemGroup((String) map.get("ITEM_GROUP"));
		param.setItemStandard((String) map.get("ITEM_STANDARD"));
		param.setItemAdmin((String) map.get("ITEM_ADMIN"));
		param.setItemDepart((String) map.get("ITEM_DEPART"));
		param.setItemSite((String) map.get("ITEM_SITE"));
		param.setItemRoom((String) map.get("ITEM_ROOM"));
		param.setItemGetStartDate((String) map.get("ITEM_GET_START_DATE"));
		param.setItemGetEndDate((String) map.get("ITEM_GET_END_DATE"));
		param.setItemGetLowPrice((String) map.get("ITEM_GET_LOW_PRICE"));
		param.setItemGetHighPrice((String) map.get("ITEM_GET_HIGH_PRICE"));
		param.setItemNote((String) map.get("ITEM_NOTE"));

		List<GetSearchTagVO> dataList = itemTagService.getSearchTag(param);

		int statusCode;

		if (dataList.isEmpty()) {
			statusCode = 101;
		} else {
			statusCode = 200;
		}

		return apiService.getListResult(dataList, statusCode);
	}

	// 등록 현황 단일 품목 등록

	@PostMapping(value = "/saveTag", produces = "application/json")
	public @ResponseBody SingleResult<Integer> saveTag(@RequestBody HashMap<String, Object> map) {

		ApiItemTagInfoParam param = new ApiItemTagInfoParam();

		param.setTag(map.get("TAG").toString());
		param.setItemCode(map.get("ITEM_CODE").toString());
		param.setItemName(map.get("ITEM_NAME").toString());
		param.setItemGroup((String) map.get("ITEM_GROUP"));
		param.setItemStandard((String) map.get("ITEM_STANDARD"));
		param.setItemAdmin((String) map.get("ITEM_ADMIN"));
		param.setItemDepart((String) map.get("ITEM_DEPART"));
		param.setItemSite((String) map.get("ITEM_SITE"));
		param.setItemRoom((String) map.get("ITEM_ROOM"));
		param.setItemGetDate((String) map.get("ITEM_GET_DATE"));
		param.setItemGetPrice((String) map.get("ITEM_GET_PRICE"));
		param.setItemNote((String) map.get("ITEM_NOTE"));

		// TAG, ITEMCODE, ITEMNAME 필수로 필요
		System.out.println(map.get("TAG").toString());
		System.out.println(map.get("ITEM_CODE").toString());
		System.out.println(map.get("ITEM_NAME").toString());

		return apiService.getSingleResult(itemTagService.saveTag(param));
	}

	// 등록 현황 품목 수정
	@PostMapping(value = "/updateTag", produces = "application/json")
	public @ResponseBody SingleResult<Integer> updateTag(@RequestBody HashMap<String, Object> map) {

		ApiItemTagInfoParam param = new ApiItemTagInfoParam();

		param.setItemName((String) map.get("ITEM_NAME"));
		param.setItemGroup((String) map.get("ITEM_GROUP"));
		param.setItemStandard((String) map.get("ITEM_STANDARD"));
		param.setItemAdmin((String) map.get("ITEM_ADMIN"));
		param.setItemDepart((String) map.get("ITEM_DEPART"));
		param.setItemSite((String) map.get("ITEM_SITE"));
		param.setItemRoom((String) map.get("ITEM_ROOM"));
		param.setItemGetDate((String) map.get("ITEM_GET_DATE"));
		param.setItemGetPrice((String) map.get("ITEM_GET_PRICE"));
		param.setItemNote((String) map.get("ITEM_NOTE"));

		param.setItemCode(map.get("ITEM_CODE").toString());

		return apiService.getSingleResult(itemTagService.updateTag(param));
	}

	// 등록 현황 품목 삭제
	@SuppressWarnings("unchecked")
	@PostMapping(value = "/deleteTag", produces = "application/json")
	public @ResponseBody SingleResult<Integer> deleteTag(@RequestBody HashMap<String, Object> map) {

		ApiItemTagInfoParam param = new ApiItemTagInfoParam();

		List<String> itemCodeArr = (List<String>) map.get("ITEM_CODE_ARR");

		param.setItemCodeArr(itemCodeArr);

		List<String> itemCodeArrChk = itemTagService.chkItemCodeArr(param);

		Integer result;

		System.out.println(itemCodeArr);
		System.out.println(itemCodeArrChk);

		if (itemCodeArrChk.containsAll(itemCodeArr)) {

			result = itemTagService.deleteTag(param);
		} else {
			System.out.println("No ItemCodeArr");
			result = 103;
		}
		return apiService.getSingleResult(result);
	}

}
