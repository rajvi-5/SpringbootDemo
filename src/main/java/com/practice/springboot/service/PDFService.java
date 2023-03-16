package com.practice.springboot.service;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

@Service
public class PDFService {
    private Logger logger = LoggerFactory.getLogger(PDFService.class);

    public ByteArrayInputStream createPDF() {
        logger.info("Create PDF started");

        String title = "Welcome";
        String content = "Demo for PDF generation";

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Document doc = new Document();
        PdfWriter.getInstance(doc,out);
        doc.open();

        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD,30);
        Paragraph titlePara = new Paragraph(title,titleFont);
        titlePara.setAlignment(Element.ALIGN_CENTER);
        doc.add(titlePara);

        Font contentFont = FontFactory.getFont(FontFactory.HELVETICA,20);
        Paragraph contentPara = new Paragraph(content,contentFont);
        contentPara.add(new Chunk("\n Added later"));
        doc.add(contentPara);

        doc.close();
        logger.info("Create PDF ended");

        return new ByteArrayInputStream(out.toByteArray());
    }


}
