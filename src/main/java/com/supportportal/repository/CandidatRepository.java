package com.supportportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supportportal.entity.Candidat;



public interface CandidatRepository extends JpaRepository<Candidat, Long> {
	
}