package com.example.demo.businessexception;

import org.springframework.http.HttpStatus;

public class BusinessException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg;
	private HttpStatus errorCode;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public HttpStatus getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(HttpStatus errorCode) {
		this.errorCode = errorCode;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public BusinessException(String msg, HttpStatus errorCode) {
		super();
		this.msg = msg;
		this.errorCode = errorCode;
	}
	public BusinessException() {
		
	}

}
