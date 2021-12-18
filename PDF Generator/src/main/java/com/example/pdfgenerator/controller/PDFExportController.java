package com.example.pdfgenerator.controller;

import com.example.pdfgenerator.service.AsposePdfService;
import com.example.pdfgenerator.service.PDFGeneratorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class PDFExportController {

    // Dependency Injection
    private final PDFGeneratorService pdfGeneratorService;
    private final AsposePdfService asposePdfController;

    // Initializing
    public PDFExportController(PDFGeneratorService pdfGeneratorService, AsposePdfService asposePdfController) {
        this.pdfGeneratorService = pdfGeneratorService;
        this.asposePdfController = asposePdfController;
    }

    // Test
    @GetMapping("/pdf/generate")
    public void generatePDF(HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormattor = new SimpleDateFormat("yyyy-MM-dd::hh:mm:ss");
        String currentDateTime = dateFormattor.format(new Date());

        // Setting up Header
        String headerKey = "Content-Disposition";
        // File type
        String headerValue = "attachment; filename=pdf_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        // This is our service class
        this.pdfGeneratorService.export(response);
    }

    static int i = 0;

    @GetMapping("/compress")
    public void compressPDF(HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
        i++;
        response.setHeader("Content-Disposition", "attachment; filename=pdf_test" + i + ".pdf");
        this.pdfGeneratorService.compressPdfFileSize(response);
    }

    @GetMapping("/output")
    public void compressAspose(HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=pdf_test.pdf");
        this.asposePdfController.compressPDF(response);
    }
}
