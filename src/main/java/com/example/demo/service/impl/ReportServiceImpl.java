package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ReportDao;
import com.example.demo.dto.ReportCountsInfoParam;
import com.example.demo.dto.ReportCountsInfoVO;
import com.example.demo.dto.ReportTotalCountsParam;
import com.example.demo.dto.TotalTagCountOfCompVO;
import com.example.demo.dto.tagSearchVO;
import com.example.demo.service.ReportService;

@Service
public class ReportServiceImpl implements ReportService{
	private ReportDao reportDao;
	
	@Autowired
	public ReportServiceImpl(ReportDao reportDao) {
		this.reportDao = reportDao;
	}
	
	@Override
	public List<TotalTagCountOfCompVO> getTotalTagCountPerDayOfComp(ReportTotalCountsParam param){
		return reportDao.getTotalTagCountPerDayOfComp(param);
	}
	
	@Override
	public List<ReportCountsInfoVO> getReportCountsInfo(ReportCountsInfoParam param){
		return reportDao.getReportCountsInfo(param);
	}
	
	@Override
	public List<String> getReportDeviceListOfComp(String compId){
		return reportDao.getReportDeviceListOfComp(compId);
	}
	
	@Override
	public List<tagSearchVO> getWorkerSearch(tagSearchVO param) {
		return reportDao.getWorkerSearch(param);
	}
}
