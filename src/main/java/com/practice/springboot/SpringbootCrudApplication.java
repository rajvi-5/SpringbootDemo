package com.practice.springboot;

import com.practice.springboot.model.Employee;
import com.practice.springboot.repository.EmployeeRepository;
import com.practice.springboot.repository.SalaryRepositoryJDBC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootCrudApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootCrudApplication.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	SalaryRepositoryJDBC salaryRepositoryJDBC;
	@Override
	public void run(String... args) throws Exception {
		Employee emp = new Employee();
		emp.setFirstName("Rajvi");
		emp.setLastName("Upadhyay");
		emp.setEmailId("rajvi.upadhyay@gmail.com");
		employeeRepository.save(emp);

		emp = new Employee();
		emp.setFirstName("Manan");
		emp.setLastName("Upadhyay");
		emp.setEmailId("manan.upadhyay@gmail.com");
		employeeRepository.save(emp);

		System.out.println(salaryRepositoryJDBC.createSalaryTable());
	}
}
