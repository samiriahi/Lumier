package com.supportportal.service;

import java.util.List;
import java.util.Optional;

import com.supportportal.entity.Employee;



public interface EmployeeService {
    List<Employee> getAllEmployees();
    Optional<Employee> getEmployeeById(Long id);
    Employee saveEmployee(Employee employee);
    void deleteEmployee(Long id);
}
