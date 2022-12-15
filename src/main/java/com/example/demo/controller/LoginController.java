package com.example.demo.controller;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.LoginParam;
import com.example.demo.dto.ReSingleResult;
import com.example.demo.service.ApiService;
import com.example.demo.service.LoginService;
import com.example.demo.util.SHA256;

@CrossOrigin("*")
@Controller
public class LoginController {

	private LoginService loginService;

	private ApiService apiService;

	@Autowired
	public LoginController(LoginService loginService, ApiService apiService) {
		this.loginService = loginService;
		this.apiService = apiService;
	}

	// 로그인 체크
	@GetMapping(value = "/getLoginResult")
	public @ResponseBody ReSingleResult<String> getLoginResult(HttpServletRequest request) {
		/* HttpSession session = request.getSession(); */
		HttpSession session = request.getSession(false);
		int statusCode;
		String data;

		if (session != null && session.getAttribute("loginUser") != null) {
			// session이 null이거나 로그인에 성공했을 때 session 기본 객체에 기록한 loginUser를 확인하여 로그인 여부를 확인
			statusCode = 201;
			data = session.getAttribute("loginUser").toString();
		} else {
			statusCode = 106;
			data = null;
		}
		return apiService.getSingleResult("getLoginResult", null, statusCode);
	}

	// 로그인
	@PostMapping(value = "/login", produces = "application/json")
	public @ResponseBody ReSingleResult<String> login(@RequestBody HashMap<String, Object> map,
			HttpServletRequest request, HttpServletResponse response) throws NoSuchAlgorithmException {

		LoginParam param = new LoginParam();
		int statusCode;
		String data;
		
		String selectUserId, userPw, selectUserPW, selectUser;

		String encryptPassword = "";
		
		try {
			userPw = map.get("WORKER_PW").toString();
			encryptPassword = SHA256.encrypt(userPw);
			param.setWorkerId(map.get("WORKER_ID").toString());
			param.setWorkerPw(encryptPassword);
			
			selectUserId = loginService.selectUserId(param);
			selectUserPW = loginService.selectUserPW(param);
			selectUser = loginService.selectUser(param);
		}catch(NullPointerException e) {
			selectUserId = null;
			selectUserPW = null;
			selectUser = null;
			return apiService.getSingleResult(null, null, 111);
		}


		if (selectUserId == null) {
			statusCode = 107;
			data = null;
		} else if (selectUserPW == null) {
			statusCode = 108;
			data = null;
		} else if (selectUser == null) {
			statusCode = 106;
			data = null;
		} else {

			HttpSession session = request.getSession();

			Cookie UpdateCookie = new Cookie("UpdateCookie", session.getId());
			UpdateCookie.setPath("/");
			UpdateCookie.setMaxAge(60 * 60 * 24 * 7);// 쿠키 유효 시간 일주일
			response.addCookie(UpdateCookie);

			session.setAttribute("loginUser", selectUserId);// 로그인 성공 시 session 기본 객체의 "loginUser" 속성에 아이디 정보 기록

			statusCode = 201;
			data = selectUserId;
		}
		return apiService.getSingleResult("login", data, statusCode);

	}

	// 로그아웃
	@GetMapping(value = "/logout")
	public @ResponseBody ReSingleResult<String> logout(HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		String data;
		int statusCode;

		if (session != null) {
			data = session.getAttribute("loginUser").toString();
			
			statusCode = 202;
			
			session.invalidate();// session 날림
						
			return apiService.getSingleResult("logout", null, 202);

		} else {
			statusCode = 112;
			return apiService.getSingleResult(null, null, 112);
		}
	}

	// 로그인 인터셉터에서 Session 또는 session.getAttribute("loginUser")이 null일때 호출
	@GetMapping(value = "/loginResult")
	public @ResponseBody ReSingleResult<String> loginResult(HttpServletRequest request) {

		return apiService.getSingleResult(null, null, 106);
	}

}
