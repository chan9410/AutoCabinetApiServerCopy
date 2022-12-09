package com.example.demo.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.ApiItemTagInfoParam;
import com.example.demo.dto.ExcelData;
import com.example.demo.dto.GetSearchTagVO;
import com.example.demo.dto.ListExcelResult;
import com.example.demo.dto.ListResult;
import com.example.demo.dto.ReSingleResult;
import com.example.demo.dto.SingleResult;
import com.example.demo.service.ApiService;
import com.example.demo.service.ItemTagService;
import com.example.demo.util.DateUtil;
import com.example.demo.util.ExcelUtil;

@CrossOrigin("*")
@Controller
@RequestMapping("/itemCon")

public class RegistrationItemController {

	private ItemTagService itemTagService;

	private ApiService apiService;

	private ExcelUtil excelUtil;

	@Autowired
	public RegistrationItemController(ItemTagService itemTagService, ApiService apiService, ExcelUtil excelUtil) {
		this.itemTagService = itemTagService;
		this.apiService = apiService;
		this.excelUtil = excelUtil;
	}

	// 등록 현황 품목 조회
	@PostMapping(value = "/getSearchTag", produces = "application/json")
	public @ResponseBody ListResult<GetSearchTagVO> getSearchTag(@RequestBody HashMap<String, Object> map) {

		ApiItemTagInfoParam param = new ApiItemTagInfoParam();

		param.setTag((String) map.get("TAG"));
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

		param.setItemGroup((String) map.get("ITEM_GROUP"));
		param.setItemStandard((String) map.get("ITEM_STANDARD"));
		param.setItemAdmin((String) map.get("ITEM_ADMIN"));
		param.setItemDepart((String) map.get("ITEM_DEPART"));
		param.setItemSite((String) map.get("ITEM_SITE"));
		param.setItemRoom((String) map.get("ITEM_ROOM"));
		param.setItemGetDate((String) map.get("ITEM_GET_DATE"));
		param.setItemGetPrice((String) map.get("ITEM_GET_PRICE"));
		param.setItemNote((String) map.get("ITEM_NOTE"));
		
		try {
			param.setTag(map.get("TAG").toString());
			param.setItemCode(map.get("ITEM_CODE").toString());
			param.setItemName(map.get("ITEM_NAME").toString());
		}catch(NullPointerException e) {
			return apiService.getSingleResult(111);
		}

		return apiService.getSingleResult(itemTagService.saveTag(param));
	}

	// 등록 현황 품목 수정
	@PostMapping(value = "/updateTag", produces = "application/json")
	public @ResponseBody SingleResult<Integer> updateTag(@RequestBody HashMap<String, Object> map) {

		ApiItemTagInfoParam param = new ApiItemTagInfoParam();

		param.setTag((String) map.get("TAG"));
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

		try {
			param.setItemCode(map.get("ITEM_CODE").toString());
		}catch(NullPointerException e) {
			return apiService.getSingleResult(111);
		}

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

	// 엑셀 업로드
	@PostMapping(value = "/excelUpload", produces = "application/json")
	public @ResponseBody ListExcelResult<ExcelData> excelUpload(@RequestParam("file") MultipartFile file, Model model)
			throws IOException {

		String extension = FilenameUtils.getExtension(file.getOriginalFilename());

		if (!extension.equals("xlsx") && !extension.equals("xls")) {
			//throw new IOException("엑셀파일만 업로드 해주세요.");
			return apiService.getListExcelResult(null, null, 112);
		}

		Workbook workbook = null;

		if (extension.equals("xlsx")) {
			workbook = new XSSFWorkbook(file.getInputStream());
		} else if (extension.equals("xls")) {
			workbook = new HSSFWorkbook(file.getInputStream());
		}

		List<ExcelData> dataList = new ArrayList<ExcelData>();

		List<Map<String, Object>> listMap = excelUtil.getListData(file, 1, 12);

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		for (Map<String, Object> map : listMap) {
			ExcelData data = new ExcelData();

			try {

				data.setTag(map.get("0").toString());
				data.setItemCode(map.get("1").toString());
				data.setItemName(map.get("2").toString());
				data.setItemGroup((String) map.get("3"));
				data.setItemAdmin((String) map.get("4"));
				if (map.get("5") == null) {
					data.setItemGetDate(null);
				} else {
					data.setItemGetDate((String) dateFormat.format(map.get("5")));
				}
				data.setItemStandard((String) map.get("6"));
				data.setItemDepart((String) map.get("7"));
				if (map.get("8") == null) {
					data.setItemGetPrice(0);
				} else {
					data.setItemGetPrice((Integer.parseInt((String) map.get("8"))));
				}
				data.setItemRoom((String) map.get("9"));
				data.setItemSite((String) map.get("10"));
				data.setItemNote((String) map.get("11"));

			} catch (IllegalArgumentException e) {
				data = null;
			} catch (NullPointerException e) {
				data = null;
			}

			dataList.add(data);
		}
		
		System.out.println(dataList);
		
		List<ExcelData> chkExcelTagArr = itemTagService.chkExcelTagArr(dataList);
		
		List<ExcelData> chkExcelItemCodeArr = itemTagService.chkExcelItemCodeArr(dataList);
		
		int statusCode;
						
		if (dataList.contains(null) == true) {
			statusCode = 109;
		}else if(chkExcelTagArr.size() != 0) {
			statusCode = 104;
		}else if(chkExcelItemCodeArr.size() != 0){
			statusCode = 105;
		}else if(itemTagService.excelUpload(dataList) == 0){
			statusCode = 101;
		}else {
			statusCode = 200;
		}
		
		System.out.println(statusCode);
		
		return apiService.getListExcelResult(chkExcelTagArr, chkExcelItemCodeArr, statusCode);

	}

	// 엑셀 템플릿 파일(기본 파일) 다운로드
	@PostMapping(value = "/downloadTemplateFile")
	public void downloadTemplateFile(HttpServletResponse response) throws IOException {//GetMapping으로 변경 필요

		response.setContentType("ms-vnd/excel");

		LocalDateTime now = LocalDateTime.now();

		String date = DateUtil.getString(now, "yyyy.MM.dd_HHmmss");

		response.setHeader("Content-Disposition", "attachment;filename=testExcel" + "_" + date + ".xlsx");

		List<String> header = Arrays.asList("RFID Tag 코드", "제품 코드", "제품명", "제품 분류", "관리자", "취득 일자", "규격", "부서", "취득 가격",
				"ROOM", "소재지", "비고");
		ByteArrayInputStream stream = ExcelUtil.createListToExcel(header);
		IOUtils.copy(stream, response.getOutputStream());

	}

}
