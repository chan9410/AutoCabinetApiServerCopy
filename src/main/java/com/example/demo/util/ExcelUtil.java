package com.example.demo.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.DefaultIndexedColorMap;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

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

			// 헤더 생성
			row = sheet.createRow(rowNo++);
			for (int i = 0; i < headerSize; i++) {

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
