package com.etoak.common.utils;

public class JsonResult {
	
	private Integer code;//×´Ì¬Âë
	private String msg;//ÐÅÏ¢
	
	public JsonResult() {
		super();
	}
	
	public JsonResult(Integer code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
