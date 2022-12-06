package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiTagInfoParam {

	@JsonProperty(value = "TAG")
	private String tag;

	@JsonProperty(value = "DEVICE_ID")
	private String deviceId;

	@JsonProperty(value = "LOCATION")
	private int location;

	@JsonProperty(value = "COUNT")
	private int count;

	@JsonProperty(value = "ITEM_CODE")
	private String itemCode;

	@JsonProperty(value = "ITEM_NAME")
	private String itemName;

	@JsonProperty(value = "COL_NUM")
	private int colNum;

	@JsonProperty(value = "ROW_NUM")
	private int rowNum;

	@JsonProperty(value = "DEVICE_NAME")
	private String deviceName;

	@JsonProperty(value = "RECENT_TIME")
	private String recentTime;

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
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

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getRecentTime() {
		return recentTime;
	}

	public void setRecentTime(String recentTime) {
		this.recentTime = recentTime;
	}

}
