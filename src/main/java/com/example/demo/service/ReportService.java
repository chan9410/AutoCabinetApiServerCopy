package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ReportCountsInfoParam;
import com.example.demo.dto.ReportCountsInfoVO;
import com.example.demo.dto.ReportTotalCountsParam;
import com.example.demo.dto.TotalTagCountOfCompVO;
import com.example.demo.dto.tagSearchVO;

public interface ReportService {
	public List<TotalTagCountOfCompVO> getTotalTagCountPerDayOfComp(ReportTotalCountsParam param);
	
	public List<ReportCountsInfoVO> getReportCountsInfo(ReportCountsInfoParam param);

	public List<String> getReportDeviceListOfComp(String compId);
	
	public List<tagSearchVO> getWorkerSearch(tagSearchVO param);

}
