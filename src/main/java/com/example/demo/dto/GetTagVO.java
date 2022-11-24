package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetTagVO {

	@JsonProperty(value = "TAG")
	private String tag;

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

}
