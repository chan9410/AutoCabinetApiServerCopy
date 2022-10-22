package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.NotifyService;
import com.example.demo.dto.KakaoNotifyInfoOfWorkersVO;

@Controller
public class NotifyController {

	private NotifyService notifyService;

	@Autowired
	public NotifyController(NotifyService notifyService) {
		this.notifyService = notifyService;
	}

	@RequestMapping("/notifyInputAlert")
	@ResponseBody
	public void notifyInputAlert(@RequestParam(value = "TAG", defaultValue = "") String tag,
			@RequestParam(value = "LOCATION", defaultValue = "") String location,
			@RequestParam(value = "TIME", defaultValue = "") String time,
			@RequestParam(value = "WORKER", defaultValue = "") String who) {
		// parameter TAG값 LOCATION값 받아오기

		// 해당 TAG를 알림 설정으로 등록해 둔 사용자 조회
		List<KakaoNotifyInfoOfWorkersVO> list = new ArrayList<KakaoNotifyInfoOfWorkersVO>();
		list = notifyService.getKakaoNotifyInfoOfWorkersByTag(tag);

		// 현재 회사 최근 Stock count 조회
		Map<String, Object> singleRecentStockCount = new HashMap<>();
		singleRecentStockCount = notifyService.getSingleRecentTotalStockCount("a01");
		String totalStockCount = singleRecentStockCount.get("RECENT_TOTAL_STOCK_COUNT").toString();

		// 입고 작업자의 이름 조회
		Map<String, Object> userName = new HashMap<>();
		userName = notifyService.getWorkerNameFromWorkerId(who);
		String whoName;
		if (userName == null) {
			whoName = "미등록 작업자";
		} else {
			whoName = userName.get("WORKER_NAME").toString();
		}

		// 조회환 사용자의 리스트를 통하여 카톡 알림 서비스 실행 => 입고알람
		Map<String, String> userInfo = new HashMap<String, String>();
		Map<String, String> itemInfo = new HashMap<String, String>();

		for (int i = 0; i < list.size(); i++) {
			KakaoNotifyInfoOfWorkersVO worker = list.get(i);
			// 입고 알림에 해당되는 사용자에 대한 카톡 알림서비스 호출
			if (worker.getIsInputAlert() == true) {
				userInfo.put("worker", worker.getWorkerName().toString());
				userInfo.put("phoneNum", worker.getWorkerPhoneNum().toString());
				itemInfo.put("item", worker.getItemName().toString());
				itemInfo.put("location", location);
				itemInfo.put("who", whoName);
				itemInfo.put("time", time);
				itemInfo.put("total", totalStockCount);
				try {
					notifyService.callKakaoInputNotifyAPI(userInfo, itemInfo);
				} catch (Exception e) {
					System.out.println(e);
				}
			} else {
				userInfo.clear();
				itemInfo.clear();
			}
		}
	}

	@RequestMapping("/notifyOutputAlert")
	@ResponseBody
	public void notifyOutputAlert(@RequestParam(value = "TAG", defaultValue = "") String tag,
			@RequestParam(value = "LOCATION", defaultValue = "") String location,
			@RequestParam(value = "TIME", defaultValue = "") String time,
			@RequestParam(value = "WORKER", defaultValue = "") String who) {
		// parameter로 TAG값 LOCATION값 받아오기

		// 해당 TAG를 알림 설정으로 등록해둔 사용자 조회
		List<KakaoNotifyInfoOfWorkersVO> list = new ArrayList<KakaoNotifyInfoOfWorkersVO>();
		list = notifyService.getKakaoNotifyInfoOfWorkersByTag(tag);

		// 현재 회사 최근 Stock count 조회
		Map<String, Object> singleRecentStockCount = new HashMap<>();
		singleRecentStockCount = notifyService.getSingleRecentTotalStockCount("a01");
		String totalStockCount = singleRecentStockCount.get("RECENT_TOTAL_STOCK_COUNT").toString();
		System.out.println(totalStockCount);

		// 출고 작업자의 이름 조회
		Map<String, Object> userName = new HashMap<>();
		userName = notifyService.getWorkerNameFromWorkerId(who);
		String whoName;
		if (userName == null) {
			whoName = "미등록 작업자";
		} else {
			whoName = userName.get("WORKER_NAME").toString();
		}

		// 조회환 사용자의 리스트를 통하여 카톡 알림 서비스 실행 => 출고알람
		Map<String, String> userInfo = new HashMap<String, String>();
		Map<String, String> itemInfo = new HashMap<String, String>();

		for (int i = 0; i < list.size(); i++) {
			KakaoNotifyInfoOfWorkersVO worker = list.get(i);
			// 입고 알림에 해당되는 사용자에 대한 카톡 알림서비스 호출
			if (worker.getIsOutputAlert() == true) {
				userInfo.put("worker", worker.getWorkerName().toString());
				userInfo.put("phoneNum", worker.getWorkerPhoneNum().toString());
				itemInfo.put("item", worker.getItemName().toString());
				itemInfo.put("location", location);
				itemInfo.put("who", whoName);
				itemInfo.put("time", time);
				itemInfo.put("total", totalStockCount);

				try {
					notifyService.callKakaoOutputNotifyAPI(userInfo, itemInfo);
				} catch (Exception e) {
					System.out.println(e);
				}
			} else {
				userInfo.clear();
				itemInfo.clear();
			}
		}
	}
}
