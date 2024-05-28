package com.jsp.HomeServo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.HomeServo.Repository.WorkRepo;
import com.jsp.HomeServo.dto.Work;

import lombok.Data;
@Repository
@Data
public class WorkDao {
	@Autowired
	WorkRepo repo;
	public Work saveWork( Work work) {
		return repo.save(work);
	}
	public Work getWorkById(int id) {
		if (repo.findById(id).isPresent()) {
			Work work=repo.findById(id).get();
			return work;
		}
		else {
			return null;
		}
	}
	public List<Work> listOfWorks() {
		List<Work> list=repo.listOfWork();
		if (list!=null) {
			return list;
		} else {
			return null;
		}
	}
	public Work updateWork(Work work) {
		if (repo.findById(work.getId()).isPresent()) {
			Work db=repo.findById(work.getId()).get();
			if (work.getAddress()==null) {
				work.setAddress(db.getAddress());
			}
			if (work.getCost()==null) {
				work.setCost(db.getCost());
			}
			if (work.getCustomer()==null) {
				work.setCustomer(db.getCustomer());
			}
			if (work.getType()==null) {
				work.setType(db.getType());
			}
			if (work.getVenders()==null) {
				work.setVenders(db.getVenders());
			}
			if (work.getStartDate()==null) {
				work.setStartDate(db.getStartDate());
			}
			if (work.getEndDate()==null) {
				work.setEndDate(db.getEndDate());
			}
			return repo.save(work);
		} else {
			return null;
		}
	}
//	public Work deleteWork(int id) {
//		Work work=repo.findById(id).get();
//		if (work!=null) {
//			repo.deleteById(id);
//			return work;
//		} else {
//			return null;
//		}
//	}
}
