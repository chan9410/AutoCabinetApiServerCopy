package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ApiItemTagInfoVO;

public interface ItemTagService {

	public Boolean regTag(ApiItemTagInfoVO param);

	public Boolean updateTag(ApiItemTagInfoVO param);

	public Boolean deleteTag(ApiItemTagInfoVO param);

	public List<ApiItemTagInfoVO> getSearchTag(ApiItemTagInfoVO param);

}
