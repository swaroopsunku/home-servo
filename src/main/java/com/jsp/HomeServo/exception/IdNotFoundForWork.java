package com.jsp.HomeServo.exception;

import lombok.Data;

@Data
public class IdNotFoundForWork extends RuntimeException {
	private String message="Id not found enter valid Id";

	public IdNotFoundForWork() {
		super();
	}
	
}
