package com.jsp.HomeServo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.HomeServo.dto.Customer;
import com.jsp.HomeServo.service.CustomerService;
import com.jsp.HomeServo.util.ResponseStructure;

@RestController
public class CustomerController {
	@Autowired
	private CustomerService service;
	
//	@CrossOrigin(origins = "http://127.0.0.1:5500")
	@PostMapping("/customer")
	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(@RequestBody Customer customer) {
		return service.saveCustomer(customer);
	}
	@PutMapping("/customer")
	public ResponseEntity<ResponseStructure<Customer>> updateCustomer(@RequestBody Customer customer) {
		return service.updateCustomer(customer);
	}
	@DeleteMapping("/customer")
	public ResponseEntity<ResponseStructure<Customer>> deleteCustomer(@RequestParam int id) {
		return service.deleteCustomer(id);
	}
	@GetMapping("/customer/login")
	public ResponseEntity<ResponseStructure<Customer>> getCustomer(@RequestParam String email, @RequestParam String password) {
		return service.getCustomerEmail(email, password);
	}
	@GetMapping("/customer")
	public ResponseEntity<ResponseStructure<com.jsp.HomeServo.duplicate.Customer>> getCustomerId(@RequestParam int id) {
		return service.getCustomer(id);
	}
	
}
