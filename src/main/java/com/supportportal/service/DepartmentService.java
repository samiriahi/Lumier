package com.supportportal.service;

import java.util.List;

import com.supportportal.entity.Department;



public interface DepartmentService {

    List<Department> getAllDepartments();

    Department getDepartmentById(Long idDepartement);

    Department saveDepartment(Department department);

    void deleteDepartment(Long idDepartement);
}