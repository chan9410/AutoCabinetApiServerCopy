package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ApiDao;
import com.example.demo.dto.ApiVO;
import com.example.demo.service.ApiService;

@Service
public class ApiServiceImpl implements ApiService {

	private ApiDao apiDao;

	@Autowired
	public ApiServiceImpl(ApiDao apiDao) {
		this.apiDao = apiDao;
	}

	@Override
	public List<ApiVO> getDeviceList() {
		return apiDao.getDeviceList();
	}

	@Override
	public List<ApiVO> currentCount(ApiVO param) {
		return apiDao.currentCount(param);
	}

}
