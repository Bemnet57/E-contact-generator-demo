package com.example.contact_generator.qr;

import com.example.contact_generator.entity.Employee;
import org.springframework.stereotype.Service;

@Service
public class VCardService {
    public String buildVCard(Employee employee) {

        return """
            BEGIN:VCARD
            VERSION:3.0
            N:%s;;;;
            FN:%s
            TEL;TYPE=CELL:%s
            EMAIL;TYPE=WORK:%s
            END:VCARD
            """.formatted(
                employee.getFullName(),
                employee.getFullName(),
                employee.getPhoneNo(),
                employee.getEmail()
        );
    }
}
