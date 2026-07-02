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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;

@Tag(
        name = "Employee API",
        description = "Employee lookup and QR generation endpoints"
)

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
    @Operation(
            summary = "Get all employees",
            description = "Retrieves all employees from the database"
    )
    @GetMapping
    public List<EmployeeResponseDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    //Search By Name Endpoint
    @Operation(
            summary = "Search employees",
            description = "Search employees by name"
    )
    @GetMapping("/search")
    public List<EmployeeResponseDTO> searchEmployees(@RequestParam String name) {
        return employeeService.searchEmployees(name);
    }

    //Get Employee By ID Endpoint
    @Operation(
            summary = "Get employee by ID",
            description = "Retrieves a specific employee"
    )
    @GetMapping("/{id}")
    public EmployeeResponseDTO getEmployeeById(
            @PathVariable Long id) {

        return employeeService.getEmployeeById(id);
    }

    //QR Code Endpoint
    @Operation(
            summary = "Generate employee contact QR code",
            description = "Returns a QR code image containing VCARD information"
    )
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
