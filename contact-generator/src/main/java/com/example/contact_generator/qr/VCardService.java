package com.example.contact_generator.qr;

import com.example.contact_generator.entity.Employee;
import org.springframework.stereotype.Service;

@Service
public class VCardService {

    public String buildVCard(Employee employee) {

        return "BEGIN:VCARD\n" +
                "VERSION:3.0\n" +
                "FN:" + employee.getFullName() + "\n" +
                "TEL:" + employee.getPhoneNumber() + "\n" +
                "EMAIL:" + employee.getEmail() + "\n" +
                "END:VCARD";
    }
}
