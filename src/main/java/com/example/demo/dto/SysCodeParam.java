package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SysCodeParam {

	@JsonProperty(value = "CODE_VALUE")
	private int codeValue;

	@JsonProperty(value = "CODE_NAME")
	private String codeName;

	@JsonProperty(value = "USE_YN")
	private String useYn;

	public int getCodeValue() {
		return codeValue;
	}

	public void setCodeValue(int codeValue) {
		this.codeValue = codeValue;
	}

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	public String getUseYn() {
		return useYn;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

}
