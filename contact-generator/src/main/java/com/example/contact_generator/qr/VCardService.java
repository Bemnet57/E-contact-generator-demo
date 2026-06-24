package com.example.contact_generator.qr;

import com.example.contact_generator.entity.Employee;
import org.springframework.stereotype.Service;

@Service
public class VCardService {
    public String buildVCard(Employee employee) {

        String phone = formatPhoneNumber(employee.getPhoneNo());

        return "BEGIN:VCARD\r\n" +
                "VERSION:3.0\r\n" +
                "FN:" + employee.getFullName() + "\r\n" +
                "TEL;TYPE=CELL:" + phone + "\r\n" +
                "EMAIL:" + employee.getEmail() + "\r\n" +
                "END:VCARD";
    }
    //helper method added to normalize phone numbers before vcard generation
    private String formatPhoneNumber(String phone) {

        if (phone == null || phone.isBlank()) {
            return "";
        }

        phone = phone.trim();

        // 9XXXXXXXX
        if (phone.matches("^9\\d{8}$")) {
            return "+251" + phone;
        }

        // 09XXXXXXXX
        if (phone.matches("^09\\d{8}$")) {
            return "+251" + phone.substring(1);
        }

        // Already international format
        if (phone.startsWith("+251")) {
            return phone;
        }

        return phone;
    }
}
