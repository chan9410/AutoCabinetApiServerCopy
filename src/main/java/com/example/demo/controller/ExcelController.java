package com.example.demo.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
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
import com.example.demo.service.ApiService;
import com.example.demo.util.ExcelUtil;

@CrossOrigin("*")
@Controller

public class ExcelController {

	private ApiService apiService;

	private ExcelUtil excelUtil;

	@Autowired
	public ExcelController(ApiService apiService, ExcelUtil excelUtil) {
		this.apiService = apiService;
		this.excelUtil = excelUtil;
	}

	@PostMapping(value = "/excelView", produces = "application/json")
	public @ResponseBody ListResult<ExcelData> excelView(@RequestParam("file") MultipartFile file, Model model)
			throws IOException {

		String extension = FilenameUtils.getExtension(file.getOriginalFilename());

		if (!extension.equals("xlsx") && !extension.equals("xls")) {
			throw new IOException("엑셀파일만 업로드 해주세요.");
		}

		@SuppressWarnings("unused")
		Workbook workbook = null;

		// workbook.setMissingCellPolicy(MissingCellPolicy.CREATE_NULL_AS_BLANK);
		// Cell에 값이 없을 경우 빈 값으로 가져오기

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

			dataList.add(data);

		}

		System.out.println(dataList);

		return apiService.getListResult(dataList, 200);
	}
}
