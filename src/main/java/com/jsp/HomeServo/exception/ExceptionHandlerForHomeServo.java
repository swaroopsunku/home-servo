package com.jsp.HomeServo.exception;

import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jsp.HomeServo.util.ResponseStructure;
@ControllerAdvice
public class ExceptionHandlerForHomeServo extends ResponseEntityExceptionHandler {
	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	private ResponseEntity<ResponseStructure<String>> sQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException ex) {
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage(ex.getMessage());
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		structure.setData("We can't perform this operation");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.BAD_REQUEST);

	}
	@ExceptionHandler(EmailNotFoundForCustomer.class)
	private ResponseEntity<ResponseStructure<String>> emailNotFoundForCustomer(EmailNotFoundForCustomer email) {
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage(email.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("Please check email once......!");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);

	}	
	@ExceptionHandler(PasswordNotFoundForCustomer.class)
	private ResponseEntity<ResponseStructure<String>> passwordNotFoundForCustomer(PasswordNotFoundForCustomer password) {
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage(password.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("Please check password once......!");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);

	}	
	@ExceptionHandler(EmailNotFoundForVender.class)
	private ResponseEntity<ResponseStructure<String>> emailNotFoundForVender(EmailNotFoundForVender email) {
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage(email.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("Please check email once......!");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);

	}	
	@ExceptionHandler(PasswordNotFoundForVender.class)
	private ResponseEntity<ResponseStructure<String>> passwordNotFoundForVender(PasswordNotFoundForVender password) {
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage(password.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("Please check password once......!");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);

	}
	@ExceptionHandler(IdNotFoundForCustomer.class)
	private ResponseEntity<ResponseStructure<String>> idNotFoundForCustomer(IdNotFoundForCustomer id) {
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage(id.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("Please check id once......!");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);

	}
	@ExceptionHandler(IdNotFoundForVender.class)
	private ResponseEntity<ResponseStructure<String>> idNotFoundForVender(IdNotFoundForVender id) {
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage(id.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("Please check id once......!");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);

	}
	@ExceptionHandler(IdNotFoundForWork.class)
	private ResponseEntity<ResponseStructure<String>> idNotFoundForWork(IdNotFoundForWork id) {
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage(id.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("Please check id once......!");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);

	}
	@ExceptionHandler(IdNotFoundForAddress.class)
	private ResponseEntity<ResponseStructure<String>> idNotFoundForAddress(IdNotFoundForAddress id) {
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage(id.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("Please check id once......!");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);

	}
	@ExceptionHandler(IdNotFoundForServiceCost.class)
	private ResponseEntity<ResponseStructure<String>> idNotFoundForServiceCost(IdNotFoundForServiceCost id) {
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage(id.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("Please check id once......!");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);

	}
}
