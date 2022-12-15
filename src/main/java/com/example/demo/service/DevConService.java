package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ApiChkDevVO;
import com.example.demo.dto.ApiColRowNumVO;
import com.example.demo.dto.ApiDevTotalValueVO;
import com.example.demo.dto.ApiDeviceControllVO;
import com.example.demo.dto.ApiTagInfoParam;
import com.example.demo.dto.SysCodeParam;

public interface DevConService {

	public int updateDevice(ApiDeviceControllVO param);

	public int saveDevice(ApiTagInfoParam param);

	public int deleteDevice(ApiDeviceControllVO param);

	public ApiColRowNumVO getColRowNum(ApiTagInfoParam param);

	public ApiChkDevVO getDeviceInfo(ApiTagInfoParam param);

	public List<ApiDeviceControllVO> getDeviceList();

	public String chkDeviceId(ApiTagInfoParam param);

	public int updateColRowNum(ApiTagInfoParam param);

	public int updateSysCodeValue(SysCodeParam param);

	public List<ApiDevTotalValueVO> getDeviceStateList();

}
