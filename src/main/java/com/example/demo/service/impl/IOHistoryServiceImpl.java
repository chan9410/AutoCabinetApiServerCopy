package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IOHistoryDao;
import com.example.demo.dto.ApiItemTagInfoParam;
import com.example.demo.dto.IOHistotyVO;
import com.example.demo.service.IOHistoryService;

@Service
public class IOHistoryServiceImpl implements IOHistoryService {

	private IOHistoryDao iOHistoryDao;

	@Autowired
	public IOHistoryServiceImpl(IOHistoryDao iOHistoryDao) {
		this.iOHistoryDao = iOHistoryDao;
	}

	@Override
	public List<IOHistotyVO> inputHistorySearch(ApiItemTagInfoParam param) {
		return iOHistoryDao.inputHistorySearch(param);
	}

	@Override
	public List<IOHistotyVO> outputHistorySearch(ApiItemTagInfoParam param) {
		return iOHistoryDao.outputHistorySearch(param);
	}

	@Override
	public List<IOHistotyVO> getIOHistory(ApiItemTagInfoParam param) {
		return iOHistoryDao.getIOHistory(param);
	}

	@Override
	public List<String> chkDevIdArr(ApiItemTagInfoParam param) {
		return iOHistoryDao.chkDevIdArr(param);
	}
}
