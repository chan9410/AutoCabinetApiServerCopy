package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.dao.LoginDao;
import com.example.demo.dto.LoginParam;
import com.example.demo.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	private LoginDao loginDao;

	public LoginServiceImpl(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

	@Override
	public String login(LoginParam param) {
		return loginDao.login(param);
	}

	@Override
	public String selectUserId(LoginParam param) {
		return loginDao.selectUserId(param);
	}

	@Override
	public String selectUserPW(LoginParam param) {
		return loginDao.selectUserPW(param);
	}

	@Override
	public String selectUser(LoginParam param) {
		return loginDao.selectUser(param);
	}

}
