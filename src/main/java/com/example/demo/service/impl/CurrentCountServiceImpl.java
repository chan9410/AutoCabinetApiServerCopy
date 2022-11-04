package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CurrentCountDao;
import com.example.demo.dto.ApiTagInfoVO;
import com.example.demo.service.CurrentCountService;

@Service
public class CurrentCountServiceImpl implements CurrentCountService {

	private CurrentCountDao currentCountDao;

	@Autowired
	public CurrentCountServiceImpl(CurrentCountDao currentCountDao) {
		this.currentCountDao = currentCountDao;
	}

	@Override
	public List<ApiTagInfoVO> currentCount(ApiTagInfoVO param) {
		return currentCountDao.currentCount(param);
	}

	@Override
	public List<ApiTagInfoVO> chkLocationInfo(ApiTagInfoVO param) {
		return currentCountDao.chkLocationInfo(param);
	}

}
