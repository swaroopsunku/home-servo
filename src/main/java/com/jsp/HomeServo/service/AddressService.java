package com.jsp.HomeServo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.HomeServo.dao.AddressDao;
import com.jsp.HomeServo.dto.Address;
import com.jsp.HomeServo.exception.IdNotFoundForAddress;
import com.jsp.HomeServo.exception.IdNotFoundForCustomer;
import com.jsp.HomeServo.util.ResponseStructure;

@Service
public class AddressService {
	@Autowired
	AddressDao dao;
	public ResponseEntity<ResponseStructure<Address>> updateAddress(Address address) {
		ResponseStructure<Address> structure= new ResponseStructure<Address>();
		structure.setData(dao.UpdateAddress(address));
		structure.setMessage("Address data updated successfully");
		structure.setStatus(HttpStatus.UPGRADE_REQUIRED.value());
		return new ResponseEntity<ResponseStructure<Address>>(structure,HttpStatus.UPGRADE_REQUIRED);
		
	}
	public ResponseEntity<ResponseStructure<Address>> getAddress(int id) {
		ResponseStructure<Address> structure= new ResponseStructure<Address>();
		Address address=dao.getAddressById(id);
		if (address!=null) {
			structure.setData(dao.getAddressById(id));
			structure.setMessage("Data retrived Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Address>>(structure,HttpStatus.FOUND);
		} else {
			throw new IdNotFoundForAddress();
		}
		
	}
}
