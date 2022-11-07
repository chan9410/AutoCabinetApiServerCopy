package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ApiDao;
import com.example.demo.dto.ApiDeviceControllVO;
import com.example.demo.dto.ListResult;
import com.example.demo.dto.SingleResult;
import com.example.demo.service.ApiService;

@Service
public class ApiServiceImpl implements ApiService {

	private ApiDao apiDao;

	@Autowired
	public ApiServiceImpl(ApiDao apiDao) {
		this.apiDao = apiDao;
	}

	// 단일 데이터 조회 결과를 처리하는 메소드
	@Override
	public <T> SingleResult<T> getSingleResult(T data) {
		SingleResult<T> singleResult = new SingleResult<>();
		singleResult.setData(data);
		return singleResult;
	}

	// 다중 데이터 조회 결과를 처리하는 메소드
	@Override
	public <T> ListResult<T> getListResult(List<T> dataList) {
		ListResult<T> listResult = new ListResult<>();
		listResult.setDataList(dataList);
		return listResult;
	}

	@Override
	public List<ApiDeviceControllVO> getDeviceList() {

		return apiDao.getDeviceList();
	}
}
