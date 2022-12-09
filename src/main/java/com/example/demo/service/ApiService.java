package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ListExcelResult;
import com.example.demo.dto.ListResult;
import com.example.demo.dto.ReSingleResult;
import com.example.demo.dto.SingleResult;

public interface ApiService {

	public <T> ListResult<T> getListResult(List<T> dataList, int statusCode);

	public <T> SingleResult<T> getSingleResult(Integer data);

	public <T> ReSingleResult<T> getSingleResult(T data, int statusCode);
	
	public <T> ListExcelResult<T> getListExcelResult(List<T> overlapTagList, List<T> overlapItemCodeList, int statusCode);


}
