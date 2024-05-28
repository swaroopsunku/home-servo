package com.jsp.HomeServo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.HomeServo.Repository.VenderRepo;
import com.jsp.HomeServo.dto.Customer;
import com.jsp.HomeServo.dto.Vender;
import com.jsp.HomeServo.dto.Work;

@Repository
public class VenderDao {
	@Autowired
	private VenderRepo repo;
	
	public Vender saveVender( Vender vender) {
		return repo.save(vender);
	}
	public Vender updateVender(Vender vender) {
		if (repo.findById(vender.getId()).isPresent()) {
			Vender db=repo.findById(vender.getId()).get();
			if (vender.getAddress()==null) {
				vender.setAddress(db.getAddress());
			}
			if (vender.getName()==null) {
				vender.setName(db.getName());
			}
			if (vender.getEmail()==null) {
				vender.setEmail(db.getEmail());
			}
			if (vender.getPassword()==null) {
				vender.setPassword(db.getPassword());
			}
			if (vender.getPhone()==0) {
				vender.setPhone(db.getPhone());
			}
			if (vender.getCostPerDay()==0) {
				vender.setCostPerDay(db.getCostPerDay());
			}
			if (vender.getCosts()==null) {
				vender.setCosts(db.getCosts());
			}
			if (vender.getRole()==null) {
				vender.setRole(db.getRole());
			}
			return repo.save(vender);
		} else {
			return null;
		}
	}
	public Vender deleteVender(int id) {
		Vender vender=repo.findById(id).get();
		if (repo.findById(vender.getId()).isPresent()) {
			if (vender.getAddress()!=null) {
				vender.setAddress(null);
			}
			if (vender.getCosts()!=null) {
				vender.setCosts(null);
			}
			repo.save(vender);
			repo.deleteById(id);
			return vender;
		} else {
			return null;
		}
	}
	public Vender getVenderByEmail(String email) {
		Vender vender=repo.findByEmail(email);
		if (vender!=null) {
			return vender;
		} else {
			return null;
		}
		
	}
	public Vender getVenderById(int id) {
		Optional<Vender> optional= repo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	public List<Vender> getAllVender() {
		List<Vender> list=repo.findAll();
		if (list!=null) {
			return list;
		} else {
			return null;
		}
	}
}
