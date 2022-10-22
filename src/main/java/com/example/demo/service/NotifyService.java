package com.example.demo.service;

import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import com.example.demo.dto.KakaoNotifyInfoOfWorkersVO;

public interface NotifyService {
	public List<KakaoNotifyInfoOfWorkersVO> getKakaoNotifyInfoOfWorkersByTag(String tag);

	public void callKakaoInputNotifyAPI(Map<String, String> userInfo, Map<String, String> itemInfo) throws Exception;

	public void callKakaoOutputNotifyAPI(Map<String, String> userInfo, Map<String, String> itemInfo) throws Exception;

	public Map<String, Object> getSingleRecentTotalStockCount(String compId);
	
	public Map<String, Object> getWorkerNameFromWorkerId(String workerId);
}
