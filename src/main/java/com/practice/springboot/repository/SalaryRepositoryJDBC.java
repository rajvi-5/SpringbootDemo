package com.practice.springboot.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SalaryRepositoryJDBC {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public int createSalaryTable()
    {
        String query = "create table if not exists Salary(id int primary key, amount int, empId bigint(10), foreign key(empId) " +
                "references employees(emp_id) )";
        int update = jdbcTemplate.update(query);
        return(update);
    }
}
