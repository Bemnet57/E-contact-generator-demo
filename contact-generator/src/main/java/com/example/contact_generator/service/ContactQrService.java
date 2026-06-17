package com.example.contact_generator.service;

import com.example.contact_generator.entity.Employee;
import com.example.contact_generator.qr.QRCodeService;
import com.example.contact_generator.qr.VCardService;
import org.springframework.stereotype.Service;

/**
 * Generates employee contact QR codes.
 * Retrieves employee information,
 * converts it to VCARD format,
 * and generates a QR image.
 */
@Service
public class ContactQrService {

    private final EmployeeService employeeService;
    private final VCardService vCardService;
    private final QRCodeService qrCodeService;

    public ContactQrService(
            EmployeeService employeeService,
            VCardService vCardService,
            QRCodeService qrCodeService) {

        this.employeeService = employeeService;
        this.vCardService = vCardService;
        this.qrCodeService = qrCodeService;
    }
    /**
     * Generates a QR code for an employee.
     *
     * @param employeeId employee identifier
     * @return PNG image as byte array
     */
    public byte[] generateEmployeeQr(Long employeeId) {

        Employee employee =
                employeeService.getEmployeeEntityById(employeeId);

        String vCard =
                vCardService.buildVCard(employee);

        return qrCodeService.generateQRCode(vCard);
    }
}

