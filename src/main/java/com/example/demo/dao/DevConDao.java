package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.ApiDeviceControllVO;
import com.example.demo.dto.ApiTagInfoVO;

@Repository
@Mapper
public interface DevConDao {

	public List<ApiDeviceControllVO> getDeviceList();

	public void saveDevice(ApiDeviceControllVO param);

	public void delPerDate(ApiDeviceControllVO param);

	public void delDevice(ApiDeviceControllVO param);

	public int updateDevice(ApiDeviceControllVO param);

	public List<ApiTagInfoVO> getColRowNum(ApiTagInfoVO param);

	public String chkDeviceId(ApiDeviceControllVO param);

}
