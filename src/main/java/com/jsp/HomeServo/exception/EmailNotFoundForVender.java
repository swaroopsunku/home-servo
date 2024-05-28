package com.jsp.HomeServo.exception;

import lombok.Data;

@Data
public class EmailNotFoundForVender extends RuntimeException{
	private String message="Email not found enter proper Email";

	public EmailNotFoundForVender() {
		super();
	}
	
}
