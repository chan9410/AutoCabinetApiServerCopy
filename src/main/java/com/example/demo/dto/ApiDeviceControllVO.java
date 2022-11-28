package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiDeviceControllVO {

	@JsonProperty(value = "DEVICE_ID")
	private String deviceId;

	@JsonProperty(value = "DEVICE_NAME")
	private String deviceName;

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

}
