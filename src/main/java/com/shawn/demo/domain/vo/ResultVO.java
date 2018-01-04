package com.shawn.demo.domain.vo;

import java.io.Serializable;

import com.shawn.demo.common.EnumResultCode;

public class ResultVO<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String code;
	
	private String msg;
	
	private T data;
	
	
	public ResultVO(String code) {
		this.code = code;
		this.msg = EnumResultCode.getValueOf(code).getDesc();
	}

	public ResultVO(String code, T data) {
		this.code = code;
		this.msg = EnumResultCode.getValueOf(code).getDesc();
		this.data = data;
	}
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.msg = EnumResultCode.getValueOf(code).getDesc();
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ResultVO [data=" + data + ", code=" + code + ", msg=" + msg + "]";
	}

}
