package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ApiDeviceControllVO;
import com.example.demo.dto.ListResult;
import com.example.demo.dto.ReSingleResult;
import com.example.demo.dto.SingleResult;

public interface ApiService {

	public List<ApiDeviceControllVO> getDeviceList();

	public <T> ListResult<T> getListResult(List<T> dataList, int statusCode);

	public <T> SingleResult<T> getSingleResult(int data);

	public <T> ReSingleResult<T> getSingleResult(T data, int statusCode);

}
