package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.DevConDao;
import com.example.demo.dto.ApiDeviceControllVO;
import com.example.demo.dto.ApiTagInfoVO;
import com.example.demo.service.DevConService;

@Service
public class DevConServiceImpl implements DevConService {

	private DevConDao devConDao;

	@Autowired
	public DevConServiceImpl(DevConDao devConDao) {
		this.devConDao = devConDao;
	}

	@Override
	public Boolean saveDevice(ApiDeviceControllVO param) {
		Boolean result;
		try {
			devConDao.saveDevice(param);
			result = true;
		} catch (Exception e) {
			result = false;
		}

		return result;
	}

	// 트랜젝션 지금 작동 X.
	@Override
	@Transactional(rollbackFor = { Exception.class })
	public Boolean delDevice(ApiDeviceControllVO param) {
		Boolean result;
		String chkDevId = devConDao.chkDeviceId(param);
		System.out.println(chkDevId);

		if (chkDevId == null) {
			return false;
		} else {
			try {
				devConDao.delPerDate(param);
				devConDao.delDevice(param);
				result = true;
			} catch (RuntimeException e) {
				// System.out.println(e);
				result = false;
			}

			return result;
		}
	}

	@Override
	public int updateDevice(ApiDeviceControllVO param) {
		return devConDao.updateDevice(param);
	}

	@Override
	public List<ApiTagInfoVO> getColRowNum(ApiTagInfoVO param) {
		return devConDao.getColRowNum(param);
	}

	@Override
	public List<ApiDeviceControllVO> getDeviceList() {

		return devConDao.getDeviceList();
	}

}
