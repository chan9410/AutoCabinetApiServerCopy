package com.example.demo.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.ExcelData;
import com.example.demo.dto.ListResult;
import com.example.demo.dto.SingleResult;
import com.example.demo.service.ApiService;
import com.example.demo.service.ItemTagService;
import com.example.demo.util.ExcelUtil;

@CrossOrigin("*")
@Controller

public class ExcelController {

	private ApiService apiService;

	private ItemTagService itemTagService;

	@Autowired
	public ExcelController(ApiService apiService, ItemTagService itemTagService) {
		this.apiService = apiService;
		this.itemTagService = itemTagService;
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

		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {/**/

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
					data.setItemGetDate((Date) row.getCell(5).getDateCellValue());
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
			} /* data = null일때 처리 serviceImpl에서 할 예정 */

			if (errorCode == 110) {
				System.out.println("NullPointerException 발생");
			} else if (errorCode == 111) {
				System.out.println("IllegalStateException 발생");
			} else if (data == null) {
				System.out.println("Data is Null");
			} else {
				itemTagService.excelUpload(data);
			}

		}
		return apiService.getSingleResult(200);
	}

	@PostMapping(value = "/excelView", produces = "application/json")
	public @ResponseBody ListResult<ExcelData> excelView(@RequestParam("file") MultipartFile file, Model model)
			throws IOException {

		String extension = FilenameUtils.getExtension(file.getOriginalFilename());

		if (!extension.equals("xlsx") && !extension.equals("xls")) {
			throw new IOException("엑셀파일만 업로드 해주세요.");
		}

		Workbook workbook = null;

		// workbook.setMissingCellPolicy(MissingCellPolicy.CREATE_NULL_AS_BLANK);
		// Cell에 값이 없을 경우 빈 값으로 가져오기

		if (extension.equals("xlsx")) {
			workbook = new XSSFWorkbook(file.getInputStream());
		} else if (extension.equals("xls")) {
			workbook = new HSSFWorkbook(file.getInputStream());
		}

		Sheet worksheet = workbook.getSheetAt(0);

		List<ExcelData> dataList = new ArrayList<>();

		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {

			Row row = worksheet.getRow(i);

			ExcelData data = new ExcelData();

			try {
				try {
					data.setTag(row.getCell(0).getStringCellValue());
					data.setItemCode(row.getCell(1).getStringCellValue());
					data.setItemName(row.getCell(2).getStringCellValue());
					data.setItemGroup(row.getCell(3, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
					data.setItemAdmin(row.getCell(4, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
					data.setItemGetDate((Date) row.getCell(5).getDateCellValue());
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
				}
			} catch (IllegalStateException e) {
				data = null;
			}

			System.out.println(data);

			dataList.add(data);
		}

		System.out.println(dataList);

		// List<ApiItemTagInfoParam> result = itemTagService.excelUpload(dataList);

		return apiService.getListResult(dataList, 200);
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
