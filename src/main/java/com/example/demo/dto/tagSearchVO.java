package com.example.demo.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class tagSearchVO {

	@JsonProperty(value = "TAG")
	private String tag;

	@JsonProperty(value = "LOCATION")
	private String location;

	@JsonProperty(value = "COMPANYID")
	private String companyId;

	@JsonProperty(value = "ITEMNAME")
	private String itemName;
	
	@JsonProperty(value = "WORKERNAME")
	private String workername;

	@JsonProperty(value = "TAGTIME")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm:ss", timezone = "GMT+9")
	private Date tagTime;
	
	@JsonProperty(value = "INPUTTAGTIME")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm:ss", timezone = "GMT+9")
	private Date inputtagTime;
	
	@JsonProperty(value = "OUTPUTTAGTIME")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm:ss", timezone = "GMT+9")
	private Date outputtagTime;

	@JsonProperty(value = "searchCode")
	private String searchCode;

	@JsonProperty(value = "searchCodeArr")
	private List<String> searchCodeArr;

	@JsonProperty(value = "chkRowTagArr")
	private List<String> chkRowTagArr;

	@JsonProperty(value = "sendData")
	private List<String> sendData;

	@JsonProperty(value = "inputStartDate")
	private String inputStartDate;

	@JsonProperty(value = "inputLastDate")
	private String inputLastDate;
	
	@JsonProperty(value = "searchWorker")
	private String searchWorker;
	
	@JsonProperty(value = "CHKROW")
	private String chkRow;

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Date getTagTime() {
		return tagTime;
	}

	public void setTagTime(Date tagTime) {
		this.tagTime = tagTime;
	}

	public String getSearchCode() {
		return searchCode;
	}

	public void setSearchCode(String searchCode) {
		this.searchCode = searchCode;
	}

	public List<String> getSearchCodeArr() {
		return searchCodeArr;
	}

	public void setSearchCodeArr(List<String> searchCodeArr) {
		this.searchCodeArr = searchCodeArr;
	}

	public List<String> getChkRowTagArr() {
		return chkRowTagArr;
	}

	public void setChkRowTagArr(List<String> chkRowTagArr) {
		this.chkRowTagArr = chkRowTagArr;
	}

	public List<String> getSendData() {
		return sendData;
	}

	public void setSendData(List<String> sendData) {
		this.sendData = sendData;
	}

	public String getInputStartDate() {
		return inputStartDate;
	}

	public void setInputStartDate(String inputStartDate) {
		this.inputStartDate = inputStartDate;
	}

	public String getInputLastDate() {
		return inputLastDate;
	}

	public void setInputLastDate(String inputLastDate) {
		this.inputLastDate = inputLastDate;
	}

	public String getSearchWorker() {
		return searchWorker;
	}

	public void setSearchWorker(String searchWorker) {
		this.searchWorker = searchWorker;
	}

	public String getWorkername() {
		return workername;
	}

	public void setWorkername(String workername) {
		this.workername = workername;
	}

	public Date getInputtagTime() {
		return inputtagTime;
	}

	public void setInputtagTime(Date inputtagTime) {
		this.inputtagTime = inputtagTime;
	}

	public Date getOutputtagTime() {
		return outputtagTime;
	}

	public void setOutputtagTime(Date outputtagTime) {
		this.outputtagTime = outputtagTime;
	}

	public String getChkRow() {
		return chkRow;
	}

	public void setChkRow(String chkRow) {
		this.chkRow = chkRow;
	}
	
}
