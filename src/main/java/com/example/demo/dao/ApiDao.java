package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.ApiColRowNumVO;
import com.example.demo.dto.ApiDeviceControllVO;
import com.example.demo.dto.ApiTagCountVO;
import com.example.demo.dto.ApiTagRegVO;
import com.example.demo.dto.tagSearchVO;

@Repository
@Mapper
public interface ApiDao {

	public List<ApiDeviceControllVO> getDeviceList();

	public List<ApiTagCountVO> currentCount(ApiTagCountVO param);

	public void saveDevice(ApiDeviceControllVO param);

	public String chkDeviceId(ApiDeviceControllVO param);

	public String chkDeviceId(ApiTagCountVO param);

	public void delPerDate(ApiDeviceControllVO param);

	public void delDevice(ApiDeviceControllVO param);

	public int updateDevice(ApiDeviceControllVO param);

	public List<tagSearchVO> searchCode(tagSearchVO param);

	public ApiColRowNumVO getColRowNum(ApiColRowNumVO param);

	public void regTag(ApiTagRegVO param);
}
