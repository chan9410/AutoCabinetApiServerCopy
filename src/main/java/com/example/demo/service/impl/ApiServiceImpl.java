package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.ApiDao;
import com.example.demo.dto.ApiColRowNumVO;
import com.example.demo.dto.ApiDeviceControllVO;
import com.example.demo.dto.ApiTagCountVO;
import com.example.demo.dto.ApiTagRegVO;
import com.example.demo.dto.CommonResult;
import com.example.demo.dto.ListResult;
import com.example.demo.dto.SingleResult;
import com.example.demo.dto.tagSearchVO;
import com.example.demo.service.ApiService;

@Service
public class ApiServiceImpl implements ApiService {

	private ApiDao apiDao;

	@Autowired
	public ApiServiceImpl(ApiDao apiDao) {
		this.apiDao = apiDao;
	}

	public enum CommonResponse {
		SUCCESS(0, "성공"), FAIL(-1, "실패");

		int code;
		String message;

		CommonResponse(int code, String message) {
			this.code = code;
			this.message = message;
		}

		public int getCode() {
			return code;
		}

		public String getMessage() {
			return message;
		}
	}

	@Override
	public <T> SingleResult<T> getSingleResult(T data) {
		SingleResult<T> singleResult = new SingleResult<>();
		singleResult.setData(data);
		setSuccessResult(singleResult);
		return singleResult;
	}

	// 다중 데이터 조회 결과를 처리하는 메소드
	@Override
	public <T> ListResult<T> getListResult(List<T> dataList) {
		ListResult<T> listResult = new ListResult<>();
		listResult.setDataList(dataList);
		setSuccessResult(listResult);
		return listResult;
	}

	// 성공 결과만 처리하는 메소드
	public CommonResult getSuccessResult() {
		CommonResult result = new CommonResult();
		setSuccessResult(result);
		return result;
	}

	// 실패 결과만 처리하는 메소드
	public CommonResult getFailResult() {
		CommonResult result = new CommonResult();
		result.setSuccess(false);
		result.setCode(CommonResponse.FAIL.getCode());
		result.setMessage(CommonResponse.FAIL.getMessage());
		return result;
	}

	// 결과 모델에 api 요청 성공 데이터를 세팅해주는 메소드
	private void setSuccessResult(CommonResult reponse) {
		reponse.setSuccess(true);
		reponse.setCode(CommonResponse.SUCCESS.getCode());
		reponse.setMessage(CommonResponse.SUCCESS.getMessage());
	}

	@Override
	public List<ApiDeviceControllVO> getDeviceList() {
		return apiDao.getDeviceList();
		/*
		 * Boolean result; try { result = apiDao.getDeviceList(); } catch (Exception e)
		 * { result = false; } return result;
		 */
	}

	@Override
	public List<ApiTagCountVO> currentCount(ApiTagCountVO param) {
		return apiDao.currentCount(param);
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
	@Transactional(rollbackFor = Exception.class)
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
			} catch (Exception e) {
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
	public List<tagSearchVO> searchCode(tagSearchVO param) {
		return apiDao.searchCode(param);
	}

	@Override
	public ApiColRowNumVO getColRowNum(ApiColRowNumVO param) {
		return apiDao.getColRowNum(param);
	}

	@Override
	public Boolean regTag(ApiTagRegVO param) {
		Boolean result;
		try {
			apiDao.regTag(param);
			result = true;
		} catch (Exception e) {
			result = false;
		}

		return result;
	}

}
