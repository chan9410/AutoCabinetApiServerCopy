package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiTagCountVO {

	@JsonProperty(value = "LOCATION")
	private int location;

	@JsonProperty(value = "COUNT")
	private int count;

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
}
