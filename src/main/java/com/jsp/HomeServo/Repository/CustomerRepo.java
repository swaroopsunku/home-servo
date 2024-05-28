package com.jsp.HomeServo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.jsp.HomeServo.dto.Customer;


public interface CustomerRepo extends JpaRepository<Customer, Integer> {
	//@Query("select a from Customer a where email:=email and password:=password")
	//public Customer login(@RequestParam String email, @RequestParam String password);
	public Customer findByEmail(String email) ;
}
