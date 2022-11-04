package com.example.demo.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.ApiItemTagInfoVO;
import com.example.demo.dto.ListResult;
import com.example.demo.service.ApiService;

@CrossOrigin("*")
@Controller
@RequestMapping("/api/itemTag")

public class ItemTagController {

	// private ItemTagService itemTagService;

	private ApiService apiService;

	/*
	 * @Autowired public ItemTagController(ItemTagService itemTagService) {
	 * this.itemTagService = itemTagService; }
	 */

	@Autowired
	public ItemTagController(ApiService apiService) {
		this.apiService = apiService;
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

}
