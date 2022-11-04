package com.example.demo.service.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//경고 무시
@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class paramNotFoundException extends Exception {
	public paramNotFoundException(String message) {
		// 부모 클래스쪽으로 전달받은 메세지를 반환
		super(message);
	}

}
