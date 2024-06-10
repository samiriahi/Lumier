package com.supportportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.supportportal.entity.Department;
import com.supportportal.service.DepartmentService;



@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{idDepartement}")
    public Department getDepartmentById(@PathVariable Long idDepartement) {
        return departmentService.getDepartmentById(idDepartement);
    }

    @PostMapping
    public Department saveDepartment(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    @PutMapping("/{idDepartement}")
    public Department updateDepartment(@PathVariable Long idDepartement, @RequestBody Department department) {
        // Implement logic to update existing department
        return departmentService.saveDepartment(department);
    }

    @DeleteMapping("/{idDepartement}")
    public void deleteDepartment(@PathVariable Long idDepartement) {
        departmentService.deleteDepartment(idDepartement);
    }
}