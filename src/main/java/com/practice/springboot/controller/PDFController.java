package com.practice.springboot.controller;

import com.practice.springboot.service.PDFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;

@RestController
public class PDFController {

    @Autowired
    PDFService pdfService;

    @GetMapping("/createPDF")
    public ResponseEntity<InputStreamResource> createPDF(){
        ByteArrayInputStream in = pdfService.createPDF();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Disposition","inline;file=demo.pdf");
        return ResponseEntity.ok().headers(httpHeaders).contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(in));
    }
}
