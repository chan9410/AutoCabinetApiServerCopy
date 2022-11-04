package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ApiTagInfoVO;

public interface CurrentCountService {

	public List<ApiTagInfoVO> currentCount(ApiTagInfoVO param);

	public List<ApiTagInfoVO> chkLocationInfo(ApiTagInfoVO param);

}
