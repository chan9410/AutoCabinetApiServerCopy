package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.tagCountVO;
import com.example.demo.dto.tagSearchVO;

@Repository
@Mapper
public interface TagCountDao {

	public List<tagCountVO> getCurrentCount();

	public List<tagCountVO> getPortNo(tagCountVO param);

	public List<tagSearchVO> getCodeSearch(tagSearchVO param);

	public List<tagSearchVO> getItemSearch(tagSearchVO param);
	
	public List<tagSearchVO> getCheckRowTag(tagSearchVO param);

	public List<tagSearchVO> getSelectCabinet(tagSearchVO param);

	public List<tagCountVO> getInputHistory();

	public List<tagCountVO> getOutputHistory();

}
