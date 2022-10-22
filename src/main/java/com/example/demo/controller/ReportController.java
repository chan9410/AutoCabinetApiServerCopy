package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dto.ReportCountsInfoParam;
import com.example.demo.dto.ReportCountsInfoVO;
import com.example.demo.dto.ReportTotalCountsParam;
import com.example.demo.dto.TotalTagCountOfCompVO;
import com.example.demo.dto.tagSearchVO;
import com.example.demo.service.ReportService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@CrossOrigin("*")
@RequestMapping("/report")
public class ReportController {

	private ReportService reportService;

	@Autowired
	public ReportController(ReportService reportService) {
		this.reportService = reportService;
	}

	@Autowired
	private ObjectMapper mapper;

	@RequestMapping("")
	public String reportMainPage() {
		return "/report/reportMain";
	}

	@RequestMapping("/Worker")
	public String reportWorker() {
		return "/report/reportWorker";
	}

	@ResponseBody
	@RequestMapping(value = "/getTotalCountPerDayOfCompId", produces = "application/json")
	public List<TotalTagCountOfCompVO> getTotalCountPerDayOfComp(@RequestBody HashMap<String, Object> map) {
		ReportTotalCountsParam param = new ReportTotalCountsParam();
		
		param.setCompId(map.get("COMP_ID").toString());
		param.setFrom(map.get("FROM").toString());
		param.setTo(map.get("TO").toString());
		
		return reportService.getTotalTagCountPerDayOfComp(param);

	}

	@ResponseBody
	@RequestMapping(value = "/getReportCountsInfo", produces = "application/json")
	public List<ReportCountsInfoVO> getReportCountsInfo(@RequestBody HashMap<String, Object> map) {

		ReportCountsInfoParam param = new ReportCountsInfoParam();
		param.setDeviceId(map.get("DEVICE_ID").toString());
		param.setFrom(map.get("FROM").toString());
		param.setTo(map.get("TO").toString());

		System.out.println(map.get("DEVICE_ID").toString());
		System.out.println(map.get("FROM").toString());
		System.out.println(map.get("TO").toString());

		return reportService.getReportCountsInfo(param);
	}

	@ResponseBody
	@RequestMapping(value = "/getReportDeviceListOfComp", produces = "application/json")
	public List<String> getReportDeviceListOfComp(@RequestBody HashMap<String, Object> map) {

		return reportService.getReportDeviceListOfComp(map.get("COMP_ID").toString());
	}
	
	@GetMapping(value = "/getWorkerSearch", produces = "application/json")
	public @ResponseBody String getWorkerSearch(
			@RequestParam(value = "searchWorker", defaultValue = "") String searchWorker,
			@RequestParam(value = "inputStartDate", required = false, defaultValue = "") String inputStartDate,
			@RequestParam(value = "inputLastDate", required = false, defaultValue = "") String inputLastDate) {

		tagSearchVO param = new tagSearchVO();
		param.setSearchWorker(searchWorker);
		param.setInputStartDate(inputStartDate);
		param.setInputLastDate(inputLastDate);
		
		System.out.println(searchWorker);
		System.out.println(inputStartDate);
		System.out.println(inputLastDate);

		List<tagSearchVO> workerSearchList = reportService.getWorkerSearch(param);

		String result = "";
		try {
			result = mapper.writeValueAsString(workerSearchList);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return result;
	}
	
}