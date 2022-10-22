package com.example.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReportCountsInfoParam {
	// 통계 보고서 재고 입고 출고 검색 조건 파라미터
	// 검색할 장비의 ID 리스트, 검색할 기간
	@JsonProperty(value = "DEVICE_ID")
	private String deviceId;

	@JsonProperty(value = "FROM")
	private String from;

	@JsonProperty(value = "TO")
	private String to;

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
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
