package com.example.pdfgenerator.service;

import com.aspose.pdf.*;
import com.aspose.pdf.optimization.OptimizationOptions;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@Service
public class AsposePdfService {

    // IS function me
    // Jo Hatana vo hta liyo
    // Maine sara code isi me daal diya
    // Laptop hang ho gya
    // One line at a time chalana

    // Ye Input Line -- Ise mat delete karna - Line 28
//    Document doc = new Document("C:\\Users\\aaa\\Downloads\\PDF TEST\\Upload\\Java_Tech_Lounge.pdf");
    // If you want to upload pdf and then change it from web
    // Check HttpServletRequest Method

    // Ye output line h - Line 93
//    doc.save(response.getOutputStream());
    public void compressPDF(HttpServletResponse response) throws IOException {
        Document doc = new Document("C:\\Users\\aaa\\Downloads\\PDF TEST\\Upload\\Java_Tech_Lounge.pdf");

        doc.optimize();

        // Initialize OptimizationOptions object
        OptimizationOptions opt = new OptimizationOptions();

// Enable image compression
// Set the quality and resolution of images in PDF file
        opt.getImageCompressionOptions().setCompressImages(true);
        opt.getImageCompressionOptions().setImageQuality(10);
        opt.getImageCompressionOptions().setMaxResolution(150);
        opt.getImageCompressionOptions().setResizeImages(true);
        doc.optimizeResources(opt);


        // Either
// Unembed all fonts in PDF
        opt.setUnembedFonts(true);

//OR
// only keep embedded fonts for used characters
        opt.setSubsetFonts(true);

// link duplicate streams
        opt.setLinkDuplcateStreams(false);

// Remove unused streams
        opt.setRemoveUnusedStreams(false);

// Remove unused objects
        opt.setRemoveUnusedObjects(false);

        doc.optimizeResources(opt);

        // Iterate through each page and annotation
        for (Page page : doc.getPages())
        {
            for (Annotation annotation : page.getAnnotations())
            {
                // Either flatten the annotation
                annotation.flatten();

                // OR delete the annotation
                // page.getAnnotations().delete(annotation);
            }
        }

        // Flatten Form fields
        if (doc.getForm().getFields().length > 0)
        {
            for (Field item : doc.getForm().getFields())
            {
                item.flatten();
            }
        }

        // Initialize RgbToDeviceGrayConversionStrategy instance
        RgbToDeviceGrayConversionStrategy strategy = new RgbToDeviceGrayConversionStrategy();
        for (int idxPage = 1; idxPage <= doc.getPages().size(); idxPage++) {
            Page page = doc.getPages().get_Item(idxPage);

            // Convert color space of each page to Greyscale
            strategy.convert(page);
        }

        doc.save(response.getOutputStream());
    }
}
