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
			System.out.println("EXIST TAG");
			return 104;
		} else if (chkItemCode != null) {
			System.out.println("EXIST ITEM CODE");
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

		System.out.println(result);

		if (chkItemCode == null) {
			System.out.println("No Tag");
			return 103;
		} else if (result == 0) {
			System.out.println("No Result");
			return 101;
		} else {
			System.out.println("Success");
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
			System.out.println("No Result");
			return 101;
		} else {
			System.out.println("Success");
			return 200;
		}
	}

	@Override
	public List<GetTagVO> getTag() {
		return itemTagDao.getTag();
	}

	@Override
	public int excelUpload(List<ExcelData> dataList) {

		int resultCode;

		List<ExcelData> chkExcelTagArr = itemTagDao.chkExcelTagArr(dataList);

		List<ExcelData> chkExcelItemCodeArr = itemTagDao.chkExcelItemCodeArr(dataList);

		if (dataList.contains(null) == true) {
			resultCode = 109;
		} else if (chkExcelTagArr.size() != 0) {
			resultCode = 104;
		} else if (chkExcelItemCodeArr.size() != 0) {
			resultCode = 105;
		} else {
			resultCode = 200;
			itemTagDao.excelUpload(dataList);
		}

		return resultCode;
	}
}
