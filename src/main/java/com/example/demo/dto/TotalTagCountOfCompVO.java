package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TotalTagCountOfCompVO {
	// 회사에 등록된 모든 장비가 읽은 재고 입고 출고의 카운트 총합
	@JsonProperty(value = "STOCK_COUNT")
	private int totalStockCount;

	@JsonProperty(value = "INPUT_COUNT")
	private int totalInputCount;

	@JsonProperty(value = "OUTPUT_COUNT")
	private int totalOutputCount;

	@JsonProperty(value = "DATE")
	private String stockDate;

	public int getTotalStockCount() {
		return totalStockCount;
	}

	public void setTotalStockCount(int totalStockCount) {
		this.totalStockCount = totalStockCount;
	}

	public int getTotalInputCount() {
		return totalInputCount;
	}

	public void setTotalInputCount(int totalInputCount) {
		this.totalInputCount = totalInputCount;
	}

	public int getTotalOutputCount() {
		return totalOutputCount;
	}

	public void setTotalOutputCount(int totalOutputCount) {
		this.totalOutputCount = totalOutputCount;
	}

	public String getStockDate() {
		return stockDate;
	}

	public void setStockDate(String stockDate) {
		this.stockDate = stockDate;
	}

}
