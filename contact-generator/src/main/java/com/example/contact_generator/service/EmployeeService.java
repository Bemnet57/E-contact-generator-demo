package com.example.contact_generator.service;

import com.example.contact_generator.dto.EmployeeResponseDTO;
import com.example.contact_generator.entity.Employee;
import com.example.contact_generator.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import com.example.contact_generator.exceptions.EmployeeNotFoundException;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeResponseDTO> getAllEmployees() {

        return employeeRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    public EmployeeResponseDTO getEmployeeById(Long id) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));

        return mapToDTO(employee);
}

    public List<EmployeeResponseDTO> searchEmployees(String name) {

        return employeeRepository
                .findByFirstNameContainingIgnoreCaseOrMiddleNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(
                        name,
                        name,
                        name
                )
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    private EmployeeResponseDTO mapToDTO(Employee employee) {
        return new EmployeeResponseDTO(
                employee.getId(),
                employee.getFullName(),
                employee.getEmail(),
//                employee.getPhoneNumber()
                employee.getPhoneNo()
        );
    }

    public Employee getEmployeeEntityById(Long id) {

        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }
}
