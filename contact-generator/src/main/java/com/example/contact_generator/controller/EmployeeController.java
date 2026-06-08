package com.example.contact_generator.controller;

import com.example.contact_generator.dto.EmployeeResponseDTO;
import com.example.contact_generator.entity.Employee;
import com.example.contact_generator.service.EmployeeService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //Get All Employees Endpoint
    @GetMapping
    public List<EmployeeResponseDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
//    @GetMapping
//    public List<Employee> getAllEmployees() {
//        return employeeService.getAllEmployees();
//    }
    //Search By Name Endpoint
    @GetMapping("/search")
    public List<Employee> searchEmployees(@RequestParam String name) {
        return employeeService.searchEmployees(name);
    }

    //Get Employee By ID Endpoint
    @GetMapping("/{id}")
    public EmployeeResponseDTO getEmployeeById(
            @PathVariable Long id) {

        return employeeService.getEmployeeById(id);
    }
//    @GetMapping("/{id}")
//    public Employee getEmployeeById(@PathVariable Long id) {
//        return employeeService.getEmployeeById(id);
//    }

}
