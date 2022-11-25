package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ApiItemTagInfoParam;
import com.example.demo.dto.IOHistotyVO;

public interface IOHistoryService {

	public List<IOHistotyVO> inputHistorySearch(ApiItemTagInfoParam param);

	public List<IOHistotyVO> outputHistorySearch(ApiItemTagInfoParam param);

	public List<IOHistotyVO> IOHistorySearch(ApiItemTagInfoParam param);

}
