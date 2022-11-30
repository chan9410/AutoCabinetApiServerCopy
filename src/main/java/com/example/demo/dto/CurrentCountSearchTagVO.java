package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrentCountSearchTagVO {

	@JsonProperty(value = "DEVICE_ID")
	private String deviceId;

	@JsonProperty(value = "LOCATION")
	private int location;

	@JsonProperty(value = "ITEM_CODE")
	private String itemCode;

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

	@JsonProperty(value = "DATE_TIME")
	private String dateTime;

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

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

}
