package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.tagCountVO;
import com.example.demo.dto.tagSearchVO;
import com.example.demo.service.TagCountService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@CrossOrigin("*")
public class indexController {

	private TagCountService tagCountService;

	@Autowired
	public indexController(TagCountService tagCountService) {
		this.tagCountService = tagCountService;
	}

	@Autowired
	private ObjectMapper mapper;

	@RequestMapping("/")
	public String index() {
		return "main";
	}

	@RequestMapping("/dashboard")
	public String dashboard() {
		return "index";
	}

	@RequestMapping("/individual_search")
	public String individual_search() {
		return "individual_search";
	}

	@RequestMapping("/group_search")
	public String group_search() {
		return "group_search";
	}

	@RequestMapping("/item_regist")
	public String item_regist() {
		return "item_regist";
	}

	@RequestMapping("/item_regist_history")
	public String item_regist_history() {
		return "item_regist_history";
	}

	@GetMapping(value = "/getCurrentCount", produces = "application/json")
	public @ResponseBody List<tagCountVO> getCurrentCount() {
		return tagCountService.getCurrentCount();
	}

	@GetMapping(value = "/getPortNo", produces = "application/json")
	public @ResponseBody String getPortNo(

			@RequestParam(value = "location", defaultValue = "") int location) {

		tagCountVO param = new tagCountVO();
		param.setLocation(location);

		List<tagCountVO> portNo = tagCountService.getPortNo(param);

		String result = "";
		try {
			result = mapper.writeValueAsString(portNo);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return result;
	}

	@GetMapping(value = "/getCodeSearch", produces = "application/json")
	public @ResponseBody String getCodeSearch(
			@RequestParam(value = "searchCode", defaultValue = "") String searchCode) {

		tagSearchVO param = new tagSearchVO();
		param.setSearchCode(searchCode);
		
		System.out.println(searchCode);

		List<tagSearchVO> tagSearchList = tagCountService.getCodeSearch(param);

		String result = "";
		try {
			result = mapper.writeValueAsString(tagSearchList);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return result;
	}

	@GetMapping(value = "/getItemSearch", produces = "application/json")
	public @ResponseBody String getItemSearch(
			@RequestParam(value = "searchCodeArr[]", defaultValue = "") List<String> searchCodeArr,
			@RequestParam(value = "inputStartDate", required = false, defaultValue = "") String inputStartDate,
			@RequestParam(value = "inputLastDate", required = false, defaultValue = "") String inputLastDate) {

		tagSearchVO param = new tagSearchVO();
		param.setSearchCodeArr(searchCodeArr);
		param.setInputStartDate(inputStartDate);
		param.setInputLastDate(inputLastDate);

		System.out.println(searchCodeArr);
		System.out.println(inputStartDate);
		System.out.println(inputLastDate);

		List<tagSearchVO> tagSearchList = tagCountService.getItemSearch(param);

		String result = "";
		try {
			result = mapper.writeValueAsString(tagSearchList);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return result;
	}
	

	@GetMapping(value = "/getCheckRowTag", produces = "application/json")
	public @ResponseBody String getCheckRowTag(
			@RequestParam(value = "chkRowTagArr[]", defaultValue = "") List<String> chkRowTagArr) {

		tagSearchVO param = new tagSearchVO();
		param.setChkRowTagArr(chkRowTagArr);

		System.out.println(chkRowTagArr);

		List<tagSearchVO> chkRowTagList = tagCountService.getCheckRowTag(param);

		String result = "";
		try {
			result = mapper.writeValueAsString(chkRowTagList);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return result;
	}

	@GetMapping(value = "/getSelectCabinet", produces = "application/json")
	public @ResponseBody String getSelectCabinet(
			@RequestParam(value = "sendData[]", defaultValue = "") List<String> sendData){

		tagSearchVO param = new tagSearchVO();
		param.setSendData(sendData);

		System.out.println(sendData);

		List<tagSearchVO> selectCabinetList = tagCountService.getSelectCabinet(param);

		String result = "";
		
		if(selectCabinetList==null) {
			result = "no_data";
		}
		
		try {
			result = mapper.writeValueAsString(selectCabinetList);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return result;
	}

	@GetMapping(value = "/getInputHistory", produces = "application/json")
	public @ResponseBody List<tagCountVO> getInputHistory() {
		return tagCountService.getInputHistory();
	}

	@GetMapping(value = "/getOutputHistory", produces = "application/json")
	public @ResponseBody List<tagCountVO> getOutputHistory() {
		return tagCountService.getOutputHistory();
	}

}
