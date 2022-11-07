package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.ApiItemTagInfoParam;
import com.example.demo.dto.GetSearchTagVO;

@Repository
@Mapper
public interface ItemTagDao {

	public void regTag(ApiItemTagInfoParam param);

	public void updateTag(ApiItemTagInfoParam param);

	public void deleteTag(ApiItemTagInfoParam param);

	public List<GetSearchTagVO> getSearchTag(ApiItemTagInfoParam param);

}
