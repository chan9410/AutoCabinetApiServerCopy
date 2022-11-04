package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiTagInfoVO {

	@JsonProperty(value = "TAG")
	private String tag;

	@JsonProperty(value = "DEVICEID")
	private String deviceId;

	@JsonProperty(value = "LOCATION")
	private int location;

	@JsonProperty(value = "COUNT")
	private int count;

	@JsonProperty(value = "ITEMCODE")
	private String itemCode;

	@JsonProperty(value = "ITEMNAME")
	private String itemName;

	@JsonProperty(value = "COLNUM")
	private int colNum;

	@JsonProperty(value = "ROWNUM")
	private int rowNum;

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
}
