package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.LoginParam;

@Mapper
@Repository
public interface LoginDao {

	public String login(LoginParam param);

	public String selectUser(LoginParam param);

}
