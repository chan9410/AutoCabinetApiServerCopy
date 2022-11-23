package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ApiItemTagInfoParam;
import com.example.demo.dto.GetSearchTagVO;

public interface ItemTagService {

	public int saveTag(ApiItemTagInfoParam param);

	public int updateTag(ApiItemTagInfoParam param);

	public int deleteTag(ApiItemTagInfoParam param);

	public List<String> chkItemCodeArr(ApiItemTagInfoParam param);

	public List<GetSearchTagVO> getSearchTag(ApiItemTagInfoParam param);

}
