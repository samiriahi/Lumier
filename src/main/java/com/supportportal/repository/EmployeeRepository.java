package com.supportportal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.supportportal.domain.User;
import com.supportportal.entity.Employee;
import com.supportportal.entity.Formation;



@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    	
	Employee findEmployeeByMat (String mat);

	Optional<Employee> findByNomPrenom(String nomPrenom);
	
}

