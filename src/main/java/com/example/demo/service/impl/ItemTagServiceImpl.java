package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ItemTagDao;
import com.example.demo.dto.ApiItemTagInfoVO;
import com.example.demo.service.ItemTagService;

@Service
public class ItemTagServiceImpl implements ItemTagService {

	private ItemTagDao itemTagDao;

	@Autowired
	public ItemTagServiceImpl(ItemTagDao itemTagDao) {
		this.itemTagDao = itemTagDao;
	}

	@Override
	public List<ApiItemTagInfoVO> getSearchTag(ApiItemTagInfoVO param) {
		return itemTagDao.getSearchTag(param);
	}

	@Override
	public Boolean regTag(ApiItemTagInfoVO param) {
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
	public Boolean updateTag(ApiItemTagInfoVO param) {
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
	public Boolean deleteTag(ApiItemTagInfoVO param) {
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
