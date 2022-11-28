package com.example.demo.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiItemTagInfoParam {

	@JsonProperty(value = "TAG")
	private String tag;

	@JsonProperty(value = "ITEM_CODE")
	private String itemCode;

	@JsonProperty(value = "ITEM_CODE_ARR")
	private List<String> itemCodeArr;

	@JsonProperty(value = "ITEM_NAME")
	private String itemName;

	@JsonProperty(value = "ITEM_GROUP")
	private String itemGroup;

	@JsonProperty(value = "ITEM_STANDARD")
	private String itemStandard;

	@JsonProperty(value = "ITEM_ADMIN")
	private String itemAdmin;

	@JsonProperty(value = "ITEM_DEPART")
	private String itemDepart;

	@JsonProperty(value = "ITEM_SITE")
	private String itemSite;

	@JsonProperty(value = "ITEM_ROOM")
	private String itemRoom;

	@JsonProperty(value = "ITEM_GET_DATE")
	private String itemGetDate;

	@JsonProperty(value = "ITEM_GET_PRICE")
	private String itemGetPrice;

	@JsonProperty(value = "ITEM_NOTE")
	private String itemNote;

	@JsonProperty(value = "DEVICE_ID")
	private String deviceId;

	@JsonProperty(value = "DEVICE_ID_ARR")
	private List<String> deviceIdArr;

	@JsonProperty(value = "DATE_TIME")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss", timezone = "GMT+9")
	private Date dateTime;

	@JsonProperty(value = "LOCATION")
	private int location;

	@JsonProperty(value = "ITEM_GET_START_DATE")
	private String itemGetStartDate;

	@JsonProperty(value = "ITEM_GET_END_DATE")
	private String itemGetEndDate;

	@JsonProperty(value = "ITEM_GET_LOW_PRICE")
	private String itemGetLowPrice;

	@JsonProperty(value = "ITEM_GET_HIGH_PRICE")
	private String itemGetHighPrice;

	@JsonProperty(value = "START_DATE_TIME")
	private String startDateTime;

	@JsonProperty(value = "END_DATE_TIME")
	private String endDateTime;

	@JsonProperty(value = "WORKER_ID")
	private String workerId;

	@JsonProperty(value = "STATE")
	private String state;

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public List<String> getItemCodeArr() {
		return itemCodeArr;
	}

	public void setItemCodeArr(List<String> itemCodeArr) {
		this.itemCodeArr = itemCodeArr;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemGroup() {
		return itemGroup;
	}

	public void setItemGroup(String itemGroup) {
		this.itemGroup = itemGroup;
	}

	public String getItemStandard() {
		return itemStandard;
	}

	public void setItemStandard(String itemStandard) {
		this.itemStandard = itemStandard;
	}

	public String getItemAdmin() {
		return itemAdmin;
	}

	public void setItemAdmin(String itemAdmin) {
		this.itemAdmin = itemAdmin;
	}

	public String getItemDepart() {
		return itemDepart;
	}

	public void setItemDepart(String itemDepart) {
		this.itemDepart = itemDepart;
	}

	public String getItemSite() {
		return itemSite;
	}

	public void setItemSite(String itemSite) {
		this.itemSite = itemSite;
	}

	public String getItemRoom() {
		return itemRoom;
	}

	public void setItemRoom(String itemRoom) {
		this.itemRoom = itemRoom;
	}

	public String getItemGetDate() {
		return itemGetDate;
	}

	public void setItemGetDate(String itemGetDate) {
		this.itemGetDate = itemGetDate;
	}

	public String getItemGetPrice() {
		return itemGetPrice;
	}

	public void setItemGetPrice(String itemGetPrice) {
		this.itemGetPrice = itemGetPrice;
	}

	public String getItemNote() {
		return itemNote;
	}

	public void setItemNote(String itemNote) {
		this.itemNote = itemNote;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public List<String> getDeviceIdArr() {
		return deviceIdArr;
	}

	public void setDeviceIdArr(List<String> deviceIdArr) {
		this.deviceIdArr = deviceIdArr;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	public String getItemGetStartDate() {
		return itemGetStartDate;
	}

	public void setItemGetStartDate(String itemGetStartDate) {
		this.itemGetStartDate = itemGetStartDate;
	}

	public String getItemGetEndDate() {
		return itemGetEndDate;
	}

	public void setItemGetEndDate(String itemGetEndDate) {
		this.itemGetEndDate = itemGetEndDate;
	}

	public String getItemGetLowPrice() {
		return itemGetLowPrice;
	}

	public void setItemGetLowPrice(String itemGetLowPrice) {
		this.itemGetLowPrice = itemGetLowPrice;
	}

	public String getItemGetHighPrice() {
		return itemGetHighPrice;
	}

	public void setItemGetHighPrice(String itemGetHighPrice) {
		this.itemGetHighPrice = itemGetHighPrice;
	}

	public String getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(String startDateTime) {
		this.startDateTime = startDateTime;
	}

	public String getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(String endDateTime) {
		this.endDateTime = endDateTime;
	}

	public String getWorkerId() {
		return workerId;
	}

	public void setWorkerId(String workerId) {
		this.workerId = workerId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
