package com.jsp.HomeServo.exception;

import lombok.Data;

@Data
public class PasswordNotFoundForVender extends RuntimeException {
	private String message="Password not found enter proper password";

	public PasswordNotFoundForVender() {
		super();
	}
	
}
