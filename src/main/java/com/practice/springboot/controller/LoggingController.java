package com.practice.springboot.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.springboot.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggingController {

    Logger logger = LoggerFactory.getLogger(LoggingController.class);

    @Autowired
    ObjectMapper objectMapper;

    @RequestMapping("/log")
    public String home(){
        logger.trace("TRACE LOG PRINTED");
        return "Logs!!";
    }
    @RequestMapping(value = "/stringToJson", method = RequestMethod.GET)
    public ResponseEntity objectMapperDemo(@RequestParam String employeeData){
        try {
            Employee employee = objectMapper.readValue(employeeData,Employee.class);
            logger.info("Employee data {}", employee);
            return ResponseEntity.ok("Done");

        } catch (JsonProcessingException e) {
            //throw new RuntimeException(e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid request");
        }
    }
}
