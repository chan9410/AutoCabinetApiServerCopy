package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class KakaoNotifyInfoOfWorkersVO {

	@JsonProperty(value = "ITEM_NAME")
	private String itemName;
	@JsonProperty(value = "WORKER_NAME")
	private String workerName;
	@JsonProperty(value = "WORKER_PHONE_NUM")
	private String workerPhoneNum;
	@JsonProperty(value = "IS_INPUT_ALERT")
	private Boolean isInputAlert;
	@JsonProperty(value = "IS_OUTPUT_ALERT")
	private Boolean isOutputAlert;

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getWorkerName() {
		return workerName;
	}

	public void setWorkerName(String workerName) {
		this.workerName = workerName;
	}

	public String getWorkerPhoneNum() {
		return workerPhoneNum;
	}

	public void setWorkerPhoneNum(String workerPhoneNum) {
		this.workerPhoneNum = workerPhoneNum;
	}

	public Boolean getIsInputAlert() {
		return isInputAlert;
	}

	public void setIsInputAlert(Boolean isInputAlert) {
		this.isInputAlert = isInputAlert;
	}

	public Boolean getIsOutputAlert() {
		return isOutputAlert;
	}

	public void setIsOutputAlert(Boolean isOutputAlert) {
		this.isOutputAlert = isOutputAlert;
	}

}
