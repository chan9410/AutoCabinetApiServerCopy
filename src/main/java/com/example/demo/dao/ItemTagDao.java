package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.ApiItemTagInfoVO;

@Repository
@Mapper
public interface ItemTagDao {

	public void regTag(ApiItemTagInfoVO param);

	public void updateTag(ApiItemTagInfoVO param);

	public void deleteTag(ApiItemTagInfoVO param);

	public List<ApiItemTagInfoVO> getSearchTag(ApiItemTagInfoVO param);

}
