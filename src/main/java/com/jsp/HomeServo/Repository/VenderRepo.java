package com.jsp.HomeServo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.HomeServo.dto.Vender;

public interface VenderRepo extends JpaRepository<Vender, Integer>{
	public Vender findByEmail(String email) ;
}
