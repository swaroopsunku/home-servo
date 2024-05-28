package com.jsp.HomeServo.service;

import java.sql.Date;
import java.time.Duration;
import java.util.ArrayList;
import java.util .List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.HomeServo.dao.CustomerDao;
import com.jsp.HomeServo.dao.ServiceCostDao;
import com.jsp.HomeServo.dao.VenderDao;
import com.jsp.HomeServo.dao.WorkDao;
import com.jsp.HomeServo.dto.Customer;
import com.jsp.HomeServo.dto.ServiceCost;
import com.jsp.HomeServo.dto.Vender;
import com.jsp.HomeServo.dto.Work;
import com.jsp.HomeServo.exception.IdNotFoundForCustomer;
import com.jsp.HomeServo.exception.IdNotFoundForServiceCost;
import com.jsp.HomeServo.exception.IdNotFoundForVender;
import com.jsp.HomeServo.exception.IdNotFoundForWork;

import com.jsp.HomeServo.util.ResponseStructure;
@Service
public class ServiceCostService {
	@Autowired
	private WorkDao workdao;
	@Autowired
	private VenderDao vendorDao;
	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private ServiceCostDao serviceCostDao;
	@Autowired
	private ServiceCost cost;
	
	
	
	public ResponseEntity<ResponseStructure<ServiceCost>> saveCost(int v_id,int w_id){
		Vender vendor=vendorDao.getVenderById(v_id);
		if(vendor!=null) {
			Work work=workdao.getWorkById(w_id);
			if(work!=null) {
				double costPerDay =vendor.getCostPerDay();
				
				Date end=work.getEndDate();
				Date start=work.getStartDate();
				Duration duration=Duration.between(start.toLocalDate().atStartOfDay(), end.toLocalDate().atStartOfDay());
				int days=(int)duration.toDays();
				
				cost.setDays(days);
				cost.setTotalAmount(days*costPerDay);
				ServiceCost cost2=serviceCostDao.saveServiceCoset(cost);
				work.setCost(cost2);
				List<ServiceCost> list=new ArrayList<ServiceCost>();
				list.add(cost2);
				list.addAll(vendor.getCosts());
				
				vendor.setCosts(list);
				vendorDao.updateVender(vendor);
				workdao.updateWork(work);
				ResponseStructure<ServiceCost> structure=new ResponseStructure<ServiceCost>();
				structure.setData(cost2);
				structure.setMessage("Service cost is saved successfully");
				structure.setStatus(HttpStatus.CREATED.value());
				return new ResponseEntity<ResponseStructure<ServiceCost>>(structure,HttpStatus.CREATED);
				
				
			}
			else {
				throw new IdNotFoundForWork();
			}
		}
		else {
			throw new IdNotFoundForVender();
		}
		
	}
	
	public ResponseEntity<ResponseStructure<ServiceCost>> payment(int c_id,ServiceCost cost){
		Customer customer=customerDao.getCustomerById(c_id);
		if(customer!=null) {
			ServiceCost cost2=serviceCostDao.getServiceCost(cost.getId());
			if(cost2!=null) {
				ResponseStructure<ServiceCost> structure=new ResponseStructure<ServiceCost>();
				structure.setData(serviceCostDao.payServiceCost(cost));
				structure.setMessage("cost saved successfully");
				structure.setStatus(HttpStatus.CREATED.value());
				return new ResponseEntity<ResponseStructure<ServiceCost>>(structure,HttpStatus.CREATED);
			}
			else
				throw new IdNotFoundForServiceCost();
		}
		else
			throw new IdNotFoundForCustomer();
	}
	
	

}