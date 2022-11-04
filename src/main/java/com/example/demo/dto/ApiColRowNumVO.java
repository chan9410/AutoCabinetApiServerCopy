package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiColRowNumVO {

	@JsonProperty(value = "COLNUM")
	private int colNum;

	@JsonProperty(value = "ROWNUM")
	private int rowNum;

	public int getColNum() {
		return colNum;
	}

	public void setColNum(int colNum) {
		this.colNum = colNum;
	}

	public int getRowNum() {
		return rowNum;
	}

	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}

}
