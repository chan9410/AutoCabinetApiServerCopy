package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ApiDeviceControllVO;
import com.example.demo.dto.ListResult;
import com.example.demo.dto.SingleResult;

public interface ApiService {

	public List<ApiDeviceControllVO> getDeviceList();

	public <T> SingleResult<T> getSingleResult(T data);

	public <T> ListResult<T> getListResult(List<T> dataList);

}
