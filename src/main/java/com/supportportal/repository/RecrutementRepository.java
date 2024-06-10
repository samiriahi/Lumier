package com.supportportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supportportal.entity.Recrutement;



public interface RecrutementRepository extends JpaRepository<Recrutement, Long> {
}