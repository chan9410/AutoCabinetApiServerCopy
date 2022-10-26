package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ApiColRowNumVO;
import com.example.demo.dto.ApiDeviceControllVO;
import com.example.demo.dto.ApiTagCountVO;
import com.example.demo.dto.ApiTagRegVO;
import com.example.demo.dto.ListResult;
import com.example.demo.dto.SingleResult;
import com.example.demo.dto.tagSearchVO;

public interface ApiService {

	public List<ApiDeviceControllVO> getDeviceList();

	public List<ApiTagCountVO> currentCount(ApiTagCountVO param);

	public int updateDevice(ApiDeviceControllVO param);

	public List<tagSearchVO> searchCode(tagSearchVO param);

	public Boolean saveDevice(ApiDeviceControllVO param);

	public Boolean delDevice(ApiDeviceControllVO param);

	public Boolean regTag(ApiTagRegVO param);

	public ApiColRowNumVO getColRowNum(ApiColRowNumVO param);

	public <T> SingleResult<T> getSingleResult(T data);

	public <T> ListResult<T> getListResult(List<T> dataList);

}
