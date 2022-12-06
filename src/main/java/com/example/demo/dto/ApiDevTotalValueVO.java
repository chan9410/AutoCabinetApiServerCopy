package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiDevTotalValueVO {

	@JsonProperty(value = "DEVICE_ID")
	private String deviceId;

	@JsonProperty(value = "DEVICE_NAME")
	private String deviceName;

	@JsonProperty(value = "STATE_LEVEL")
	private String stateLevel;

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

	public String getStateLevel() {
		return stateLevel;
	}

	public void setStateLevel(String stateLevel) {
		this.stateLevel = stateLevel;
	}

}
