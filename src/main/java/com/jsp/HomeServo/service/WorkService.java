package com.jsp.HomeServo.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.HomeServo.dao.CustomerDao;
import com.jsp.HomeServo.dao.VenderDao;
import com.jsp.HomeServo.dao.WorkDao;
import com.jsp.HomeServo.dto.Customer;
import com.jsp.HomeServo.dto.Vender;
import com.jsp.HomeServo.dto.Work;
import com.jsp.HomeServo.exception.IdNotFoundForVender;
import com.jsp.HomeServo.exception.IdNotFoundForWork;
import com.jsp.HomeServo.util.ResponseStructure;

@Service
public class WorkService {
	@Autowired
	private WorkDao dao;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private VenderDao venderDao;
	
	public ResponseEntity<ResponseStructure<Work>> saveWork(Work work, int cus_id) {
		Customer customer=customerDao.getCustomerById(cus_id);
		if (customer!=null) {
			work.setCustomer(customer);
			ResponseStructure<Work> structure=new ResponseStructure<Work>();
			structure.setData(dao.saveWork(work));
			structure.setMessage("Work saved sucessfully");
			structure.setStatus(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Work>>(structure, HttpStatus.CREATED);
		}
		else {
			return null;
		}
	}
	public ResponseEntity<ResponseStructure<Work>> updateWorkStartDate(int Work_id, int ven_id) {
		Vender vender=venderDao.getVenderById(ven_id);
		if (vender!=null) {
			Work work=dao.getWorkById(Work_id);
			if (work!=null) {
				Date date=new Date( new java.util.Date().getTime());
				work.setStartDate(date);
				List<Vender> list = new ArrayList<>();
				list.add(vender);
				work.setVenders(list);
				ResponseStructure< Work> structure=new ResponseStructure<Work>();
				structure.setData(dao.updateWork(work));
				structure.setMessage("Work saved Successfully");
				structure.setStatus(HttpStatus.CREATED.value());
				return new ResponseEntity<ResponseStructure<Work>>(structure,HttpStatus.CREATED);
			} else {
				throw new IdNotFoundForWork();
			}
		} else {
			throw new IdNotFoundForVender();
		}
	}
	public ResponseEntity<ResponseStructure<Work>> updateWorkEndDate(int Work_id, int ven_id) {
		Vender vender=venderDao.getVenderById(ven_id);
		if (vender!=null) {
			Work work=dao.getWorkById(Work_id);
			if (work!=null) {
				Date date=new Date( new java.util.Date().getTime());
				work.setEndDate(date);
				List<Vender> list = new ArrayList<>();
				list.add(vender);
				work.setVenders(list);
				ResponseStructure< Work> structure=new ResponseStructure<Work>();
				structure.setData(dao.updateWork(work));
				structure.setMessage("Work saved Successfully");
				structure.setStatus(HttpStatus.CREATED.value());
				return new ResponseEntity<ResponseStructure<Work>>(structure,HttpStatus.CREATED);
			} else {
				throw new IdNotFoundForWork();
			}
		} else {
			throw new IdNotFoundForVender();
		}
	}
	public ResponseEntity<ResponseStructure<Work>> getWork(int id) {
		ResponseStructure<Work> structure= new ResponseStructure<Work>();
		Work work=dao.getWorkById(id);
		if (work!=null) {
			structure.setData(dao.getWorkById(id));
			structure.setMessage("Data retrived Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Work>>(structure,HttpStatus.FOUND);
		} else {
			throw new IdNotFoundForWork();
		}
	}
//	public ResponseEntity<ResponseStructure<Work>> deleteWork(int id) {
//		ResponseStructure<Work> structure= new ResponseStructure<Work>();
//		structure.setData(dao.deleteWork(id));
//		structure.setMessage("Work data delete successfully");
//		structure.setStatus(HttpStatus.UPGRADE_REQUIRED.value());
//		return new ResponseEntity<ResponseStructure<Work>>(structure,HttpStatus.UPGRADE_REQUIRED);
//		
//	}
	public ResponseEntity<ResponseStructure<List<Work>>> getWorkAll(int v_id){
 		Vender vender=venderDao.getVenderById(v_id);
 		if(vender!=null) {
 			List<Work> list=dao.listOfWorks();
 			ResponseStructure<List<Work>> structure=new ResponseStructure<>();
 			structure.setMessage("data fetch successfully");
 			structure.setStatus(HttpStatus.FOUND.value());
 			structure.setData(list);
 			return new ResponseEntity<ResponseStructure<List<Work>>>(structure,HttpStatus.FOUND);
 			
 		}
 		else {
 			throw new IdNotFoundForVender();
 		}
	}
}
