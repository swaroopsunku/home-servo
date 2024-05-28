package com.jsp.HomeServo.exception;

import lombok.Data;

@Data
public class EmailNotFoundForCustomer extends RuntimeException {
	private String message="Email not found enter proper Email";

	public EmailNotFoundForCustomer() {
		super();
	}

}
