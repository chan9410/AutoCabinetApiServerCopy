package com.example.demo.dto;

import java.util.List;

public class ListExcelResult<T> extends CommonResult {

	public List<T> overlapTagList;
	
	public List<T> overlapItemCodeList;

	public List<T> getOverlapTagList() {
		return overlapTagList;
	}

	public void setOverlapTagList(List<T> overlapTagList) {
		this.overlapTagList = overlapTagList;
	}

	public List<T> getOverlapItemCodeList() {
		return overlapItemCodeList;
	}

	public void setOverlapItemCodeList(List<T> overlapItemCodeList) {
		this.overlapItemCodeList = overlapItemCodeList;
	}
	
}
