package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ApiItemTagInfoParam;
import com.example.demo.dto.GetSearchTagVO;

public interface ItemTagService {

	public Boolean regTag(ApiItemTagInfoParam param);

	public Boolean updateTag(ApiItemTagInfoParam param);

	public Boolean deleteTag(ApiItemTagInfoParam param);

	public List<GetSearchTagVO> getSearchTag(ApiItemTagInfoParam param);

}
