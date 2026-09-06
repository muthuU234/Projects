package com.image.image.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {

	
	@org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResponse>globalHandler(Exception ex){
		ExceptionResponse error= new ExceptionResponse("Something Went Wrong "+ex.getClass().getSimpleName(), HttpStatus.INTERNAL_SERVER_ERROR.value());
		return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	
	}
	}
