package com.example.pdfgenerator.service;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfDocument;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class PDFGeneratorService {
    public void export(HttpServletResponse response) throws IOException {
        Document document = new Document(PageSize.A4);

        // Write this document and write it out to response as Output Stream
        PdfWriter.getInstance(document, response.getOutputStream());

        // Open our document
        document.open();

        // Some editing
        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontTitle.setSize(18);

        // Making a paragraph
        Paragraph paragraph = new Paragraph("This is a paragraph", fontTitle);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        // Adding in the document
        document.add(paragraph);
        document.add(paragraph);

        // Close a document
        document.close();
    }

    // Reading existing PDF and Sending Compressed PDF
    public void compressPdfFileSize(HttpServletResponse response) throws IOException {
        PdfReader originalPDF = new PdfReader(new FileInputStream("C:\\Users\\aaa\\Downloads\\PDF TEST\\Upload\\Java_Tech_Lounge.pdf"));
        PdfStamper compressed = new PdfStamper(originalPDF, response.getOutputStream());

        int total = originalPDF.getNumberOfPages() + 1;
        for ( int i=1; i<total; i++) {
            originalPDF.setPageContent(i + 1, originalPDF.getPageContent(i + 1));
        }

        compressed.setFullCompression();
        compressed.close();
    }
}
