package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
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
	public String chkDeviceId(ApiTagInfoParam param) {
		return devConDao.chkDeviceId(param);
	}

	@Override
	public int saveDevice(ApiDeviceControllVO param) {

		String chkDevId = devConDao.chkDeviceId(param);

		if (chkDevId != null) {
			System.out.println("No DeviceId");
			return 102;
		} else {

			try {
				devConDao.saveDevice(param);
				return 200;
			} catch (DuplicateKeyException e) {
				return 102;
			}
		}

	}

	@Override
	public int delDevice(ApiDeviceControllVO param) {

		String chkDevId = devConDao.chkDeviceId(param);

		int result = devConDao.delDevice(param);
		System.out.println(result);

		if (chkDevId == null) {
			System.out.println("No DeviceId");
			return 100;
		} else if (result == 0) {
			return 101;
		} else {
			return 200;
		}
	}

	@Override
	public int updateDevice(ApiDeviceControllVO param) {

		String chkDevId = devConDao.chkDeviceId(param);

		int result = devConDao.updateDevice(param);

		if (chkDevId == null) {
			System.out.println("No DeviceId");
			return 100;
		} else if (result == 0) {
			return 101;
		} else {
			return 200;
		}

	}

	@Override
	public ApiColRowNumVO getColRowNum(ApiTagInfoParam param) {
		return devConDao.getColRowNum(param);
	}

	@Override
	public ApiChkDevVO chkDevInfo(ApiTagInfoParam param) {
		return devConDao.chkDevInfo(param);
	}

	@Override
	public List<ApiDeviceControllVO> getDeviceList() {
		return devConDao.getDeviceList();
	}

	@Override
	public int updateColRowNum(ApiTagInfoParam param) {

		String chkDevId = devConDao.chkDeviceId(param);

		int result = devConDao.updateColRowNum(param);

		if (chkDevId == null) {
			System.out.println("No Device");
			return 100;
		} else if (result == 0) {
			return 101;
		} else {
			return 200;
		}

	}

}
