package com.jsp.HomeServo.exception;

public class IdNotFoundForAddress extends RuntimeException {
	private String message="Id not found enter valid Id";

	public IdNotFoundForAddress() {
		super();
	}
}
