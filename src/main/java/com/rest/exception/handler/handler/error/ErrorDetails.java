package com.rest.exception.handler.handler.error;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.Data;

@Data
public class ErrorDetails {
	
	public static final String MORE_INFO = "http://localhost:8080/docs/errors/";
	
	private String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));;
	private String code;
	private String status;
	private String message;
	private String details;
	private String more_info;

	public ErrorDetails(String code, String status, String message, String details) {
		super();
		this.code = code;
		this.status = status;
		this.message = message;
		this.details = details;
		this.more_info =  ErrorDetails.MORE_INFO + this.code;
	}
}