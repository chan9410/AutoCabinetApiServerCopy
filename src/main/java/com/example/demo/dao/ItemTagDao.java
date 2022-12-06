package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.ApiItemTagInfoParam;
import com.example.demo.dto.ExcelData;
import com.example.demo.dto.GetSearchTagVO;
import com.example.demo.dto.GetTagVO;

@Repository
@Mapper
public interface ItemTagDao {

	public int saveTag(ApiItemTagInfoParam param);

	public int updateTag(ApiItemTagInfoParam param);

	public int deleteTag(ApiItemTagInfoParam param);

	public List<GetSearchTagVO> getSearchTag(ApiItemTagInfoParam param);

	public String chkTag(ApiItemTagInfoParam param);

	public String chkItemCode(ApiItemTagInfoParam param);

	public List<String> chkItemCodeArr(ApiItemTagInfoParam param);

	public List<GetTagVO> getTag();

	public int excelUpload(ExcelData data);

	public String chkTag(ExcelData data);

	public String chkItemCode(ExcelData data);

	public void excelUpload(List<ExcelData> dataList);

}
