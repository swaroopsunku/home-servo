package com.jsp.HomeServo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.HomeServo.dto.Address;

public interface AddressRepo extends JpaRepository<Address, Integer> {

}
