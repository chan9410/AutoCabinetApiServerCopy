package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiDeviceControllVO {

	@JsonProperty(value = "DEVICEID")
	private String deviceId;

	@JsonProperty(value = "DEVICENAME")
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
