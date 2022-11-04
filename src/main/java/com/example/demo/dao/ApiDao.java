package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.ApiDeviceControllVO;
import com.example.demo.dto.ApiItemTagInfoVO;
import com.example.demo.dto.ApiTagCountVO;
import com.example.demo.dto.ApiTagInfoVO;

@Repository
@Mapper
public interface ApiDao {

	public List<ApiDeviceControllVO> getDeviceList();

	public List<ApiTagInfoVO> currentCount(ApiTagInfoVO param);

	public List<ApiTagInfoVO> chkLocationInfo(ApiTagInfoVO param);

	public void saveDevice(ApiDeviceControllVO param);

	public String chkDeviceId(ApiDeviceControllVO param);

	public String chkDeviceId(ApiTagCountVO param);

	public void delPerDate(ApiDeviceControllVO param);

	public void delDevice(ApiDeviceControllVO param);

	public int updateDevice(ApiDeviceControllVO param);

	public ApiTagInfoVO getColRowNum(ApiTagInfoVO param);

	public void regTag(ApiItemTagInfoVO param);

	public void updateTag(ApiItemTagInfoVO param);

	public void deleteTag(ApiItemTagInfoVO param);

	public List<ApiItemTagInfoVO> getSearchTag(ApiItemTagInfoVO param);

	public List<ApiItemTagInfoVO> inputHistorySearch(ApiItemTagInfoVO param);

	public List<ApiItemTagInfoVO> outputHistorySearch(ApiItemTagInfoVO param);

}
