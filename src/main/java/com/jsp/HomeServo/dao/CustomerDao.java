 package com.jsp.HomeServo.dao;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.HomeServo.Repository.CustomerRepo;
import com.jsp.HomeServo.dto.Customer;



@Repository
public class CustomerDao {
	@Autowired
	private CustomerRepo repo;
	public Customer saveCustomer(Customer customer) {
		return repo.save(customer);
	}
	public Customer getCustomerById(int id) {
		Optional<Customer> optional= repo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	public Customer updateCustomer(Customer customer) {
		if (repo.findById(customer.getId()).isPresent()) {
			Customer db=repo.findById(customer.getId()).get();
			if (customer.getAddress()==null) {
				customer.setAddress(db.getAddress());
			}
			if (customer.getName()==null) {
				customer.setName(db.getName());
			}
			if (customer.getEmail()==null) {
				customer.setEmail(db.getEmail());
			}
			if (customer.getPassword()==null) {
				customer.setPassword(db.getPassword());
			}
			if (customer.getPhone()==0) {
				customer.setPhone(db.getPhone());
			}
			if (customer.getFamilyCount()==0) {
				customer.setFamilyCount(db.getFamilyCount());
			}
			if (customer.getWorks()==null) {
				customer.setWorks(db.getWorks());
			}
			return repo.save(customer);
		} else {
			return null;
		}
	}
	public Customer deleteCustomer(int id) {
		Optional<Customer> optional=repo.findById(id);
		if (optional.isPresent()) {
			repo.delete(optional.get());
			return optional.get();
		}
		return optional.get();
	}
	public Customer getCustomerByEmail(String email) {
		Customer customer=repo.findByEmail(email);
		if (customer!=null) {
			return customer;
		} else {
			return null;
		}
		
	}
//	public Customer loginCustomer(String email, String password) {
//		return repo.login(email, password);
//	}
}
