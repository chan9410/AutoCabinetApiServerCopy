package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReportTotalCountsParam {

	@JsonProperty(value = "COMP_ID")
	private String compId;

	@JsonProperty(value = "FROM")
	private String from;

	@JsonProperty(value = "TO")
	private String to;

	public String getCompId() {
		return compId;
	}

	public void setCompId(String compId) {
		this.compId = compId;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}
	
	
}
