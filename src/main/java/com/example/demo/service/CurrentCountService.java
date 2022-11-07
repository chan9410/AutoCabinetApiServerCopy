package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ApiItemTagInfoParam;
import com.example.demo.dto.ApiSearchTagInfoVO;
import com.example.demo.dto.ApiTagCountVO;
import com.example.demo.dto.ApiTagInfoParam;
import com.example.demo.dto.CurrentCountSearchTagVO;

public interface CurrentCountService {

	public List<ApiTagCountVO> currentCount(ApiTagInfoParam param);

	public ApiSearchTagInfoVO chkLocationInfo(ApiTagInfoParam param);

	public List<CurrentCountSearchTagVO> getCurrentCountSearch(ApiItemTagInfoParam param);

}
