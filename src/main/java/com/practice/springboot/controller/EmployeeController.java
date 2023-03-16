package com.practice.springboot.controller;

import com.practice.springboot.exception.ResourceNotFoundException;
import com.practice.springboot.model.Employee;
import com.practice.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("restapi/crud/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    //get all employees
    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }
    //create employee
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }
    //get employee by id
    @GetMapping("{id}")
    public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable long id){
        Optional<Employee> employee = employeeRepository.findById(id);
        return ResponseEntity.ok(employee);
    }
    //update employee
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee updateDetails){
        Employee updateEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found")); //Using Optional is better
        updateEmployee.setFirstName(updateDetails.getFirstName());
        updateEmployee.setLastName(updateDetails.getLastName());
        updateEmployee.setEmailId(updateDetails.getEmailId());
        employeeRepository.save(updateEmployee);
        return ResponseEntity.ok(updateEmployee);
    }
    //delete employee
    @DeleteMapping("{id}")
    public long deleteEmployee(@PathVariable long id){
        Employee emp = employeeRepository.findById(id).isPresent()?employeeRepository.findById(id).get():null;//findById returns Optional. To get object from Optional get() is used
        if(emp!=null) {
            employeeRepository.deleteById(id);
            return id;
        }
        return 0;
    }
}
