package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.KakaoNotifyInfoOfWorkersVO;

@Repository
@Mapper
public interface NotifyDao {
	public List<KakaoNotifyInfoOfWorkersVO> getKakaoNotifyInfoOfWorkersByTag(String tag);
	
	public Map<String, Object> getSingleRecentTotalStockCount(String compId);

	public Map<String, Object> getWorkerNameFromWorkerId(String workerId);
}
