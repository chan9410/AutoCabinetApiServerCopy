package com.example.demo.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.DefaultIndexedColorMap;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFDataFormat;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class ExcelUtil {

	public Object getCellValue(XSSFCell cell) {

		Object value = null;

		if (cell == null) {
			return value;
		}

		switch (cell.getCellType()) {

		case STRING:
			value = cell.getStringCellValue();
			break;
		case NUMERIC:

			if (DateUtil.isCellDateFormatted(cell) == true) {
				value = cell.getDateCellValue();
			} else {
				value = (int) cell.getNumericCellValue() + "";
			}
			break;
		case BLANK:
			value = null;
		default:
			break;

		}
		return value;
	}

	public List<Map<String, Object>> getListData(MultipartFile file, int startRowNum, int columnLength) {

		List<Map<String, Object>> excelList = new ArrayList<Map<String, Object>>();

		try {

			OPCPackage opcPackage = OPCPackage.open(file.getInputStream());

			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(opcPackage);

			// workbook.setMissingCellPolicy(MissingCellPolicy.CREATE_NULL_AS_BLANK);

			XSSFSheet sheet = workbook.getSheetAt(0);

			int rowIndex = 0;
			int columnIndex = 0;

			for (rowIndex = startRowNum; rowIndex < sheet.getLastRowNum() + 1; rowIndex++) {
				XSSFRow row = sheet.getRow(rowIndex);

				if (row.getCell(0) != null && !row.getCell(0).toString().isBlank()) {

					Map<String, Object> map = new HashMap<String, Object>();

					int cells = columnLength;

					for (columnIndex = 0; columnIndex <= cells; columnIndex++) {
						XSSFCell cell = row.getCell(columnIndex);
						map.put(String.valueOf(columnIndex), getCellValue(cell));

					}
					excelList.add(map);
				}
			}

		} catch (InvalidFormatException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return excelList;

	}

	public static ByteArrayInputStream createListToExcel(List<String> excelHeader) {

		try (Workbook workbook = new XSSFWorkbook()) {

			Sheet sheet = workbook.createSheet("excelDownTest");
			Row row;
			Cell cell;
			int rowNo = 0;

			int headerSize = excelHeader.size();

			// 테이블 헤더 설정 지정
			XSSFCellStyle headerStyle = (XSSFCellStyle) workbook.createCellStyle();

			// 경계선 설정
			headerStyle.setBorderTop(BorderStyle.THIN);
			headerStyle.setBorderBottom(BorderStyle.THIN);
			headerStyle.setBorderLeft(BorderStyle.THIN);
			headerStyle.setBorderRight(BorderStyle.THIN);

			// 색상
			headerStyle.setFillForegroundColor(
					new XSSFColor(new java.awt.Color(255, 255, 255), new DefaultIndexedColorMap()));
			headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			// 헤더 가운데 정렬
			headerStyle.setAlignment(HorizontalAlignment.CENTER);
			headerStyle.setVerticalAlignment(VerticalAlignment.CENTER);

			// 헤더 폰트
			Font headerFont = workbook.createFont();
			headerFont.setFontHeight((short) 1600);

			XSSFCellStyle style = (XSSFCellStyle) workbook.createCellStyle();

			XSSFDataFormat format = (XSSFDataFormat) workbook.createDataFormat();

			style.setDataFormat(format.getFormat("@"));

			// 헤더 생성
			row = sheet.createRow(rowNo++);
			for (int i = 0; i < headerSize; i++) {

				if (i != 5 && i != 8) {
					sheet.setDefaultColumnStyle(i, style);
				}
				sheet.autoSizeColumn(i);
				sheet.setColumnWidth(i, sheet.getColumnWidth(0) + 1000);

				cell = row.createCell(i);
				cell.setCellStyle(headerStyle);
				cell.setCellValue(excelHeader.get(i));
				// 설정한 헤더 값 입력
			}

			// 컬럼 사이즈 추가 조절

			sheet.autoSizeColumn(0);
			sheet.setColumnWidth(0, sheet.getColumnWidth(0) + 5000);
			sheet.autoSizeColumn(1);
			sheet.setColumnWidth(1, sheet.getColumnWidth(0) + 3000);
			sheet.autoSizeColumn(5);
			sheet.setColumnWidth(5, sheet.getColumnWidth(0) + 2000);
			sheet.autoSizeColumn(11);
			sheet.setColumnWidth(11, sheet.getColumnWidth(0) + 2000);

			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			workbook.write(outputStream);
			return new ByteArrayInputStream(outputStream.toByteArray());

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
