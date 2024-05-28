package com.jsp.HomeServo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.HomeServo.dto.ServiceCost;
import com.jsp.HomeServo.service.ServiceCostService;
import com.jsp.HomeServo.util.ResponseStructure;

@RestController
public class ServiceCostController {
	@Autowired
	private ServiceCostService service;
	
	@PostMapping("serviceCost")
	public ResponseEntity<ResponseStructure<ServiceCost>> saveServiceCost(@RequestParam int v_id,@RequestParam int w_id){
		return service.saveCost(v_id, w_id);
	}
	@PutMapping("/cost")
	public ResponseEntity<ResponseStructure<ServiceCost>> payment(@RequestParam int c_id, @RequestBody ServiceCost cost){
		return service.payment(c_id, cost);
	}

}
