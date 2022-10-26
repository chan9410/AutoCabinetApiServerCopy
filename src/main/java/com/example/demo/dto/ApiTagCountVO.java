package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiTagCountVO {

	@JsonProperty(value = "LOCATION")
	private int location;

	@JsonProperty(value = "COUNT")
	private int count;

	@JsonProperty(value = "DEVICEID")
	private String deviceId;

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

}
