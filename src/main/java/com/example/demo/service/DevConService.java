package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ApiDeviceControllVO;
import com.example.demo.dto.ApiTagInfoVO;

public interface DevConService {

	public List<ApiDeviceControllVO> getDeviceList();

	public int updateDevice(ApiDeviceControllVO param);

	public Boolean saveDevice(ApiDeviceControllVO param);

	public Boolean delDevice(ApiDeviceControllVO param);

	public List<ApiTagInfoVO> getColRowNum(ApiTagInfoVO param);

}
