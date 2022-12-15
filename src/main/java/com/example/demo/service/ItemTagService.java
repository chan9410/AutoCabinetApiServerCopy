package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ApiItemTagInfoParam;
import com.example.demo.dto.ExcelData;
import com.example.demo.dto.GetSearchTagVO;
import com.example.demo.dto.GetTagVO;

public interface ItemTagService {

	public int saveTag(ApiItemTagInfoParam param);

	public int updateTag(ApiItemTagInfoParam param);

	public int deleteTag(ApiItemTagInfoParam param);

	public List<String> chkItemCodeArr(ApiItemTagInfoParam param);

	public List<GetSearchTagVO> getTagInfo(ApiItemTagInfoParam param);

	public List<GetTagVO> getTag();

	public int saveItemExcel(List<ExcelData> dataList);

	public List<ExcelData> chkExcelTagArr(List<ExcelData> dataList);

	public List<ExcelData> chkExcelItemCodeArr(List<ExcelData> dataList);

}
