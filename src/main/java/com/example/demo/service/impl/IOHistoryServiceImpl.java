package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IOHistoryDao;
import com.example.demo.dto.ApiItemTagInfoVO;
import com.example.demo.service.IOHistoryService;

@Service
public class IOHistoryServiceImpl implements IOHistoryService {

	private IOHistoryDao iOHistoryDao;

	@Autowired
	public IOHistoryServiceImpl(IOHistoryDao iOHistoryDao) {
		this.iOHistoryDao = iOHistoryDao;
	}

	@Override
	public List<ApiItemTagInfoVO> inputHistorySearch(ApiItemTagInfoVO param) {
		return iOHistoryDao.inputHistorySearch(param);
	}

	@Override
	public List<ApiItemTagInfoVO> outputHistorySearch(ApiItemTagInfoVO param) {
		return iOHistoryDao.outputHistorySearch(param);
	}

}
