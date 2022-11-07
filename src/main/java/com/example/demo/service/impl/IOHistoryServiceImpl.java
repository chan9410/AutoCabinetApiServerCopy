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

		String chkDeviceId = iOHistoryDao.chkDeviceId(param);

		if (chkDeviceId == null) {
			System.out.println("No DeviceId");
			return null;
		} else {
			return iOHistoryDao.inputHistorySearch(param);
		}
	}

	@Override
	public List<IOHistotyVO> outputHistorySearch(ApiItemTagInfoParam param) {

		String chkDeviceId = iOHistoryDao.chkDeviceId(param);

		if (chkDeviceId == null) {
			System.out.println("No DeviceId");
			return null;
		} else {
			return iOHistoryDao.outputHistorySearch(param);
		}
	}

}
