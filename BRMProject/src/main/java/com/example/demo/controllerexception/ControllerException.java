package com.example.demo.controllerexception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.businessexception.BusinessException;

@ControllerAdvice
public class ControllerException {

	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<Object> ThrowException(BusinessException businessException){
		return new ResponseEntity<>(businessException.getMsg(),businessException.getErrorCode());
	}
}
