package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.tagCountVO;
import com.example.demo.dto.tagSearchVO;

public interface TagCountService {

	public List<tagCountVO> getCurrentCount();

	public List<tagCountVO> getPortNo(tagCountVO param);

	public List<tagSearchVO> getCodeSearch(tagSearchVO param);

	public List<tagSearchVO> getItemSearch(tagSearchVO param);
	
	public List<tagSearchVO> getCheckRowTag(tagSearchVO param);

	public List<tagSearchVO> getSelectCabinet(tagSearchVO param);

	public List<tagCountVO> getInputHistory();

	public List<tagCountVO> getOutputHistory();

}
