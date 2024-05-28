package com.jsp.HomeServo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.HomeServo.dao.VenderDao;

import com.jsp.HomeServo.dto.Vender;
import com.jsp.HomeServo.exception.EmailNotFoundForCustomer;
import com.jsp.HomeServo.exception.EmailNotFoundForVender;
import com.jsp.HomeServo.exception.IdNotFoundForCustomer;
import com.jsp.HomeServo.exception.IdNotFoundForVender;
import com.jsp.HomeServo.exception.PasswordNotFoundForCustomer;
import com.jsp.HomeServo.exception.PasswordNotFoundForVender;
import com.jsp.HomeServo.util.ResponseStructure;

@Service
public class VenderService {
	@Autowired
	private VenderDao dao;
	public ResponseEntity<ResponseStructure<Vender>> saveVender(Vender vender) {
		ResponseStructure<Vender> structure= new ResponseStructure<Vender>();
		structure.setData(dao.saveVender(vender));
		structure.setMessage("Vender data saved successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Vender>>(structure,HttpStatus.CREATED);
		
	}
	public ResponseEntity<ResponseStructure<Vender>> updateVender(Vender vender) {
		ResponseStructure<Vender> structure= new ResponseStructure<Vender>();
		structure.setData(dao.updateVender(vender));
		structure.setMessage("Vendar data updated successfully");
		structure.setStatus(HttpStatus.UPGRADE_REQUIRED.value());
		return new ResponseEntity<ResponseStructure<Vender>>(structure,HttpStatus.UPGRADE_REQUIRED);
		
	}
	public ResponseEntity<ResponseStructure<Vender>> deleteVender(int id) {
		ResponseStructure<Vender> structure= new ResponseStructure<Vender>();
		structure.setData(dao.deleteVender(id));
		structure.setMessage("Vendar data delete successfully");
		structure.setStatus(HttpStatus.UPGRADE_REQUIRED.value());
		return new ResponseEntity<ResponseStructure<Vender>>(structure,HttpStatus.UPGRADE_REQUIRED);
		
	}
	public ResponseEntity<ResponseStructure<Vender>> getVenderEmail(String email, String password) {
		Vender vender=dao.getVenderByEmail(email);
		if (vender!=null) {
			if (vender.getPassword().equals(password)) {
				ResponseStructure<Vender> structure= new ResponseStructure<Vender>();
				structure.setData(vender);
				structure.setMessage("Vender Login Successfully");
				structure.setStatus(HttpStatus.FOUND.value());
				return new ResponseEntity<ResponseStructure<Vender>>(structure,HttpStatus.FOUND);
			}
			else {
				throw new PasswordNotFoundForVender();
			}
		}
		else {
			throw new EmailNotFoundForVender();
		}
		
	}
	public ResponseEntity<ResponseStructure<Vender>> getVender(int id) {
		ResponseStructure<Vender> structure= new ResponseStructure<Vender>();
		Vender vender=dao.getVenderById(id);
		if (vender!=null) {
			structure.setData(dao.getVenderById(id));
			structure.setMessage("Data retrived Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Vender>>(structure,HttpStatus.FOUND);
		} else {
			throw new IdNotFoundForVender();
		}
		
	}
	public ResponseEntity<ResponseStructure<List<Vender>>> getAllVender() {
		ResponseStructure<List<Vender>> structure=new ResponseStructure<List<Vender>>();
		structure.setData(dao.getAllVender());
		structure.setMessage("Data retrived Successfully");
		structure.setStatus(HttpStatus.FOUND.value());
		return new ResponseEntity<ResponseStructure<List<Vender>>>(structure,HttpStatus.FOUND);
	}
}
