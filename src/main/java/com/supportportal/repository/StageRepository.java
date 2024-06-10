package com.supportportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supportportal.entity.Stage;



public interface StageRepository extends JpaRepository<Stage, Long> {
	
	Stage findStageByReference (String reference );
}
