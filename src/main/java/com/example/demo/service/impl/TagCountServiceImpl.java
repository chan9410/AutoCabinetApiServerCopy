package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.TagCountDao;
import com.example.demo.dto.tagCountVO;
import com.example.demo.dto.tagSearchVO;
import com.example.demo.service.TagCountService;

@Service
public class TagCountServiceImpl implements TagCountService {

	private TagCountDao tagCountDao;

	@Autowired
	public TagCountServiceImpl(TagCountDao tagCountDao) {
		this.tagCountDao = tagCountDao;
	}

	@Override
	public List<tagCountVO> getCurrentCount() {
		return tagCountDao.getCurrentCount();
	}

	@Override
	public List<tagCountVO> getPortNo(tagCountVO param) {
		return tagCountDao.getPortNo(param);
	}

	@Override
	public List<tagSearchVO> getCodeSearch(tagSearchVO param) {
		return tagCountDao.getCodeSearch(param);
	}

	@Override
	public List<tagSearchVO> getItemSearch(tagSearchVO param) {
		return tagCountDao.getItemSearch(param);
	}

	@Override
	public List<tagSearchVO> getCheckRowTag(tagSearchVO param) {
		return tagCountDao.getCheckRowTag(param);
	}

	@Override
	public List<tagSearchVO> getSelectCabinet(tagSearchVO param) {
		return tagCountDao.getSelectCabinet(param);
	}

	@Override
	public List<tagCountVO> getInputHistory() {
		return tagCountDao.getInputHistory();
	}

	@Override
	public List<tagCountVO> getOutputHistory() {
		return tagCountDao.getOutputHistory();
	}

}
