package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ItemTagDao;
import com.example.demo.dto.ApiItemTagInfoParam;
import com.example.demo.dto.GetSearchTagVO;
import com.example.demo.service.ItemTagService;

@Service
public class ItemTagServiceImpl implements ItemTagService {

	private ItemTagDao itemTagDao;

	@Autowired
	public ItemTagServiceImpl(ItemTagDao itemTagDao) {
		this.itemTagDao = itemTagDao;
	}

	@Override
	public List<GetSearchTagVO> getSearchTag(ApiItemTagInfoParam param) {
		return itemTagDao.getSearchTag(param);
	}

	@Override
	public Boolean regTag(ApiItemTagInfoParam param) {
		Boolean result;
		try {
			itemTagDao.regTag(param);
			result = true;
		} catch (Exception e) {
			result = false;
		}

		return result;
	}

	@Override
	public Boolean updateTag(ApiItemTagInfoParam param) {
		Boolean result;
		try {
			itemTagDao.updateTag(param);
			result = true;
		} catch (Exception e) {
			result = false;
		}

		return result;
	}

	@Override
	public Boolean deleteTag(ApiItemTagInfoParam param) {
		Boolean result;
		try {
			itemTagDao.deleteTag(param);
			result = true;
		} catch (Exception e) {
			result = false;
		}

		return result;
	}

}
