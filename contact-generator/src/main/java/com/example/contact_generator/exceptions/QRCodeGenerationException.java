package com.example.contact_generator.exceptions;

public class QRCodeGenerationException extends RuntimeException {
    public QRCodeGenerationException(String message) {
        super(message);
    }
}
