package com.supportportal.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.supportportal.entity.Department;





public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
