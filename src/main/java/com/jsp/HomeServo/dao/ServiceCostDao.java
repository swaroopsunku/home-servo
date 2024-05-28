package com.jsp.HomeServo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.HomeServo.Repository.ServiceCostRepo;
import com.jsp.HomeServo.dto.ServiceCost;

@Repository
public class ServiceCostDao {
	@Autowired
	ServiceCostRepo repo;
	public ServiceCost saveServiceCoset( ServiceCost cost) {
		return repo.save(cost);
	}
	public ServiceCost payServiceCost(ServiceCost cost) {
		ServiceCost cost2=repo.findById(cost.getId()).get();
		if(cost2!=null) {
			cost2.setMode(cost.getMode());
			return repo.save(cost2);
		}
		else {
			return null;
		}
	}
	public ServiceCost getServiceCost(int id) {
		if(repo.findById(id).isPresent()) {
			return repo.findById(id).get();
		}
		else {
			return null;
		}
	}
}
