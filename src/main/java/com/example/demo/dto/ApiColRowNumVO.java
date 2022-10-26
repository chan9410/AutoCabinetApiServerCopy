package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiColRowNumVO {

	@JsonProperty(value = "COLNUM")
	private int colNum;

	@JsonProperty(value = "ROWNUM")
	private int rowNum;

	@JsonProperty(value = "DEVICEID")
	private String deviceId;

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

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
}
