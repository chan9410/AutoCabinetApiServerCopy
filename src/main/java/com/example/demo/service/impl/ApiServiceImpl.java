package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.ApiDao;
import com.example.demo.dto.ApiDeviceControllVO;
import com.example.demo.dto.ApiItemTagInfoVO;
import com.example.demo.dto.ApiTagInfoVO;
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

	@Override
	public List<ApiTagInfoVO> currentCount(ApiTagInfoVO param) {
		return apiDao.currentCount(param);
	}

	@Override
	public List<ApiTagInfoVO> chkLocationInfo(ApiTagInfoVO param) {
		return apiDao.chkLocationInfo(param);
	}

	@Override
	public Boolean saveDevice(ApiDeviceControllVO param) {
		Boolean result;
		try {
			apiDao.saveDevice(param);
			result = true;
		} catch (Exception e) {
			result = false;
		}

		return result;
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public Boolean delDevice(ApiDeviceControllVO param) {
		Boolean result;
		String chkDevId = apiDao.chkDeviceId(param);
		System.out.println(chkDevId);

		if (chkDevId == null) {
			return false;
		} else {
			try {
				apiDao.delPerDate(param);
				apiDao.delDevice(param);
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
		return apiDao.updateDevice(param);
	}

	@Override
	public ApiTagInfoVO getColRowNum(ApiTagInfoVO param) {
		return apiDao.getColRowNum(param);
	}

	@Override
	public List<ApiItemTagInfoVO> getSearchTag(ApiItemTagInfoVO param) {
		return apiDao.getSearchTag(param);
	}

	@Override
	public Boolean regTag(ApiItemTagInfoVO param) {
		Boolean result;
		try {
			apiDao.regTag(param);
			result = true;
		} catch (Exception e) {
			result = false;
		}

		return result;
	}

	@Override
	public Boolean updateTag(ApiItemTagInfoVO param) {
		Boolean result;
		try {
			apiDao.updateTag(param);
			result = true;
		} catch (Exception e) {
			result = false;
		}

		return result;
	}

	@Override
	public Boolean deleteTag(ApiItemTagInfoVO param) {
		Boolean result;
		try {
			apiDao.deleteTag(param);
			result = true;
		} catch (Exception e) {
			result = false;
		}

		return result;
	}

	@Override
	public List<ApiItemTagInfoVO> inputHistorySearch(ApiItemTagInfoVO param) {
		return apiDao.inputHistorySearch(param);
	}

	@Override
	public List<ApiItemTagInfoVO> outputHistorySearch(ApiItemTagInfoVO param) {
		return apiDao.outputHistorySearch(param);
	}

}
