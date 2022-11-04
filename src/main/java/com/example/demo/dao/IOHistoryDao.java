package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.ApiItemTagInfoVO;

@Repository
@Mapper
public interface IOHistoryDao {

	public List<ApiItemTagInfoVO> inputHistorySearch(ApiItemTagInfoVO param);

	public List<ApiItemTagInfoVO> outputHistorySearch(ApiItemTagInfoVO param);

}
