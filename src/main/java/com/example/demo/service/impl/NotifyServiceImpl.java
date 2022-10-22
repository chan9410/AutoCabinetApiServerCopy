package com.example.demo.service.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.NotifyDao;
import com.example.demo.dto.KakaoNotifyInfoOfWorkersVO;
import com.example.demo.service.NotifyService;

@Service
public class NotifyServiceImpl implements NotifyService {
	private NotifyDao notifyDao;

	@Autowired
	public NotifyServiceImpl(NotifyDao notifyDao) {
		this.notifyDao = notifyDao;
	}

	@Override
	public List<KakaoNotifyInfoOfWorkersVO> getKakaoNotifyInfoOfWorkersByTag(String tag) {
		return notifyDao.getKakaoNotifyInfoOfWorkersByTag(tag);
	}

	@Override
	public Map<String, Object> getSingleRecentTotalStockCount(String compId) {
		return notifyDao.getSingleRecentTotalStockCount(compId);
	}

	@Override
	public Map<String, Object> getWorkerNameFromWorkerId(String workerId) {
		return notifyDao.getWorkerNameFromWorkerId(workerId);
	}

	@Override
	public void callKakaoInputNotifyAPI(Map<String, String> userInfo, Map<String, String> itemInfo) throws Exception {
		JSONObject param = new JSONObject();

		URL url = new URL("https://api-alimtalk.cloud.toast.com/alimtalk/v2.2/appkeys/q3c3bFvCw5WqsNvi/messages");
		HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json");
		con.setRequestProperty("Accept-Charset", "UTF-8");
		con.setRequestProperty("X-Secret-Key", "YiBV88Bd");

		HashMap<String, String> templateParameter = new HashMap<String, String>();
		templateParameter.put("worker", userInfo.get("worker"));
		templateParameter.put("who", itemInfo.get("who"));
		templateParameter.put("time", itemInfo.get("time"));
		templateParameter.put("item", itemInfo.get("item"));
		templateParameter.put("location", itemInfo.get("location"));
		templateParameter.put("total", itemInfo.get("total"));

		Map<String, Object> reciptientListItem = new HashMap<String, Object>();
		Object recipientNo = userInfo.get("phoneNum");
		reciptientListItem.put("recipientNo", recipientNo);
		reciptientListItem.put("templateParameter", templateParameter);

		List<Object> recipientList = new ArrayList<Object>();
		recipientList.add(reciptientListItem);

		param.put("senderKey", "42482e1e17457b55a754d20a835764dfa653c5e5");
		param.put("templateCode", "INPUT_ALERT");
		param.put("recipientList", recipientList);

		con.setDoOutput(true);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(con.getOutputStream()));
		bw.write(param.toString());
		System.out.println(param.toString());
		bw.flush();
		bw.close();

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String returnMsg = in.readLine();
		System.out.println(returnMsg);
	}

	@Override
	public void callKakaoOutputNotifyAPI(Map<String, String> userInfo, Map<String, String> itemInfo) throws Exception {

		JSONObject param = new JSONObject();

		URL url = new URL("https://api-alimtalk.cloud.toast.com/alimtalk/v2.2/appkeys/q3c3bFvCw5WqsNvi/messages");
		HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json");
		con.setRequestProperty("Accept-Charset", "UTF-8");
		con.setRequestProperty("X-Secret-Key", "YiBV88Bd");

		HashMap<String, String> templateParameter = new HashMap<String, String>();
		templateParameter.put("worker", userInfo.get("worker"));
		templateParameter.put("who", itemInfo.get("who"));
		templateParameter.put("time", itemInfo.get("time"));
		templateParameter.put("item", itemInfo.get("item"));
		templateParameter.put("location", itemInfo.get("location"));
		templateParameter.put("total", itemInfo.get("total"));

		Map<String, Object> reciptientListItem = new HashMap<String, Object>();
		Object recipientNo = userInfo.get("phoneNum");
		reciptientListItem.put("recipientNo", recipientNo);
		reciptientListItem.put("templateParameter", templateParameter);

		List<Object> recipientList = new ArrayList<Object>();
		recipientList.add(reciptientListItem);

		param.put("senderKey", "42482e1e17457b55a754d20a835764dfa653c5e5");
		param.put("templateCode", "OUTPUT_ALERT");
		param.put("recipientList", recipientList);

		con.setDoOutput(true);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(con.getOutputStream()));
		bw.write(param.toString());
		System.out.println(param.toString());
		bw.flush();
		bw.close();

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String returnMsg = in.readLine();
		System.out.println(returnMsg);
	}

}
