package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.ApiItemTagInfoParam;
import com.example.demo.dto.IOHistotyVO;

@Repository
@Mapper
public interface IOHistoryDao {

	public List<IOHistotyVO> inputHistorySearch(ApiItemTagInfoParam param);

	public List<IOHistotyVO> outputHistorySearch(ApiItemTagInfoParam param);

	public List<IOHistotyVO> getIOHistory(ApiItemTagInfoParam param);

	public List<String> chkDevIdArr(ApiItemTagInfoParam param);

}
