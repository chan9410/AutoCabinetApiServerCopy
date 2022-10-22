package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.ApiVO;

@Repository
@Mapper
public interface ApiDao {

	public List<ApiVO> getDeviceList();

	public List<ApiVO> currentCount(ApiVO param);

}
