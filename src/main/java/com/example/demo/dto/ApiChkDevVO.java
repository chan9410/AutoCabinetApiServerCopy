package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiChkDevVO {

	@JsonProperty(value = "DEVICE_ID")
	private String deviceId;

	@JsonProperty(value = "DEVICE_NAME")
	private String deviceName;

	@JsonProperty(value = "COL_NUM")
	private int colNum;

	@JsonProperty(value = "ROW_NUM")
	private int rowNum;

	@JsonProperty(value = "STATE")
	private String state;

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
