package com.supportportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supportportal.entity.Formation;



public interface FormationRepository extends JpaRepository<Formation, Long> {
}