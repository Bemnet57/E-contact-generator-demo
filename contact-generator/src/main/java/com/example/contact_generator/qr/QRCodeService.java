package com.example.contact_generator.qr;
import com.example.contact_generator.exceptions.QRCodeGenerationException;
import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.ByteArrayOutputStream;

@Service
public class QRCodeService {

    public byte[] generateQRCode(String text) {

        try {

            QRCodeWriter qrCodeWriter =
                    new QRCodeWriter();

            BitMatrix bitMatrix =
                    qrCodeWriter.encode(
                            text,
                            BarcodeFormat.QR_CODE,
                            300,
                            300
                    );

            ByteArrayOutputStream outputStream =
                    new ByteArrayOutputStream();

            MatrixToImageWriter.writeToStream(
                    bitMatrix,
                    "PNG",
                    outputStream
            );

            return outputStream.toByteArray();

        }
        catch (Exception e) {
            throw new QRCodeGenerationException(
                    "Failed to generate QR code"
            );
        }
    }
}
