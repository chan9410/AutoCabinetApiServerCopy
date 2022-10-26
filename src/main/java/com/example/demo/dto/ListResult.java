package com.example.demo.dto;

import java.util.List;

public class ListResult<T> extends CommonResult {

	public List<T> dataList;

	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}

}
