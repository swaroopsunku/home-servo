package com.jsp.HomeServo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.HomeServo.dto.Address;

import com.jsp.HomeServo.service.AddressService;
import com.jsp.HomeServo.util.ResponseStructure;

@RestController
public class AddressController {
	@Autowired
	AddressService service;
	
	@PutMapping("/address")
	public ResponseEntity<ResponseStructure<Address>> updateAddress(@RequestBody Address address) {
		return service.updateAddress(address);
	}
	@GetMapping("/address")
	public ResponseEntity<ResponseStructure<Address>> getAddressId(@RequestParam int id) {
		return service.getAddress(id);
	}
}
