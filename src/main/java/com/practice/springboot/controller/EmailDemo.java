package com.practice.springboot.controller;

import com.practice.springboot.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailDemo {
    @Autowired
    EmailService emailService;

    @GetMapping("/sendEmail")
    public String sendEmail(){
        return emailService.sendEmail();
    }

    @GetMapping("/sendEmailWithAttachment")
    public String sendEmailWithAttachment(){
       String result = emailService.sendEmailWithAttachment();
       return result;
    }

}
