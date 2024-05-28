package com.jsp.HomeServo.exception;

import lombok.Data;

@Data
public class IdNotFoundForVender extends RuntimeException{
	private String message="Id not found enter valid Id";

	public IdNotFoundForVender() {
		super();
	}
	
}
