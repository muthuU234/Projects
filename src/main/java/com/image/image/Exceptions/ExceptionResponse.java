package com.image.image.Exceptions;

import java.time.LocalDateTime;

public class ExceptionResponse {

	private String message;
	private int value;
	private LocalDateTime datetime;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public LocalDateTime getDatetime() {
		return datetime;
	}
	public void setDatetime(LocalDateTime datetime) {
		this.datetime = LocalDateTime.now();
	}
	
	
	public ExceptionResponse(String message,int value) {
		this.message=message;
		this.value=value;
		this.datetime=LocalDateTime.now();
	}
	
}
