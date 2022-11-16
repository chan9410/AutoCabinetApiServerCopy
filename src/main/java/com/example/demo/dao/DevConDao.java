package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.ApiChkDevVO;
import com.example.demo.dto.ApiColRowNumVO;
import com.example.demo.dto.ApiDeviceControllVO;
import com.example.demo.dto.ApiTagInfoParam;

@Repository
@Mapper
public interface DevConDao {

	public int saveDevice(ApiDeviceControllVO param);

	public int delDevice(ApiDeviceControllVO param);

	public int updateDevice(ApiDeviceControllVO param);

	public ApiColRowNumVO getColRowNum(ApiTagInfoParam param);

	public ApiChkDevVO chkDevInfo(ApiTagInfoParam param);

	public List<ApiDeviceControllVO> getDeviceList();

	public String chkDeviceId(ApiDeviceControllVO param);

	public String chkDeviceId(ApiTagInfoParam param);

	public int updateColRowNum(ApiTagInfoParam param);

}
