package com.example.contact_generator.controller;

import com.example.contact_generator.dto.EmployeeResponseDTO;
import com.example.contact_generator.service.ContactQrService;
import com.example.contact_generator.service.EmployeeService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    private final ContactQrService contactQrService;

    public EmployeeController(
            EmployeeService employeeService,
            ContactQrService contactQrService) {

        this.employeeService = employeeService;
        this.contactQrService = contactQrService;
    }

    //Get All Employees Endpoint
    @GetMapping
    public List<EmployeeResponseDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    //Search By Name Endpoint
    @GetMapping("/search")
    public List<EmployeeResponseDTO> searchEmployees(@RequestParam String name) {
        return employeeService.searchEmployees(name);
    }

    //Get Employee By ID Endpoint
    @GetMapping("/{id}")
    public EmployeeResponseDTO getEmployeeById(
            @PathVariable Long id) {

        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/{id}/qrcode")
    public ResponseEntity<byte[]> getEmployeeQrCode(
            @PathVariable Long id) {

        byte[] qrCode =
                contactQrService.generateEmployeeQr(id);

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(qrCode);

    }


}
