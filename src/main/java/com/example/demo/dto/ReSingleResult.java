package com.example.demo.dto;

public class ReSingleResult<T> extends CommonResult {

	public T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
