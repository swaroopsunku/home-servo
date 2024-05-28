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
import com.jsp.HomeServo.dto.Vender;
import com.jsp.HomeServo.service.VenderService;
import com.jsp.HomeServo.util.ResponseStructure;

@RestController
public class VenderController {
	@Autowired
	private VenderService service;
	@PostMapping("/vender")
	public ResponseEntity<ResponseStructure<Vender>> saveVender(@RequestBody Vender vender) {
		return service.saveVender(vender);
	}
	@PutMapping("/vender")
	public ResponseEntity<ResponseStructure<Vender>> updateVender(@RequestBody Vender vender) {
		return service.updateVender(vender);
	}
	@DeleteMapping("/vender")
	public ResponseEntity<ResponseStructure<Vender>> deleteVender(@RequestParam int id) {
		return service.deleteVender(id);
	}
	@GetMapping("/vender")
	public ResponseEntity<ResponseStructure<Vender>> getVender(@RequestParam String email, @RequestParam String password) {
		return service.getVenderEmail(email, password);
	}
	@GetMapping("/vender/id")
	public ResponseEntity<ResponseStructure<Vender>> getVenderById(@RequestParam int id) {
		return service.getVender(id);
	}
	@GetMapping("/vender/all")
	public ResponseEntity<ResponseStructure<List<Vender>>> getAllVender() {
		return service.getAllVender();
	}
}
