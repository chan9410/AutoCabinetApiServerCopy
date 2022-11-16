package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ApiChkDevVO;
import com.example.demo.dto.ApiColRowNumVO;
import com.example.demo.dto.ApiDeviceControllVO;
import com.example.demo.dto.ApiTagInfoParam;

public interface DevConService {

	public int updateDevice(ApiDeviceControllVO param);

	public int saveDevice(ApiDeviceControllVO param);

	public int delDevice(ApiDeviceControllVO param);

	public ApiColRowNumVO getColRowNum(ApiTagInfoParam param);

	public ApiChkDevVO chkDevInfo(ApiTagInfoParam param);

	public List<ApiDeviceControllVO> getDeviceList();

	public String chkDeviceId(ApiTagInfoParam param);

	public int updateColRowNum(ApiTagInfoParam param);

}
