package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.DevConDao;
import com.example.demo.dto.ApiChkDevVO;
import com.example.demo.dto.ApiColRowNumVO;
import com.example.demo.dto.ApiDeviceControllVO;
import com.example.demo.dto.ApiTagInfoParam;
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

	@Override
	public Boolean delDevice(ApiDeviceControllVO param) {
		Boolean result;
		String chkDevId = devConDao.chkDeviceId(param);
		System.out.println(chkDevId);

		if (chkDevId == null) {
			System.out.println("No DeviceId");
			return false;
		} else {
			try {
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

		String chkDevId = devConDao.chkDeviceId(param);

		if (chkDevId == null) {
			System.out.println("No DeviceId");
			return 100;
		} else {
			return devConDao.updateDevice(param);
		}
	}

	@Override
	public ApiColRowNumVO getColRowNum(ApiTagInfoParam param) {

		String chkDevId = devConDao.chkDeviceId(param);

		if (chkDevId == null) {
			System.out.println("No DeviceId");
			return null;
		} else {
			return devConDao.getColRowNum(param);
		}
	}

	@Override
	public ApiChkDevVO chkDevInfo(ApiTagInfoParam param) {

		String chkDevId = devConDao.chkDeviceId(param);

		if (chkDevId == null) {
			System.out.println("No DeviceId");
			return null;
		} else {
			return devConDao.chkDevInfo(param);
		}
	}

}
