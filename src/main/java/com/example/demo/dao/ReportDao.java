package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.ReportCountsInfoParam;
import com.example.demo.dto.ReportCountsInfoVO;
import com.example.demo.dto.ReportTotalCountsParam;
import com.example.demo.dto.TotalTagCountOfCompVO;
import com.example.demo.dto.tagSearchVO;

@Repository
@Mapper
public interface ReportDao {
	public List<TotalTagCountOfCompVO> getTotalTagCountPerDayOfComp(ReportTotalCountsParam param);
	
	public List<ReportCountsInfoVO> getReportCountsInfo(ReportCountsInfoParam param);

	public List<String> getReportDeviceListOfComp(String compId);
	
	public List<tagSearchVO> getWorkerSearch(tagSearchVO param);

}
