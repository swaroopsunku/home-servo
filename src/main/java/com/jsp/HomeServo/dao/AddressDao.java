package com.jsp.HomeServo.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.HomeServo.Repository.AddressRepo;
import com.jsp.HomeServo.dto.Address;

@Repository
public class AddressDao {
	@Autowired
	AddressRepo repo;
	public Address UpdateAddress(Address address) {
		if (repo.findById(address.getId()).isPresent()) {
			Address address2=repo.findById(address.getId()).get();
			if (address.getD_No() == null) {
				address.setD_No(address2.getD_No());
			}
			if (address.getStreet() == null) {
				address.setStreet(address2.getStreet());
			}
			if (address.getLandmark() == null) {
				address.setLandmark(address2.getLandmark());
			}
			if (address.getDistrict() == null) {
				address.setDistrict(address2.getDistrict());
			}
			if (address.getState() == null) {
				address.setState(address2.getState());
			}
			if (address.getPincode() == 0) {
				address.setPincode(address2.getPincode());
			}
			return repo.save(address);
		} else {
			return null;
		}
	}
	public Address getAddressById(int id) {
		Optional<Address> optional= repo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
}
