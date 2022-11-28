package com.example.demo.controller;

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

	@GetMapping(value = "/loginChk")
	public @ResponseBody ReSingleResult<String> loginChk(HttpServletRequest request) {
		/* HttpSession session = request.getSession(); */
		HttpSession session = request.getSession(false);
		int statusCode;
		String data;

		if (session != null && session.getAttribute("loginUser") != null) {
			// session이 null이거나 로그인에 성공했을 때 session 기본 객체에 기록한 loginUser를 확인하여 로그인 여부를 확인
			statusCode = 201;
			data = session.getAttribute("loginUser").toString();
			System.out.println(data);
		} else {
			statusCode = 106;
			data = null;
		}

		return apiService.getSingleResult(data, statusCode);
	}

	@PostMapping(value = "/login", produces = "application/json")
	public @ResponseBody ReSingleResult<String> login(@RequestBody HashMap<String, Object> map,
			HttpServletRequest request, HttpServletResponse response) {

		LoginParam param = new LoginParam();
		String userPw = map.get("WORKERPW").toString();
		int statusCode;
		String data;

		String encryptPassword = "";
		try {
			encryptPassword = SHA256.encrypt(userPw);
		} catch (Exception e) {
			System.out.println("PW fails to SHA256");
			statusCode = 108;
		}

		param.setWorkerId(map.get("WORKERID").toString());
		param.setWorkerPw(encryptPassword);

		String selectUserId = loginService.selectUserId(param);
		String selectUserPW = loginService.selectUserPW(param);
		String selectUser = loginService.selectUser(param);

		if (selectUserId == null) {
			System.out.println("UserId is Null");
			statusCode = 109;
			data = null;
		} else if(selectUserPW == null) {
			System.out.println("UserPW is Null");
			statusCode = 110;
			data = null;
		} else if (selectUser == null) {
			System.out.println("Login Fail");
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

		return apiService.getSingleResult(data, statusCode);

	}

	@GetMapping(value = "/logout")
	public @ResponseBody ReSingleResult<String> logout(HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		int statusCode;
		String data;

		if (session != null) {
			data = session.getAttribute("loginUser").toString();

			session.invalidate();// session 날림
			statusCode = 202;
		} else {
			statusCode = 107;
			data = null;
		}

		return apiService.getSingleResult(data, statusCode);
	}

	@GetMapping(value = "/loginResult")
	public @ResponseBody ReSingleResult<String> loginResult(HttpServletRequest request) {

		return apiService.getSingleResult(null, 106);
	}

}
