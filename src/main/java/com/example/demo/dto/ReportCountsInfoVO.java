package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReportCountsInfoVO {
	// 통계 보고서 재고 입고 출고 검색 결과
	@JsonProperty(value = "STOCK_COUNT")
	private int stockCount;

	@JsonProperty(value = "INPUT_COUNT")
	private int inputCount;

	@JsonProperty(value = "OUTPUT_COUNT")
	private int outputCount;

	@JsonProperty(value = "DATE")
	private String stockDate;

	public int getStockCount() {
		return stockCount;
	}

	public void setStockCount(int stockCount) {
		this.stockCount = stockCount;
	}

	public int getInputCount() {
		return inputCount;
	}

	public void setInputCount(int inputCount) {
		this.inputCount = inputCount;
	}

	public int getOutputCount() {
		return outputCount;
	}

	public void setOutputCount(int outputCount) {
		this.outputCount = outputCount;
	}

	public String getStockDate() {
		return stockDate;
	}

	public void setDate(String stockDate) {
		this.stockDate = stockDate;
	}
}
