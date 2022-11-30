package com.example.demo.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
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
import com.example.demo.dto.ListResult;
import com.example.demo.dto.SingleResult;
import com.example.demo.service.ApiService;
import com.example.demo.service.ItemTagService;
import com.example.demo.util.ExcelUtil;

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

	@PostMapping(value = "/excelUpload", produces = "application/json")
	public @ResponseBody SingleResult<ExcelData> excelUpload(@RequestParam("file") MultipartFile file, Model model)
			throws IOException {

		String extension = FilenameUtils.getExtension(file.getOriginalFilename()); // 3

		if (!extension.equals("xlsx") && !extension.equals("xls")) {
			throw new IOException("엑셀파일만 업로드 해주세요.");
		}

		Workbook workbook = null;

		if (extension.equals("xlsx")) {
			workbook = new XSSFWorkbook(file.getInputStream());
		} else if (extension.equals("xls")) {
			workbook = new HSSFWorkbook(file.getInputStream());
		}

		Sheet worksheet = workbook.getSheetAt(0);

		int dataLength = worksheet.getPhysicalNumberOfRows();

		for (int i = 1; i < dataLength; i++) {/**/

			Row row = worksheet.getRow(i);

			int errorCode = 200;

			ExcelData data = new ExcelData();

			try {
				try {
					data.setTag(row.getCell(0).getStringCellValue());
					data.setItemCode(row.getCell(1).getStringCellValue());
					data.setItemName(row.getCell(2).getStringCellValue());
					data.setItemGroup(row.getCell(3, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
					data.setItemAdmin(row.getCell(4, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
					data.setItemGetDate(
							(Date) row.getCell(5, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getDateCellValue());
					data.setItemStandard(
							row.getCell(6, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
					data.setItemDepart(row.getCell(7, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
					data.setItemGetPrice(
							(int) (row.getCell(8, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue()));
					data.setItemRoom(row.getCell(9, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
					data.setItemSite(row.getCell(10, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
					data.setItemNote(row.getCell(11, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());

				} catch (NullPointerException e) {
					data = null;
					errorCode = 110;
				}
			} catch (IllegalStateException e) {
				data = null;
				errorCode = 111;
			}

			if (errorCode == 110) {
				System.out.println("NullPointerException 발생");
			} else if (errorCode == 111) {
				System.out.println("IllegalStateException 발생");
			} else if (data == null) {
				System.out.println("Data is Null");
			} else {
				itemTagService.excelTempUpload(data);
			}
		}
		int tempCount = itemTagService.getCountexcelTemp();
		int statusCode;

		System.out.println(tempCount);
		System.out.println(dataLength);

		if (tempCount == dataLength - 1) {// 엑셀의 첫번째 열은 읽지 않음.
			itemTagService.excelUpload();
			itemTagService.deleteExcelTemp();
			statusCode = 200;
		} else {
			itemTagService.deleteExcelTemp();
			statusCode = 109;
		}

		return apiService.getSingleResult(statusCode);
	}

	@PostMapping(value = "/downloadTemplateFile")
	public void downloadTemplateFile(HttpServletResponse response) throws IOException {

		response.setContentType("ms-vnd/excel");
		response.setHeader("Content-Disposition", "attachment;filename=testExcel.xlsx");

		List<String> header = Arrays.asList("RFID Tag 코드", "제품 코드", "제품명", "제품 분류", "관리자", "취득 일자", "규격", "부서", "취득 가격",
				"ROOM", "소재지", "비고");
		ByteArrayInputStream stream = ExcelUtil.createListToExcel(header);
		IOUtils.copy(stream, response.getOutputStream());

	}

}
