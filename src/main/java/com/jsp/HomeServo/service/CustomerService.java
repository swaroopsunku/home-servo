package com.jsp.HomeServo.service;

import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.HomeServo.dao.CustomerDao;
import com.jsp.HomeServo.dto.Customer;

import com.jsp.HomeServo.exception.EmailNotFoundForCustomer;
import com.jsp.HomeServo.exception.IdNotFoundForCustomer;
import com.jsp.HomeServo.exception.PasswordNotFoundForCustomer;
import com.jsp.HomeServo.util.ResponseStructure;

@Service

public class CustomerService {
	@Autowired
	private CustomerDao dao;
	@Autowired
	private com.jsp.HomeServo.duplicate.Customer cust;
	@Autowired
	ModelMapper mapper;
	
	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(Customer customer) {
		ResponseStructure<Customer> structure= new ResponseStructure<Customer>();
		structure.setData(dao.saveCustomer(customer));
		structure.setMessage("Customer data saved successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Customer>>(structure,HttpStatus.CREATED);
		
	}
	public ResponseEntity<ResponseStructure<Customer>> updateCustomer(Customer customer) {
		ResponseStructure<Customer> structure= new ResponseStructure<Customer>();
		structure.setData(dao.updateCustomer(customer));
		structure.setMessage("Customer data updated successfully");
		structure.setStatus(HttpStatus.UPGRADE_REQUIRED.value());
		return new ResponseEntity<ResponseStructure<Customer>>(structure,HttpStatus.UPGRADE_REQUIRED);
		
	}
	public ResponseEntity<ResponseStructure<Customer>> deleteCustomer(int id) {
		ResponseStructure<Customer> structure= new ResponseStructure<Customer>();
		structure.setData(dao.deleteCustomer(id));
		structure.setMessage("Customer data delete successfully");
		structure.setStatus(HttpStatus.UPGRADE_REQUIRED.value());
		return new ResponseEntity<ResponseStructure<Customer>>(structure,HttpStatus.UPGRADE_REQUIRED);	
	}
	public ResponseEntity<ResponseStructure<com.jsp.HomeServo.duplicate.Customer>> getCustomer(int id) {
		ResponseStructure<com.jsp.HomeServo.duplicate.Customer> structure= new ResponseStructure<com.jsp.HomeServo.duplicate.Customer>();
		Customer customer=dao.getCustomerById(id);
		if (customer!=null) {
			cust.setId(customer.getId());
			cust.setName(customer.getName());
			cust.setPhone(customer.getPhone());
			cust.setEmail(customer.getEmail());
			cust.setFamilyCount(customer.getFamilyCount());
			cust.setAddress_id(customer.getAddress().getId());
//			com.jsp.HomeServo.duplicate.Customer custo=(com.jsp.HomeServo.duplicate.Customer)this.mapper.map(customer, com.jsp.HomeServo.duplicate.Customer.class);
			
			structure.setData(cust);
			structure.setMessage("Data retrived Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<com.jsp.HomeServo.duplicate.Customer>>(structure,HttpStatus.FOUND);
		} else {
			throw new IdNotFoundForCustomer();
		}
		
	}
	public ResponseEntity<ResponseStructure<Customer>> getCustomerEmail(String email, String password) {
		Customer customer=dao.getCustomerByEmail(email);
		if (customer!=null) {
			if (customer.getPassword().equals(password)) {
				ResponseStructure<Customer> structure= new ResponseStructure<Customer>();
				structure.setData(customer);
				structure.setMessage("Customer Login Successfully");
				structure.setStatus(HttpStatus.FOUND.value());
				return new ResponseEntity<ResponseStructure<Customer>>(structure,HttpStatus.FOUND);
			}
			else {
				throw new PasswordNotFoundForCustomer();
			}
		}
		else {
			throw new EmailNotFoundForCustomer();
		}
		
	}
}
