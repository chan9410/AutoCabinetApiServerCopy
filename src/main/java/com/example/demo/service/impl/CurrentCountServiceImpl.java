package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CurrentCountDao;
import com.example.demo.dto.ApiItemTagInfoParam;
import com.example.demo.dto.ApiSearchTagInfoVO;
import com.example.demo.dto.ApiTagCountVO;
import com.example.demo.dto.ApiTagInfoParam;
import com.example.demo.dto.CurrentCountSearchTagVO;
import com.example.demo.service.CurrentCountService;

@Service
public class CurrentCountServiceImpl implements CurrentCountService {

	private CurrentCountDao currentCountDao;

	@Autowired
	public CurrentCountServiceImpl(CurrentCountDao currentCountDao) {
		this.currentCountDao = currentCountDao;
	}

	@Override
	public String chkDeviceId(ApiTagInfoParam param) {

		return currentCountDao.chkDeviceId(param);
	}

	@Override
	public List<ApiTagCountVO> currentCount(ApiTagInfoParam param) {
		return currentCountDao.currentCount(param);
	}

	@Override
	public ApiSearchTagInfoVO chkLocationInfo(ApiTagInfoParam param) {
		return currentCountDao.chkLocationInfo(param);
	}

	@Override
	public List<CurrentCountSearchTagVO> getCurrentCountSearch(ApiItemTagInfoParam param) {
		return currentCountDao.getCurrentCountSearch(param);
	}

}
