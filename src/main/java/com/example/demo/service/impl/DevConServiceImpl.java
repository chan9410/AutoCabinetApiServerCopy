package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.DevConDao;
import com.example.demo.dto.ApiChkDevVO;
import com.example.demo.dto.ApiColRowNumVO;
import com.example.demo.dto.ApiDevTotalValueVO;
import com.example.demo.dto.ApiDeviceControllVO;
import com.example.demo.dto.ApiTagInfoParam;
import com.example.demo.dto.SysCodeParam;
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
	public int saveDevice(ApiTagInfoParam param) {

		String chkDevId = devConDao.chkDeviceId(param);

		String chkDeviceYN = devConDao.chkDeviceYN(param);

		if (chkDevId != null) {
			return 102;
		} else if (chkDeviceYN != null) {
			try {
				devConDao.recycleDevId(param);
				devConDao.saveDeviceState(param);
				return 200;
			} catch (Exception e) {
				return 101;
			}
		} else {
			try {
				devConDao.saveDevice(param);
				devConDao.saveDeviceState(param);
				return 200;
			} catch (Exception e) {
				return 101;
			}
		}

	}

	@Override
	public int delDevice(ApiDeviceControllVO param) {

		String chkDevId = devConDao.chkDeviceId(param);

		if (chkDevId == null) {
			return 100;
		} else {
			try {
				devConDao.delDeviceState(param);
				devConDao.delDevice(param);
				return 200;
			} catch (Exception e) {
				return 101;
			}
		}
	}

	@Override
	public int updateDevice(ApiDeviceControllVO param) {

		String chkDevId = devConDao.chkDeviceId(param);

		int result = devConDao.updateDevice(param);

		if (chkDevId == null) {
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
			return 100;
		} else if (result == 0) {
			return 101;
		} else {
			return 200;
		}

	}

	@Override
	public int updateSysCode(SysCodeParam param) {

		String chkCodeName = devConDao.chkCodeName(param);

		int statusCode;
		int result = devConDao.updateSysCode(param);

		if (chkCodeName == null) {
			statusCode = 110;
		} else if (result == 0) {
			statusCode = 101;
		} else {
			statusCode = 200;
		}

		return statusCode;
	}

	@Override
	public List<ApiDevTotalValueVO> getDevTotalValueList() {
		return devConDao.getDevTotalValueList();
	}

}
