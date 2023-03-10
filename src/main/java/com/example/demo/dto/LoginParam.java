package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginParam {

	@JsonProperty(value = "WORKER_ID")
	private String workerId;

	@JsonProperty(value = "WORKER_PW")
	private String workerPw;

	@JsonProperty(value = "WORKER_NAME")
	private String workerName;

	public String getWorkerId() {
		return workerId;
	}

	public void setWorkerId(String workerId) {
		this.workerId = workerId;
	}

	public String getWorkerPw() {
		return workerPw;
	}

	public void setWorkerPw(String workerPw) {
		this.workerPw = workerPw;
	}

	public String getWorkerName() {
		return workerName;
	}

	public void setWorkerName(String workerName) {
		this.workerName = workerName;
	}

}
