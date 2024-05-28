package com.jsp.HomeServo.exception;

import lombok.Data;

@Data
public class PasswordNotFoundForCustomer extends RuntimeException {
	private String message="Password not found enter proper password";

	public PasswordNotFoundForCustomer() {
		super();
	}
	
	
}
