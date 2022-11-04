package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ApiDeviceControllVO;
import com.example.demo.dto.ApiItemTagInfoVO;
import com.example.demo.dto.ApiTagInfoVO;
import com.example.demo.dto.ListResult;
import com.example.demo.dto.SingleResult;

public interface ApiService {

	public List<ApiDeviceControllVO> getDeviceList();

	public List<ApiTagInfoVO> currentCount(ApiTagInfoVO param);

	public List<ApiTagInfoVO> chkLocationInfo(ApiTagInfoVO param);

	public int updateDevice(ApiDeviceControllVO param);

	public Boolean saveDevice(ApiDeviceControllVO param);

	public Boolean delDevice(ApiDeviceControllVO param);

	public Boolean regTag(ApiItemTagInfoVO param);

	public Boolean updateTag(ApiItemTagInfoVO param);

	public Boolean deleteTag(ApiItemTagInfoVO param);

	public ApiTagInfoVO getColRowNum(ApiTagInfoVO param);

	public <T> SingleResult<T> getSingleResult(T data);

	public <T> ListResult<T> getListResult(List<T> dataList);

	public List<ApiItemTagInfoVO> getSearchTag(ApiItemTagInfoVO param);

	public List<ApiItemTagInfoVO> inputHistorySearch(ApiItemTagInfoVO param);

	public List<ApiItemTagInfoVO> outputHistorySearch(ApiItemTagInfoVO param);

}
