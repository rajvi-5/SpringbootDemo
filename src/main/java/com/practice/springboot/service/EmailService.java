package com.practice.springboot.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import java.io.File;

@Service
public class EmailService {

    @Autowired
    JavaMailSender javaMailSender;

    public String sendEmail(){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("rajvi.upadhyay05@gmail.com");
        mailMessage.setTo("rajvi05upadhyay@gmail.com");
        mailMessage.setSubject("Hello from Springboot");
        mailMessage.setText("Hi");
        javaMailSender.send(mailMessage);
        return "Mail sent successfully";
    }

    public String sendEmailWithAttachment(){
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper= new MimeMessageHelper(mimeMessage,true);
            mimeMessageHelper.setFrom("rajvi.upadhyay05@gmail.com");
            mimeMessageHelper.setTo("rajvi05upadhyay@gmail.com");
            mimeMessageHelper.setSubject("Hello from Springboot");
            mimeMessageHelper.setText("Hi");
            File file = new File("D:\\Rajvi\\test.txt");
            mimeMessageHelper.addAttachment(file.getName(),file);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        return "Mail sent successfully";
    }

}
