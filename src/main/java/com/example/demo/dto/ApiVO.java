package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiVO {

	@JsonProperty(value = "DEVICEID")
	private String deviceId;

	@JsonProperty(value = "DEVICENAME")
	private String deviceName;

	@JsonProperty(value = "LOCATION")
	private String location;

	@JsonProperty(value = "COUNT")
	private String count;

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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

}
