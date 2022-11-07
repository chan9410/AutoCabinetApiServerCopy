package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiSearchTagInfoVO {

	@JsonProperty(value = "ITEMCODE")
	private String itemCode;

	@JsonProperty(value = "ITEMNAME")
	private String itemName;

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

}