package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.ApiTagInfoVO;

@Repository
@Mapper
public interface CurrentCountDao {

	public List<ApiTagInfoVO> currentCount(ApiTagInfoVO param);

	public List<ApiTagInfoVO> chkLocationInfo(ApiTagInfoVO param);

}
