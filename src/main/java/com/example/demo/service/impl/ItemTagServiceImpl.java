package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ItemTagDao;
import com.example.demo.dto.ApiItemTagInfoParam;
import com.example.demo.dto.ExcelData;
import com.example.demo.dto.GetSearchTagVO;
import com.example.demo.dto.GetTagVO;
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
	public int saveTag(ApiItemTagInfoParam param) {

		String chkTag = itemTagDao.chkTag(param);

		String chkItemCode = itemTagDao.chkItemCode(param);

		if (chkTag != null) {
			return 104;
		} else if (chkItemCode != null) {
			return 105;
		} else {
			itemTagDao.saveTag(param);
			return 200;
		}
	}

	@Override
	public int updateTag(ApiItemTagInfoParam param) {

		String chkItemCode = itemTagDao.chkItemCode(param);

		int result = itemTagDao.updateTag(param);

		if (chkItemCode == null) {
			return 103;
		} else if (result == 0) {
			return 101;
		} else {
			return 200;
		}
	}

	@Override
	public List<String> chkItemCodeArr(ApiItemTagInfoParam param) {
		return itemTagDao.chkItemCodeArr(param);
	}

	@Override
	public int deleteTag(ApiItemTagInfoParam param) {
		int result = itemTagDao.deleteTag(param);

		if (result == 0) {
			return 101;
		} else {
			return 200;
		}
	}

	@Override
	public List<GetTagVO> getTag() {
		return itemTagDao.getTag();
	}

	@Override
	public int excelUpload(List<ExcelData> dataList) {
		return itemTagDao.excelUpload(dataList);
	}

	@Override
	public List<ExcelData> chkExcelTagArr(List<ExcelData> dataList) {
		return itemTagDao.chkExcelTagArr(dataList);
	}

	@Override
	public List<ExcelData> chkExcelItemCodeArr(List<ExcelData> dataList) {
		return itemTagDao.chkExcelItemCodeArr(dataList);
	}
}
