package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.ApiChkDevVO;
import com.example.demo.dto.ApiColRowNumVO;
import com.example.demo.dto.ApiDeviceControllVO;
import com.example.demo.dto.ApiTagInfoParam;

@Repository
@Mapper
public interface DevConDao {

	public void saveDevice(ApiDeviceControllVO param);

	public void delDevice(ApiDeviceControllVO param);

	public int updateDevice(ApiDeviceControllVO param);

	public ApiColRowNumVO getColRowNum(ApiTagInfoParam param);

	public ApiChkDevVO chkDevInfo(ApiTagInfoParam param);

	public String chkDeviceId(ApiDeviceControllVO param);

	public String chkDeviceId(ApiTagInfoParam param);

}
