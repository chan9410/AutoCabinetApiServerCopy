package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.CommonResult;
import com.example.demo.dto.ListResult;
import com.example.demo.dto.ReSingleResult;
import com.example.demo.dto.SingleResult;
import com.example.demo.service.ApiService;

@Service
public class ApiServiceImpl implements ApiService {

	public enum CommonResponse {

		SUCCESS(200, "성공했습니다."), NODEVICE(400, "디바이스가 없습니다."), NODATA(404, "API 결과가 없습니다."), NOTAG(400, "태그가 없습니다."),
		EXISTDEV(401, "Device가 존재합니다."), EXISTTAG(401, "Tag가 존재합니다."), EXISTITEMCODE(401, "존재하는 ITEM CODE입니다."),
		EXISTDEVID(401, "Device Id가 존재합니다."), ERROR(500, "알 수 없는 에러 발생");

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
	public <T> ReSingleResult<T> getSingleResult(T data, int statusCode) {
		ReSingleResult<T> singleResult = new ReSingleResult<>();

		switch (statusCode) {
		case (200):
			singleResult.setData(data);
			setSuccessResult(singleResult);
			System.out.println("SUCCESS");
			return singleResult;
		case (100):
			setNoDev(singleResult);
			System.out.println("NO DEVICE");
			return singleResult;
		case (101):
			setNoData(singleResult);
			System.out.println("NO RESULT");
			return singleResult;
		}
		return singleResult;
	}

	@Override
	public <T> SingleResult<T> getSingleResult(Integer data) {
		SingleResult<T> singleResult = new SingleResult<>();

		switch (data) {
		case (200):
			singleResult.setData(data);
			setSuccessResult(singleResult);
			System.out.println("SUCCESS");
			return singleResult;
		case (100):
			data = null;
			setNoDev(singleResult);
			System.out.println("NO DEVICE");
			return singleResult;
		case (101):
			data = null;
			setNoData(singleResult);
			System.out.println("NO RESULT");
			return singleResult;
		case (102):
			data = null;
			setExistDev(singleResult);
			System.out.println("EXIST DEVICE");
			return singleResult;
		case (103):
			data = null;
			setNoTag(singleResult);
			System.out.println("NO TAG");
			return singleResult;
		case (104):
			data = null;
			setExistTag(singleResult);
			System.out.println("EXIST TAG");
			return singleResult;
		case (105):
			data = null;
			setExistItemCode(singleResult);
			System.out.println("EXIST ITEM CODE");
			return singleResult;
		case (500):
			data = null;
			setError(singleResult);
			System.out.println("ERROR");
			return singleResult;
		}
		return singleResult;
	}

	// 다중 데이터 조회 결과를 처리하는 메소드
	@Override
	public <T> ListResult<T> getListResult(List<T> dataList, int statusCode) {
		ListResult<T> listResult = new ListResult<>();

		switch (statusCode) {
		case (200):
			listResult.setDataList(dataList);
			setSuccessResult(listResult);
			System.out.println("SUCCESS");
			return listResult;
		case (100):
			setNoDev(listResult);
			System.out.println("NO DEVICE");
			return listResult;
		case (101):
			setNoData(listResult);
			System.out.println("NO RESULT");
			return listResult;
		case (103):
			setNoTag(listResult);
			System.out.println("NO TAG");
			return listResult;

		}
		return listResult;
	}

	private void setSuccessResult(CommonResult result) {
		result.setCode(CommonResponse.SUCCESS.getCode());
		result.setMessage(CommonResponse.SUCCESS.getMessage());
	}

	private void setNoDev(CommonResult result) {
		result.setCode(CommonResponse.NODEVICE.getCode());
		result.setMessage(CommonResponse.NODEVICE.getMessage());
	}

	private void setNoData(CommonResult result) {
		result.setCode(CommonResponse.NODATA.getCode());
		result.setMessage(CommonResponse.NODATA.getMessage());
	}

	private void setExistDev(CommonResult result) {
		result.setCode(CommonResponse.EXISTDEV.getCode());
		result.setMessage(CommonResponse.EXISTDEV.getMessage());
	}

	private void setNoTag(CommonResult result) {
		result.setCode(CommonResponse.NOTAG.getCode());
		result.setMessage(CommonResponse.NOTAG.getMessage());
	}

	private void setExistTag(CommonResult result) {
		result.setCode(CommonResponse.EXISTTAG.getCode());
		result.setMessage(CommonResponse.EXISTTAG.getMessage());
	}

	private void setExistItemCode(CommonResult result) {
		result.setCode(CommonResponse.EXISTITEMCODE.getCode());
		result.setMessage(CommonResponse.EXISTITEMCODE.getMessage());
	}

	private void setError(CommonResult result) {
		result.setCode(CommonResponse.ERROR.getCode());
		result.setMessage(CommonResponse.ERROR.getMessage());
	}

}
