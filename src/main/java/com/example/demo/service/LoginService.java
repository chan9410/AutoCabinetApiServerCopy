package com.example.demo.service;

import com.example.demo.dto.LoginParam;

public interface LoginService {

	public String login(LoginParam param);

	public String selectUser(LoginParam param);

}
