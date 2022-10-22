package com.example.demo.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class tagCountVO {

	@JsonProperty(value = "LOCATION")
	private int location;

	@JsonProperty(value = "TAG")
	private String tag;

	@JsonProperty(value = "DEVICEID")
	private String deviceId;

	@JsonProperty(value = "WORKERID")
	private String workerId;

	@JsonProperty(value = "COUNT")
	private int count;

	@JsonProperty(value = "TAGTIME")
	//@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+9")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm:ss", timezone = "GMT+9")
	private Date tagTime;

	@JsonProperty(value = "ITEMNAME")
	private String itemName;
	
	@JsonProperty(value = "WORKERNAME")
	private String workername;
	
	@JsonProperty(value = "DEVICENAME")
	private String deviceName;
	

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getWorkerId() {
		return workerId;
	}

	public void setWorkerId(String workerId) {
		this.workerId = workerId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Date getTagTime() {
		return tagTime;
	}

	public void setTagTime(Date tagTime) {
		this.tagTime = tagTime;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getWorkername() {
		return workername;
	}

	public void setWorkername(String workername) {
		this.workername = workername;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
}
