package com.jsp.HomeServo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.HomeServo.dto.Customer;
import com.jsp.HomeServo.dto.Work;
import com.jsp.HomeServo.service.WorkService;
import com.jsp.HomeServo.util.ResponseStructure;

@RestController
public class WorkController {
	@Autowired
	WorkService service;
	@PostMapping("/work")
	public ResponseEntity<ResponseStructure<Work>> saveWork(@RequestBody Work work,@RequestParam int cus_id) {
		return service.saveWork(work, cus_id);
	}
	@PutMapping("/work/start")
	private ResponseEntity<ResponseStructure<Work>> updateWorkStartDate(@RequestParam int Work_id,@RequestParam int ven_id ) {
		
		return service.updateWorkStartDate(Work_id, ven_id);
	}
	@PutMapping("/work/end")
	private ResponseEntity<ResponseStructure<Work>> updateWorkEndDate(@RequestParam int Work_id,@RequestParam int ven_id ) {
		
		return service.updateWorkEndDate(Work_id, ven_id);
	}
	@GetMapping("/work")
	public ResponseEntity<ResponseStructure<Work>> getWorkId(@RequestParam int id) {
		return service.getWork(id);
	}
//	@DeleteMapping("/work")
//	public ResponseEntity<ResponseStructure<Work>> deleteWork(@RequestParam int id) {
//		return service.deleteWork(id);
//	}
	@GetMapping("/work/all")
	public ResponseEntity<ResponseStructure<List<Work>>> getListOfWorks(@RequestParam int ven_id) {
		return service.getWorkAll(ven_id);
	}
}
