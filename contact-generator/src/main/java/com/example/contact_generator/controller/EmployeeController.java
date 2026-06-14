package com.example.contact_generator.controller;

import com.example.contact_generator.dto.EmployeeResponseDTO;
import com.example.contact_generator.entity.Employee;
import com.example.contact_generator.qr.QRCodeService;
import com.example.contact_generator.service.EmployeeService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.contact_generator.qr.VCardService;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final VCardService vCardService;
    private final QRCodeService qrCodeService;

    public EmployeeController(EmployeeService employeeService,VCardService vCardService,QRCodeService qrCodeService) {
        this.employeeService = employeeService;
        this.vCardService = vCardService;
        this.qrCodeService = qrCodeService;
    }

    //Get All Employees Endpoint
    @GetMapping
    public List<EmployeeResponseDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

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

    //just to test vcard generation
    @GetMapping("/{id}/vcard")
    public String getVCard(@PathVariable Long id) {

        Employee employee =
                employeeService.getEmployeeEntityById(id);

        return vCardService.buildVCard(employee);
    }

    @GetMapping("/test-qr")
    public ResponseEntity<byte[]> testQr() {

        byte[] qrCode =  qrCodeService.generateQRCode("Hello World");

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.IMAGE_PNG_VALUE)
                .body(qrCode);
    }

    @GetMapping("/test-vcard-qr")
    public ResponseEntity<byte[]> testVCardQr() {

        String vCard =
                """
                BEGIN:VCARD
                VERSION:3.0
                FN:John Doe
                TEL;TYPE=CELL:+251911223344
                EMAIL:john@example.com
                END:VCARD
                """;

        byte[] qrCode =
                qrCodeService.generateQRCode(vCard);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE,
                        MediaType.IMAGE_PNG_VALUE)
                .body(qrCode);
    }

    // QR Endpoint
    @GetMapping("/{id}/qrcode")
    public ResponseEntity<byte[]> getEmployeeQrCode(@PathVariable Long id) {

        Employee employee = employeeService.getEmployeeEntityById(id);

        String vCard = vCardService.buildVCard(employee);

        byte[] qrCode = qrCodeService.generateQRCode(vCard);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.IMAGE_PNG_VALUE)
                .body(qrCode);
    }


}
