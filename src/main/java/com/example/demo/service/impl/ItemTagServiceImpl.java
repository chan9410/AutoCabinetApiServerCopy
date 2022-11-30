package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
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
			try {
				itemTagDao.saveTag(param);
				return 200;
			} catch (DuplicateKeyException e) {/* 이거 꼭 필요하나? */
				return 104;
			}
		}
	}

	@Override
	public int updateTag(ApiItemTagInfoParam param) {

		String chkItemCode = itemTagDao.chkItemCode(param);

		int result = itemTagDao.updateTag(param);

		System.out.println(result);

		/*
		 * 파라미터 비정상적으로 입력 시 에러 발생. EX) 태그 값만 파라미터로 넣거나, 태그 값을 제외하고 바꿀 파라미터 값만 넣을 때 SQL
		 * 문법에 맞지 않아 오류 발생
		 */

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
	public void excelTempUpload(ExcelData data) {

		String chkTag = itemTagDao.chkTag(data);

		String chkItemCode = itemTagDao.chkItemCode(data);

		if (chkTag != null) {
			System.out.println("EXIST TAG");

		} else if (chkItemCode != null) {
			System.out.println("EXIST ITEM CODE");
		} else {
			itemTagDao.excelTempUpload(data);
		}
	}

	@Override
	public int getCountexcelTemp() {
		return itemTagDao.getCountexcelTemp();
	}

	@Override
	public void excelUpload() {
		itemTagDao.excelUpload();
	}

	@Override
	public void deleteExcelTemp() {
		itemTagDao.deleteExcelTemp();
	}
}
