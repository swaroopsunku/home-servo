package com.jsp.HomeServo.exception;

import lombok.Data;

@Data
public class IdNotFoundForServiceCost extends RuntimeException{
	private String message="Id not found enter valid Id";

	public IdNotFoundForServiceCost() {
		super();
	}
	
}
