package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ApiVO;

public interface ApiService {

	public List<ApiVO> getDeviceList();

	public List<ApiVO> currentCount(ApiVO param);

}
