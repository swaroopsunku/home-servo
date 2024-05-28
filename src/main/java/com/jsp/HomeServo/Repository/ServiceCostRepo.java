package com.jsp.HomeServo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.HomeServo.dto.ServiceCost;

public interface ServiceCostRepo extends JpaRepository<ServiceCost, Integer> {

}
