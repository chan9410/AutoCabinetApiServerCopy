package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ApiItemTagInfoVO;

public interface IOHistoryService {

	public List<ApiItemTagInfoVO> inputHistorySearch(ApiItemTagInfoVO param);

	public List<ApiItemTagInfoVO> outputHistorySearch(ApiItemTagInfoVO param);

}
