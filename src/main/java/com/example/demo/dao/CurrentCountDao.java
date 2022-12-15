package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.ApiItemTagInfoParam;
import com.example.demo.dto.ApiSearchTagInfoVO;
import com.example.demo.dto.ApiTagCountVO;
import com.example.demo.dto.ApiTagInfoParam;
import com.example.demo.dto.CurrentCountSearchTagVO;

@Repository
@Mapper
public interface CurrentCountDao {

	public List<ApiTagCountVO> getCurrentStockCount(ApiTagInfoParam param);

	public List<ApiSearchTagInfoVO> getCurrentLocationInfo(ApiTagInfoParam param);

	public List<CurrentCountSearchTagVO> getCurrentStockInfo(ApiItemTagInfoParam param);

	public String chkDeviceId(ApiTagInfoParam param);

	public String chkDeviceId(ApiItemTagInfoParam param);

}
