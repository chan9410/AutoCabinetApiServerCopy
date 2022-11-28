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

		SUCCESS(200, "성공했습니다."), NO_DEVICE(400, "디바이스가 없습니다."), NO_DATA(404, "API 결과가 없습니다."), NO_TAG(400, "태그가 없습니다."),
		EXIST_DEV(401, "Device가 존재합니다."), EXIST_TAG(401, "Tag가 존재합니다."), EXIST_ITEM_CODE(401, "존재하는 ITEM CODE입니다."),
		LOGIN_SUCCESS(200, "로그인에 성공하였습니다."), LOGIN_FAIL(400, "로그인에 실패하였습니다."), LOGOUT_SUCCESS(200, "로그아웃에 성공하였습니다."),
		SESSION_NULL(400, "Session이 Null 값입니다."), SHA_NULL(400, "PW를 SHA256화하는데 실패하였습니다."),
		USER_ID_NULL(400, "User ID가 Null 값입니다."), USER_PW_NULL(400, "User PW가 Null 값입니다.");

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
		case (201):
			singleResult.setData(data);
			setLoginSuccess(singleResult);
			System.out.println("LOGIN SUCCESS");
			return singleResult;
		case (202):
			singleResult.setData(data);
			setLogoutSuccess(singleResult);
			System.out.println("LOGOUT SUCCESS");
			return singleResult;
		case (106):
			data = null;
			setLoginFail(singleResult);
			System.out.println("LOGIN FAIL");
			return singleResult;
		case (107):
			data = null;
			setSessionNull(singleResult);
			System.out.println("SESSION IS NULL");
			return singleResult;
		case (108):
			data = null;
			setSHAFail(singleResult);
			System.out.println("PW Fails to SHA256");
			return singleResult;
		case (109):
			data = null;
			setUserIdNull(singleResult);
			System.out.println("ID IS NULL");
			return singleResult;
		case (110):
			data = null;
			setUserPWNull(singleResult);
			System.out.println("PW IS NULL");
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
		result.setCode(CommonResponse.NO_DEVICE.getCode());
		result.setMessage(CommonResponse.NO_DEVICE.getMessage());
	}

	private void setNoData(CommonResult result) {
		result.setCode(CommonResponse.NO_DATA.getCode());
		result.setMessage(CommonResponse.NO_DATA.getMessage());
	}

	private void setExistDev(CommonResult result) {
		result.setCode(CommonResponse.EXIST_DEV.getCode());
		result.setMessage(CommonResponse.EXIST_DEV.getMessage());
	}

	private void setNoTag(CommonResult result) {
		result.setCode(CommonResponse.NO_TAG.getCode());
		result.setMessage(CommonResponse.NO_TAG.getMessage());
	}

	private void setExistTag(CommonResult result) {
		result.setCode(CommonResponse.EXIST_TAG.getCode());
		result.setMessage(CommonResponse.EXIST_TAG.getMessage());
	}

	private void setExistItemCode(CommonResult result) {
		result.setCode(CommonResponse.EXIST_ITEM_CODE.getCode());
		result.setMessage(CommonResponse.EXIST_ITEM_CODE.getMessage());
	}

	private void setLoginSuccess(CommonResult result) {
		result.setCode(CommonResponse.LOGIN_SUCCESS.getCode());
		result.setMessage(CommonResponse.LOGIN_SUCCESS.getMessage());
	}

	private void setLogoutSuccess(CommonResult result) {
		result.setCode(CommonResponse.LOGOUT_SUCCESS.getCode());
		result.setMessage(CommonResponse.LOGOUT_SUCCESS.getMessage());
	}

	private void setLoginFail(CommonResult result) {
		result.setCode(CommonResponse.LOGIN_FAIL.getCode());
		result.setMessage(CommonResponse.LOGIN_FAIL.getMessage());
	}

	private void setSessionNull(CommonResult result) {
		result.setCode(CommonResponse.SESSION_NULL.getCode());
		result.setMessage(CommonResponse.SESSION_NULL.getMessage());
	}

	private void setSHAFail(CommonResult result) {
		result.setCode(CommonResponse.SHA_NULL.getCode());
		result.setMessage(CommonResponse.SHA_NULL.getMessage());
	}

	private void setUserIdNull(CommonResult result) {
		result.setCode(CommonResponse.USER_ID_NULL.getCode());
		result.setMessage(CommonResponse.USER_ID_NULL.getMessage());
	}

	private void setUserPWNull(CommonResult result) {
		result.setCode(CommonResponse.USER_PW_NULL.getCode());
		result.setMessage(CommonResponse.USER_PW_NULL.getMessage());
	}

}
