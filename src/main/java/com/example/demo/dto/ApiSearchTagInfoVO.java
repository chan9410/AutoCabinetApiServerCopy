package com.example.demo.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiSearchTagInfoVO {

	@JsonProperty(value = "ITEM_CODE")
	private String itemCode;

	@JsonProperty(value = "ITEM_NAME")
	private String itemName;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd HH:mm:ss", timezone = "GMT+9")
	@JsonProperty(value = "DATE_TIME")
	private Date dateTime;

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
