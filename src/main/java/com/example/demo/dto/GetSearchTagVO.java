package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetSearchTagVO {

	@JsonProperty(value = "ITEMCODE")
	private String itemCode;

	@JsonProperty(value = "ITEMNAME")
	private String itemName;

	@JsonProperty(value = "ITEMGROUP")
	private String itemGroup;

	@JsonProperty(value = "ITEMSTANDARD")
	private String itemStandard;

	@JsonProperty(value = "ITEMADMIN")
	private String itemAdmin;

	@JsonProperty(value = "ITEAMDEPART")
	private String itemDepart;

	@JsonProperty(value = "ITEMSITE")
	private String itemSite;

	@JsonProperty(value = "ITEMROOM")
	private String itemRoom;

	@JsonProperty(value = "ITEMGETDATE")
	private String itemGetDate;

	@JsonProperty(value = "ITEMGETPRICE")
	private String itemGetPrice;

	@JsonProperty(value = "ITEMNOTE")
	private String itemNote;

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

}