package com.supportportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supportportal.entity.Stagier;



public interface StagierRepository extends JpaRepository<Stagier, Long> {

	Stagier findStagierByCin(String cin);
}